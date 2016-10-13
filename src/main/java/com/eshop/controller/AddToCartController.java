package com.eshop.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.dao.ComputerDAO;
import com.eshop.dao.LaptopDAO;
import com.eshop.dao.TabletDAO;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.models.Computer;
import com.eshop.models.Laptop;
import com.eshop.models.Tablet;

@Controller
public class AddToCartController {

	@RequestMapping(value = "/addtocart", method = RequestMethod.GET)
	public String creatingArticles(Model model) {

		return "mainpage";
	}

	@RequestMapping(value = "/getArticleId", method = RequestMethod.POST)
	public String addToCart(HttpServletRequest request) throws SQLException, InvalidInputException {
		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("Id"));
		String articleType = request.getParameter("Article");

		if (session.getAttribute("username") != null) {
			if (articleType.equals("computer")) {
				ArrayList<Computer> computers = (ArrayList<Computer>) session.getAttribute("cart");
				computers.add(new ComputerDAO().getComputerById(id));
				// for (Computer computer : computers) {
				// System.out.println(computer);
				// }
			}

			if (articleType.equals("laptop")) {
				ArrayList<Laptop> laptops = (ArrayList<Laptop>) session.getAttribute("cart");
				laptops.add(new LaptopDAO().getLaptopById(id));
				// for (Laptop laptop : laptops) {
				// System.out.println(laptop);
				// }
			}

			if (articleType.equals("tablet")) {
				ArrayList<Tablet> tablets = (ArrayList<Tablet>) session.getAttribute("cart");
				tablets.add(new TabletDAO().getTabletById(id));
				// for (Tablet tablet : tablets) {
				// System.out.println(tablet);
				// }
			}
		}

		return "mainpage";
	}

	@RequestMapping(value = "/removeArticle", method = RequestMethod.POST)
	public String removeArticle(HttpServletRequest request) throws SQLException, InvalidInputException {

		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("Id"));
		String articleType = request.getParameter("Article");
		
		if (articleType.equals("computer")) {
			ArrayList<Computer> computers = (ArrayList<Computer>) session.getAttribute("cart");
			
			computers.remove(new ComputerDAO().getComputerById(id));
			return "redirect:/cart";
		}

		if (articleType.equals("laptop")) {
			ArrayList<Laptop> laptops = (ArrayList<Laptop>) session.getAttribute("cart");
			laptops.remove(new LaptopDAO().getLaptopById(id));
			return "redirect:/cart";
			
		}

		if (articleType.equals("tablet")) {
			ArrayList<Tablet> tablets = (ArrayList<Tablet>) session.getAttribute("cart");
			tablets.remove(new TabletDAO().getTabletById(id));
			return "redirect:/cart";
			// for (Tablet tablet : tablets) {
			// System.out.println(tablet);
			// }
		}
		
		return "cart";
	}

}
