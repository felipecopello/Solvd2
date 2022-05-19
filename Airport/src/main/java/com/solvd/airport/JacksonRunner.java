package com.solvd.airport;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.entities.Plane;
import com.solvd.airport.entities.Ticket;
import com.solvd.airport.jackson.JacksonUtil;
import com.solvd.airport.jaxb.JaxbUtil;

import jakarta.xml.bind.JAXBException;

public class JacksonRunner {
	private static final Logger LOGGER = LogManager.getLogger(JacksonRunner.class);

	public static void main(String[] arg) {

		Plane plane = new Plane();
		plane.setPlaneId(502);
		plane.setModel("Boing 111-vo6");
		plane.setCapacity(20);

		JacksonUtil.writePlane(plane);
		JacksonUtil.mapPassenger();

		try {
			Ticket ticket = JaxbUtil.unmarshallTicket("src/main/resources/data.xml");
			JacksonUtil.mapTicket(ticket);
		} catch (JAXBException | IOException e) {
			LOGGER.info(e.getCause());
		}
	}
}
