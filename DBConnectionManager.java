package com.mohammed.farhan.db.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

	private final String URL = "jdbc:ucanaccess://C://Users//Mohammed.Farhan//OneDrive - Zurich Insurance//Desktop//Unterlagen//Meine//Java//test//projects_2021//mohammed_//DB_mohammedStore.accdb";

	public Connection connect() throws SQLException {

		
			Connection connection = DriverManager.getConnection(URL);
		
		return connection;

	}
}
