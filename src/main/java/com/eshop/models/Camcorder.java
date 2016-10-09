package com.eshop.models;

import javax.activity.InvalidActivityException;

import com.eshop.exceptions.InvalidInputException;

public class Camcorder extends Article{
	private double resolution;
	private String cameraType;
	private double displaySize;
	private int digitalZoom;
	
	public Camcorder(String image,String label, String model, double price, double resolution, String cameraType, double displaySize,
			int digitalZoom) throws InvalidInputException, InvalidActivityException {
		super(label, model, price, image);
		setResolution(resolution);
		setCameraType(cameraType);
		setDisplaySize(displaySize);
		setDigitalZoom(digitalZoom);
	}

	@Override
	public String toString() {
		return "Camcorder [resolution=" + resolution + ", cameraType=" + cameraType + ", displaySize=" + displaySize
				+ ", digitalZoom=" + digitalZoom + ", toString()=" + super.toString() + "]";
	}

	public double getResolution() {
		return resolution;
	}
	
	public void setResolution(double resolution) throws InvalidActivityException {
		if(resolution < 0)
			this.resolution = resolution;
		else
			throw new InvalidActivityException("Invalid input!");
	}
	public String getCameraType() {
		return cameraType;
	}
	public void setCameraType(String cameraType) throws InvalidInputException {
		if(cameraType != null && !cameraType.isEmpty())
			this.cameraType = cameraType;
		else throw new InvalidInputException("Invalid camera type!");
	}
	public double getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(double displaySize) throws InvalidInputException {
		if(displaySize < 0)
			this.displaySize = displaySize;
		else
			throw new InvalidInputException("Invalid display size !");
	}
	public int getDigitalZoom() {
		return digitalZoom;
	}
	public void setDigitalZoom(int digitalZoom) throws InvalidInputException {
		if(digitalZoom < 0)
			this.digitalZoom = digitalZoom;
		else
			throw new InvalidInputException("Invalid input!");
	}
	
	
}
