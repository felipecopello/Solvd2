package com.solvd.airport;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.entities.City;
import com.solvd.airport.entities.Luggage;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.interfaces.IAirlineDao;
import com.solvd.airport.interfaces.ICityDao;
import com.solvd.airport.interfaces.ICountryDao;
import com.solvd.airport.interfaces.ILuggageDao;
import com.solvd.airport.interfaces.IPassengerDao;
import com.solvd.airport.interfaces.IPilotDao;
import com.solvd.airport.interfaces.IPlaneDao;
import com.solvd.airport.interfaces.IRouteDao;

import util.SqlSessionFactoryUtil;

public class MyBatisRunner {
	private static final Logger LOGGER = LogManager.getLogger(MyBatisRunner.class);

	private static SqlSessionFactory factory = SqlSessionFactoryUtil.getInstance();

	public static void main(String[] args) throws Exception {

		try (SqlSession session = factory.openSession()) {
			LOGGER.info("______________ PLANES ______________");
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

			LOGGER.info("______________ COUNTRIES ______________");
			ICountryDao countryMapper = session.getMapper(ICountryDao.class);
			LOGGER.info("Country = " + countryMapper.getById(1));

			LOGGER.info("______________ CITIES ______________");
			ICityDao cityMapper = session.getMapper(ICityDao.class);
			City city = cityMapper.getById(1);
			LOGGER.info("City = " + city);

			LOGGER.info("______________ PASSENGERS ______________");
			IPassengerDao passengerMapper = session.getMapper(IPassengerDao.class);
			Passenger passenger = passengerMapper.getById(2);
			LOGGER.info("Passenger = " + passenger);

			LOGGER.info("______________ LUGGAGES ______________");
			ILuggageDao luggageMapper = session.getMapper(ILuggageDao.class);
			Luggage luggage = luggageMapper.getById(1);
			LOGGER.info("Luggage = " + luggage);
			LOGGER.info("Luggage = " + luggageMapper.getByPassengerId(2));

			LOGGER.info("_______________ AIRLINES _______________");
			IAirlineDao airlineMapper = session.getMapper(IAirlineDao.class);
			LOGGER.info("Airline = " + airlineMapper.getById(1));
			LOGGER.info("Airline = " + airlineMapper.getAll());

			LOGGER.info("_______________ PILOTS _______________");
			IPilotDao pilotMapper = session.getMapper(IPilotDao.class);
			LOGGER.info("Pilot = " + pilotMapper.getById(1));
			LOGGER.info("Pilot = " + pilotMapper.getAll());

			LOGGER.info("_______________ ROUTES _______________");
			IRouteDao routeMapper = session.getMapper(IRouteDao.class);
			LOGGER.info("Route = " + routeMapper.getById(1));

			LOGGER.info("_______________ AIRPORTS _______________");
			ICityDao airportMapper = session.getMapper(ICityDao.class);
			LOGGER.info("Route = " + airportMapper.getAll());

		}
	}
}
