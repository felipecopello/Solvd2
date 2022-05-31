package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.dao.jdbc.realization.PilotDao;
import com.solvd.airport.dao.jdbc.realization.RouteDao;
import com.solvd.airport.entities.Airline;
import com.solvd.airport.entities.Flight;
import com.solvd.airport.entities.Pilot;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.entities.Route;
import com.solvd.airport.interfaces.IAirlineDao;
import com.solvd.airport.interfaces.IAirportDao;
import com.solvd.airport.interfaces.IFlightDao;
import com.solvd.airport.interfaces.IPilotDao;
import com.solvd.airport.interfaces.IPlaneDao;
import com.solvd.airport.interfaces.IRouteDao;
import com.solvd.airport.patterns.DaoFactory;

public class FlightService {
	private static final Logger LOGGER = LogManager.getLogger(AirlineService.class);
	private IFlightDao flightDao = (IFlightDao) DaoFactory.getDao("flight");
	private IPlaneDao planeDao = (IPlaneDao) DaoFactory.getDao("plane");
	private IPilotDao pilotDao = new PilotDao();
	private IRouteDao routeDao = new RouteDao();
	private IAirlineDao airlineDao = (IAirlineDao) DaoFactory.getDao("airline");
	private AirportService airportService = new AirportService();
	private IAirportDao airportDao = (IAirportDao) DaoFactory.getDao("airport");

	public Flight getFlightById(long id) {
		Flight flight = new Flight();

		try {
			flight = flightDao.getById(id);
			populateFlight(flight);
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return flight;
	}

	public List<Flight> getAllFlights() {
		List<Flight> flightList = new ArrayList<>();
		try {
			flightList = flightDao.getAll();
			flightList.forEach((flight) -> {
				try {
					populateFlight(flight);
				} catch (SQLException e) {
					LOGGER.info(e.getMessage());
				}
			});
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return flightList;
	}

	public void deleteFlight(Flight flight) {
		try {
			flightDao.delete(flight);
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}

	}

	public void populateFlight(Flight flight) throws SQLException {
		long id = flight.getFlightId();
		try {
			Plane plane = planeDao.getByFlightId(id);
			Pilot pilot = pilotDao.getByFlightId(id);
			Airline airline = airlineDao.getByPilotId(pilot.getPilotId());
			Route r = routeDao.getByFlightId(id);
			r.setDepartureAirport(
					airportService.populateAirport(airportDao.getDepartureAirportByRouteId(r.getRouteId())));
			r.setArrivalAirport(
					airportService.populateAirport(airportDao.getDepartureAirportByRouteId(r.getRouteId())));
			pilot.setEmployer(airline);
			flight.setPlane(plane);
			flight.setPilot(pilot);
			flight.setRoute(r);
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
	}

}
