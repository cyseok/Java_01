<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 userinfo 테이블에 회원정보 삽입하고 [user_login.jsp] 문서로 
이동하는 URL 주소를 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect("user_error.jsp");
		return;
	}

	request.setCharacterEncoding("utf-8");
	
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	int status = Integer.parseInt(request.getParameter("status"));
	
	UserinfoDTO userinfo = new UserinfoDTO();
	userinfo.setUserid(userid);
	userinfo.setPassword(password);
	userinfo.setName(name);
	userinfo.setEmail(email);
	userinfo.setStatus(status);
	
	int rows = UserinfoModelOneDAO.getDAO().insertUserinfo(userinfo);
	
	if(rows>0) {  // 회원등록 성공
		response.sendRedirect("user_login.jsp");
	} else {  // 회원동록 실패 -> 전달받은 아이디에 대한 pk 제약조건 위반으로 인해 발생
		session.setAttribute("message", "이미 사용중인 아이디입니다.");
		session.setAttribute("userinfo", userinfo);
		response.sendRedirect("user_write.jsp");
	}
	
	
%>    
