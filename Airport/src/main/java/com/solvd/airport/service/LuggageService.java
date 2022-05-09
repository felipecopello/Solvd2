package com.solvd.airport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.dao.jdbc.realization.LuggageDao;
import com.solvd.airport.entities.Luggage;
import com.solvd.airport.interfaces.ILuggageDao;

public class LuggageService {
	private static final Logger LOGGER = LogManager.getLogger(AirlineService.class);
	private ILuggageDao luggageDao = new LuggageDao();

	public Luggage getLuggageById(long id) {
		Luggage luggage = new Luggage();

		try {
			luggage = luggageDao.getById(id);
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return luggage;
	}

	public List<Luggage> getAllLuggages() {
		List<Luggage> luggageList = new ArrayList<>();
		try {
			luggageList = luggageDao.getAll();
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
		}
		return luggageList;
	}
}
