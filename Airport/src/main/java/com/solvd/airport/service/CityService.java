package com.solvd.airport.service;

import java.sql.SQLException;

import com.solvd.airport.dao.jdbc.realization.CityDao;
import com.solvd.airport.dao.jdbc.realization.CountryDao;
import com.solvd.airport.entities.City;
import com.solvd.airport.entities.Country;
import com.solvd.airport.interfaces.ICityDao;
import com.solvd.airport.interfaces.ICountryDao;

public class CityService {
	private ICityDao cityDao = new CityDao();
	private ICountryDao countryDao = new CountryDao();

	public City getCityById(long id) {
		City city = new City();
		Country country = new Country();
		try {
			city = cityDao.getById(id);
			country = countryDao.getByCityId(id);
			city.setCountry(country);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}
}
