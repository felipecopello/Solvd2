package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<City> getAllCities() {
		List<City> cityList = new ArrayList<>();
		try {
			cityList = cityDao.getAll();
			cityList.forEach((city) -> {
				try {
					Country country = countryDao.getByCityId(city.getCityId());
					city.setCountry(country);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cityList;
	}
}
