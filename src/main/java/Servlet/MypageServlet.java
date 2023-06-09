package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.OrderPurchaseEntity;
import Entity.ProductEntity;
import Service.MypageService;


@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//セッションスコープからユーザーIDを取り出す。(省略してIDを123にする)
		int user_id = 123;
		List<OrderPurchaseEntity> OrderPurchaseEntityList = 
				MypageService.getOrderHistoryEntity(user_id);
		
		List<ProductEntity> OrderProductEntityList =
				MypageService.productInfo(OrderPurchaseEntityList);
		
		request.setAttribute("OrderProductEntityList", OrderProductEntityList);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}



}
