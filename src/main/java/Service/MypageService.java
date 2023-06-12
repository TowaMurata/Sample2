package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.ItemDao;
import DAO.OrderPurchaseDao;
import Entity.ItemEntity;
import Entity.OrderPurchaseEntity;
public class MypageService {
	
	public static List<OrderPurchaseEntity> getOrderHistoryEntity(int user_id) {
		
		OrderPurchaseDao orderDao = new OrderPurchaseDao();
		List<OrderPurchaseEntity> OrderHistryEntityList = orderDao.select(user_id);
		return OrderHistryEntityList;
	}
	
	public static List<ItemEntity> ItemInfo(List<OrderPurchaseEntity> OrderPurchaseEntityList){
		
		List<Integer> itemIdList = new ArrayList<>();
		for(int i = 0; i < OrderPurchaseEntityList.size(); i++) {
			itemIdList.add(OrderPurchaseEntityList.get(i).getItem_id());
		}
		
		List<ItemEntity> OrderItemEntityList = new ArrayList<>();
		ItemDao itemDao = new ItemDao();
		OrderItemEntityList = itemDao.getItemDetail(itemIdList);

		
		return OrderItemEntityList;
    }
}
