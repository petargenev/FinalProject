package com.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.dao.UserDAO;
import com.eshop.exceptions.UserException;
import com.eshop.models.User;

@Controller
public class RegistrationController {
	UserDAO userDao = new UserDAO();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String creatingUser(Model model) {
		model.addAttribute(new User());
		return "login";
	}

	@RequestMapping(value = "/RegistrationController", method = RequestMethod.POST)
	public String addNewUser(@ModelAttribute User user, Model model) throws UserException {
		
		System.out.println("IMETO" + userDao.isValidName(user.getName()));
		System.out.println("PAROLATA" + userDao.isValidPassword(user.getPassword()));
		System.out.println("EMAILA " + userDao.isValidEmail(user.getEmail()));
		if (userDao.isValidName(user.getName()) && 
			userDao.isValidEmail(user.getEmail()) &&
			userDao.isValidPassword(user.getPassword())){
			System.out.println("VKARVAM USER");
				userDao.registerUser(user);
				model.addAttribute(user);
				System.out.println(user);
				return "forward:/login";
		}else{
			return "mainpage";
		}
		
	}

}
