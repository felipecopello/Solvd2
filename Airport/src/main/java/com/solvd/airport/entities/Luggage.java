package com.solvd.airport.entities;

public class Luggage {
	private float weight;

	public Luggage() {
	};

	public Luggage(float weight) {
		this.weight = weight;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Luggage [weight=" + weight + "]";
	}

}
