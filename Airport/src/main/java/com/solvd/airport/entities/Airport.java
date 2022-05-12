package com.solvd.airport.entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "airport")
@XmlSeeAlso({ City.class, Country.class })
@XmlType(propOrder = { "airportId", "name", "planesCapacity", "city" })
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

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public int getPlanesCapacity() {
		return planesCapacity;
	}

	@XmlElement(name = "planesCapacity")
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

	@XmlElement(name = "city")
	public void setCity(City city) {
		this.city = city;
	}

	public long getAirportId() {
		return airportId;
	}

	@XmlAttribute
	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}
}
