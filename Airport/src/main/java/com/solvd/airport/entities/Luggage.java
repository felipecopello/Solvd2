package com.solvd.airport.entities;

public class Luggage {
	private int weight;
	private Passenger owner;

	public Luggage() {
	};

	public Luggage(int weight, Passenger owner) {
		this.weight = weight;
		this.owner = owner;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Passenger getOwner() {
		return owner;
	}

	public void setOwner(Passenger owner) {
		this.owner = owner;
	}
}
