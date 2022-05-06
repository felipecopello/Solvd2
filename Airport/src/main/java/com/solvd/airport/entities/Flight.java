package com.solvd.airport.entities;

public class Flight {
	private Plane plane;
	private Pilot pilot;
	private Route route;
	private int priceUsd;

	public Flight() {
	}

	public Flight(Plane plane, Pilot pilot, Route route, int priceUsd) {
		this.plane = plane;
		this.pilot = pilot;
		this.route = route;
		this.priceUsd = priceUsd;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public int getPriceUsd() {
		return priceUsd;
	}

	public void setPriceUsd(int priceUsd) {
		this.priceUsd = priceUsd;
	}

	@Override
	public String toString() {
		return "Flight [plane=" + plane + ", pilot=" + pilot + ", route=" + route + ", priceUsd=" + priceUsd + "]";
	}

}
