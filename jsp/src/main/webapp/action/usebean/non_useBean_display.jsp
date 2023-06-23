<%@page import="xyz.itwill.bean.Hewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 내장 객체에 저장된 속성값을 반환받아 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%
	/*
	// 비정상요청
	if(session.getAttribute("hewon")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	Hewon hewon = (Hewon)session.getAttribute("hewon");
	
	// 다른 JSP문서에서 내장객체에 저장된 속성값을 지워줌
	session.removeAttribute("hewon");
	*/
	
	// 위처럼 표기하는거 대신에
	if(request.getAttribute("hewon")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	} 

	//내장객체에 저장된 속성값을 반환받아 저장
	Hewon hewon=(Hewon)request.getAttribute("hewon");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보확인</h1>
	<hr>
	<p>이름 = <%=hewon.getName() %></p>
	<p>전화번호 = <%=hewon.getPhone() %></p>
	<p>주소 = <%=hewon.getAddress() %></p>


</body>
</html>