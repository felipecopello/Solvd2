package com.solvd.airport.jaxb;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.Runner;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.entities.Plane;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class jaxbTest {
	private static final Logger LOGGER = LogManager.getLogger(Runner.class);

	public static void marshallPlane(Plane plane) throws JAXBException, IOException {

		JAXBContext context = JAXBContext.newInstance(Plane.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(plane, new File("src/main/resources/plane.xml"));
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

	public static void marshalObject(Object o) throws JAXBException, IOException {

		JAXBContext context = JAXBContext.newInstance(Object.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(o, new File("src/main/resources/objectTest.xml"));
		LOGGER.info("The object " + o.toString() + " was succesfully marshalled");
	}
}
