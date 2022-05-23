package com.solvd.airport.jackson;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.entities.Ticket;

public class JacksonUtil {
	private static final Logger LOGGER = LogManager.getLogger(JacksonUtil.class);
	private static ObjectMapper objectMapper = new ObjectMapper();

	public static void writePlane(Plane plane) {

		File file = new File("src/main/resources/plane.json");

		try {
			objectMapper.writeValue(file, plane);
			LOGGER.info("The plane " + plane.getPlaneId() + " was succesfully written in json file.");
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}
	}

	public static void mapPassenger() {
		File file = new File("src/main/resources/passenger.json");

		try {
			Passenger passengerPaco = objectMapper.readValue(file, Passenger.class);
			LOGGER.info(passengerPaco);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeTicket(Ticket ticket) {
		File file = new File("src/main/resources/ticket.json");

		try {
			objectMapper.writeValue(file, ticket);
			LOGGER.info("The ticket " + ticket + " was succesfully written in json file.");
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}
	}

	public static void mapAirport(String path) {
		File file = new File(path);

		try {
			Airport airport = objectMapper.readValue(file, Airport.class);
			LOGGER.info(airport);

		} catch (IOException e) {
			LOGGER.error(e.getStackTrace());
		}
	}

	public static void mapAirports() {
		ObjectMapper om = new ObjectMapper();
		File file = new File("src/main/resources/airports.json");

		try {

			JavaType type = om.getTypeFactory().constructCollectionLikeType(List.class, Airport.class);
			List<Airport> airports = om.readValue(file, type);
			airports.forEach((airport) -> {
				LOGGER.info(airport);
			});

			System.out.println(airports.size());
		} catch (Exception e) {
			LOGGER.info(e.getStackTrace());
		}
	}
}
