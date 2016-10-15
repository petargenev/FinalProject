package com.eshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public String sayHello(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("invalidLogin");
		return "cart";
	}
	
	
	
	
	


}
