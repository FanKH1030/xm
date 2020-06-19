package com.bea.order.util.handler;

import com.bea.order.util.SysException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fandi on 2020/4/5 0005.
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView view = new ModelAndView();

        SysException sysException = null;
        if (e instanceof SysException) {
            sysException = (SysException) e;
        } else {
            sysException = new SysException("系统正在维护中-----------------");
        }

        view.addObject("msg", sysException.getMsg());
        view.setViewName("error");
        return view;
    }
}
