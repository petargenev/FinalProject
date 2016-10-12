package com.eshop.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.dao.UserDAO;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.exceptions.UserException;
import com.eshop.models.User;

@Controller
public class LoginController {

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String creatingUser(Model model) {
//		model.addAttribute(new User());
//		return "login";
//	}

	@RequestMapping(value = "/LoginController", method = RequestMethod.POST)
	public String logUser(@ModelAttribute User user,HttpServletRequest request) throws UserException {


		System.out.println(user);
	
		User userFromDb = null;
		try {
			userFromDb = new UserDAO().getUser(user.getEmail(), user.getPassword());
			if (userFromDb.getName() != null) {
				HttpSession session = request.getSession();
				session.setAttribute("username", userFromDb.getName());
				System.out.println(session.getAttribute("username"));
				
				return "mainpage";
			} else {
				return "login";
			}
		} catch (InvalidInputException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return "login";
	}

}
