<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달값을 이용하여 다른 JSP 문서로 Forward 이동하는 JSP 문서 --%>
<%
	String pageName = request.getParameter("pageName");

	if(pageName==null) {
		// 클라이언트에게 URL 주소를 전달하여 응답처리
		// => ★URL 주소를 응답받은 클라이언트는 브라우저의 요청 URL 주소를 변경하여
		//    서버의 JSP 문서를 요청하여 실행결과(HTML)를 응답받아 출력 -> redirect 이동
		response.sendRedirect("main.jsp");
		return;
		
	}
	
	String contextPath = pageName + ".jsp";
%>
<%-- forward Tag : 요청 JSP 문서에서 다른 JSP 문서를 스레드로 이동하여 JSP 문서로 처리
 => 서버에서 이동되었으므로 클라이언트의 URL 주소 미변경
 => 스레드가 이동되는 JSP 문서에서는 request 내장객체에 저장된 속성값을 반환받아 사용 가능
 
 => 형식 : <jsp:forward page="이동될 JSP 문서"></jsp:forward>
 => page 속성값으로 JSP 표현식 사용 가능 --%>
<%--  --%>
<jsp:forward page="<%=contextPath %>"></jsp:forward>
