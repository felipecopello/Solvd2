package com.solvd.airport.interfaces;

import java.sql.SQLException;

import com.solvd.airport.entities.Airline;

public interface IAirlineDao extends IEntityDao<Airline> {

	Airline getByPilotId(long id) throws SQLException;

}
