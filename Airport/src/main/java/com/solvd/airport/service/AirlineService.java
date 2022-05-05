package com.solvd.airport.dao.service;

import java.sql.SQLException;

import com.solvd.airport.dao.interfaces.IAirlineDao;
import com.solvd.airport.dao.jdbc.realization.AirlineDao;
import com.solvd.airport.entities.Airline;

public class AirlineService {
	private IAirlineDao airlineDao = new AirlineDao();

	public Airline getAirlineById(long id) {
		Airline p = new Airline();
		try {
			p = airlineDao.getById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}
