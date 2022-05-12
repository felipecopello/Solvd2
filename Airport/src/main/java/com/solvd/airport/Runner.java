package com.solvd.airport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.connection.ConnectionPool;
import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.dom.DomTask;

public class Runner extends abstractJDBCDao {
	private static final Logger LOGGER = LogManager.getLogger(Runner.class);
	private static ConnectionPool cp = getCp();

	public static void main(String[] arg) {

//		AirlineService airlineService = new AirlineService();
//		// Airline swiss = new Airline("Swiss", 691);
////		LOGGER.info(airlineService.getAirlineById(2));
//		// airlineService.saveAirline(swiss);
//		LOGGER.info(airlineService.getAllAirlines());
//
////		PilotService pilotService = new PilotService();
////		Pilot pilotDanna = pilotService.getPilotById(1);
////		LOGGER.info(pilotDanna.getEmployer());
////		String[] updateData = { "50", "2" };
////		pilotService.updatePilot(pilotDanna, updateData);
////		LOGGER.info(pilotService.getPilotById(1));
////		LOGGER.info(pilotService.getAllPilots());
//
////		CountryService countryService = new CountryService();
////		Country spain = new Country("Spain");
////		countryService.saveCountry(spain);
////		Country españa = countryService.getCountryById(9);
////		LOGGER.info(countryService.getAllCountries());
//
//		CityService cityService = new CityService();
////		City barcelona = new City("Barcelona", españa, 2500000);
////		cityService.saveCity(barcelona);
//		City barna = cityService.getCityById(8);
////		LOGGER.info(cityService.getAllCities());
//
////		AirportService airportService = new AirportService();
//		Airport elPrat = new Airport("Aeropuerto Internacional el Prat", 854, barna);
////		airportService.saveAirport(elPrat);
////		LOGGER.info(airportService.getAirportById(1));
////		LOGGER.info(airportService.getAllAirports());
//
////		LuggageService luggageService = new LuggageService();
////		LOGGER.info(luggageService.getLuggageById(1));
////		LOGGER.info(luggageService.getAllLuggages());
//
//		PassengerService passengerService = new PassengerService();
//		Passenger passenger = passengerService.getPassengerById(1);
////		LOGGER.info(passengerService.getAllPassengers());
//
////		RouteService routeService = new RouteService();
////		LOGGER.info(routeService.getRouteById(2));
////		LOGGER.info(routeService.getAllRoutes());
//
////		PlaneService planeService = new PlaneService();
////		Plane plane1 = planeService.getPlaneById(1);
////		LOGGER.info(plane1);
////		plane1.setCapacity(598);
////		planeService.updatePlane(plane1);
////		LOGGER.info(planeService.getAllPlanes());
//
////		FlightService flightService = new FlightService();
////		Flight flight1 = flightService.getFlightById(1);
////		LOGGER.info(flightService.getFlightById(6));
////		LOGGER.info(flightService.getAllFlights());
////		flightService.deleteFlight(flight1);
//		// LOGGER.info(flightService.getAllFlights());
//
////		AirlineInAirportService aInAService = new AirlineInAirportService();
////		LOGGER.info(aInAService.getAirportsByAirlineId(1));

		DomTask.enteringDocument("passenger");

		cp.closeAllConnections(cp);
	}
}
