package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.dao.jdbc.realization.CountryDao;
import com.solvd.airport.entities.Country;
import com.solvd.airport.interfaces.ICountryDao;

public class CountryService {
	private static final Logger LOGGER = LogManager.getLogger(AirlineService.class);
	private ICountryDao countryDao = new CountryDao();

	public Country getCountryById(long id) {
		Country c = new Country();
		try {
			c = countryDao.getById(id);
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return c;
	}

	public List<Country> getAllCountries() {
		List<Country> countryList = new ArrayList<>();
		try {
			countryList = countryDao.getAll();
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return countryList;
	}

	public void saveCountry(Country country) {
		try {
			countryDao.save(country);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
