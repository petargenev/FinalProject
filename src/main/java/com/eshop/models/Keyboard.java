package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class Keyboard extends Article{
	private String type;
	
	private String colour;
	
	public Keyboard(String label, String model, double price, String type,  String colour, String image)
			throws InvalidInputException {
		super(label, model, price, image);
		setType(type);
	
		setColor(colour);
	}

	@Override
	public String toString() {
		return "Keyboard [type=" + type + ", color=" + colour + ", toString()="
				+ super.toString() + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) throws InvalidInputException {
		if(type != null && !type.isEmpty())
		{
		this.type = type;
		}else{
			throw new InvalidInputException("Invalid type!");
		}
	}

	

	public String getColour() {
		return colour;
	}

	public void setColor(String color) throws InvalidInputException {
		if(color != null && !color.isEmpty()){
		this.colour = color;
		}else{
			throw new InvalidInputException("Invalid color!");
		}
	}
	
	
	
}
