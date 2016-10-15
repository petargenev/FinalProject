package com.eshop.controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.comparator.LabelComparator;
import com.eshop.dao.ComputerDAO;
import com.eshop.dao.LaptopDAO;
import com.eshop.dao.TabletDAO;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.models.Article;
import com.eshop.models.Label;
import com.eshop.models.User;

@Controller
@RequestMapping
public class MainPageController {

	@RequestMapping(value = { "/index", "/mainpage", "/sortBy" }, method = RequestMethod.GET)
	public String mainPage(Model model, HttpServletRequest request, @ModelAttribute String label)
			throws SQLException, InvalidInputException {
		HttpSession session = request.getSession();

		Collection<Article> computers = new ComputerDAO().showAll();
		Collection<Article> laptops = new LaptopDAO().showAll();
		Collection<Article> tablets = new TabletDAO().showAll();
		Set<Label> labels = new TreeSet<Label>(new LabelComparator());
		
		Integer counter = new Integer(0);
	
		session.removeAttribute("invalidLogin");
		if (!computers.isEmpty()) {
			model.addAttribute("computers", computers);
			for (Article computer : computers) {

				if (labels.contains(new Label(computer.getModel()))) {
					Iterator<Label> iterator = labels.iterator();
					while (iterator.hasNext()) {

						Label currentLabel = iterator.next();
						if (currentLabel.getName().equals(new Label(computer.getModel()).getName())) {
							currentLabel.increaseCount();

							System.out.println(currentLabel.getCount());
						}
					}
				} else {
					System.out.println("dobavqm nov label");
					labels.add(new Label(computer.getModel()));
				}
			}
		}
		if (!laptops.isEmpty()) {
			model.addAttribute("laptops", laptops);
			for (Article laptop : laptops) {

				if (labels.contains(new Label(laptop.getModel()))) {
					Iterator<Label> iterator = labels.iterator();
					while (iterator.hasNext()) {

						Label currentLabel = iterator.next();
						if (currentLabel.getName().equals(new Label(laptop.getModel()).getName())) {
							currentLabel.increaseCount();

							System.out.println(currentLabel.getCount());
						}
					}
				} else {

					labels.add(new Label(laptop.getModel()));
				}
			}
		}
		if (!tablets.isEmpty()) {
			model.addAttribute("tablets", tablets);
			for (Article tablet : tablets) {

				if (labels.contains(new Label(tablet.getLabel()))) {
					Iterator<Label> iterator = labels.iterator();
					while (iterator.hasNext()) {

						Label currentLabel = iterator.next();
						if (currentLabel.getName().equals(new Label(tablet.getLabel()).getName())) {
							currentLabel.increaseCount();

							System.out.println(currentLabel.getCount());
						}
					}
				} else {
					System.out.println("dobavqm nov label");
					labels.add(new Label(tablet.getLabel()));

				}
			}
		}

		int articlesCount = (laptops.size() + computers.size() + tablets.size());

		session.setAttribute("articlesCount", articlesCount);

		model.addAttribute("labels", labels);

		return "mainpage";
	}

	@RequestMapping(value = { "/showByLabel" }, method = RequestMethod.POST)
	public String showByLabel(Model model, HttpServletRequest request) throws SQLException, InvalidInputException {
		String label = request.getParameter("label");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("label", label);
		
		return "redirect:/mainpage";
	}

}
