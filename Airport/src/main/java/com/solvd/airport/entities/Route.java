package com.solvd.airport.entities;

public class Route {
	private int arrivalAirportId;
	private int departureAirportId;
	private Airport departureAirport;
	private Airport arrivalAirport;

	public Route() {
	};

	public Route(int departureAirportId, int arrivalAirportId) {
		this.arrivalAirportId = arrivalAirportId;
		this.departureAirportId = departureAirportId;
	}

	public Route(Airport departureAirport, Airport arrivalAirport) {
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}

	public int getDepartureAirportId() {
		return departureAirportId;
	}

	public void setDepartureAirportId(int departureAirportId) {
		this.departureAirportId = departureAirportId;
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

	@Override
	public String toString() {
		return "Route [departureAirportId=" + departureAirportId + ", arrivalAirportId=" + arrivalAirportId
				+ ", departureAirport=" + departureAirport + ", arrivalAirport=" + arrivalAirport + "]";
	}

	public int getArrivalAirportId() {
		return arrivalAirportId;
	}

	public void setArrivalAirportId(int arrivalAirportId) {
		this.arrivalAirportId = arrivalAirportId;
	}

}
