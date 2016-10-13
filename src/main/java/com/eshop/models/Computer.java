package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class Computer extends Article{
	
	private String type = "computer";
	

	private int ram;
	private String processorType;	
	private double processorSpeed;
	private String videoCardType;
	private int hdd;
	private String operationSystem;
	
	

	public Computer(){
		super();
	}

	public Computer(String model, String label,  int ram, String processorType, 
			double processorSpeed, String videoCardType, int hdd, String operationSystem, double price, String image, int id)
			throws InvalidInputException,InvalidInputException {
		super(model,label,price,image, id);
		
		setRam(ram);
		setProcessorType(processorType);
		setProcessorSpeed(processorSpeed);
		setVideoCardType(videoCardType);
		setHdd(hdd);
		setOperationSystem(operationSystem);
		
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
	
	public String getType() {
		return type;
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
		return "Computer [ram=" + ram + ", processorType=" + processorType + ", processorSpeed=" + processorSpeed
				+ ", videoCardType=" + videoCardType + ", hdd=" + hdd + ", operationSystem=" + operationSystem
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hdd;
		result = prime * result + ((operationSystem == null) ? 0 : operationSystem.hashCode());
		long temp;
		temp = Double.doubleToLongBits(processorSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((processorType == null) ? 0 : processorType.hashCode());
		result = prime * result + ram;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((videoCardType == null) ? 0 : videoCardType.hashCode());
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
		Computer other = (Computer) obj;
		if (hdd != other.hdd)
			return false;
		if (operationSystem == null) {
			if (other.operationSystem != null)
				return false;
		} else if (!operationSystem.equals(other.operationSystem))
			return false;
		if (Double.doubleToLongBits(processorSpeed) != Double.doubleToLongBits(other.processorSpeed))
			return false;
		if (processorType == null) {
			if (other.processorType != null)
				return false;
		} else if (!processorType.equals(other.processorType))
			return false;
		if (ram != other.ram)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (videoCardType == null) {
			if (other.videoCardType != null)
				return false;
		} else if (!videoCardType.equals(other.videoCardType))
			return false;
		return true;
	}


	

	

}
