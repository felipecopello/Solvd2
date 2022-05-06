package com.solvd.airport.interfaces;

import java.sql.SQLException;

import com.solvd.airport.entities.City;

public interface ICityDao extends IEntityDao<City> {

	City getByAirportId(long id) throws SQLException;

}
