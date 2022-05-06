package com.solvd.airport.entities;

public class Luggage {
	private int weight;

	public Luggage() {
	};

	public Luggage(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Luggage [weight=" + weight + "]";
	}

}
