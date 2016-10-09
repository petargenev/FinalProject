package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class Tablet extends Article {
	
	private double displaySize;
	private String displayType;
	private String resolution;
	private String cpu;

	public Tablet(String label, String model, double price,String cpu,  double displaySize, String displayType,
			String resolution, String image) throws InvalidInputException {
		super(label, model, price, image);
		setCpu(cpu);
		setDisplaySize(displaySize);
		setDisplayType(displayType);
		setResolution(resolution);
	}

	@Override
	public String toString() {
		return "Tablet [processor=" +  ", displaySize=" + displaySize + ", displayType=" + displayType
				+ ", resolution=" + resolution + ", toString()=" + super.toString() + "]";
	}

	

	public double getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(double displaySize) throws InvalidInputException {
		if (displaySize < 0)
			this.displaySize = displaySize;
		else
			throw new InvalidInputException("Invalid input!");

	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) throws InvalidInputException {
		if (displayType != null && !displayType.isEmpty())
			this.displayType = displayType;
		else
			throw new InvalidInputException("Invalid input!");
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) throws InvalidInputException {
		if (resolution != null && !resolution.isEmpty())
			this.resolution = resolution;
		else
			throw new InvalidInputException("Invalid input!");
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) throws InvalidInputException {
		if(cpu!= null && !cpu.isEmpty())
			this.cpu = cpu;
		else
			throw new InvalidInputException("Invalid input!");
	}

}
