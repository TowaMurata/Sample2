package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.OrderPurchaseEntity;
import logic.CartOrderEntityCreateLogic;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<OrderPurchaseEntity> orderEntityList = (List<OrderPurchaseEntity>) session.getAttribute("OrderEntityList");

		//カートに入れる商品IDと数量を取得
		String id = request.getParameter("test");
		int prodcutId = Integer.parseInt(id);
		String q = request.getParameter("quantity");
		int quantity = Integer.parseInt(q);
		//セッションスコープからアカウントIDを取得する(省略して id ==10とする)
		int accountId = 10;

		//オーダーエンティティ登録ロジックに処理を移す
		OrderPurchaseEntity o = CartOrderEntityCreateLogic.create(prodcutId, quantity, accountId);
		orderEntityList.add(o);
		for(int i = 0; i<orderEntityList.size(); i++) {
		System.out.println(orderEntityList.get(i).getItem_id());
		}
		session.setAttribute("OrderEntityList", orderEntityList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/prodcutList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
