package com.solvd.airport.entities;

public class Airport {
	private long airportId;
	private String name;
	private int planesCapacity;
	private City city;

	public Airport() {
	};

	public Airport(String name, int planesCapacity, City city) {
		this.name = name;
		this.planesCapacity = planesCapacity;
		this.city = city;
	}

	public Airport(long airportId, String name, int planesCapacity) {
		this.airportId = airportId;
		this.name = name;
		this.planesCapacity = planesCapacity;
	}

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
		return "Airport [name=" + name + ", planesCapacity=" + planesCapacity + ", city=" + city + "]";
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public long getAirportId() {
		return airportId;
	}

	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}
}
