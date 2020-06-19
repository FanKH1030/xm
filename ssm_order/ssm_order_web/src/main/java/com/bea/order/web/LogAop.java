package com.bea.order.web;

import com.bea.order.model.SysLog;
import com.bea.order.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by fandi on 2020/6/18 0018.
 */
@Component
@Aspect// 切面
public class LogAop {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private SysLogService sysLogService;
	
	private Date visitTime;
	private Class clazz;
	private Method method;
	
	private String username;
	private String ip;
	private String url;
	private Long executionTime;// 执行时长
	
	
	/**
	 * 前置通知
	 * 获取 开始时间visitTime，执行的类方法method
	 *
	 * @param jp
	 */
	@Before("execution(* com.bea.order.web.*.*(..))")
	public void doBefore(JoinPoint jp) throws NoSuchMethodException, ClassNotFoundException {
		visitTime = new Date();
		
		clazz = jp.getTarget().getClass();
		Signature signature = jp.getSignature();
		String methodName = jp.getSignature().getName();
		System.out.println("clazz:" + clazz);
		System.out.println("methodName:" + methodName);
		if ("initBinder".equalsIgnoreCase(methodName)) {
			return;
		}
		
		Object[] args = jp.getArgs();
		if (args == null || args.length == 0) {
			method = clazz.getMethod(methodName);// 只能获取无参数方法
		} else {
			
			Class<?> model = Class.forName("org.springframework.ui.Model");
			
			Class<?>[] typeArgs = new Class<?>[args.length];
			for (int i = 0; i < args.length; i++) {
				Class<?> clazzO = args[i].getClass();
				
				Object o = null;
				try {
					o = clazzO.newInstance();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				if (o instanceof Model) {
					typeArgs[i] = model;
				} else {
					typeArgs[i] = args[i].getClass();
				}
				
			}
			
			method = clazz.getMethod(methodName, typeArgs);
		}
		
	}
	
	
	@After("execution(* com.bea.order.web.*.*(..))")
	public void doAfter(JoinPoint jp) {
		Date visitAfterTime = new Date();
		executionTime = visitAfterTime.getTime() - visitTime.getTime();
		
		// 获取url
		if (clazz != null && method != null && clazz != LogAop.class) {
			// 1.获取类上注解的值/order
			// @RequestMapping("/order")
			// public class OrdersController {
			RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
			if (clazzAnnotation != null) {
				String classValue = clazzAnnotation.value()[0];
				
				// 2.获取方法上的值/findAll
				// @RequestMapping("/findAll")
				//public String findAll(Model model,
				RequestMapping methodAnnotation = (RequestMapping) method.getAnnotation(RequestMapping.class);
				if (methodAnnotation != null) {
					String methodValue = methodAnnotation.value()[0];
					
					url = classValue + methodValue;
				}
			}
		}
		
		// 获取ip
		ip = request.getRemoteAddr();
		
		// 获取当前用户username
		//request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")
		SecurityContext context = SecurityContextHolder.getContext();//上下文登陆的用户
		User user = (User) context.getAuthentication().getPrincipal();
		username = user.getUsername();
		
		
		if (clazz != null && method != null && clazz != LogAop.class) {
			SysLog sysLog = new SysLog();
			sysLog.setVisitTime(visitTime);
			sysLog.setUsername(username);
			sysLog.setIp(ip);
			sysLog.setUrl(url);
			sysLog.setExecutionTime(executionTime);
			sysLog.setMethod(clazz.getName() + "." + method.getName());
			System.out.println("sysLog ===> " + sysLog);
			
			sysLogService.add(sysLog);
		}
	}
}
