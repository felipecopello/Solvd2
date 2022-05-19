package com.solvd.airport.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "route")
@XmlType(propOrder = { "routeId", "departureAirport", "arrivalAirport" })
public class Route {
	@JsonProperty
	private long routeId;
	@JsonProperty
	private Airport departureAirport;
	@JsonProperty
	private Airport arrivalAirport;

	public Route() {
	};

	public Route(long routeId) {
		this.routeId = routeId;
	}

	public Route(Airport departureAirport, Airport arrivalAirport) {
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	@XmlElement(name = "departureAirport")
	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	@XmlElement(name = "arrivalAirport")
	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public long getRouteId() {
		return routeId;
	}

	@XmlAttribute
	public void setRouteId(long routeId) {
		this.routeId = routeId;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", departureAirport=" + departureAirport + ", arrivalAirport="
				+ arrivalAirport + "]";
	}

}
