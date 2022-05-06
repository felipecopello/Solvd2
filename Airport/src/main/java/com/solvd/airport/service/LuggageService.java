package com.solvd.airport.service;

import java.sql.SQLException;

import com.solvd.airport.dao.jdbc.realization.LuggageDao;
import com.solvd.airport.entities.Luggage;
import com.solvd.airport.interfaces.ILuggageDao;

public class LuggageService {
	private ILuggageDao luggageDao = new LuggageDao();

	public Luggage getLuggageById(long id) {
		Luggage luggage = new Luggage();

		try {
			luggage = luggageDao.getById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return luggage;
	}
}
