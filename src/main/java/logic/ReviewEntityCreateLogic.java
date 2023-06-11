package logic;

import Entity.ReviewEntity;

public class ReviewEntityCreateLogic {

	public static ReviewEntity reviewEntityCreate(int account_id, String item_id) {
		int itemId = Integer.parseInt(item_id);

		ReviewEntity reviewEntity = new ReviewEntity();
		reviewEntity.setAccount_id(account_id);
		reviewEntity.setItem_id(itemId);
		return reviewEntity;
	}
}
