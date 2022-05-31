package com.solvd.airport.patterns;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.solvd.airport.entities.City;
import com.solvd.airport.entities.Country;
import com.solvd.airport.entities.Luggage;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.interfaces.ICityDao;
import com.solvd.airport.interfaces.ICountryDao;
import com.solvd.airport.interfaces.IEntityDao;
import com.solvd.airport.interfaces.ILuggageDao;
import com.solvd.airport.interfaces.IPassengerDao;
import com.solvd.airport.interfaces.IPlaneDao;

import util.SqlSessionFactoryUtil;

public class MyBatisFactory extends AbstractFactory {

	private static SqlSessionFactory factory = SqlSessionFactoryUtil.getInstance();
	private static SqlSession session = factory.openSession();

	public IEntityDao<?> getMyBatis(String myBatis) {
		myBatis = myBatis.toLowerCase();
		switch (myBatis) {
		case "plane":
			IEntityDao<Plane> planeMapper = session.getMapper(IPlaneDao.class);
			return planeMapper;
		case "country":
			IEntityDao<Country> countryMapper = session.getMapper(ICountryDao.class);
			return countryMapper;
		case "city":
			IEntityDao<City> cityMapper = session.getMapper(ICityDao.class);
			return cityMapper;
		case "passenger":
			IEntityDao<Passenger> passengerMapper = session.getMapper(IPassengerDao.class);
			return passengerMapper;
		case "luggage":
			IEntityDao<Luggage> luggageMapper = session.getMapper(ILuggageDao.class);
			return luggageMapper;
		}
		return null;
	}

	public static SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		MyBatisFactory.session = session;
	}
}
