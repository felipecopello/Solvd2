package com.solvd.airport.interfaces;

import java.sql.SQLException;

import com.solvd.airport.entities.Pilot;

public interface IPilotDao extends IEntityDao<Pilot> {
	Pilot getByFlightId(long id) throws SQLException;
}
