package com.eshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {



	@RequestMapping(value="/LogoutController", method = RequestMethod.GET)
	public String logoutUser(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("cart");
		session.removeAttribute("isAdmin");
		return "redirect:/mainpage";
	}
	
	@RequestMapping(value="/LogoutCartController", method = RequestMethod.GET)
	public String logoutUserCart(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("cart");
		session.removeAttribute("isAdmin");
		return "redirect:/mainpage";
	}


}
