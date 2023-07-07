<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그아웃 처리 후 [ser_login.jsp] 문서를 요청하는 URL 주소 응답 --%>  
<%
	session.invalidate();

	response.sendRedirect("user_login.jsp");
%>  