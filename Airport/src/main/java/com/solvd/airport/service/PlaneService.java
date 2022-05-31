package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.entities.Plane;
import com.solvd.airport.interfaces.IPlaneDao;
import com.solvd.airport.patterns.DaoFactory;

public class PlaneService {
	private static final Logger LOGGER = LogManager.getLogger(AirlineService.class);
	private IPlaneDao planeDao = (IPlaneDao) DaoFactory.getDao("plane");

	public Plane getPlaneById(long id) {
		Plane p = new Plane();

		try {
			p = planeDao.getById(id);

		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return p;
	}

	public List<Plane> getAllPlanes() {
		List<Plane> planeList = new ArrayList<>();
		try {
			planeList = planeDao.getAll();
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return planeList;
	}

	public void updatePlane(Plane plane) {
		try {
			planeDao.update(plane);
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
	}
}
