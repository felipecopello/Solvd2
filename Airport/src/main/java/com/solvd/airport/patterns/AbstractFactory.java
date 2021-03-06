package com.solvd.airport.patterns;

public class AbstractFactory {
	private static DaoFactory daoFactory = new DaoFactory();
	private static MyBatisFactory myBatisFactory = new MyBatisFactory();

	// You can see the implementation of AbstractFactory in MyBatisRunner class.
	public static AbstractFactory getFactory(String factory) {
		factory = factory.toLowerCase();
		switch (factory) {
		case "daofactory":
			return daoFactory;
		case "mybatisfactory":
			return myBatisFactory;
		}

		return null;
	}
}
