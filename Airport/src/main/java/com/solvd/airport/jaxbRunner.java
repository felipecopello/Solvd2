package com.solvd.airport;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.entities.City;
import com.solvd.airport.entities.Country;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.jaxb.jaxbTest;

import jakarta.xml.bind.JAXBException;

public class jaxbRunner {
	private static final Logger LOGGER = LogManager.getLogger(jaxbRunner.class);

	public static void main(String[] arg) {
		Country argentina = new Country(601, "Argentina");
		City buenosAires = new City(701, "Buenos Aires", argentina, 4500000);

		Plane plane = new Plane();
		plane.setPlaneId(502);
		plane.setModel("Boing 111-vo6");
		plane.setCapacity(20);

		try {
			// jaxbTest.marshallPlane(plane);
			// jaxbTest.marshalCountry(argentina);
			jaxbTest.marshalCity(buenosAires);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}

		try {
			Plane plane2 = jaxbTest.unmarshallPlane("src/main/resources/plane.xml");
			Passenger passenger1 = jaxbTest.unmarshallPassenger("src/main/resources/passenger.xml");
			jaxbTest.marshalPassenger(passenger1);
			LOGGER.info(plane2);
			LOGGER.info(passenger1);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
}
