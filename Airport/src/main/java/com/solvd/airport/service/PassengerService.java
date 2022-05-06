package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.dao.jdbc.realization.LuggageDao;
import com.solvd.airport.dao.jdbc.realization.PassengerDao;
import com.solvd.airport.entities.Luggage;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.interfaces.ILuggageDao;
import com.solvd.airport.interfaces.IPassengerDao;

public class PassengerService {
	private IPassengerDao passengerDao = new PassengerDao();
	private ILuggageDao luggageDao = new LuggageDao();

	public Passenger getPassengerById(long id) {
		Passenger passenger = new Passenger();
		List<Luggage> luggages = new ArrayList<Luggage>();

		try {
			passenger = passengerDao.getById(id);
			luggages = luggageDao.getByPassengerId(id);
			passenger.setLuggages(luggages);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passenger;
	}
}
