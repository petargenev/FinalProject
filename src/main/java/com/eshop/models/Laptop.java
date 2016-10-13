package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class Laptop extends Computer{
	private String type = "laptop";
	private double displaySize;
	private String resolution;
	
	
	
	
	


	public Laptop() {
		super();
	}


	public Laptop(double displaySize, String resolution, String model, String label, int ram, String processorType, double processorSpeed,
			String videoCardType, int hdd, String operationSystem, double price, String image, int id)
			throws InvalidInputException, InvalidInputException {
		super(model, label, ram, processorType, processorSpeed, videoCardType, hdd, operationSystem, price, image, id);
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
	public String getType() {
		return type;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(displaySize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((resolution == null) ? 0 : resolution.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		if (Double.doubleToLongBits(displaySize) != Double.doubleToLongBits(other.displaySize))
			return false;
		if (resolution == null) {
			if (other.resolution != null)
				return false;
		} else if (!resolution.equals(other.resolution))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
