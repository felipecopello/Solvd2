package com.solvd.airport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.service.FlightService;

public class Runner {
	private static final Logger LOGGER = LogManager.getLogger(Runner.class);

	public static void main(String[] arg) {
		// PilotService pilotService = new PilotService();
		// LOGGER.info(pilotService.getPilotById(1).toString());
		// LOGGER.info(pilotService.getAllPilots().toString());

		// AirlineService airlineService = new AirlineService();
		// LOGGER.info(airlineService.getAirlineById(1).toString());
		// LOGGER.info(airlineService.getAllAirlines().toString());

		// AirportService airportService = new AirportService();
		// LOGGER.info(airportService.getAirportById(1).toString());
		// LOGGER.info(airportService.getAllAirports().toString());

		// CountryService countryService = new CountryService();
		// LOGGER.info(countryService.getCountryById(1).toString());
		// LOGGER.info(countryService.getAllCountries().toString());

		// CityService cityService = new CityService();
		// LOGGER.info(cityService.getCityById(1).toString());
		// LOGGER.info(cityService.getAllCities().toString());

		// LuggageService luggageService = new LuggageService();
		// LOGGER.info(luggageService.getLuggageById(1).toString());
		// LOGGER.info(luggageService.getAllLuggages().toString());

		// PassengerService passengerService = new PassengerService();
		// LOGGER.info(passengerService.getPassengerById(1).toString());
		// LOGGER.info(passengerService.getAllPassengers().toString());

		// RouteService routeService = new RouteService();
		// LOGGER.info(routeService.getRouteById(1).toString());
		// LOGGER.info(routeService.getAllRoutes().toString());

		// PlaneService planeService = new PlaneService();
		// LOGGER.info(planeService.getPlaneById(1).toString());
		// LOGGER.info(planeService.getAllPlanes().toString());

		FlightService flightService = new FlightService();
		// LOGGER.info(flightService.getFlightById(1).toString());
		LOGGER.info(flightService.getAllFlights().toString());

		// AirlineInAirportService aInAService = new AirlineInAirportService();
		// LOGGER.info(aInAService.getAirportsByAirlineId(1).toString());
	}
}
