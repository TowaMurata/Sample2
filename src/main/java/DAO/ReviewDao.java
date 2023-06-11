package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entity.ProductEntity;
import Entity.ReviewEntity;

public class ReviewDao extends AbstractDao {

	public List<ProductEntity> getProductDetail(ReviewEntity reviewEntity) {

		Connection connection = super.getConnection();
		List<ProductEntity> OrderProductEntityList = new ArrayList<>();
		ProductEntity entity = null;

		try {
			String sql = "SELECT * FROM item WHERE id = ?";

			for (int i = 1; i < itemIdList.size(); i++) {
				sql = sql.concat(" OR id = ?");
			}
			sql = sql.concat(";");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			for (int i = 0, j = 1; i < itemIdList.size(); i++, j++) {
				preparedStatement.setInt(j, itemIdList.get(i));
			}

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				entity = new ProductEntity();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setCategory(resultSet.getString("category"));
				entity.setStock(resultSet.getInt("stock"));
				entity.setSales_price(resultSet.getInt("sales_price"));
				entity.setTarget_gender_code(resultSet.getString("target_gender_code"));
				OrderProductEntityList.add(entity);
			}

			resultSet.close();
			preparedStatement.close();
			super.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return OrderProductEntityList;

	}
}