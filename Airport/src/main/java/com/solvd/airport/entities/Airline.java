package com.solvd.airport.entities;

public class Airline {
	private String name;
	private int workingPlanes;

	public Airline() {
	};

	public Airline(String name, int workingPlanes) {
		this.name = name;
		this.workingPlanes = workingPlanes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWorkingPlanes() {
		return workingPlanes;
	}

	public void setWorkingPlanes(int workingPlanes) {
		this.workingPlanes = workingPlanes;
	}

	@Override
	public String toString() {
		return "Airline [name=" + name + ", workingPlanes=" + workingPlanes + "]";
	}

}
