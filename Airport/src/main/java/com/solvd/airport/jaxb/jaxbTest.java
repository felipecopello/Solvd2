package com.solvd.airport.jaxb;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.DaoRunner;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.entities.City;
import com.solvd.airport.entities.Country;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.entities.Ticket;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class jaxbTest {
	private static final Logger LOGGER = LogManager.getLogger(DaoRunner.class);

	public static void marshallPlane(Plane plane) throws JAXBException, IOException {

		JAXBContext context = JAXBContext.newInstance(Plane.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(plane, new File("src/main/resources/objectTest.xml"));
		LOGGER.info("The plane " + plane.getPlaneId() + " was succesfully marshalled");
	}

	public static Plane unmarshallPlane(String path) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Plane.class);
		return (Plane) context.createUnmarshaller().unmarshal(new FileReader(path));
	}

	public static Passenger unmarshallPassenger(String path) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Passenger.class);
		return (Passenger) context.createUnmarshaller().unmarshal(new FileReader(path));
	}

	public static void marshalPassenger(Passenger passenger) throws JAXBException, IOException {

		JAXBContext context = JAXBContext.newInstance(Passenger.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(passenger, new File("src/main/resources/objectTest.xml"));
		LOGGER.info("The object " + passenger.toString() + " was succesfully marshalled");
	}

	public static void marshalCountry(Country country) throws JAXBException, IOException {

		JAXBContext context = JAXBContext.newInstance(Country.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(country, new File("src/main/resources/objectTest.xml"));
		LOGGER.info("The object " + country.toString() + " was succesfully marshalled");
	}

	public static void marshalCity(City city) throws JAXBException, IOException {

		JAXBContext context = JAXBContext.newInstance(City.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(city, new File("src/main/resources/objectTest.xml"));
		LOGGER.info("The object " + city.toString() + " was succesfully marshalled");
	}

	public static void marshalTicket(Ticket ticket) throws JAXBException, IOException {

		JAXBContext context = JAXBContext.newInstance(Ticket.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(ticket, new File("src/main/resources/objectTest.xml"));
		LOGGER.info("The object " + ticket.toString() + " was succesfully marshalled");
	}

	public static Ticket unmarshallTicket(String path) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Ticket.class);
		return (Ticket) context.createUnmarshaller().unmarshal(new FileReader(path));
	}

	public static void marshalAirport(Airport airport) throws JAXBException, IOException {

		JAXBContext context = JAXBContext.newInstance(Airport.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(airport, new File("src/main/resources/objectTest.xml"));
		LOGGER.info("The object " + airport.toString() + " was succesfully marshalled");
	}

}
