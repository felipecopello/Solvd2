package com.solvd.airport.jackson;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
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

	public static void mapTicket(Ticket ticket) {
		File file = new File("src/main/resources/ticket.json");

		try {
			objectMapper.writeValue(file, ticket);
			LOGGER.info("The ticket " + ticket + " was succesfully written in json file.");
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}
	}
}
