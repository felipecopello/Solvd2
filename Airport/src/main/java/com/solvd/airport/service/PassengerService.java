package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.dao.jdbc.realization.LuggageDao;
import com.solvd.airport.dao.jdbc.realization.PassengerDao;
import com.solvd.airport.entities.Luggage;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.interfaces.ILuggageDao;
import com.solvd.airport.interfaces.IPassengerDao;

public class PassengerService {
	private static final Logger LOGGER = LogManager.getLogger(AirlineService.class);
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
			LOGGER.info(e.getMessage());
		}
		return passenger;
	}

	public List<Passenger> getAllPassengers() {
		List<Passenger> passengerList = new ArrayList<>();
		try {
			passengerList = passengerDao.getAll();
			passengerList.forEach((passenger) -> {
				try {
					List<Luggage> luggages = luggageDao.getByPassengerId(passenger.getPassengerId());
					passenger.setLuggages(luggages);
				} catch (SQLException e) {
					LOGGER.info(e.getMessage());
				}
			});
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return passengerList;
	}
}
