package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.dao.jdbc.realization.AirlineDao;
import com.solvd.airport.entities.Airline;
import com.solvd.airport.interfaces.IAirlineDao;

public class AirlineService {
	private IAirlineDao airlineDao = new AirlineDao();

	public Airline getAirlineById(long id) {
		Airline a = new Airline();
		try {
			a = airlineDao.getById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public List<Airline> getAllAirlines() {
		List<Airline> airlineList = new ArrayList<>();
		try {
			airlineList = airlineDao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airlineList;
	}
}
