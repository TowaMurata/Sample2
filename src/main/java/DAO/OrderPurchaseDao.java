package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entity.OrderPurchaseEntity;

public class OrderPurchaseDao extends AbstractDao {

	public  List<OrderPurchaseEntity> select(int user_id){
		Connection connection = super.getConnection();
		List<OrderPurchaseEntity> OrderHistryEntityList =
				new ArrayList<>();
		OrderPurchaseEntity entity = null;
		try {
		String sql = "SELECT * FROM orderpurchase WHERE account_id = ?;";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, user_id);
		
		
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()){
			entity = new OrderPurchaseEntity();
			entity.setUser_id(resultSet.getInt("account_id"));
			entity.setItem_id(resultSet.getInt("item_id"));
			entity.setOrder_quantity(resultSet.getInt("order_quantity"));
			entity.setOrder_date(resultSet.getDate("order_date"));
			OrderHistryEntityList.add(entity);
		}

		resultSet.close();
		preparedStatement.close();
		super.closeConnection();
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return OrderHistryEntityList;
	}




}
