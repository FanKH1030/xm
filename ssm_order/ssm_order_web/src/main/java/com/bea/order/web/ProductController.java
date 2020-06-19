package com.bea.order.web;

import com.bea.order.model.Product;
import com.bea.order.service.ProductService;
import com.bea.order.util.date.MyDateEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new MyDateEdit("yyyy-MM-dd HH:mm"));
	}
	
	@RequestMapping("/view")
	@ResponseBody
	public List<Product> view(Model model) throws Exception {
		List<Product> productList = productService.findAll();
		model.addAttribute("productList", productList);
		return productList;
	}
	
	@RequestMapping("/findAll")
	public String findAll(Model model) throws Exception {
		List<Product> productList = productService.findAll();
		model.addAttribute("productList", productList);
		return "product-list";
	}
	
	@RequestMapping("/save")
	@RolesAllowed({"ADMIN", "USER"})
	public String save(Product product) throws Exception {
		productService.save(product);
		return "redirect:findAll.do";
	}
	
	@RequestMapping("/update")
	@RolesAllowed({"ADMIN", "USER"})
	public String update(Product product) throws Exception {
		productService.update(product);
		return "redirect:findAll.do";
	}
	
	@RequestMapping("/delete")
	@RolesAllowed({"ADMIN", "USER"})
	public String delete(String id) throws Exception {
		productService.delete(id);
		return "redirect:findAll.do";
	}
}
