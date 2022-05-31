package com.solvd.airport.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.airport.interfaces.IListener;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "flight")
@XmlType(propOrder = { "flightId", "plane", "pilot", "route" })
public class Flight {
	@JsonProperty
	private long flightId;
	@JsonProperty
	private Plane plane;
	@JsonProperty
	private Pilot pilot;
	@JsonProperty
	private Route route;

	@XmlTransient
	private String flightStatus;
	@XmlTransient
	private List<IListener> listeners = new ArrayList<>();

	public Flight() {
	}

	public Flight(long flightId, int priceUsd) {
		this.flightId = flightId;
	}

	public void addListener(IListener listener) {
		this.listeners.add(listener);
	}

	public void removeListener(IListener listener) {
		this.listeners.remove(listener);
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

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", plane=" + plane + ", pilot=" + pilot + ", route=" + route + "]";
	}

	public long getFlightId() {
		return flightId;
	}

	@XmlAttribute
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getFlightStatus() {
		return flightStatus;
	}

	@XmlTransient
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
		for (IListener listener : this.listeners) {
			listener.updateFlightStatus(this.flightStatus);
		}
	}

}
