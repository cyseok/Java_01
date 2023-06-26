<%@page import="xyz.itwill.bean.Hewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 내장 객체의 속성값으로 저장하고 ["non_useBean_display.jsp"] 문서로
forward 이동하는 JSP 문서 -> 요청에 대한 처리만 제공한다. --%>
<%
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}
	
	// POST 방식으로 전달된 값에 대한 CharacterSet 변경
	request.setCharacterEncoding("utf-8");
	
	// 회원정보를 반환받아 저장
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	
	// JavaBean 클래스로 객체를 생성하여 전달값으로 필드값 변경
	Hewon hewon = new Hewon();
	hewon.setName(name);
	hewon.setPhone(phone);
	hewon.setAddress(address);
	
	
	/*
	★ Redirect 이동
	// JavaBean을 내장객체의 속성값으로 저장
	// => 동일한 클라이언트에서 사용되는 모든 JSP 문서에게 속성값 제공
	session.setAttribute("hewon", hewon);
	
	// Redirect 이동 : 클라이언트에게 URL 주소를 전달하여 다른 JSP 문서를 요청하여 실행결과를 출력
	// => 클라이언트의 요청 URL 주소변경 -> 클라이언트를 이용하여 페이지(JSP 문서) 이동
	// => session 내장 객체에 속성값을 저장하여 Redirect 이동되는 JSP 문서에서 사용
	// => Redirect 이동되는 JSP 문서에서 session 내장 객체에 속성값을 반환받은 후 반드시 제거
	
	response.sendRedirect("non_useBean_display.jsp");
	*/
	
	// ===================================================================
	
	// ★ Forward 이동
	// JavaBean객체를 reques 내장객체의 속성값으로 저장
	// => 스레드가 이동되는 JSP 문서로만 속성값 제공
	request.setAttribute("hewon", hewon);
	
	// forward 이동 : 요청 JSP 문서에서 응답 JSP 문서로 스레드를 이동하여 응답처리
	// => 클라이언트의 요청 URL 주소 미변경 -> 서버에서 JSP 문서 이동
	// => request 내장 객체에 속성값을 저장하여 forward 이동되는 JSP 문서에서 반환받아 사용
	// => 포워드 이동되는 JSP 문서가 실행 종료되면 request 내장객체에 저장된 속성값 자동 소멸
	
	// request.getRequestDispatcher(String path) : 스레드를 이동하기 위한 정보를 저장한 객체
	// RequestDispatcher.forward(ServletRequest request, ServletResponse response) : forward 이동 메소드
	// => 매개변수에 request 객체와 respone 객체를 저장하여 스레드가 이동되는 JSP 문서에 전달
	request.getRequestDispatcher("non_useBean_display").forward(request, response);
	
%>














