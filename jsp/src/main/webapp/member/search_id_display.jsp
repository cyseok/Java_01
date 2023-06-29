<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디 검색 관련 정보를 전달받아 MEMBER 테이블에 저장된 회원정보의 아이디를 검색하여
클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%
	if(request.getMethod().equals("GET")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;
	}

	// ★★템플릿 페이지 몸체부에 포함되는 JSP 문서에서는 request 객체 정보 변경 불가능
	// => 템플릿 페이지(index.jsp)에서 requset 정보를 변경해줘야 한다.
	// request.setCharacterEncoding("utf-8");
	
	//전달값을 반환받아 저장
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	
	
	// DTO 객체를 생성하여 전달값으로 필드값을 변경한다.
	
	MemberDTO member= new MemberDTO();
	member.setName(name);
	member.setEmail(email);
	
	
	String id = MemberDAO.getDAO().selectMemberId(member);
	

%>
<h1>아이디 검색 결과</h1>
<% if(id!=null) {  //검색 결과가 있는 경우 %>
	<p style="font-size: 1.5em;"><%=name %>님의 아이디는 [<%=id %>]입니다.</p>
<% } else { %>
	<p style="font-size: 1.5em;">존재하지 않는 아이디 또는 이메일입니다.</p>
<%} %>


