package fillter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminLoginFilter
 */
@WebFilter("/Admin/*")
public class AdminLoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 로그인 상태에서만 요청할수 있는 필터링 -> 필터를 사용(LoginFilter)
		System.out.println("LoginFilter.doFilter() 실행");
		HttpSession session = ((HttpServletRequest)request).getSession();
		if (session.getAttribute("adminId") == null) { // 이미 로그인 되어있는 상태이다
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/adminLogin");
			return;
		}
		chain.doFilter(request, response);
	}
}
