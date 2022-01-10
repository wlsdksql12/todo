package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

@WebServlet("/addMember")
public class addMemberController extends HttpServlet {
	private MemberService memberService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		memberService = new MemberService();
		Member member = new Member();
		
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
		
		System.out.println("00000000"+member+"00000000000000000");
		
		memberService.addMember(member);
		request.getRequestDispatcher("/WEB-INF/view/loginForm.jsp").forward(request, response);
	}
}
