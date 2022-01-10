package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;
import vo.Notice;

@WebServlet("/member/noticeOne")
public class NoticeController extends HttpServlet {
	private NoticeService noticeService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		System.out.println("00000000a"+noticeNo+"a000000000noticeNo");
		
		noticeService = new NoticeService();
		Notice notice = noticeService.noticeOne(noticeNo);
		
		System.out.println("000000000000"+notice+"00000000000000notice");
		
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/view/noticeOne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
