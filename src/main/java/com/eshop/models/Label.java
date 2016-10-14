package com.eshop.models;

import org.springframework.context.annotation.ComponentScan;

import com.eshop.exceptions.InvalidInputException;

public class Label {
	private String name;
	private int count = 1;
	
	public Label(String name) throws InvalidInputException {
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) throws InvalidInputException {
		if(name != null && !name.isEmpty())
			this.name = name;

	}
	
	public void increaseCount(){
		this.count++;
	}

	public int getCount() {
		return count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Label other = (Label) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
	
}
