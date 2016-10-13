package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class Tablet extends Article {
	private String type = "tablet";
	private double displaySize;
	private String displayType;
	private String resolution;
	private String cpu;
	
	public Tablet(){
		super();
	}

	public Tablet(String label, String model, double price,String cpu,  double displaySize, String displayType,
			String resolution, String image, int id) throws InvalidInputException {
		super(label, model, price, image, id);
		setCpu(cpu);
		setDisplaySize(displaySize);
		setDisplayType(displayType);
		setResolution(resolution);
	}

	
	

	@Override
	public String toString() {
		return "Tablet [displaySize=" + displaySize + ", displayType=" + displayType + ", resolution=" + resolution
				+ ", cpu=" + cpu + ", toString()=" + super.toString() + "]";
	}

	public double getDisplaySize() {
		return displaySize;
	}

	public String getType() {
		return type;
	}

	public void setDisplaySize(double displaySize) throws InvalidInputException {
		if (displaySize > 0)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpu == null) ? 0 : cpu.hashCode());
		long temp;
		temp = Double.doubleToLongBits(displaySize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((displayType == null) ? 0 : displayType.hashCode());
		result = prime * result + ((resolution == null) ? 0 : resolution.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablet other = (Tablet) obj;
		if (cpu == null) {
			if (other.cpu != null)
				return false;
		} else if (!cpu.equals(other.cpu))
			return false;
		if (Double.doubleToLongBits(displaySize) != Double.doubleToLongBits(other.displaySize))
			return false;
		if (displayType == null) {
			if (other.displayType != null)
				return false;
		} else if (!displayType.equals(other.displayType))
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
