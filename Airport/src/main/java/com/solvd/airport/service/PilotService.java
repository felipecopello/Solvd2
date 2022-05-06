package com.solvd.airport.service;

import java.sql.SQLException;

import com.solvd.airport.dao.jdbc.realization.AirlineDao;
import com.solvd.airport.dao.jdbc.realization.PilotDao;
import com.solvd.airport.entities.Airline;
import com.solvd.airport.entities.Pilot;
import com.solvd.airport.interfaces.IAirlineDao;
import com.solvd.airport.interfaces.IPilotDao;

public class PilotService {
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
			e.printStackTrace();
		}
		return p;
	}
}
