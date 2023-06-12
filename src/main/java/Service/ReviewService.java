package Service;

import DAO.ProductDao;
import DAO.ReviewDao;
import Entity.ProductEntity;
import Entity.ReviewEntity;
import logic.ReviewEntityCreateLogic;

public class ReviewService {
	public static ProductEntity prodcutInfo(String item_id) {
		int itemId = Integer.parseInt(item_id);
		ProductDao prodcutdao = new ProductDao();
		ProductEntity productEntity = prodcutdao.getReviewProdcutInfo(itemId);
		return productEntity;
	}

	public static void insertReview(ReviewEntity reviewEntity, String review) {
		
		ReviewDao reviewDao = new ReviewDao();
		int number = reviewDao.countNumber();
		
		reviewEntity = ReviewEntityCreateLogic.addDitailReviewEntityCreate(number,review,reviewEntity);
		
		reviewDao.insert(reviewEntity);
		
		
	}
}
