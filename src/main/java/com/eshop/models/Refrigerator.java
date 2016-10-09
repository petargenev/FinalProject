package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class Refrigerator extends Article{
	
	private int totalCapacity;
	private String energyClass;
	private String colour;
	
	
	public Refrigerator(String label, String model, double price, int totalCapacity, String energyClass,
			String colour, String image) throws InvalidInputException {
		super(label, model, price,image);
		setTotalCapacity(totalCapacity);
		setEnergyClass(energyClass);
		setColour(colour);
		
	}
	public int getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(int  totalCapacity) throws InvalidInputException {
		if(totalCapacity > 0)
			this.totalCapacity = totalCapacity;
		else 
			throw new InvalidInputException("Invalid input!");
	}
	public String getEnergyClass() {
		return energyClass;
	}
	public void setEnergyClass(String energyClass) throws InvalidInputException {
		if(energyClass != null && !energyClass.isEmpty())
			this.energyClass = energyClass;
		else 
			throw new InvalidInputException("Invalid input!");
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) throws InvalidInputException {
		if(colour != null && !colour.isEmpty())
			this.colour = colour;
		else 
			throw new InvalidInputException("Invalid input!");
	}
	
	
}
