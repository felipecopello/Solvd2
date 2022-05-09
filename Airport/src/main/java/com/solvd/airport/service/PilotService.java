package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.dao.jdbc.realization.AirlineDao;
import com.solvd.airport.dao.jdbc.realization.PilotDao;
import com.solvd.airport.entities.Airline;
import com.solvd.airport.entities.Pilot;
import com.solvd.airport.interfaces.IAirlineDao;
import com.solvd.airport.interfaces.IPilotDao;

public class PilotService {
	private static final Logger LOGGER = LogManager.getLogger(AirlineService.class);
	private IPilotDao pilotDao = new PilotDao();
	private IAirlineDao airlineDao = new AirlineDao();

	public Pilot getPilotById(long id) {
		Pilot p = new Pilot();
		Airline a = new Airline();
		try {
			p = pilotDao.getById(id);
			a = airlineDao.getByPilotId(id);
			p.setEmployer(a);
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return p;
	}

	public List<Pilot> getAllPilots() {
		List<Pilot> pilotList = new ArrayList<>();
		try {
			pilotList = pilotDao.getAll();
			pilotList.forEach((pilot) -> {
				try {
					Airline airline = airlineDao.getByPilotId(pilot.getPilotId());
					pilot.setEmployer(airline);
				} catch (SQLException e) {
					LOGGER.info(e.getMessage());
				}
			});
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return pilotList;
	}
}
