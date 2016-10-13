package com.eshop.models;

import java.sql.SQLDataException;

import com.eshop.exceptions.InvalidInputException;

public abstract class Article {
	private String label;
	private String model;
	private double price;
	private String image;
	private int id;
	
	public Article(){
		
	}
	public Article(String label, String model, double price, String image, int id) throws InvalidInputException {
		setLabel(label);
		setModel(model);
		setPrice(price);
		setImage(image);
		setId(id);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) throws InvalidInputException {
		if(id>0)
			this.id = id;
		else
			throw new InvalidInputException();
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws InvalidInputException {
		if (price > 0) {
			this.price = price;
		} else {
			throw new InvalidInputException("Invalid price!");
		}

	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) throws InvalidInputException {
		if (label != null && !label.isEmpty()) {
			this.label = label;
		} else {
			throw new InvalidInputException("Invalid label!");
		}
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) throws InvalidInputException {
		if (model != null && !model.isEmpty()) {
			this.model = model;
		} else {
			throw new InvalidInputException("Invalid label!");
		}
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) throws InvalidInputException {
		if(image != null && !image.isEmpty())
			this.image = image;
		else
			throw new InvalidInputException("Invalid input!");
	}
	@Override
	public String toString() {
		return "Article [label=" + label + ", model=" + model + ", price=" + price + ", image=" + image + "]";
	}

	

}
