package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.ProductEntity;
import Entity.ReviewEntity;
import Service.ReviewService;

@WebServlet("/ReviewInputServlet")
public class ReviewInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductEntity productEntity = ReviewService.prodcutInfo(request.getParameter("id"));

		//セッションスコープからユーザーIDを取り出す。(省略してIDを123にする)
		int account_id = 123;
		ReviewEntity reviewEntity = logic.ReviewEntityCreateLogic.reviewEntityCreate(account_id,
				request.getParameter("id"));

		HttpSession session = request.getSession();
		request.setAttribute("productEntity", productEntity);
		session.setAttribute("reviewEntity", reviewEntity);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/reviewInput.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
