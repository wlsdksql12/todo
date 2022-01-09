package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CalenderService;
import service.TodoService;
import vo.Member;
import vo.Todo;


@WebServlet("/member/Calender")
public class CalenderController extends HttpServlet {
	private CalenderService calenderService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentYear = request.getParameter("currentYear");
		String currentMonth = request.getParameter("currentMonth");
		String option = request.getParameter("option");
		
		// 디버깅
		System.out.println(currentYear + "<-- currentYear");
		System.out.println(currentMonth + "<-- currentMonth");
		System.out.println(option + "<-- option");
		
		calenderService = new CalenderService();
		String memberId = ((Member)request.getSession().getAttribute("loginMember")).getMemberId();
		Map<String, Object> map = calenderService.getTargetCalender(memberId ,currentYear, currentMonth, option);
		
		System.out.println("00"+map.get("targetMonth")+"00map.get(\"targetMonth\")");
		
		// 모델
		request.setAttribute("targetYear", map.get("targetYear"));
		request.setAttribute("targetMonth", map.get("targetMonth"));
		request.setAttribute("endDay", map.get("endDay"));
		// 달력을 출력할때 앞/뒤 필요한 공백<td>
		request.setAttribute("startBlank", map.get("startBlank"));
		request.setAttribute("endBlank", map.get("endBlank"));
		// 달력에 출력할 todo 모델 목록
		request.setAttribute("todoList", map.get("todoList"));
		
		request.getRequestDispatcher("/WEB-INF/view/calender.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
