package com.solvd.airport.entities;

public class Route {
	private long routeId;
	private Airport departureAirport;
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

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public long getRouteId() {
		return routeId;
	}

	public void setRouteId(long routeId) {
		this.routeId = routeId;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", departureAirport=" + departureAirport + ", arrivalAirport="
				+ arrivalAirport + "]";
	}

}
