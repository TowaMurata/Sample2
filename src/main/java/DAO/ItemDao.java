package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.ItemEntity;

public class ItemDao extends AbstractDao {
	// データベース接続に使用する情報

	public List<ItemEntity> ranking() {
		List<ItemEntity> rankingList = new ArrayList<ItemEntity>();

		// データベースへ接続

		// SELECT文を準備
		String sql = "select * from item order by stock limit 3 offset 0";
		PreparedStatement pStmt;
		try {
			Connection connection = super.getConnection();
			pStmt = connection.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String category = rs.getString("category");
				int stock = rs.getInt("stock");
				int sales_price = rs.getInt("sales_price");
				int target_gender_code = rs.getInt("target_gender_code");
				ItemEntity ItemEntity = new ItemEntity(id, name, category, stock, sales_price,
						target_gender_code);
				rankingList.add(ItemEntity);
			}

			rs.close();
			pStmt.close();
			super.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// SELECTを実行し、結果表を取得

		// 結果表に格納されたレコードの内容を
		// rankingインスタンスに設定し、ArrayListインスタンスに追加
		return rankingList;
	}

	public List<ItemEntity> getItemDetail(List<Integer> itemIdList) {

		Connection connection = super.getConnection();
		List<ItemEntity> OrderItemEntityList = new ArrayList<>();
		ItemEntity entity = null;

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
				entity = new ItemEntity();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setCategory(resultSet.getString("category"));
				entity.setStock(resultSet.getInt("stock"));
				entity.setSales_price(resultSet.getInt("sales_price"));
				entity.setTarget_gender_code(resultSet.getString("target_gender_code"));
				OrderItemEntityList.add(entity);
			}

			resultSet.close();
			preparedStatement.close();
			super.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return OrderItemEntityList;

	}

	public ItemEntity getReviewProdcutInfo(int item_id) {

		Connection connection = super.getConnection();
		ItemEntity entity = null;

		try {
			String sql = "SELECT * FROM item WHERE id = ?;";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, item_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				entity = new ItemEntity();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setCategory(resultSet.getString("category"));
				entity.setStock(resultSet.getInt("stock"));
				entity.setSales_price(resultSet.getInt("sales_price"));
				entity.setTarget_gender_code(resultSet.getString("target_gender_code"));
			}

			resultSet.close();
			preparedStatement.close();
			super.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return entity;
	}
}