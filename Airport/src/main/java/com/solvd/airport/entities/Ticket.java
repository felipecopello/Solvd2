package com.solvd.airport.entities;

import java.util.List;

public class Ticket {
	private Passenger owner;
	private List<Flight> flight;
	private int priceUsd;

	public Ticket(Passenger owner, List<Flight> flight, int priceUsd) {
		this.owner = owner;
		this.flight = flight;
		this.priceUsd = priceUsd;
	}

	public Passenger getOwner() {
		return owner;
	}

	public void setOwner(Passenger owner) {
		this.owner = owner;
	}

	public List<Flight> getFlight() {
		return flight;
	}

	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}

	public int getPriceUsd() {
		return priceUsd;
	}

	public void setPriceUsd(int priceUsd) {
		this.priceUsd = priceUsd;
	}

	@Override
	public String toString() {
		return "Ticket [owner=" + owner + ", flight=" + flight + ", priceUsd=" + priceUsd + "]";
	}
}
