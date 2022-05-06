package com.solvd.airport.service;

import java.sql.SQLException;

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
	private IAirportDao airportDao = new AirportDao();
	private ICityDao cityDao = new CityDao();
	private ICountryDao countryDao = new CountryDao();

	public Airport getAirportById(long id) {
		Airport airport = new Airport();
		City city = new City();
		Country country = new Country();
		try {
			airport = airportDao.getById(id);
			city = cityDao.getByAirportId(id);
			country = countryDao.getByAirportId(id);
			city.setCountry(country);
			airport.setCity(city);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airport;
	}
}