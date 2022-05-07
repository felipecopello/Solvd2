package com.solvd.airport.service;

import java.sql.SQLException;

import com.solvd.airport.dao.jdbc.realization.PlaneDao;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.interfaces.IPlaneDao;

public class PlaneService {
	private IPlaneDao planeDao = new PlaneDao();

	public Plane getPlaneById(long id) {
		Plane p = new Plane();

		try {
			p = planeDao.getById(id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}
