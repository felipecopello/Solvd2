package com.solvd.airport.entities;

public class Pilot extends Person {
	private Airline employer;

	public Pilot() {
	};

	public Pilot(String name, int age) {
		super(name, age);
	}

	public Airline getEmployer() {
		return employer;
	}

	public void setEmployer(Airline employer) {
		this.employer = employer;
	}

	@Override
	public String toString() {
		return "Pilot [name=" + getName() + ", age=" + getAge() + ", employer=" + employer + "]";
	}

}
