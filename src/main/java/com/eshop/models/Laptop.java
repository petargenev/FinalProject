package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class Laptop extends Computer{
	private double displaySize;
	private String resolution;
	
	
	
	
	


	public Laptop() {
		super();
	}


	public Laptop(double displaySize, String resolution, String model, String label, int ram, String processorType, double processorSpeed,
			String videoCardType, int hdd, String operationSystem, double price, String image)
			throws InvalidInputException, InvalidInputException {
		super(model, label, ram, processorType, processorSpeed, videoCardType, hdd, operationSystem, price, image);
		setDisplaySize(displaySize);
		setResolution(resolution);
	}


	@Override
	public String toString() {
		return "Laptop [displaySize=" + displaySize + ", resolution=" + resolution + ", toString()=" + super.toString()
				+ "]";
	}


	public double getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(double displaySize) throws InvalidInputException {
		if(displaySize > 0)
			this.displaySize = displaySize;
		else
			throw new InvalidInputException("Invalid display size!");
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) throws InvalidInputException {
		if(resolution != null && !resolution.isEmpty())
			this.resolution = resolution;
		else
			throw new InvalidInputException("Invalid resolution!");
	}
	
	
}
