<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자로부터 로그인 처리에 필요한 인증정보(아이디와 비밀번호)를 입력받기 JSP 문서 --%>
<%-- => [로그인] 태그를 클릭한 경우 [login_action.jsp] 문서를 요청하여 페이지 이동 - 입력값(인증정보) 전달 --%>
<%
	//전달된 에러메세지를 반환받아 저장
	String message=request.getParameter("message");
	if(message==null) {//전달값이 없는 경우
		message="";//null 문자값 출력 방지
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
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
			<td><input type="password" name="passwd"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="loginBtn">로그인</button>
		</tr>
	</table>
	</form>
	<p id="message" style="color: red;"><%=message %></p>
	
	<script type="text/javascript">
	loginForm.id.focus();
	
	document.getElementById("loginBtn").onclick=function() {
		if(loginForm.id.value=="") {
			document.getElementById("message").innerHTML="아이디를 입력해 주세요.";
			loginForm.id.focus();
			return;
		}
		
		if(loginForm.passwd.value=="") {
			document.getElementById("message").innerHTML="비밀번호를 입력해 주세요.";
			loginForm.passwd.focus();
			return;
		}
		
		loginForm.submit();
	}
	</script>
</body>
</html>








