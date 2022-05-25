package com.solvd.airport;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.entities.Plane;

import mappers.PlaneMapper;

public class MyBatisRunner {
	private static final Logger LOGGER = LogManager.getLogger(DaoRunner.class);

	public static void main(String[] args) throws Exception {
		Reader reader = Resources.getResourceAsReader("config.xml");

		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);

		try (SqlSession session = factory.openSession()) {
			PlaneMapper mapper = session.getMapper(PlaneMapper.class);
			Plane plane = mapper.getById(2);
			LOGGER.info("Plane = " + plane);
		}
	}
}
