package com.solvd.airport.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IEntityDao<T> {
	public T getById(long id) throws SQLException;

	public List<T> getAll();

	public void save(T t);

	public void update(T t, String[] params);

	public void delete(T t);
}
