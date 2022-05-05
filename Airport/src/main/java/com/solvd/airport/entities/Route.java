package com.solvd.airport.entities;

public class Route {
	private Airport departureAirport;
	private Airport arrivalAirport;

	Route() {
	};

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
}
