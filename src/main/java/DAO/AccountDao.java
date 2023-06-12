package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.AccountEntity;

public class AccountDao extends AbstractDao {

	public int countNumber() {
		Connection connection = super.getConnection();
		int number = 0;
		try {
			String sql = "SELECT MAX(id) +1 as create_number FROM account;";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				number = resultSet.getInt("create_number");
			} else {
				number = 1;
			}
			resultSet.close();
			preparedStatement.close();
			super.closeConnection();

			return number;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}

	public AccountEntity insert(AccountEntity entity) {
		Connection connection = super.getConnection();
		PreparedStatement preparedStatement = null;
		int rows = 0;
		try {
			String sql = "insert into account(login_id, password, name) values (?,?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, entity.getId());
			preparedStatement.setString(2, entity.getPassword());
			preparedStatement.setString(3, entity.getName());

			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				super.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rows != 1) {
			entity = null;
			return entity;
		}
		return entity;
	}
}
