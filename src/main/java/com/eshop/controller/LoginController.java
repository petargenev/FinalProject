package com.eshop.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.dao.ComputerDAO;
import com.eshop.dao.UserDAO;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.exceptions.UserException;
import com.eshop.models.Article;
import com.eshop.models.User;

@Controller
public class LoginController {

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String creatingUser(Model model) {
	// model.addAttribute(new User());
	// return "login";
	// }

	@RequestMapping(value = "/LoginController", method = RequestMethod.POST)
	public String logUser(@ModelAttribute User user, HttpServletRequest request) throws UserException, InvalidInputException, SQLException {
		HttpSession session = request.getSession();
		User userFromDb = null;

		session.removeAttribute("invalidLogin");
		
		

		try {
			userFromDb = new UserDAO().getUser(user.getEmail(), user.getPassword());
			if (userFromDb.getName() != null) {

				
				session.setAttribute("username", userFromDb.getName());
				session.setAttribute("cart", new ArrayList<Article>());
				Double price = new Double(0);
				session.setAttribute("carttotalprice", price);
				System.out.println(session.getAttribute("username"));
				
				if (userFromDb.isAdministrator()) {
					session.setAttribute("isAdmin", true);
				} else {
					session.setAttribute("isAdmin", false);
				}
				
				
					session.removeAttribute("invalidLogin");
				
				
				return "redirect:/mainpage";
			} else {
				session.setAttribute("invalidLogin", "Грешен имейл или парола! Опитай пак.");
				return "login";
			}
		} catch (InvalidInputException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "login";
	}

}
