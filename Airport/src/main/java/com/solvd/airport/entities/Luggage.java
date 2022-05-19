package com.solvd.airport.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "luggage")
@XmlType(propOrder = { "weight" })
public class Luggage {
	@JsonProperty
	private float weight;

	public Luggage() {
	};

	public Luggage(float weight) {
		this.weight = weight;
	}

	public float getWeight() {
		return weight;
	}

	@XmlElement(name = "weight")
	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Luggage [weight=" + weight + "]";
	}

}
