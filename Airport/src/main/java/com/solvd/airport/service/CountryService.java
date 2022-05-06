package com.solvd.airport.service;

import java.sql.SQLException;

import com.solvd.airport.dao.jdbc.realization.CountryDao;
import com.solvd.airport.entities.Country;
import com.solvd.airport.interfaces.ICountryDao;

public class CountryService {

	private ICountryDao countryDao = new CountryDao();

	public Country getCountryById(long id) {
		Country c = new Country();
		try {
			c = countryDao.getById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

}
