package com.solvd.airport.service;

import java.sql.SQLException;

import com.solvd.airport.dao.jdbc.realization.AirportDao;
import com.solvd.airport.dao.jdbc.realization.CityDao;
import com.solvd.airport.dao.jdbc.realization.CountryDao;
import com.solvd.airport.dao.jdbc.realization.RouteDao;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.entities.City;
import com.solvd.airport.entities.Country;
import com.solvd.airport.entities.Route;
import com.solvd.airport.interfaces.IAirportDao;
import com.solvd.airport.interfaces.ICityDao;
import com.solvd.airport.interfaces.ICountryDao;
import com.solvd.airport.interfaces.IRouteDao;

public class RouteService {
	private IRouteDao routeDao = new RouteDao();
	private IAirportDao airportDao = new AirportDao();
	private ICityDao cityDao = new CityDao();
	private ICountryDao countryDao = new CountryDao();

	public Route getRouteById(long id) {
		Route r = new Route();

		try {
			r = routeDao.getById(id);
			populateRoute(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public Route populateRoute(Route r) {

		try {
			Airport departureAirport = airportDao.getById(r.getDepartureAirportId());
			Airport arrivalAirport = airportDao.getById(r.getArrivalAirportId());

			City departureCity = cityDao.getByAirportId(r.getDepartureAirportId());
			City arrivalCity = cityDao.getByAirportId(r.getArrivalAirportId());

			Country departureCountry = countryDao.getByAirportId(r.getDepartureAirportId());
			Country arrivalCountry = countryDao.getByAirportId(r.getArrivalAirportId());

			departureCity.setCountry(departureCountry);
			arrivalCity.setCountry(arrivalCountry);
			departureAirport.setCity(departureCity);
			arrivalAirport.setCity(arrivalCity);

			r.setDepartureAirport(departureAirport);
			r.setArrivalAirport(arrivalAirport);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
}
