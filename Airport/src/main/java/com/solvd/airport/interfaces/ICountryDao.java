package com.solvd.airport.interfaces;

import java.sql.SQLException;

import com.solvd.airport.entities.Country;

public interface ICountryDao extends IEntityDao<Country> {

	Country getByCityId(long id) throws SQLException;

	Country getByAirportId(long id) throws SQLException;

}
