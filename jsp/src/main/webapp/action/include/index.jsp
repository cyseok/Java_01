<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	 
	<%@include file="header.jspf" %>
 	
	<%-- Content 영역 --%>
	<p>메일 정보 출력</p>
	<p>메일 정보 출력</p>
	<p>메일 정보 출력</p>
	<p>메일 정보 출력</p>
	<p>메일 정보 출력</p>
	<p>메일 정보 출력</p>
	
	<%-- Footer 영역 --%>
	<hr>
	<p>Copyright</p>
	<p>관리자 : ~~~</p>

</body>
</html>