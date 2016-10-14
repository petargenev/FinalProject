package com.eshop.controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.comparator.LabelComparator;
import com.eshop.dao.ComputerDAO;
import com.eshop.dao.LaptopDAO;
import com.eshop.dao.TabletDAO;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.models.Article;
import com.eshop.models.Label;

@Controller
public class ShowArticleController {

	@RequestMapping(value = "/computers", method = RequestMethod.GET)
	public String showAllComputers(Model model) throws SQLException, InvalidInputException {

		Collection<Article> computers = new ComputerDAO().showAll();
		Set<Label> labels = new TreeSet<Label>(new LabelComparator());

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
		model.addAttribute("labels", labels);

		return "mainpage";
	}

	@RequestMapping(value = "/laptops", method = RequestMethod.GET)
	public String showAllLaptops(Model model) throws SQLException, InvalidInputException {

		Collection<Article> laptops = new LaptopDAO().showAll();
		Set<Label> labels = new TreeSet<Label>(new LabelComparator());

		// for (Article article : computers) {
		// if (article instanceof Computer) {
		// System.out.println(((Computer) article));
		// }
		// }
		//
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

		model.addAttribute("labels", labels);

		return "mainpage";

	}

	@RequestMapping(value = "/tablets", method = RequestMethod.GET)
	public String showAllTablets(Model model) throws SQLException, InvalidInputException {

		Collection<Article> tablets = new TabletDAO().showAll();
		Set<Label> labels = new TreeSet<Label>(new LabelComparator());

	
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
		model.addAttribute("labels", labels);

		return "mainpage";
	}
}
