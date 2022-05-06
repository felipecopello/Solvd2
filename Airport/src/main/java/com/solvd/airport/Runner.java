package com.solvd.airport;

import com.solvd.airport.service.AirlineService;
import com.solvd.airport.service.AirportService;
import com.solvd.airport.service.CountryService;
import com.solvd.airport.service.PilotService;

public class Runner {
	public static void main(String[] arg) {
		PilotService ps = new PilotService();
		System.out.println(ps.getPilotById(1).toString());

		AirlineService as = new AirlineService();
		System.out.println(as.getAirlineById(1).toString());

		AirportService airS = new AirportService();
		System.out.println(airS.getAirportById(1).toString());

		CountryService cs = new CountryService();
		System.out.println(cs.getCountryById(1).toString());
	}
}
