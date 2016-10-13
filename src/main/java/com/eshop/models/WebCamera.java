package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class WebCamera extends Article {

	private String resolution;
	private int framesPerSecond;

	public WebCamera(String label, String model, double price, String resolution, int framesPerSecond, String image, int id)
			throws InvalidInputException {
		super(label, model, price, image, id);
		setResolution(resolution);
		setFramesPerSecond(framesPerSecond);

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

	public int getFramesPerSecond() {

		return framesPerSecond;
	}

	public void setFramesPerSecond(int framesPerSecond) throws InvalidInputException {
		if (framesPerSecond > 0)
			this.framesPerSecond = framesPerSecond;
		else
			throw new InvalidInputException("Invalid input!");
	}

	@Override
	public String toString() {
		return "WebCamera [resolution=" + resolution + ", framesPerSecond=" + framesPerSecond + ", hasMicrophone="
				+ ", toString()=" + super.toString() + "]";
	}

}
