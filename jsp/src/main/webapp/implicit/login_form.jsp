<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 처리에 필요한 인증정보(id, password)를 입력받기 위한 JSP 문서
 => 로그인 태그를 클릭한 경우 [login_action.jsp] 문서를 요청해 페이지 이동 -> 입력값() --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="login_action.jsp" method="post" name="loginForm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="loginBtn">로그인</button>
		</tr>
	</table>
	</form>
	<p id="messge" style="color : red"></p>
	
	<script type="text/javascript">
	loginForm.id.focus();
	
	doucument.getElementById("loginBtn").onclick=function
	
	</script>

</body>
</html>