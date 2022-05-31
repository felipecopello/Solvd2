package com.solvd.airport.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.airport.interfaces.IListener;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "pilot")
@XmlType(propOrder = { "pilotId", "employer" })
public class Pilot extends Person implements IListener {
	@JsonProperty
	private int pilotId;
	@JsonProperty
	private Airline employer;
	@XmlTransient
	private String flightStatus;

	public Pilot() {
	};

	public Pilot(int pilotId, String name, int age) {
		super(name, age);
		this.pilotId = pilotId;
	}

	public Airline getEmployer() {
		return employer;
	}

	@XmlElement(name = "employer")
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

	@XmlAttribute
	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
	}

	public String getFlightStatus() {
		return flightStatus;
	}

	@XmlTransient
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	@Override
	public void updateFlightStatus(Object o) {
		this.setFlightStatus((String) o);
	}

}
