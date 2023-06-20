package xyz.itwill.guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

// 방명록 게시글을 전달받아 GUEST 테이블에 삽입하고 방명록 게시글 목록 페이지(/guest/list.itwill)로 
//   이동하기 위한 URL 주소를 클라이언트에게 전달하여 응답하는 서블릿
// => 방명록 게시글 입력 페이지(guest/writeForm.itwill)에서 form태그를 사용해 post 방식으로 요청하는 서블릿
@WebServlet("/guest/write.itwill")
public class GuestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// (비정상적인 요청)서블릿을 GET 방식으로 요청한 경우
		if (request.getMethod().equals("GET")) {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
		
		// 리퀘스트 메시지(post 방식일떄만 사용) 몸체부에 저장되어 전달되는 값에 대한 캐릭터셋 변경
		request.setCharacterEncoding("utf-8");
		
		// 전달값을 반환받아 저장
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// DTO 객체를 생성하여 전달할 수 있게 필드값으로 작성해준다
		GuestDTO guest = new GuestDTO();
		guest.setWriter(writer);
		guest.setSubject(subject);
		guest.setContent(content);
		
		// GUEST 테이블에 행을 삽입한 DAO 클래스의 메소드를 호출한다.
		GuestDAO.getDAO().insertGuest(guest);
		
		// 클라이언트에게 URL 주소를 전달하여 응답처리
		// => 클라이언트는 전달받은 URL 주소의 서블릿을 요청하여 실행결과를 응답받아 출력
		response.sendRedirect("list.itwill");
		
	}

}
