package com.solvd.airport.patterns;

import com.solvd.airport.dao.jdbc.realization.AirlineDao;
import com.solvd.airport.dao.jdbc.realization.AirportDao;
import com.solvd.airport.dao.jdbc.realization.CityDao;
import com.solvd.airport.dao.jdbc.realization.CountryDao;
import com.solvd.airport.dao.jdbc.realization.FlightDao;
import com.solvd.airport.dao.jdbc.realization.LuggageDao;
import com.solvd.airport.dao.jdbc.realization.PassengerDao;
import com.solvd.airport.dao.jdbc.realization.PlaneDao;
import com.solvd.airport.entities.Airline;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.entities.City;
import com.solvd.airport.entities.Country;
import com.solvd.airport.entities.Flight;
import com.solvd.airport.entities.Luggage;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.interfaces.IEntityDao;

public class DaoFactory extends AbstractFactory {

	public static IEntityDao<?> getDao(String dao) {
		dao = dao.toLowerCase();
		switch (dao) {
		case "plane":
			IEntityDao<Plane> planeDao = new PlaneDao();
			return planeDao;
		case "flight":
			IEntityDao<Flight> flightDao = new FlightDao();
			return flightDao;
		case "airline":
			IEntityDao<Airline> airlineDao = new AirlineDao();
			return airlineDao;
		case "passenger":
			IEntityDao<Passenger> passengerDao = new PassengerDao();
			return passengerDao;
		case "city":
			IEntityDao<City> cityDao = new CityDao();
			return cityDao;
		case "country":
			IEntityDao<Country> countryDao = new CountryDao();
			return countryDao;
		case "airport":
			IEntityDao<Airport> airportDao = new AirportDao();
			return airportDao;
		case "luggage":
			IEntityDao<Luggage> luggageDao = new LuggageDao();
			return luggageDao;
		}
		return null;
	}
}
