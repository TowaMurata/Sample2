package logic;

import Entity.OrderPurchaseEntity;

public class CartOrderEntityCreateLogic {

	public static OrderPurchaseEntity create(int prodcutId, int prodcutQuantity, int userId) {

		OrderPurchaseEntity o = new OrderPurchaseEntity();

		o.setItem_id(prodcutId);
		o.setOrder_quantity(prodcutQuantity);
		o.setUser_id(userId);

		return o;
	}
}
