package com.bea.order.web;

import com.bea.order.model.Orders;
import com.bea.order.service.OrdersService;
import com.bea.order.util.date.MyDateEdit;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Controller
@RequestMapping("/order")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new MyDateEdit("yyyy-MM-dd HH:mm"));
	}
	
	@RequestMapping("/findAll")
	public String findAll(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer pageNum,
	                      @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize) throws Exception {
		List<Orders> ordersList = ordersService.findAll(pageNum, pageSize);
		PageInfo pageInfo = new PageInfo(ordersList);
		model.addAttribute("pageInfo", pageInfo);
		return "orders-page-list";
	}
	
	@RequestMapping("/findById")
	public String findById(Model model, String id) throws Exception {
		Orders orders = ordersService.findById(id);
		model.addAttribute("orders", orders);
		return "orders-show";
	}
	
}
