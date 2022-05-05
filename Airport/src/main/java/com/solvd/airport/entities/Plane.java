package com.solvd.airport.entities;

public class Plane {
	private String model;
	private int capacity;

	public Plane() {
	};

	public Plane(String model, Integer capacity) {
		this.model = model;
		this.capacity = capacity;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

}
