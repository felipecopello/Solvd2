package com.solvd.airport.entities;

public class Passenger extends Person {
	private String email;

	public Passenger() {
	};

	public Passenger(String name, int age, String email) {
		super(name, age);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
