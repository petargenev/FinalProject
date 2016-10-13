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
public class ShowArticleController {

	@RequestMapping(value = "/computers", method = RequestMethod.GET)
	public String showAllComputers(Model model) throws SQLException, InvalidInputException {
		
		Collection<Article> computers = new ComputerDAO().showAll();
		
//		for (Article article : computers) {
//			if (article instanceof Computer) {
//				System.out.println(((Computer) article));
//			}
//		}
//		
		if(!computers.isEmpty())
			model.addAttribute("computers", computers);
		
		return "mainpage";
	}
	
	@RequestMapping(value = "/laptops", method = RequestMethod.GET)
	public String showAllLaptops(Model model) throws SQLException, InvalidInputException {
		
		Collection<Article> laptops = new LaptopDAO().showAll();
		
//		for (Article article : computers) {
//			if (article instanceof Computer) {
//				System.out.println(((Computer) article));
//			}
//		}
//		
		if(!laptops.isEmpty())
			model.addAttribute("laptops", laptops);
		
		return "mainpage";
	}
	
	@RequestMapping(value = "/tablets", method = RequestMethod.GET)
	public String showAllTablets(Model model) throws SQLException, InvalidInputException {
		
		Collection<Article> tablets = new TabletDAO().showAll();
		
//		for (Article article : computers) {
//			if (article instanceof Computer) {
//				System.out.println(((Computer) article));
//			}
//		}
//		
		if(!tablets.isEmpty())
			model.addAttribute("tablets", tablets);
		
		return "mainpage";
	}
}
