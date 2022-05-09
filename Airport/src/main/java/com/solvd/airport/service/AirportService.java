package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.dao.jdbc.realization.AirportDao;
import com.solvd.airport.dao.jdbc.realization.CityDao;
import com.solvd.airport.dao.jdbc.realization.CountryDao;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.entities.City;
import com.solvd.airport.entities.Country;
import com.solvd.airport.interfaces.IAirportDao;
import com.solvd.airport.interfaces.ICityDao;
import com.solvd.airport.interfaces.ICountryDao;

public class AirportService {
	private static final Logger LOGGER = LogManager.getLogger(AirlineService.class);
	private IAirportDao airportDao = new AirportDao();
	private ICityDao cityDao = new CityDao();
	private ICountryDao countryDao = new CountryDao();

	public Airport getAirportById(long id) {
		Airport airport = new Airport();
		try {
			airport = airportDao.getById(id);
			City city = cityDao.getByAirportId(id);
			Country country = countryDao.getByAirportId(id);
			city.setCountry(country);
			airport.setCity(city);
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return airport;
	}

	public List<Airport> getAllAirports() {
		List<Airport> airportList = new ArrayList<>();
		try {
			airportList = airportDao.getAll();
			airportList.forEach((airport) -> {
				try {
					City city = cityDao.getByAirportId(airport.getAirportId());
					Country country = countryDao.getByAirportId(airport.getAirportId());
					city.setCountry(country);
					airport.setCity(city);
				} catch (SQLException e) {
					LOGGER.info(e.getMessage());
				}
			});
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return airportList;
	}
}
