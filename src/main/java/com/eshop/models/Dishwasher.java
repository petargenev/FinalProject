package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class Dishwasher extends Article {
	private int capacity;
	private String energyClass;
	private int programmesNumber;
	private int temperaturesNumber;

	public Dishwasher(String label, String model, double price, int capacity, String energyClass,
			int programmesNumber, int temperaturesNumber, String image, int id) throws InvalidInputException {
		super(label, model, price, image, id);
		setCapacity(capacity);
		setEnergyClass(energyClass);
		setProgrammesNumber(programmesNumber);
		setTemperaturesNumber(temperaturesNumber);
	}

	@Override
	public String toString() {
		return "Dishwasher [capacity=" + capacity + ", energyClass=" + energyClass + ", programmesNumber="
				+ programmesNumber + ", temperaturesNumber=" + temperaturesNumber + ", toString()=" + super.toString()
				+ "]";
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) throws InvalidInputException {
		if (capacity >0)
			this.capacity = capacity;
		else
			throw new InvalidInputException("Invalid input!");
	}

	public String getEnergyClass() {
		return energyClass;
	}

	public void setEnergyClass(String energyClass) throws InvalidInputException {
		if (energyClass != null && !energyClass.isEmpty())
			this.energyClass = energyClass;
		else
			throw new InvalidInputException("Invalid input!");
	}

	public int getProgrammesNumber() {
		return programmesNumber;
	}

	public void setProgrammesNumber(int programmesNumber) throws InvalidInputException {
		if (programmesNumber > 0)
			this.programmesNumber = programmesNumber;
		else
			throw new InvalidInputException("Invalid input!");
	}

	public int getTemperaturesNumber() {
		return temperaturesNumber;
	}

	public void setTemperaturesNumber(int temperaturesNumber) throws InvalidInputException {
		if (temperaturesNumber > 0)
			this.temperaturesNumber = temperaturesNumber;
		else
			throw new InvalidInputException("Invalid input!");

	}

}
