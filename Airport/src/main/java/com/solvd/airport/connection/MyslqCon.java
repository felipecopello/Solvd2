package com.solvd.airport.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class MysqlCon {
	public static void main(String args[]) {
		String query = "Select * from pilots where id = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/airport?user=root");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, 1);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}