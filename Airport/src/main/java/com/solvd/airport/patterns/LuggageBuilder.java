package com.solvd.airport.patterns;

import com.solvd.airport.entities.Luggage;

public class LuggageBuilder {
	private float weight;

	public LuggageBuilder() {
	}

	public LuggageBuilder(float weight) {
		this.weight = weight;
	}

	public LuggageBuilder setWeight(float weight) {
		this.weight = weight;
		return this;
	}

	public Luggage build() {
		return new Luggage(weight);
	}
}
