package com.solvd.airport.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "passenger")
@XmlType(propOrder = { "passengerId", "email", "luggages" })
public class Passenger extends Person {
	@JsonProperty
	private long passengerId;
	@JsonProperty
	private String email;
	@JsonProperty
	private List<Luggage> luggages;

	public Passenger() {
	};

	public Passenger(String name, int age, String email, long id) {
		super(name, age);
		this.email = email;
		this.passengerId = id;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Luggage> getLuggages() {
		return luggages;
	}

	@XmlElementWrapper(name = "luggages")
	@XmlElement(name = "luggage")
	public void setLuggages(List<Luggage> luggages) {
		this.luggages = luggages;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + getName() + ", age=" + getAge() + ",email=" + email + ", luggages=" + luggages
				+ "]";
	}

	public long getPassengerId() {
		return passengerId;
	}

	@XmlAttribute
	public void setPassengerId(long id) {
		this.passengerId = id;
	}

}
