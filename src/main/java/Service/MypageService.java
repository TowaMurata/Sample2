package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.OrderPurchaseDao;
import DAO.ProductDao;
import Entity.OrderPurchaseEntity;
import Entity.ProductEntity;
public class MypageService {
	
	public static List<OrderPurchaseEntity> getOrderHistoryEntity(int user_id) {
		
		OrderPurchaseDao orderDao = new OrderPurchaseDao();
		List<OrderPurchaseEntity> OrderHistryEntityList = orderDao.select(user_id);
		return OrderHistryEntityList;
	}
	
	public static List<ProductEntity> productInfo(List<OrderPurchaseEntity> OrderPurchaseEntityList){
		
		List<Integer> itemIdList = new ArrayList<>();
		for(int i = 0; i < OrderPurchaseEntityList.size(); i++) {
			itemIdList.add(OrderPurchaseEntityList.get(i).getItem_id());
		}
		
		List<ProductEntity> OrderProductEntityList = new ArrayList<>();
		ProductDao productDao = new ProductDao();
		OrderProductEntityList = productDao.getProductDetail(itemIdList);

		
		return OrderProductEntityList;
    }
}
