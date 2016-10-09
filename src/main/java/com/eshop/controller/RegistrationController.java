package com.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.models.User;

@Controller
public class RegistrationController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String creatingUser(Model model) {
		model.addAttribute(new User());
		return "login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String addNewUser(@ModelAttribute User user) {

		System.out.println(user);

		return "login";
	}

}
