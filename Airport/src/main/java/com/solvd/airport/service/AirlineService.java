package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.entities.Airline;
import com.solvd.airport.interfaces.IAirlineDao;
import com.solvd.airport.patterns.DaoFactory;

public class AirlineService {
	private static final Logger LOGGER = LogManager.getLogger(AirlineService.class);
	private IAirlineDao airlineDao = (IAirlineDao) DaoFactory.getDao("airline");

	public Airline getAirlineById(long id) {
		Airline a = new Airline();
		try {
			a = airlineDao.getById(id);
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return a;
	}

	public List<Airline> getAllAirlines() {
		List<Airline> airlineList = new ArrayList<>();
		try {
			airlineList = airlineDao.getAll();
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return airlineList;
	}

	public void saveAirline(Airline airline) {
		try {
			airlineDao.save(airline);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
