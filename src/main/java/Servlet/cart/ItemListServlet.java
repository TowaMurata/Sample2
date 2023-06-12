package Servlet.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.OrderPurchaseEntity;

@WebServlet("/ItemListServlet")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//カートに入れる処理を書く

		HttpSession session = request.getSession();
		if (session.getAttribute("OrderEntityList") == null) {
			List<OrderPurchaseEntity> ol = new ArrayList<>();
			session.setAttribute("OrderEntityList", ol);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/prodcutList.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
