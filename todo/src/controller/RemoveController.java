package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;


@WebServlet("/member/Remove")
public class RemoveController extends HttpServlet {
	private Member member;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		member = (Member) session.getAttribute("loginMember");
		System.out.println(member.getMemberId() + "<-- Remove.doget.member.getMemberId");
		
		request.getRequestDispatcher("/WEB-INF/view/remove.jsp?memberId="+member.getMemberId()).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Remove.doPost()실행");
		
		MemberService memberService = new MemberService();
		member = new Member();
		
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
		
		System.out.println(member + "<-- dopost.member");
		
		System.out.println(member.getMemberId() + "<-- dopost.member.getMemberId()");
		System.out.println(member.getMemberPw() + "<-- dopost..member.getMemberPw()");
		
		boolean rs = memberService.removeMember(member.getMemberId(), member.getMemberPw());
		
		if(rs == false) {
			System.out.println("실패!");
			response.sendRedirect(request.getContextPath()+"/member/Remove");
		} else {
			System.out.println("성공!");
			response.sendRedirect(request.getContextPath()+"/member/Logout");
		}
		
		
		
	}

}
