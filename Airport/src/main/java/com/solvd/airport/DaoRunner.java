package com.solvd.airport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.connection.AbstractJDBCDao;
import com.solvd.airport.connection.ConnectionPool;
import com.solvd.airport.entities.Airline;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.entities.City;
import com.solvd.airport.entities.Country;
import com.solvd.airport.entities.Flight;
import com.solvd.airport.entities.Pilot;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.service.AirlineInAirportService;
import com.solvd.airport.service.AirlineService;
import com.solvd.airport.service.AirportService;
import com.solvd.airport.service.CityService;
import com.solvd.airport.service.CountryService;
import com.solvd.airport.service.FlightService;
import com.solvd.airport.service.LuggageService;
import com.solvd.airport.service.PassengerService;
import com.solvd.airport.service.PilotService;
import com.solvd.airport.service.PlaneService;
import com.solvd.airport.service.RouteService;

public class DaoRunner extends AbstractJDBCDao {
	private static final Logger LOGGER = LogManager.getLogger(DaoRunner.class);
	private static ConnectionPool cp = getCp();

	// When you run this, you will see in the console some null results because some
	// fields are null in the database.
	// Thats because in previous tasks we had to show crud operations in sql that
	// changed some data.

	public static void main(String[] arg) {

		AirlineService airlineService = new AirlineService();
		Airline swiss = new Airline("Swiss", 691);
		LOGGER.info(airlineService.getAirlineById(2));
		airlineService.saveAirline(swiss);
		LOGGER.info(airlineService.getAllAirlines());

		PilotService pilotService = new PilotService();
		Pilot pilotDanna = pilotService.getPilotById(1);
		LOGGER.info(pilotDanna.getEmployer());
		String[] updateData = { "50", "2" };
		pilotService.updatePilot(pilotDanna, updateData);
		LOGGER.info(pilotService.getPilotById(1));
		LOGGER.info(pilotService.getAllPilots());

		CountryService countryService = new CountryService();
		Country spain = new Country("Spain");
		countryService.saveCountry(spain);
		Country españa = countryService.getCountryById(9);
		LOGGER.info(countryService.getAllCountries());

		CityService cityService = new CityService();
		City barcelona = new City("Barcelona", españa, 2500000);
		cityService.saveCity(barcelona);
		City barna = cityService.getCityById(8);
		LOGGER.info(cityService.getAllCities());

		AirportService airportService = new AirportService();
		Airport elPrat = new Airport("Aeropuerto Internacional el Prat", 854, barna);
		airportService.saveAirport(elPrat);
		LOGGER.info(airportService.getAirportById(1));
		LOGGER.info(airportService.getAllAirports());

		LuggageService luggageService = new LuggageService();
		LOGGER.info(luggageService.getLuggageById(1));
		LOGGER.info(luggageService.getAllLuggages());

		PassengerService passengerService = new PassengerService();
		LOGGER.info(passengerService.getPassengerById(1));
		LOGGER.info(passengerService.getAllPassengers());

		RouteService routeService = new RouteService();
		LOGGER.info(routeService.getRouteById(2));
		LOGGER.info(routeService.getAllRoutes());

		PlaneService planeService = new PlaneService();
		Plane plane1 = planeService.getPlaneById(1);
		LOGGER.info(plane1);
		plane1.setCapacity(598);
		planeService.updatePlane(plane1);
		LOGGER.info(planeService.getAllPlanes());

		FlightService flightService = new FlightService();
		Flight flight1 = flightService.getFlightById(1);
		LOGGER.info(flightService.getFlightById(2));
		LOGGER.info(flightService.getAllFlights());
		flightService.deleteFlight(flight1);

		AirlineInAirportService aInAService = new AirlineInAirportService();
		LOGGER.info(aInAService.getAirportsByAirlineId(1));

		cp.closeAllConnections(cp);
	}
}
