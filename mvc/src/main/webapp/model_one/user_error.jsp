<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 에러메시지를 클라이언트에게 전달하여 응답
=> [메인으로] 태그를 클릭한 경우 [user_login.jsp] 문서 요청 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
<style type="text/css">
body {
	text-align: center;
}

.message {
	color: red;
	font-size: 1.5em;
}
</style>
</head>
<body>
	<h1>errorPage</h1>
	<hr>
	<p class="message">프로그램 실행에 예기치 못한 오류가 발생하였거나<br>
	비정상적인 프로그램을 요청하여 오류가 발생하였습니다.</p>
	<button type="button" onclick="location.href='user_login.jsp';">메인으로</button>

</body>
</html>