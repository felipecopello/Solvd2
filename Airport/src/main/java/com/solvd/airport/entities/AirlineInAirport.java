package com.solvd.airport.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirlineInAirport {
	@JsonProperty
	private int airlineId;
	@JsonProperty
	private int airportId;
	@JsonProperty
	private Airline airline;
	@JsonProperty
	private List<Airport> airports;

	public AirlineInAirport(int airlineId, int airportId) {
		this.airlineId = airlineId;
		this.airportId = airportId;
	}

	public AirlineInAirport(Airline airline, List<Airport> airports) {
		this.airline = airline;
		this.airports = airports;
	}

	public AirlineInAirport() {
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public int getAirportId() {
		return airportId;
	}

	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}

	@Override
	public String toString() {
		return "AirlineInAirport [airline=" + airline + ", airports=" + airports + "]";
	}

}
