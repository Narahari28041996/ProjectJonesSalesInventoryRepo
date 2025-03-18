package com.crm.JonesSalesAndInventoryProject.generic.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * @author Narahari
 */
public class DatabaseUtility {
	Connection conn = null;

	/**
	 * This method is used to provide the database connection
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @throws SQLException
	 */
	public void getDatabaseConnection(String url, String username, String password) throws SQLException {
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * This method is used to connect the database with the given set of data
	 * 
	 * @throws SQLException
	 */
	/* hard-coded database connection--available in our system */
	public void getDatabaseConnection() throws SQLException {
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * This method is used to close the database connection
	 * 
	 * @throws Throwable
	 */
	public void closeDatabaseConnection() throws Throwable {
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * This method is used to execute the update,delete and insert query
	 * 
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeNonSelectQuery(String query) throws Throwable {
		ResultSet result = null;
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery(query);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;// return entire table
	}

	/**
	 * This method is used to execute the select query
	 * 
	 * @param query
	 * @return
	 * @throws Throwable
	 */

	public int executeSelectQuery(String query) throws Throwable {
		int result = 0;
		try {
			Statement state = conn.createStatement();
			result = state.executeUpdate(query);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;// return +1 or-1 or 0
	}
}