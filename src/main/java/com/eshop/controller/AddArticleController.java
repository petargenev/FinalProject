package com.eshop.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.dao.ComputerDAO;
import com.eshop.dao.LaptopDAO;
import com.eshop.dao.TabletDAO;
import com.eshop.exceptions.ArticleException;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.exceptions.UserException;
import com.eshop.models.Computer;
import com.eshop.models.Laptop;
import com.eshop.models.Tablet;
import com.eshop.models.User;

@Controller
public class AddArticleController {

	private static final String UPLOAD_LOCATION = "D:\\articlePhoto\\";

	@RequestMapping(value = "/addarticle", method = RequestMethod.GET)
	public String creatingArticles(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("isAdmin") == null || session.getAttribute("isAdmin").equals(false))
			return "404";
		model.addAttribute(new Computer());
		model.addAttribute(new Tablet());
		model.addAttribute(new Laptop());

		return "addarticle";

	}

	@RequestMapping(value = "/addcomputer", method = RequestMethod.POST)
	public String addNewComputer(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute Computer computer,
			Model model, HttpServletRequest session) {

		// do something else
		try {
			String[] path = multipartFile.getOriginalFilename().split("\\\\");
			String fileName = path[path.length - 1];
			FileCopyUtils.copy(multipartFile.getBytes(), new File(getUploadLocation() + fileName));
			String image = ("./img/" + fileName);
			computer.setImage(image);

			if (computerValidation(computer))
				return "404";

			new ComputerDAO().insertArticle(computer);

			return creatingArticles(model, session);
		} catch (ArticleException | IOException e) {
			e.printStackTrace();
			return "404";
		} catch (InvalidInputException e) {
			e.printStackTrace();
			return "404";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}

	@RequestMapping(value = "/addtablet", method = RequestMethod.POST)
	public String addNewTablet(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute Tablet tablet,
			Model model, HttpServletRequest session)
			throws UserException, ArticleException, IOException, InvalidInputException {
		try {
			String[] path = multipartFile.getOriginalFilename().split("\\\\");
			String fileName = path[path.length - 1];
			FileCopyUtils.copy(multipartFile.getBytes(), new File(getUploadLocation() + fileName));
			String image = ("./img/" + fileName);
			tablet.setImage(image);

			if (tabletValidation(tablet))
				return "404";

			new TabletDAO().insertArticle(tablet);

			return creatingArticles(model, session);
		} catch (IOException e) {
			e.printStackTrace();
			return "404";
		} catch (InvalidInputException e) {
			e.printStackTrace();
			return "404";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}

	@RequestMapping(value = "/addlaptop", method = RequestMethod.POST)
	public String addNewLaptop(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute Laptop laptop,
			Model model, HttpServletRequest session) {
		try {
			String[] path = multipartFile.getOriginalFilename().split("\\\\");
			String fileName = path[path.length - 1];
			FileCopyUtils.copy(multipartFile.getBytes(), new File(getUploadLocation() + fileName));
			String image = ("./img/" + fileName);
			laptop.setImage(image);

			if (laptopValidation(laptop))
				return "404";

			new LaptopDAO().insertArticle(laptop);

			return creatingArticles(model, session);
		} catch (ArticleException | IOException e) {
			e.printStackTrace();
			return "404";
		} catch (InvalidInputException e) {
			e.printStackTrace();
			return "404";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}

	@RequestMapping(value = "/addcomputer", method = RequestMethod.GET)
	public String computerGetMethod() {
		return "mainpage";
	}

	@RequestMapping(value = "/addlaptop", method = RequestMethod.GET)
	public String laptopGetMethod() {
		return "mainpage";
	}

	@RequestMapping(value = "/addtablet", method = RequestMethod.GET)
	public String tabletGetMethod() {
		return "mainpage";
	}

	private boolean laptopValidation(Laptop laptop) {
		if (laptop.getHdd() <= 0 || (laptop.getLabel().isEmpty() || laptop.getLabel() == null)
				|| (laptop.getModel().isEmpty() || laptop.getModel() == null)
				|| (laptop.getOperationSystem().isEmpty() || laptop.getOperationSystem() == null)
				|| laptop.getPrice() <= 0 || laptop.getProcessorSpeed() <= 0
				|| (laptop.getProcessorType().isEmpty() || laptop.getProcessorType() == null) || laptop.getRam() <= 0
				|| (laptop.getVideoCardType().isEmpty() || laptop.getVideoCardType() == null)
				|| (laptop.getResolution().isEmpty() || laptop.getResolution() == null)
				|| laptop.getDisplaySize() <= 0) {
			return true;
		}
		return false;

	}

	private boolean computerValidation(Computer computer) {
		if (computer.getHdd() <= 0 || (computer.getLabel().isEmpty() || computer.getLabel() == null)
				|| (computer.getModel().isEmpty() || computer.getModel() == null)
				|| (computer.getOperationSystem().isEmpty() || computer.getOperationSystem() == null)
				|| computer.getPrice() <= 0 || computer.getProcessorSpeed() <= 0
				|| (computer.getProcessorType().isEmpty() || computer.getProcessorType() == null)
				|| computer.getRam() <= 0
				|| (computer.getVideoCardType().isEmpty() || computer.getVideoCardType() == null)) {

			return true;
		}
		return false;
	}

	private boolean tabletValidation(Tablet tablet) {
		if ((tablet.getLabel().isEmpty() || tablet.getLabel() == null)
				|| (tablet.getModel().isEmpty() || tablet.getModel() == null)
				|| (tablet.getDisplayType().isEmpty() || tablet.getDisplayType() == null) || tablet.getPrice() <= 0
				|| tablet.getDisplaySize() <= 0 || (tablet.getLabel().isEmpty() || tablet.getLabel() == null)
				|| (tablet.getResolution().isEmpty() || tablet.getResolution() == null)
				|| tablet.getDisplaySize() <= 0) {

			return true;
		}
		return false;
	}

	public static String getUploadLocation() {
		return UPLOAD_LOCATION;
	}

}
