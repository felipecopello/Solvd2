package com.solvd.airport.entities;

public class Airport {
	private String name;
	private int planesCapacity;
	private City city;

	public Airport() {
	};

	public Airport(String name, int planesCapacity) {
		this.name = name;
		this.planesCapacity = planesCapacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlanesCapacity() {
		return planesCapacity;
	}

	public void setPlanesCapacity(int planesCapacity) {
		this.planesCapacity = planesCapacity;
	}

	@Override
	public String toString() {
		return "Airport [name=" + name + ", planesCapacity=" + planesCapacity + "]";
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
