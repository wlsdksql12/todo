package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Member;

@WebServlet("/member/deleteTodoList")
public class deleteTodoListController extends HttpServlet {

	private TodoService todoService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		
		System.out.println("000000000000000000000000000000"+todoNo+"00000000000000000000000todoNo");
		System.out.println("000000000000000000000000000000"+memberId+"00000000000000000000000memberId");
		
		request.setAttribute("todoNo", todoNo);
		request.getRequestDispatcher("/WEB-INF/view/deleteTodo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		
		System.out.println(memberId + "<-- deleteTodoList.dopost.memberId");
		System.out.println(todoNo + "<-- deleteTodoList.dopost.todoNo");
		
		todoService = new TodoService();
		
		todoService.deleteTodoList(memberId, todoNo);
		
		response.sendRedirect(request.getContextPath()+"/member/Calender");
	}

}
