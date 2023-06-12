package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Entity.ReviewEntity;

public class ReviewDao extends AbstractDao {

	public void insert(ReviewEntity reviewEntity) {

		Connection connection = super.getConnection();

		try {
			String sql = "insert into review ( id, item_id, account_id, review)"
					+ "values(?, ?, ?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1,reviewEntity.getId());
				preparedStatement.setInt(2,reviewEntity.getItem_id());
				preparedStatement.setInt(3,reviewEntity.getAccount_id());
				preparedStatement.setString(4,reviewEntity.getReview());

			int resultSet = preparedStatement.executeUpdate();
			preparedStatement.close();
			super.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int countNumber() {
		Connection connection = super.getConnection();
		int number = 0;
		try {
			String sql = "SELECT MAX(id) +1 as create_number FROM review;";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				number = resultSet.getInt("create_number");
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
}