package com.bea.order.web;

import com.bea.order.model.Role;
import com.bea.order.service.RoleService;
import com.bea.order.util.date.MyDateEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new MyDateEdit("yyyy-MM-dd HH:mm"));
	}
	
	@RequestMapping("/findAll")
	@RolesAllowed({"ADMIN", "USER"})
	public String findAll(Model model) throws Exception {
		List<Role> roleList = roleService.findAll();
		model.addAttribute("roleList", roleList);
		return "role-list";
	}
	
	@RequestMapping("/save")
	@RolesAllowed("USER")
	public String add(Model model, Role role) throws Exception {
		roleService.add(role);
		return "redirect:findAll.do";
	}
	
	@RequestMapping("/findRoleByIdAndAllPermission")
	public String findRoleByIdAndAllPermission(Model model, String id) throws Exception {
		Role role = roleService.findRoleByIdAndAllPermission(id);
		model.addAttribute("role", role);
		return "role-permission-add";
	}
	
	@RequestMapping("/addPermissionToRole")
	@RolesAllowed("USER")
	public String addPermissionToRole(Model model, @RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "ids", required = true) String[] permissionIds) throws Exception {
		roleService.addPermissionToRole(roleId, permissionIds);
		return "redirect:findAll.do";
	}
	
}
