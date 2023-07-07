<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 정보를 전달받아 Userinfo 테이블의 회원정보와 비교하여 인증 처리 후
[user_login.jsp] 문서를 요청하는 URL 주소를 응답 --%>
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect("user_error.jsp");
		return;
	}

	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	
	UserinfoDTO userinfo = UserinfoModelOneDAO.getDAO().selectUserinfo(userid);
	if(userinfo==null || !userinfo.getPassword().equals(password)) {
		session.setAttribute("message", "입력된 아이디가 잘못되었거나 비밀번호가 맞지 않습니다.");
		session.setAttribute("userid", userid);
		response.sendRedirect("user_login.jsp");
		return;
	}
	
	// 인증 성공
	session.setAttribute("loginUserinfo", userinfo);
	
	response.sendRedirect("user_login.jsp");
%>