package Service;

import DAO.ProductDao;
import Entity.ProductEntity;
import Entity.ReviewEntity;

public class ReviewService {
	public static ProductEntity prodcutInfo(String item_id) {
		int itemId = Integer.parseInt(item_id);
		ProductDao prodcutdao = new ProductDao();
		ProductEntity productEntity = prodcutdao.getReviewProdcutInfo(itemId);
		return productEntity;
	}

	public static ReviewEntity insertReview() {

		return null;

	}
}
