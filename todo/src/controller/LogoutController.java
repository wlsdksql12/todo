package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/member/Logout")
public class LogoutController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 필터를 사용
		HttpSession session = request.getSession();
		if (session.getAttribute("Member") == null) { // 이미 로그인 되어있는 상태이다
			response.sendRedirect(request.getContextPath()+"/Login");
			return;
		}
		*/
		request.getSession().invalidate();
		request.getRequestDispatcher("/WEB-INF/view/loginForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
