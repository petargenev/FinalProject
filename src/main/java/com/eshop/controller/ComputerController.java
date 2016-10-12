package com.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ComputerController {

	@RequestMapping(value="/ComputerController", method = RequestMethod.GET)
	public String checkout(Model model) {
	
		return "checkout";
	}	
	
	
	


}
