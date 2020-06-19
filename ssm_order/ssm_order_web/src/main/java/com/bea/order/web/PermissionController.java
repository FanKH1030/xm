package com.bea.order.web;

import com.bea.order.model.Permission;
import com.bea.order.service.PermissionService;
import com.bea.order.util.date.MyDateEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new MyDateEdit("yyyy-MM-dd HH:mm"));
	}
	
	@RequestMapping("/findAll")
	public String findAll(Model model) throws Exception {
		List<Permission> permissionList = permissionService.findAll();
		model.addAttribute("permissionList", permissionList);
		return "permission-list";
	}
	
	@RequestMapping("/save")
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public String add(Model model, Permission permission) throws Exception {
		permissionService.add(permission);
		return "redirect:findAll.do";
	}
	
}
