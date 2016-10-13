package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;



public class Mouse extends Article {

	private String resolution;
	

	public Mouse(String label, String model, double price, String resolution, String image, int id)
			throws InvalidInputException {
		super(label, model, price, image, id);
		setResolution(resolution);
		
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) throws InvalidInputException {
		if (resolution != null && !resolution.isEmpty()) {
			this.resolution = resolution;
		} else {
			throw new InvalidInputException("Invalid resolution!");
		}
	}



	@Override
	public String toString() {
		return "Mouse [resolution=" + resolution + ", toString()=" + super.toString() + "]";
	}

	

}
