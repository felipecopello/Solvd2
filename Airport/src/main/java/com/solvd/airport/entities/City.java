package com.solvd.airport.entities;

public class City {
	private String name;
	private Country country;
	private int population;

	public City() {
	};

	public City(String name, int population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", country=" + country + "]";
	}

}
