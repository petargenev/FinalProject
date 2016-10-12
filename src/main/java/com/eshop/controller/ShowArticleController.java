package com.eshop.controller;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.dao.ComputerDAO;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.models.Article;
import com.eshop.models.Computer;

@Controller
public class ShowArticleController {

	@RequestMapping(value = "/addcomputer", method = RequestMethod.POST)
	public String showAllComputers(Model model) throws SQLException, InvalidInputException {
		
		Collection<Article> computers = new ComputerDAO().showAll();
		
//		for (Article article : computers) {
//			if (article instanceof Computer) {
//				System.out.println(((Computer) article));
//			}
//		}
//		
		model.addAttribute("computers", computers);
		return "mainpage";
	}
}
