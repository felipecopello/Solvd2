package com.solvd.airport.entities;

public class Plane {
	private long planeId;
	private String model;
	private int capacity;

	public Plane() {
	};

	public Plane(long planeId, String model, int capacity) {
		this.planeId = planeId;
		this.model = model;
		this.capacity = capacity;
	}

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

	@Override
	public String toString() {
		return "Plane [model=" + model + ", capacity=" + capacity + "]";
	}

	public long getPlaneId() {
		return planeId;
	}

	public void setPlaneId(long planeId) {
		this.planeId = planeId;
	}

}
