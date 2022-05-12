package com.solvd.airport.entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "flight")
@XmlType(propOrder = { "flightId", "plane", "pilot", "route", "priceUsd" })
public class Flight {
	private long flightId;
	private Plane plane;
	private Pilot pilot;
	private Route route;
	private int priceUsd;

	public Flight() {
	}

	public Flight(long flightId, int priceUsd) {
		this.flightId = flightId;
		this.priceUsd = priceUsd;
	}

	public Plane getPlane() {
		return plane;
	}

	@XmlElement(name = "plane")
	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Pilot getPilot() {
		return pilot;
	}

	@XmlElement(name = "pilot")
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public Route getRoute() {
		return route;
	}

	@XmlElement(name = "route")
	public void setRoute(Route route) {
		this.route = route;
	}

	public int getPriceUsd() {
		return priceUsd;
	}

	@XmlElement(name = "priceUsd")
	public void setPriceUsd(int priceUsd) {
		this.priceUsd = priceUsd;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", plane=" + plane + ", pilot=" + pilot + ", route=" + route
				+ ", priceUsd=" + priceUsd + "]";
	}

	public long getFlightId() {
		return flightId;
	}

	@XmlAttribute
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

}
