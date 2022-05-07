package com.solvd.airport.interfaces;

import java.sql.SQLException;

import com.solvd.airport.entities.Route;

public interface IRouteDao extends IEntityDao<Route> {
	Route getByFlightId(long id) throws SQLException;
}
