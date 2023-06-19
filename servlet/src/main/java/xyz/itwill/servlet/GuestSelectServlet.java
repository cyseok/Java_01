package xyz.itwill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// GUSET 테이블에 저장된 모든 행을 검색하여 클라이언트에게 전달하여 응답하는 서블릿
@WebServlet("/guest/list.itwill")
public class GuestSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
