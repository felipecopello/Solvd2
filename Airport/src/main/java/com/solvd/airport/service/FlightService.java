package com.solvd.airport.service;

import java.sql.SQLException;

import com.solvd.airport.dao.jdbc.realization.AirlineDao;
import com.solvd.airport.dao.jdbc.realization.FlightDao;
import com.solvd.airport.dao.jdbc.realization.PilotDao;
import com.solvd.airport.dao.jdbc.realization.PlaneDao;
import com.solvd.airport.dao.jdbc.realization.RouteDao;
import com.solvd.airport.entities.Airline;
import com.solvd.airport.entities.Flight;
import com.solvd.airport.entities.Pilot;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.entities.Route;
import com.solvd.airport.interfaces.IAirlineDao;
import com.solvd.airport.interfaces.IFlightDao;
import com.solvd.airport.interfaces.IPilotDao;
import com.solvd.airport.interfaces.IPlaneDao;
import com.solvd.airport.interfaces.IRouteDao;

public class FlightService {
	private IFlightDao flightDao = new FlightDao();
	private IPlaneDao planeDao = new PlaneDao();
	private IPilotDao pilotDao = new PilotDao();
	private IRouteDao routeDao = new RouteDao();
	private IAirlineDao airlineDao = new AirlineDao();

	public Flight getFlightById(long id) {
		Flight flight = new Flight();

		try {
			flight = flightDao.getById(id);
			Plane plane = planeDao.getByFlightId(id);
			Pilot pilot = pilotDao.getByFlightId(id);
			Airline airline = airlineDao.getByPilotId(pilot.getPilotId());
			Route route = routeDao.getByFlightId(id);

			RouteService routeService = new RouteService();
			routeService.populateRoute(route);

			pilot.setEmployer(airline);
			flight.setPlane(plane);
			flight.setPilot(pilot);
			flight.setRoute(route);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flight;
	}

}
