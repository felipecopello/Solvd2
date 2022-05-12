package com.solvd.airport.entities;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "airline")
@XmlType(propOrder = { "name", "workingPlanes" })
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

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public int getWorkingPlanes() {
		return workingPlanes;
	}

	@XmlElement(name = "workingPlanes")
	public void setWorkingPlanes(int workingPlanes) {
		this.workingPlanes = workingPlanes;
	}

	@Override
	public String toString() {
		return "Airline [name=" + name + ", workingPlanes=" + workingPlanes + "]";
	}

}
