package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.dao.jdbc.realization.AirlineDao;
import com.solvd.airport.dao.jdbc.realization.AirlineInAirportDao;
import com.solvd.airport.entities.Airline;
import com.solvd.airport.entities.AirlineInAirport;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.interfaces.IAirlineDao;
import com.solvd.airport.interfaces.IAirlineInAirportDao;

public class AirlineInAirportService {
	private static final Logger LOGGER = LogManager.getLogger(AirlineInAirportService.class);
	private IAirlineInAirportDao airlineInAirportDao = new AirlineInAirportDao();
	private IAirlineDao airlineDao = new AirlineDao();

	public AirlineInAirport getAirportsByAirlineId(long id) {
		AirlineInAirport airlineInAirport = new AirlineInAirport();

		try {
			Airline airline = airlineDao.getById(id);
			List<Airport> airports = airlineInAirportDao.getAirportsByAirlineId(id);
			airlineInAirport.setAirline(airline);
			airlineInAirport.setAirports(airports);

		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return airlineInAirport;
	}
}
