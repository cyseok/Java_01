<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name=request.getParameter("name");

	List<MyHewon> hewonList=null;
	
	if(name==null || name.equals("")) {//전달값이 없는 경우
		hewonList=MyHewonDAO.getDAO().selectHewonList();//전체 검색
	} else {
		hewonList=MyHewonDAO.getDAO().selectNameHewonList(name);//조건 검색
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	text-align: center;
	padding: 3px;
}

.id { width: 150px; }
.name { width: 150px; }
.phone { width: 200px; }
.email { width: 200px; }
.status { width: 100px; }
</style>
</head>
<body>
	<h1>회원목록</h1>
	<hr>
	<table>
		<tr>
			<td class="id">아이디</td>
			<td class="name">이름</td>
			<td class="phone">전화번호</td>
			<td class="email">이메일</td>
			<td class="status">공개범위</td>
		</tr>
		<% if(hewonList.isEmpty()) { %>
			<tr>
				<td colspan="5">검색된 회원정보가 없습니다.</td>
			</tr>
		<% } else { %>
			<% for(MyHewon hewon : hewonList) { %>
			<tr>
				<td><%=hewon.getId() %></td>
				<td><%=hewon.getName() %></td>
				<td><%=hewon.getPhone() %></td>
				<td><%=hewon.getEmail() %></td>
				<td><%=hewon.getStatus() %></td>
			</tr>
			<% } %>
		<% } %>
	</table>
	<br>
	
	<form method="post">
		이름 : <input type="text" name="name">
		<button type="submit">검색</button>
	</form>	
</body>
</html>
