package com.bea.order.web;

import com.bea.order.model.SysLog;
import com.bea.order.service.SysLogService;
import com.bea.order.util.date.MyDateEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new MyDateEdit("yyyy-MM-dd HH:mm"));
	}
	
	@RequestMapping("/findAll")
	public String findAll(Model model) throws Exception {
		List<SysLog> sysLogList = sysLogService.findAll();
		model.addAttribute("sysLogList", sysLogList);
		return "sysLog-list";
	}
	
}
