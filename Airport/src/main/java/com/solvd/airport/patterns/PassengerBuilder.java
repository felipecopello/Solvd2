package com.solvd.airport.patterns;

import java.util.List;

import com.solvd.airport.entities.Luggage;
import com.solvd.airport.entities.Passenger;

public class PassengerBuilder {
	private String name;
	private int age;
	private long passengerId;
	private String email;
	private List<Luggage> luggages;

	public PassengerBuilder() {
	}

	public PassengerBuilder(String name, int age, long passengerId, String email, List<Luggage> luggages) {
		this.name = name;
		this.age = age;
		this.passengerId = passengerId;
		this.email = email;
		this.luggages = luggages;
	}

	public PassengerBuilder setPassengerId(long passengerId) {
		this.passengerId = passengerId;
		return this;
	}

	public PassengerBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public PassengerBuilder setLuggages(List<Luggage> luggages) {
		this.luggages = luggages;
		return this;
	}

	public PassengerBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public PassengerBuilder setAge(int age) {
		this.age = age;
		return this;
	}

	public Passenger build() {
		return new Passenger(name, age, passengerId, email, luggages);
	}
}
