package com.solvd.airport;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.entities.City;
import com.solvd.airport.entities.Luggage;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.interfaces.ICityDao;
import com.solvd.airport.interfaces.ICountryDao;
import com.solvd.airport.interfaces.ILuggageDao;
import com.solvd.airport.interfaces.IPassengerDao;
import com.solvd.airport.interfaces.IPlaneDao;

public class MyBatisRunner {
	private static final Logger LOGGER = LogManager.getLogger(DaoRunner.class);

	public static void main(String[] args) throws Exception {
		Reader reader = Resources.getResourceAsReader("config.xml");

		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);

		try (SqlSession session = factory.openSession()) {
			IPlaneDao planeMapper = session.getMapper(IPlaneDao.class);
			Plane plane = planeMapper.getById(2);
			LOGGER.info("Plane = " + plane);
			planeMapper.save("Avianca LFH 25514", 122);
			planeMapper.update("Boeing LFH 25514", 428, 2);
			LOGGER.info("Plane = " + planeMapper.getById(2));
			List<Plane> planes = planeMapper.getAll();
			planes.forEach((p) -> {
				LOGGER.info(p);
			});

			ICountryDao countryMapper = session.getMapper(ICountryDao.class);
			LOGGER.info("Country = " + countryMapper.getById(1));

			ICityDao cityMapper = session.getMapper(ICityDao.class);
			City city = cityMapper.getById(1);
			LOGGER.info("City = " + city);

			IPassengerDao passengerMapper = session.getMapper(IPassengerDao.class);
			Passenger passenger = passengerMapper.getById(2);
			LOGGER.info("Passenger = " + passenger);

			ILuggageDao luggageMapper = session.getMapper(ILuggageDao.class);
			Luggage luggage = luggageMapper.getById(1);
			LOGGER.info("Luggage = " + luggage);
			LOGGER.info("Luggage = " + luggageMapper.getByPassengerId(2));
		}
	}
}
