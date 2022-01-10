package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import service.NoticeService;
import vo.Member;
import vo.Notice;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private MemberService memberService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login 폼페이지
		// 이미 로그인 되었다면 요청 처리 불가
		HttpSession session = request.getSession();
		if (session.getAttribute("member") !=null) { // 이미 로그인 되어있는 상태이다
			response.sendRedirect(request.getContextPath()+"/member/Calender");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/loginForm.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login.doPost()실행");
		//request.setCharacterEncoding("utf8");
		// 모든 컨트롤러의 doPost() 상단에(요청처리전) 무조건 request.setCharacterEncoding()이 있어야함 -> 
		// -> 공통된 로직이 중복 -> 필터를 사용하자
		
		// login 액션
		memberService = new MemberService();
		Member member = new Member();
		
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
		
		System.out.println(member);
		
		Member loginMember = memberService.login(member);
		System.out.println(loginMember);
		
		HttpSession session = request.getSession();
		
		if(loginMember == null) {
			System.out.println("로그인 실패");
			response.sendRedirect(request.getContextPath()+"/Login");
		}else if(loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			System.out.println("로그인성공!");
			response.sendRedirect(request.getContextPath()+"/member/Calender");
			//request.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(request, response);
		}
	}

}
