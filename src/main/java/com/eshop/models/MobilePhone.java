package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class MobilePhone extends Article{
	private String cpu;
	private double displaySize;
	private String displayType;
	private double rearCamera;
	
	
	public MobilePhone(String label, String model, double price, String cpu, double displaySize, String displayType,
			double rearCamera, String image) throws InvalidInputException {
		super(label, model, price, image);
		setCpu(cpu);
		setDisplaySize(displaySize);
		setDisplayType(displayType);
		setRearCamera(rearCamera);
	}
	@Override
	public String toString() {
		return "MobilePhone [cpu=" + cpu + ", displaySize=" + displaySize + ", displayType=" + displayType
				+ ", rearCamera=" + rearCamera + ", toString()=" + super.toString() + "]";
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) throws InvalidInputException {
		if(cpu != null && !cpu.isEmpty())
			this.cpu = cpu;
		else
			throw new InvalidInputException("Invalid input!");
	}
	public double getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(double displaySize) throws InvalidInputException {
		if(displaySize < 0)
			this.displaySize = displaySize;
		else
			throw new InvalidInputException("Invalid input!");
	}
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) throws InvalidInputException {
		if(displayType != null && !displayType.isEmpty())
			this.displayType = displayType;
		else
			throw new InvalidInputException("Invalid input!");
	}
	public double getRearCamera() {
		return rearCamera;
	}
	public void setRearCamera(double rearCamera) throws InvalidInputException {
		if(rearCamera < 0)
			this.rearCamera = rearCamera;
		else
			throw new InvalidInputException("Invalid input!");
	}
	
	
}
