package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Member;
import vo.Todo;


@WebServlet("/member/contentUpdate")
public class contentUpdateController extends HttpServlet {
	
	private Todo todo;
	private TodoService todoService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		String todoDate = request.getParameter("todoDate");
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		
		System.out.println(memberId + "<-- contentUpdate.memberId");
		System.out.println(todoDate + "<-- contentUpdate.todoDate");
		System.out.println(todoNo + "<-- contentUpdate.todoNo");
		
		request.setAttribute("memberId", memberId);
		request.setAttribute("todoDate", todoDate);
		request.setAttribute("todoNo", todoNo);
		request.getRequestDispatcher("/WEB-INF/view/contentUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("contentUpdate.doPost()실행");
		
		String content = request.getParameter("todoContent");
		String memberId = request.getParameter("memberId");
		String todoDate = request.getParameter("todoDate");
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		
		System.out.println(content + "<-- contentUpdate.dopost.content");
		System.out.println(memberId + "<-- contentUpdate.dopost.memberId");
		System.out.println(todoDate + "<-- contentUpdate.dopost.todoDate");
		
		todo = new Todo();
		todo.setMemberId(memberId);
		todo.setTodoContent(content);
		todo.setTodoDate(todoDate);
		todo.setTodoNo(todoNo);
		
		todoService = new TodoService();
		boolean rs =  todoService.updateContent(todo);
		
		// 날짜 자르기
		String y = todoDate.substring(0,4);
		String m = todoDate.substring(5,7);
		String d = todoDate.substring(8,10);

		if(rs == false) {
			System.out.println("실패!");
			response.sendRedirect(request.getContextPath()+"/member/TodoList?y="+y+"&m="+m+"&d="+d);
		} else {
			System.out.println("성공!");
			response.sendRedirect(request.getContextPath()+"/member/TodoList?y="+y+"&m="+m+"&d="+d);
		}
	}

}
