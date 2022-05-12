package com.solvd.airport.entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "city")
@XmlType(propOrder = { "cityId", "name", "country", "population" })
public class City {
	private long cityId;
	private String name;
	private Country country;
	private int population;

	public City() {
	};

	public City(String name, Country country, int population) {
		this.name = name;
		this.country = country;
		this.population = population;
	}

	public City(long cityId, String name, int population) {
		this.cityId = cityId;
		this.name = name;
		this.population = population;
	}

	public City(String name, int population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	@XmlElement(name = "country")
	public void setCountry(Country country) {
		this.country = country;
	}

	public int getPopulation() {
		return population;
	}

	@XmlElement(name = "population")
	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", name=" + name + ", country=" + country + ", population=" + population
				+ "]";
	}

	public long getCityId() {
		return cityId;
	}

	@XmlAttribute
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

}
