package com.solvd.airport.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.solvd.airport.entities.Luggage;

public interface ILuggageDao extends IEntityDao<Luggage> {

	List<Luggage> getByPassengerId(long id) throws SQLException;

}
