package com.eshop.controller;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.dao.ComputerDAO;
import com.eshop.dao.LaptopDAO;
import com.eshop.dao.TabletDAO;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.models.Article;

@Controller
@RequestMapping
public class MainPageController {

	@RequestMapping(value = {"/index","/mainpage"}, method = RequestMethod.GET)
	public String mainPage(Model model) throws SQLException, InvalidInputException {
		Collection<Article> computers = new ComputerDAO().showAll();
		Collection<Article> laptops = new LaptopDAO().showAll();
		Collection<Article> tablets = new TabletDAO().showAll();
	
		if(!computers.isEmpty())
			model.addAttribute("computers", computers);
		if(!computers.isEmpty())
			model.addAttribute("laptops", laptops);
		if(!computers.isEmpty())
			model.addAttribute("tablets", tablets);
		
		return "mainpage";
	}

}
