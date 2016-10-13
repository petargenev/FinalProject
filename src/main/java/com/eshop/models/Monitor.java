package com.eshop.models;

import javax.activity.InvalidActivityException;

import com.eshop.exceptions.InvalidInputException;

public class Monitor extends Article{

	private String displayType;
	private double displaySize;
	private String resolution;
	private String contrast;

	

	public Monitor(String label, String model,String displayType, double displaySize, String resolution,
			String contrast, double price, String image, int id) throws InvalidActivityException, InvalidInputException {
		super(label,model,price,image, id);
		setDisplayType(displayType);
		setDisplaySize(displaySize);
		setResolution(resolution);
		setContrast(contrast);
		setPrice(price);
	}





	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) throws InvalidActivityException {
		if (displayType != null && !displayType.isEmpty()) {
			this.displayType = displayType;
		} else {
			throw new InvalidActivityException("Invalid display type!");
		}
	}

	public double getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(double displaySize) throws InvalidActivityException {
		if (displaySize > 0) {
			this.displaySize = displaySize;
		} else {
			throw new InvalidActivityException("Invalid display size!");
		}
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) throws InvalidActivityException {
		if (resolution != null && !resolution.isEmpty()) {
			this.resolution = resolution;
		} else {
			throw new InvalidActivityException("Invalid resolution!");
		}
	}

	public String getContrast() {
		return contrast;
	}

	public void setContrast(String contrast) throws InvalidActivityException {
		if (contrast != null && !contrast.isEmpty()) {
			this.contrast = contrast;
		} else {
			throw new InvalidActivityException("Invalid input!");
		}
	}





	@Override
	public String toString() {
		return "Monitor [displayType=" + displayType + ", displaySize=" + displaySize + ", resolution=" + resolution
				+ ", contrast=" + contrast + ", toString()=" + super.toString() + "]";
	}



	



	
	

}
