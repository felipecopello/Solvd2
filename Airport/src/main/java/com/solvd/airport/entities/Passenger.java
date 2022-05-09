package com.solvd.airport.entities;

import java.util.List;

public class Passenger extends Person {
	private long passengerId;
	private String email;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Luggage> getLuggages() {
		return luggages;
	}

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

	public void setPassengerId(long id) {
		this.passengerId = id;
	}

}
