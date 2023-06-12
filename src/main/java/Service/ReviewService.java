package Service;

import DAO.ItemDao;
import DAO.ReviewDao;
import Entity.ItemEntity;
import Entity.ReviewEntity;
import logic.ReviewEntityCreateLogic;

public class ReviewService {
	public static ItemEntity prodcutInfo(String item_id) {
		int itemId = Integer.parseInt(item_id);
		ItemDao prodcutdao = new ItemDao();
		ItemEntity productEntity = prodcutdao.getReviewProdcutInfo(itemId);
		return productEntity;
	}

	public static void insertReview(ReviewEntity reviewEntity, String review) {
		
		ReviewDao reviewDao = new ReviewDao();
		int number = reviewDao.countNumber();
		
		reviewEntity = ReviewEntityCreateLogic.addDitailReviewEntityCreate(number,review,reviewEntity);
		
		reviewDao.insert(reviewEntity);
		
		
	}
}
