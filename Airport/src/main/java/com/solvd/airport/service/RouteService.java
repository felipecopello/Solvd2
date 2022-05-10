package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.dao.jdbc.realization.AirportDao;
import com.solvd.airport.dao.jdbc.realization.RouteDao;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.entities.Route;
import com.solvd.airport.interfaces.IAirportDao;
import com.solvd.airport.interfaces.IRouteDao;

public class RouteService {
	private static final Logger LOGGER = LogManager.getLogger(AirlineService.class);
	private IRouteDao routeDao = new RouteDao();
	private IAirportDao airportDao = new AirportDao();
	private AirportService airportService = new AirportService();

	public Route getRouteById(long id) {
		Route r = new Route();

		try {
			r = routeDao.getById(id);
			r.setDepartureAirport(airportService.populateAirport(airportDao.getDepartureAirportByRouteId(id)));
			r.setArrivalAirport(airportService.populateAirport(airportDao.getDepartureAirportByRouteId(id)));
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return r;
	}

	public List<Route> getAllRoutes() {
		List<Route> routeList = new ArrayList<>();
		try {
			routeList = routeDao.getAll();
			routeList.forEach((r) -> {
				try {
					Airport departureAirport = airportService
							.populateAirport(airportDao.getDepartureAirportByRouteId(r.getRouteId()));
					r.setDepartureAirport(departureAirport);

					Airport arrivalAirport = airportDao.getArrivalAirportByRouteId(r.getRouteId());
					r.setArrivalAirport(arrivalAirport);

				} catch (SQLException e) {
					LOGGER.info(e.getMessage());
				}
			});
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return routeList;
	}

}
