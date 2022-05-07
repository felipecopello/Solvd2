package com.solvd.airport.entities;

public class Pilot extends Person {
	private int pilotId;
	private Airline employer;

	public Pilot() {
	};

	public Pilot(int pilotId, String name, int age) {
		super(name, age);
		this.pilotId = pilotId;
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

	public int getPilotId() {
		return pilotId;
	}

	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
	}

}
