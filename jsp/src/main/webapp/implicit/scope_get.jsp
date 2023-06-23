<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_scope</title>
</head>
<body>
	<h1>객체의 사용범위(Scope)</h1>
	<hr>
	<%
		// 내장 객체에 저장된 속성값을 속성명으로 구분하여 반환받아 저장
		// => 속성명의 속성값이 없는 경우 null 반환
		// => ★속성값을 Object 객체로 반환하므로 반드시 명시적 객체 형변환 사용
		String pageName=(String)pageContext.getAttribute("pageName");
		String requestName=(String)request.getAttribute("requestName");
		String sessionName=(String)session.getAttribute("sessionName");
		String applicationName=(String)application.getAttribute("applicationName");
	%>
	<p>pageName = <%=pageName %></p>
	<p>requestName = <%=requestName %></p>
	<p>sessionName = <%=sessionName %></p>
	<p>sessionName = <%=applicationName %></p>
	<%-- ★★set 브라우저가 열려있을 때는 sessionName, applicationName이 출력되고
	브라우저가 없어지면 sessionName이 언바인딩 되면서
	 get 브라우저만 실행 할 떄 applicationName 만 출력된다.  --%>

</body>
</html>