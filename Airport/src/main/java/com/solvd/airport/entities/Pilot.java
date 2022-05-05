package com.solvd.airport.entities;

public class Pilot extends Person {
	private String employer;

	public Pilot() {
	};

	public Pilot(String name, int age, String employer) {
		super(name, age);
		this.employer = employer;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}
}
