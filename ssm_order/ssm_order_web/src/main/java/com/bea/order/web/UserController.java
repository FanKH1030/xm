package com.bea.order.web;

import com.bea.order.model.Users;
import com.bea.order.service.UserService;
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
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new MyDateEdit("yyyy-MM-dd HH:mm"));
	}
	
	@RequestMapping("/findAll")
	public String findAll(Model model) throws Exception {
		List<Users> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "user-list";
	}
	
	@RequestMapping("/findById")
	public String findById(Model model, String id) throws Exception {
		Users user = userService.findById(id);
		model.addAttribute("user", user);
		return "user-show";
	}
	
	@RequestMapping("/save")
	@RolesAllowed("ADMIN")
	public String add(Model model, Users users) throws Exception {
		userService.add(users);
		return "redirect:findAll.do";
	}
	
	@RequestMapping("/findUserByIdAndAllRole")
	public String findUserByIdAndAllRole(Model model, String id) throws Exception {
		Users user = userService.findUserByIdAndAllRole(id);
		model.addAttribute("user", user);
		return "user-role-add";
	}
	
	@RequestMapping("/addRoleToUser")
	@RolesAllowed({"ADMIN", "USER"})
	public String addRoleToUser(Model model, @RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) throws Exception {
		userService.addRoleToUser(userId, roleIds);
		return "redirect:findAll.do";
	}
	
}
