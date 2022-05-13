package com.solvd.airport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.dom.DomTask;

public class DomRunner {
	private static final Logger LOGGER = LogManager.getLogger(DomRunner.class);

	public static void main(String[] arg) {
		// String path = "src/main/resources/data.xml";

		try {
			DomTask.enteringDocument("ticket");
			// DomTask.printDom(path);
			DomTask.creatingDomDocument();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
