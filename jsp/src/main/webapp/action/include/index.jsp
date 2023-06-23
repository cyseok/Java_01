<%@page import="org.apache.catalina.webresources.Cache"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	// JSP 문서 요청시 전달된 값을 반환받아 저장
	String category = request.getParameter("category");

	if(category==null) {
		category="mail";
	}
	
	
	String headerPath = "";  // Header 영역에 포함될 파일의 경로를 저장하기 위한 변수
	String master = "";  // 관리자 페이지 관리자의 정보를 저장하기 위한 변수
	
	
	// 전달값을 구분하여 변수에 파일 경로 저장
	if(category.equals("mail")) {
		headerPath="header_mail.jsp";
		master="홍길동(hong@itwill.xyz)";
	} else if(category.equals("blog")) {
		headerPath="header_blog.jsp";
		master="임꺽정(lim@itwill.xyz)";
	} else if(category.equals("cafe")) {
		headerPath="header_cafe.jsp";
		master="전우치(cheon@itwill.xyz)";
	} else {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	
	//Content 영역에 포함될 파일의 경로를 저장하기 위한 변수
		// => 전달값으로 Content 영역에 포함될 파일의 경로 저장
		String contentPath=category+".jsp";
	
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<%-- Header 영역 --%>
	<%-- 
	<h1>쇼핑몰</h1>
	<a href="index.jsp">쇼핑</a>&nbsp;&nbsp;
	<a href="index.jsp">블로그</a>&nbsp;&nbsp;
	<a href="index.jsp">카페</a>&nbsp;&nbsp;
	--%>
	
	<%-- include Directive : 외부파일(JSPF)의 소스코드를 JSP 문서에 포함
	 => CSL(HTML, CSS, JavaScript) 및 SSL(Java - Script Element)의 소스코드 포함
	 => JSP 문서를 요청한 경우 file 속성값으로 설정된 외부파일의 소스코드를 포함하여
	 	실행한 결과를 클라이언트에게 응답한다.
	 => include Directive의 file 속성값으로 설정된 외부파일의 내용이 변경될 경우
	 	JSP 문서를 변경한 것과 동일하므로 JSP 문서를 다시 해석하여 서블릿으로 생성 --%>
	<%-- include Directive의 file 속성값으로 JSP의 표현식(Expression) 사용 불가능
	 => include Directive의 file 속성값으로 설정된 외부파일의 소스코드만 포함 -> 정적포함 --%>
	<%-- ========================================================================== --%>
	 
	<%-- 	<%@include file="header.jspf" %> --%>
	<%-- <%@include file="<%=headerPath %>" %> --%>
	
	
	<%-- include Tag : 요청 JSP 문서에서 다른 JSP 문서로 스레드를 이동하여 실행하고
						 실행될 결과를 가져와 요청 JSP 문서에 포함하는 태그 --%>
	<%-- => 형식 : <jsp:include path="JSP 문서 파일경로"></jsp:include> --%>
	<%-- => 형식 : <jsp:include path="JSP 문서 파일경로"/>< --%>
	<jsp:include page="<%=headerPath %>"/>
	
	<%-- JSP 문서의 실행결과 = CSL(HTML, CSS, JavaScript)를 가져온다. --%>
	<%-- => page 속성값으로 설정된  JSP 문서가 없는 경우 error --%>
	<%-- => page 속성값으로 설정된  JSP 문서가 변경되고 요청 JSP 문서에 영향X --%>
	
	<%-- include Tag의 page 속성값으로 JSP의 표현식 사용가능 --%>
	<%-- => JSP의 표현식으로 제공되는 JSP 문서 포함 -> 동적포함 --%>
 	
 	<%-- ========================================================================== --%>
	<%-- Content 영역 --%>
	<%-- 
	<p>메일 정보 출력</p>
	<p>메일 정보 출력</p>
	<p>메일 정보 출력</p>
	<p>메일 정보 출력</p>
	<p>메일 정보 출력</p>
	<p>메일 정보 출력</p>
	--%>
	<jsp:include page="<%=contentPath %>"/>
	
	<%-- ========================================================================== --%>
	<%-- Footer 영역 --%>
	<%-- 
	<hr>
	<p>Copyright</p> --%>
	<%-- <p>관리자 : ~~~</p> --%>
	<%-- <p>관리자 : <%=master %></p> --%>
	
	~
	<jsp:include page="footer.jsp">
		<jsp:param value="<%=master %>" name="master"/>
	</jsp:include>

</body>
</html>