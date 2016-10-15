package com.eshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.dao.ComputerDAO;
import com.eshop.dao.LaptopDAO;
import com.eshop.dao.TabletDAO;
import com.eshop.dao.UserDAO;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.models.Article;
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
	public String addToCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, InvalidInputException, IOException {
		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("Id"));
		String articleType = request.getParameter("Article");

		if (session.getAttribute("username") != null && session.getAttribute("cart") != null) {
			if (articleType.equals("computer")) {
				// adding article to the cart

				ArrayList<Article> computers = (ArrayList<Article>) session.getAttribute("cart");
				boolean isExisting = false;

				for (Article computer : computers) {
					if (computer.equals(new ComputerDAO().getComputerById(id))) {
						isExisting = true;
						break;
					}

				}

				if (!isExisting) {
					computers.add(new ComputerDAO().getComputerById(id));
					// increasing total price
					Double currentPrice = (Double) session.getAttribute("carttotalprice");
					currentPrice += new ComputerDAO().getComputerById(id).getPrice();
					session.setAttribute("carttotalprice", currentPrice);
				} else {
					PrintWriter out = response.getWriter();
					out.print("Article exists!");
					out.flush();
					out.close();
				}

			}

			if (articleType.equals("laptop")) {
				ArrayList<Article> laptops = (ArrayList<Article>) session.getAttribute("cart");
				boolean isExisting = false;

				if (laptops != null) {
					for (Article laptop : laptops) {
						if (laptop.equals(new LaptopDAO().getLaptopById(id))) {
							isExisting = true;
							break;
						}

					}
				}

				if (!isExisting) {
					laptops.add(new LaptopDAO().getLaptopById(id));
					// increasing total price
					Double currentPrice = (Double) session.getAttribute("carttotalprice");
					currentPrice += new LaptopDAO().getLaptopById(id).getPrice();
					session.setAttribute("carttotalprice", currentPrice);
				} else {
					PrintWriter out = response.getWriter();
					out.print("Article exists!");
					out.flush();
					out.close();
				}

			}

			if (articleType.equals("tablet")) {
				ArrayList<Article> tablets = (ArrayList<Article>) session.getAttribute("cart");
				boolean isExisting = false;
				if (tablets == null) {
					System.out.println("kolichkata e null");
				}
				for (Article tablet : tablets) {
					if (tablet.equals(new TabletDAO().getTabletById(id))) {
						isExisting = true;
						break;
					}

				}

				if (!isExisting) {
					tablets.add(new TabletDAO().getTabletById(id));
					// increasing total price
					Double currentPrice = (Double) session.getAttribute("carttotalprice");
					currentPrice += new TabletDAO().getTabletById(id).getPrice();
					session.setAttribute("carttotalprice", currentPrice);
				} else {
					PrintWriter out = response.getWriter();
					out.print("Article exists!");
					out.flush();
					out.close();
				}
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

			Double currentPrice = (Double) session.getAttribute("carttotalprice");
			currentPrice -= new ComputerDAO().getComputerById(id).getPrice();
			session.setAttribute("carttotalprice", currentPrice);

		}

		if (articleType.equals("laptop")) {
			ArrayList<Laptop> laptops = (ArrayList<Laptop>) session.getAttribute("cart");
			laptops.remove(new LaptopDAO().getLaptopById(id));

			Double currentPrice = (Double) session.getAttribute("carttotalprice");
			currentPrice -= new LaptopDAO().getLaptopById(id).getPrice();
			session.setAttribute("carttotalprice", currentPrice);

		}

		if (articleType.equals("tablet")) {
			ArrayList<Tablet> tablets = (ArrayList<Tablet>) session.getAttribute("cart");
			tablets.remove(new TabletDAO().getTabletById(id));

			Double currentPrice = (Double) session.getAttribute("carttotalprice");
			currentPrice -= new TabletDAO().getTabletById(id).getPrice();
			session.setAttribute("carttotalprice", currentPrice);

		}

		return "cart";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout(HttpServletRequest request) throws SQLException, InvalidInputException {

		HttpSession session = request.getSession();

		if (session.getAttribute("cart") != null) {
			List<Article> products = (ArrayList<Article>) session.getAttribute("cart");
			for (Article article : products) {
				if (article instanceof Computer) {
					new ComputerDAO().deleteComputer(article.getId());
				}

				if (article instanceof Laptop) {
					new LaptopDAO().deleteLaptop(article.getId());
				}

				if (article instanceof Tablet) {
					new TabletDAO().deleteTablet(article.getId());
				}
			}
			Double price = new Double(0);
			session.setAttribute("carttotalprice", price);
			
			session.setAttribute("cart", new ArrayList<Article>());
		}

		return "cart";
	}
	
	

}