package com.solvd.airport.interfaces;

import java.sql.SQLException;

import com.solvd.airport.entities.Airport;

public interface IAirportDao extends IEntityDao<Airport> {

	Airport getDepartureAirportByRouteId(long id) throws SQLException;

	Airport getArrivalAirportByRouteId(long id) throws SQLException;

	void save(Airport airport) throws SQLException;
}
