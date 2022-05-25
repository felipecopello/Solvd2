package com.solvd.airport.interfaces;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;

import com.solvd.airport.entities.Plane;

public interface IPlaneDao extends IEntityDao<Plane> {
	Plane getByFlightId(long id) throws SQLException;

	void update(Plane plane) throws SQLException;

	void update(@Param("model") String model, @Param("capacity") int capacity, @Param("id") long id)
			throws SQLException;

	void save(@Param("model") String model, @Param("capacity") int capacity) throws SQLException;
}
