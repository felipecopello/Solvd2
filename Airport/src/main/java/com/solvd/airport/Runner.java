package com.solvd.airport;

import com.solvd.airport.service.CityService;
import com.solvd.airport.service.CountryService;
import com.solvd.airport.service.LuggageService;
import com.solvd.airport.service.PassengerService;

public class Runner {
	public static void main(String[] arg) {
		// PilotService pilotS = new PilotService();
		// System.out.println(pilotS.getPilotById(1).toString());

		// AirlineService aS = new AirlineService();
		// System.out.println(aS.getAirlineById(1).toString());

		// AirportService airS = new AirportService();
		// System.out.println(airS.getAirportById(1).toString());

		CountryService cS = new CountryService();
		System.out.println(cS.getCountryById(1).toString());

		CityService cityS = new CityService();
		System.out.println(cityS.getCityById(1).toString());

		LuggageService lS = new LuggageService();
		System.out.println(lS.getLuggageById(1).toString());

		PassengerService passengerS = new PassengerService();
		System.out.println(passengerS.getPassengerById(1).toString());
	}
}
