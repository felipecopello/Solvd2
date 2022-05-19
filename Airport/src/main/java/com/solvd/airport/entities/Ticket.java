package com.solvd.airport.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ticket")
@XmlType(propOrder = { "passenger", "flight", "priceUsd" })
public class Ticket {
	@JsonProperty
	private Passenger passenger;
	@JsonProperty
	private List<Flight> flight;
	@JsonProperty
	private int priceUsd;

	public Ticket() {
	}

	public Ticket(Passenger passenger, List<Flight> flight, int priceUsd) {
		this.passenger = passenger;
		this.flight = flight;
		this.priceUsd = priceUsd;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	@XmlElement(name = "passenger")
	public void setPassenger(Passenger owner) {
		this.passenger = owner;
	}

	public List<Flight> getFlight() {
		return flight;
	}

	@XmlElementWrapper(name = "flights")
	@XmlElement(name = "flight")
	public void setFlight(List<Flight> flight) {
		this.flight = flight;
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
		return "Ticket [passenger=" + passenger + ", flight=" + flight + ", priceUsd=" + priceUsd + "]";
	}
}
