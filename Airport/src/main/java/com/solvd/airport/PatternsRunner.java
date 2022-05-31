package com.solvd.airport;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.entities.Flight;
import com.solvd.airport.entities.Luggage;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.entities.Pilot;
import com.solvd.airport.patterns.LuggageBuilder;
import com.solvd.airport.patterns.PassengerBuilder;

public class PatternsRunner {
	private static final Logger LOGGER = LogManager.getLogger(PatternsRunner.class);

	public static void main(String[] arg) {
		Luggage luggage1 = new LuggageBuilder().setWeight((float) 2.4).build();
		Luggage luggage2 = new LuggageBuilder().setWeight((float) 21.8).build();
		LOGGER.info(luggage1);
		LOGGER.info(luggage2);
		List<Luggage> luggages = new ArrayList<>();
		luggages.add(luggage1);
		luggages.add(luggage2);

		Passenger pepito = new PassengerBuilder("pepito", 51, 4, "pepito@gmail.com", luggages).build();
		LOGGER.info(pepito);

		Pilot pilotoJuan = new Pilot();

		Flight flightToLondon = new Flight();
		flightToLondon.addListener(pepito);
		flightToLondon.setFlightStatus("DELAYED");
		LOGGER.info(pepito.getFlightStatus());
		flightToLondon.addListener(pilotoJuan);
		LOGGER.info(pilotoJuan.getFlightStatus());
		flightToLondon.setFlightStatus("DEPARTED");
		LOGGER.info(pepito.getFlightStatus());
		LOGGER.info(pilotoJuan.getFlightStatus());
	}
}
