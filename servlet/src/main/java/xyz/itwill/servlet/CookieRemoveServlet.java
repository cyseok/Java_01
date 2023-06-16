package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieRemoveServlet
 */

// 클라이언트에 저장된 모든 쿠키를 삭제하고 처리결과를 전달하여 응답하는 서블릿
@WebServlet("/remove.itwill")
public class CookieRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) { // 쿠키가 있는 경우
			for(Cookie cookie : cookies ) {
				// 쿠키의 유지시간을 0으로 변경
				// => 유지 시간이 지난 쿠키는 클라이언트에서 자동 소멸 -> 클라이언트에 저장된 쿠키는 삭제
				cookie.setMaxAge(0);
				response.addCookie(cookie);  // 클라이언트에 저장된 기존 쿠키를 덮어씌움
				
			}
			
		}
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 삭제</h1>");
		out.println("<hr>");
		out.println("<p>네 안에 쿠키 없다.</p>");
		out.println("<hr>");
		out.println("<p><a href='read.itwill'>쿠키 읽기</a></p>");
		out.println("</body>");
		out.println("</html>");
	}

}
