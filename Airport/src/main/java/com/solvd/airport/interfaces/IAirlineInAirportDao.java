package com.solvd.airport.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.solvd.airport.entities.AirlineInAirport;
import com.solvd.airport.entities.Airport;

public interface IAirlineInAirportDao extends IEntityDao<AirlineInAirport> {
	List<Airport> getAirportsByAirlineId(long id) throws SQLException;
}
