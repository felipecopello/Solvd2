package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	private static final Logger LOGGER = LogManager.getLogger(AirlineService.class);
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
			LOGGER.info(e.getMessage());
		}
		return r;
	}

	public List<Route> getAllRoutes() {
		List<Route> routeList = new ArrayList<>();
		try {
			routeList = routeDao.getAll();
			routeList.forEach((route) -> {
				try {
					populateRoute(route);
				} catch (SQLException e) {
					LOGGER.info(e.getMessage());
				}
			});
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return routeList;
	}

	public Route populateRoute(Route r) throws SQLException {

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
			LOGGER.info(e.getMessage());
		}
		return r;
	}
}
