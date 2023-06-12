package Servlet.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.ReviewEntity;
import Service.ReviewService;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String review = request.getParameter("review");
		HttpSession session = request.getSession();
		session.removeAttribute("message");
		if(review.length() == 0) {
			String message = "レビューを記入してください。";
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/reviewInput.jsp");	
			session.setAttribute("message", message);
			dispatcher.forward(request, response);
		}else {
		ReviewEntity reviewEntity = (ReviewEntity) session.getAttribute("reviewEntity");
		ReviewService.insertReview(reviewEntity, review);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");	
		dispatcher.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
