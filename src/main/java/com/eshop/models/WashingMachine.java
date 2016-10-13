package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class WashingMachine extends Article {
	
	private String kind;
	private int roundsPerMinute;
	private String energyClass;
	private double washingCapacity;
	
	
	public WashingMachine(String label, String model, double price, String kind, int roundsPerMinute,
			String energyClass, double washingCapacity, String image, int id) throws InvalidInputException {
		super(label, model, price, image, id);
		setKind(kind);
		setRoundsPerMinute(roundsPerMinute);
		setEnergyClass(energyClass);
		setWashingCapacity(washingCapacity);
	}
	@Override
	public String toString() {
		return "WashingMachine [kind=" + kind + ", roundsPerMinute=" + roundsPerMinute + ", energyClass=" + energyClass
				+ ", washingCapacity=" + washingCapacity + ", toString()=" + super.toString() + "]";
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) throws InvalidInputException {
		if(kind != null && !kind.isEmpty())
			this.kind = kind;
		else 
			throw new InvalidInputException("Invalid input!");
	}
	public int getRoundsPerMinute() {
		return roundsPerMinute;
	}
	public void setRoundsPerMinute(int roundsPerMinute) throws InvalidInputException {
		if(roundsPerMinute > 0)
			this.roundsPerMinute = roundsPerMinute;
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
	public double getWashingCapacity() {
		return washingCapacity;
	}
	public void setWashingCapacity(double washingCapacity) throws InvalidInputException {
		if(washingCapacity > 0)
			this.washingCapacity = washingCapacity;
		else 
			throw new InvalidInputException("Invalid input!");
	}
	
	
}
