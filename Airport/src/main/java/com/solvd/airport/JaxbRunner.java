package com.solvd.airport;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.entities.Airport;
import com.solvd.airport.entities.City;
import com.solvd.airport.entities.Country;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.entities.Ticket;
import com.solvd.airport.jaxb.JaxbUtil;

import jakarta.xml.bind.JAXBException;

public class JaxbRunner {
	private static final Logger LOGGER = LogManager.getLogger(JaxbRunner.class);

	public static void main(String[] arg) {
		Country argentina = new Country(601, "Argentina");
		City buenosAires = new City(701, "Buenos Aires", argentina, 4500000);

		Plane plane = new Plane();
		plane.setPlaneId(502);
		plane.setModel("Boing 111-vo6");
		plane.setCapacity(20);

		Airport airport = new Airport();
		airport.setAirportId(0001);
		airport.setCity(buenosAires);
		airport.setName("Montevideo Airport");

		try {
			// jaxbTest.marshallPlane(plane);
			// jaxbTest.marshalCountry(argentina);
			JaxbUtil.marshalCity(buenosAires);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}

		try {
			Plane plane2 = JaxbUtil.unmarshallPlane("src/main/resources/plane.xml");
			Passenger passenger1 = JaxbUtil.unmarshallPassenger("src/main/resources/passenger.xml");
			Ticket ticket = JaxbUtil.unmarshallTicket("src/main/resources/data.xml");
			JaxbUtil.marshalPassenger(passenger1);
			JaxbUtil.marshalAirport(airport);
			LOGGER.info(airport);
			LOGGER.info(plane2);
			LOGGER.info(passenger1);
			LOGGER.info(ticket);

		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
}
