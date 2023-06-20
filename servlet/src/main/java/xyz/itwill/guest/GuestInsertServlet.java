package xyz.itwill.guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 방명록 게시글을 전달받아 GUEST 테이블에 삽입하고 방명록 게시글 목록 페이지(/guest/list.itwill)로 
//   이동하기 위한 URL 주소를 클라이언트에게 전달하여 응답하는 서블릿
@WebServlet("/guest/iwrite.itwill")
public class GuestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
