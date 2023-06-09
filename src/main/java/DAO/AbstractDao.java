package DAO;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public abstract class AbstractDao {

	private Connection connection;

	protected Connection getConnection() {
		if (connection != null) {
			return connection;
		}
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/ecshop");
			connection = dataSource.getConnection();
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
				connection = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
