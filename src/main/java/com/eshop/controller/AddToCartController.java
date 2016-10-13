package com.eshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public String addToCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, InvalidInputException, IOException {
		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("Id"));
		String articleType = request.getParameter("Article");

		if (session.getAttribute("username") != null) {
			if (articleType.equals("computer")) {
				//adding article to the cart
				ArrayList<Computer> computers = (ArrayList<Computer>) session.getAttribute("cart");
				//checking if article is in the cart
				 boolean isExisting = false;
				for (Computer computer : computers) {
					if(computer.equals(new ComputerDAO().getComputerById(id))){
						isExisting = true;
						break;
					}
					
				}
				
				if(!isExisting){
					computers.add(new ComputerDAO().getComputerById(id));
					//increasing total price
					Double currentPrice = (Double)session.getAttribute("carttotalprice");
					currentPrice += new ComputerDAO().getComputerById(id).getPrice();
					session.setAttribute("carttotalprice", currentPrice);
				}else{
					PrintWriter out = response.getWriter();
					out.print("Article exists!");
					out.flush();
					out.close();
				}
				
				
				
			}

			if (articleType.equals("laptop")) {
				ArrayList<Laptop> laptops = (ArrayList<Laptop>) session.getAttribute("cart");
				boolean isExisting = false;
				for (Laptop laptop : laptops) {
					if(laptop.equals(new LaptopDAO().getLaptopById(id))){
						isExisting = true;
						break;
					}
					
				}
				
				if(!isExisting){
					laptops.add(new LaptopDAO().getLaptopById(id));
					//increasing total price
					Double currentPrice = (Double)session.getAttribute("carttotalprice");
					currentPrice += new LaptopDAO().getLaptopById(id).getPrice();
					session.setAttribute("carttotalprice", currentPrice);
				}else{
					PrintWriter out = response.getWriter();
					out.print("Article exists!");
					out.flush();
					out.close();
				}
				
			}

			if (articleType.equals("tablet")) {
				ArrayList<Tablet> tablets = (ArrayList<Tablet>) session.getAttribute("cart");
				tablets.add(new TabletDAO().getTabletById(id));
				
				Double currentPrice = (Double)session.getAttribute("carttotalprice");
				currentPrice += new TabletDAO().getTabletById(id).getPrice();
				session.setAttribute("carttotalprice", currentPrice);
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
			
			Double currentPrice = (Double)session.getAttribute("carttotalprice");
			currentPrice -= new ComputerDAO().getComputerById(id).getPrice();
			session.setAttribute("carttotalprice", currentPrice);
			
		}

		if (articleType.equals("laptop")) {
			ArrayList<Laptop> laptops = (ArrayList<Laptop>) session.getAttribute("cart");
			laptops.remove(new LaptopDAO().getLaptopById(id));
			
			Double currentPrice = (Double)session.getAttribute("carttotalprice");
			currentPrice -= new LaptopDAO().getLaptopById(id).getPrice();
			session.setAttribute("carttotalprice", currentPrice);
			
		}

		if (articleType.equals("tablet")) {
			ArrayList<Tablet> tablets = (ArrayList<Tablet>) session.getAttribute("cart");
			tablets.remove(new TabletDAO().getTabletById(id));
			
			Double currentPrice = (Double)session.getAttribute("carttotalprice");
			currentPrice -= new TabletDAO().getTabletById(id).getPrice();
			session.setAttribute("carttotalprice", currentPrice);
			
		}
		
		return "cart";
	}
	
	

}
