package com.solvd.airport.interfaces;

import java.sql.SQLException;

import com.solvd.airport.entities.Plane;

public interface IPlaneDao extends IEntityDao<Plane> {
	Plane getByFlightId(long id) throws SQLException;

	void update(Plane plane) throws SQLException;
}
