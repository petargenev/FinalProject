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
import org.springframework.web.bind.annotation.ResponseBody;

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

		if (session.getAttribute("username") == null) {
			PrintWriter out = response.getWriter();
			out.print("User not logged!");
			out.flush();
			out.close();
			return "mainpage";
		}

		int id = Integer.parseInt(request.getParameter("Id"));
		String articleType = request.getParameter("Article");

		if (session.getAttribute("username") != null && session.getAttribute("cart") != null) {
			if (articleType.equals("computer")) {
				// adding article to the cart

				ArrayList<Article> computers = (ArrayList<Article>) session.getAttribute("cart");
				boolean isExisting = false;

				for (Article computer : computers) {
					if (computer.equals(new ComputerDAO().getArticleById(id))) {
						isExisting = true;
						break;
					}

				}

				if (!isExisting) {
					computers.add(new ComputerDAO().getArticleById(id));
					// increasing total price
					Double currentPrice = (Double) session.getAttribute("carttotalprice");
					currentPrice += new ComputerDAO().getArticleById(id).getPrice();
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
						if (laptop.equals(new LaptopDAO().getArticleById(id))) {
							isExisting = true;
							break;
						}

					}
				}

				if (!isExisting) {
					laptops.add(new LaptopDAO().getArticleById(id));
					// increasing total price
					Double currentPrice = (Double) session.getAttribute("carttotalprice");
					currentPrice += new LaptopDAO().getArticleById(id).getPrice();
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
					if (tablet.equals(new TabletDAO().getArticleById(id))) {
						isExisting = true;
						break;
					}

				}

				if (!isExisting) {
					tablets.add(new TabletDAO().getArticleById(id));
					// increasing total price
					Double currentPrice = (Double) session.getAttribute("carttotalprice");
					currentPrice += new TabletDAO().getArticleById(id).getPrice();
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

			computers.remove(new ComputerDAO().getArticleById(id));

			Double currentPrice = (Double) session.getAttribute("carttotalprice");
			currentPrice -= new ComputerDAO().getArticleById(id).getPrice();
			session.setAttribute("carttotalprice", currentPrice);

		}

		if (articleType.equals("laptop")) {
			ArrayList<Laptop> laptops = (ArrayList<Laptop>) session.getAttribute("cart");
			laptops.remove(new LaptopDAO().getArticleById(id));

			Double currentPrice = (Double) session.getAttribute("carttotalprice");
			currentPrice -= new LaptopDAO().getArticleById(id).getPrice();
			session.setAttribute("carttotalprice", currentPrice);

		}

		if (articleType.equals("tablet")) {
			ArrayList<Tablet> tablets = (ArrayList<Tablet>) session.getAttribute("cart");
			tablets.remove(new TabletDAO().getArticleById(id));

			Double currentPrice = (Double) session.getAttribute("carttotalprice");
			currentPrice -= new TabletDAO().getArticleById(id).getPrice();
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
					new ComputerDAO().deleteArticleById(article.getId());
				}

				if (article instanceof Laptop) {
					new LaptopDAO().deleteArticleById(article.getId());
				}

				if (article instanceof Tablet) {
					new TabletDAO().deleteArticleById(article.getId());
				}
			}
			Double price = new Double(0);
			session.setAttribute("carttotalprice", price);

			session.setAttribute("cart", new ArrayList<Article>());
		}

		return "cart";
	}

	@RequestMapping(value = "/removeItem", method = RequestMethod.POST)
	
	public String removeItem(HttpServletRequest request) throws SQLException, InvalidInputException {
		int id = Integer.parseInt(request.getParameter("Id"));
		String articleType = request.getParameter("Article");
		if(articleType.equals("computer"))
			new ComputerDAO().deleteArticleById(id);
		
		if(articleType.equals("laptop"))
			new LaptopDAO().deleteArticleById(id);
		
		if(articleType.equals("tablet"))
			new TabletDAO().deleteArticleById(id);
		
		return "mainpage";
	}

	@RequestMapping(value = "/checkIfLogged", method = RequestMethod.POST)
	@ResponseBody
	public String checkIfLogged(HttpServletRequest request) {
		System.out.println("POVERQVAM ZA LOG !!!!!!!!!!!!!!!!!");
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			return "true";
		} else {
			return "false";
		}
	}

}