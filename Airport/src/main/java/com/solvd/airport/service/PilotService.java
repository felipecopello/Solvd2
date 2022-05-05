package com.solvd.airport.dao.service;

import java.sql.SQLException;

import com.solvd.airport.dao.interfaces.IPilotDao;
import com.solvd.airport.dao.jdbc.realization.PilotDao;
import com.solvd.airport.entities.Pilot;

public class PilotService {
	private IPilotDao pilotDao = new PilotDao();

	public Pilot getPilotById(long id) {
		Pilot p = new Pilot();
		try {
			p = pilotDao.getById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}
