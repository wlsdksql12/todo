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

@WebServlet("/member/addTodo")
public class addTodoController extends HttpServlet {

	private TodoService todoService;
	private Todo todo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("addTodo.addTodo() 실행");
		String todoDate = request.getParameter("todoDate");
		String todoContent = request.getParameter("todoContent");
		String fontColor = request.getParameter("fontColor");
		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		
		todo = new Todo();
		todo.setTodoDate(todoDate);
		todo.setTodoContent(todoContent);
		todo.setMemberId(memberId);
		todo.setFontColor(fontColor);
		
		// 값이 제대로 들어왔나 확인
		System.out.println("0000"+todo+"00000");
		
		todoService = new TodoService();
		
		// 날짜 자르기
		String y = todoDate.substring(0,4);
		String m = todoDate.substring(5,7);
		String d = todoDate.substring(todoDate.length()-2, todoDate.length());
		
		
		// boolean값으로 받아 실패 성공 확인과 이동
		boolean rs =  todoService.addTodo(todo);
		
		if(rs == false) {
			System.out.println("실패");
			response.sendRedirect(request.getContextPath()+"/member/Calender");
		} else {
			System.out.println("성공");
			response.sendRedirect(request.getContextPath()+"/member/TodoList?y="+y+"&m="+m+"&d="+d);
		}
		
		
	}

}
