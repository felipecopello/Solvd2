package com.solvd.airport.service;

import java.sql.SQLException;

import com.solvd.airport.dao.jdbc.realization.AirportDao;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.interfaces.IAirportDao;

public class AirportService {
	private IAirportDao airportDao = new AirportDao();

	public Airport getAirportById(long id) {
		Airport a = new Airport();
		try {
			a = airportDao.getById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
}
