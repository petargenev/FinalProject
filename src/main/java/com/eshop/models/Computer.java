package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class Computer extends Article{
	private String type;

	

	private int ram;
	private String processorType;	
	private double processorSpeed;
	private String videoCardType;
	private int hdd;
	private String operationSystem;
	
	

	

	public Computer(String type, String label, String model, int ram, String processorType, 
			double processorSpeed, String videoCardType, int hdd, String operationSystem, double price, String image)
			throws InvalidInputException,InvalidInputException {
		super(type,label,price,image);
		setModel(model);
		setRam(ram);
		setProcessorType(processorType);
		setProcessorSpeed(processorSpeed);
		setVideoCardType(videoCardType);
		setHdd(hdd);
		setOperationSystem(operationSystem);
		
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) throws InvalidInputException {
		if (type != null && !type.isEmpty()) {
			this.type = type;
		} else {
			throw new InvalidInputException("Invalid type!");
		}
	}



	public int getRam() {
		return ram;
	}

	public void setRam(int ram) throws InvalidInputException {
		if (ram >0) {
			this.ram = ram;
		} else {
			throw new InvalidInputException("Invalid input!");
		}
	}

	public String getProcessorType() {
		return processorType;
	}

	public void setProcessorType(String processorType) throws InvalidInputException {
		if (processorType != null && !processorType.isEmpty()) {
			this.processorType = processorType;
		} else {
			throw new InvalidInputException("Invalid input!");
		}
	}

	
	public double getProcessorSpeed() {
		return processorSpeed;
	}

	public void setProcessorSpeed(double processorSpeed) throws InvalidInputException {
		if (processorSpeed > 0) {
			this.processorSpeed = processorSpeed;
		} else {
			throw new InvalidInputException("Invalid input!");
		}
	}

	public String getVideoCardType() {
		return videoCardType;
	}

	public void setVideoCardType(String videoCardType) throws InvalidInputException {
		if (videoCardType != null && !videoCardType.isEmpty()) {
			this.videoCardType = videoCardType;
		} else {
			throw new InvalidInputException("Invalid input!");
		}
	}

	public int getHdd() {
		return hdd;
	}

	public void setHdd(int hdd) throws InvalidInputException {
		if (hdd > 0) {
			this.hdd = hdd;
		} else {
			throw new InvalidInputException("Invalid input!");
		}
	}

	public String getOperationSystem() {
		return operationSystem;
	}

	public void setOperationSystem(String os) throws InvalidInputException {
		if (os != null && !os.isEmpty()) {
			this.operationSystem = os;
		} else {
			throw new InvalidInputException("Invalid operation system!");
		}
	}


	@Override
	public String toString() {
		return "Computer [type=" + type + ", ram=" + ram + ", processorType=" + processorType + ", displaySize="
				 + ", processorSpeed=" + processorSpeed + ", videoCardType=" + videoCardType + ", hdd="
				+ hdd + ", operationSystem=" + operationSystem + ", toString()=" + super.toString() + "]";
	}


	

}
