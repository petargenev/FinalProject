package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class Camera extends Article {
	private double resolution;
	private int opticalZoom;
	private double displaySize;
	private int digitalZoom;

	
	
	public Camera(String image, String label, String model, double price, double resolution, int opticalZoom, double displaySize,
			int digitalZoom) throws InvalidInputException {
		super(label, model, price,image);
		setResolution(resolution);
		setOpticalZoom(opticalZoom);
		setDisplaySize(displaySize);
		setDigitalZoom(digitalZoom);
	}

	@Override
	public String toString() {
		return "Camera [resolution=" + resolution + ", opticalZoom=" + opticalZoom + ", displaySize=" + displaySize
				+ ", digitalZoom=" + digitalZoom + ", toString()=" + super.toString() + "]";
	}

	public double getResolution() {
		return resolution;
	}

	public void setResolution(double resolution) throws InvalidInputException {
		if (resolution < 0)
			this.resolution = resolution;
		else
			throw new InvalidInputException("Invalid resolution!");
	}

	public int getOpticalZoom() {
		return opticalZoom;
	}

	public void setOpticalZoom(int opticalZoom) throws InvalidInputException {
		if (opticalZoom < 0)
			this.opticalZoom = opticalZoom;
		else
			throw new InvalidInputException("Invalid input!");
	}

	public double getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(double displaySize) throws InvalidInputException {
		if (displaySize < 0)
			this.displaySize = displaySize;
		else
			throw new InvalidInputException("Invalid display size!");
	}

	public int getDigitalZoom() {
		return digitalZoom;
	}

	public void setDigitalZoom(int digitalZoom) throws InvalidInputException {
		if (digitalZoom < 0)
			this.digitalZoom = digitalZoom;
		else
			throw new InvalidInputException("Invalid input!");
	}

}
