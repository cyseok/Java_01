<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">
div {
	
}
</style>
</head>
<body>
	<h1>브라우저 캐싱</h1>
	<hr>
	<div>클라이언트 플렛폼의 현재 날짜와 시간은 
	<span id="clientTime">2023년 7월 4일 12시 22분 30초</span>입니다.</div>
	
	<div>서버 플렛폼의 현재 날짜와 시간은 
	<span id="serverTime">2023년 7월 4일 12시 22분 30초</span>입니다.</div>
	
	<script type="text/javascript">
	// 브라우저가 실행된 클라이언트 플렛폼의 현재 날짜와 시간을 제공받아 태그를 변경하는 함수
	// => 브라우가 실행된 클라이언트에 따라 다른 결과 제공 가능
	function displayClientTime() {
		var now = new Date();
		var displayTime = now.getFullYear() + "년 " + (now.getMonth()+1) + "월 " + now.getDate() + "일 "
					+ now.getHours() + "시 " + now.getMinutes() + "분 " + now.getSeconds() + "초 " + now.getMilliseconds();
		document.getElementById("clientTime").innerHTML = displayTime;
	}
	
	displayClientTime();
	setInterval(displayClientTime, 10);
	
	// 웹프로그램을 실행하는 서버 플렛폼의 현재 날짜와 시간을 제공 받아 태그를 변경하는 함수
	// => 서버 플렛폼의 날짜와 시간을 제공받아 사용하므로 모든 클라이언트에게 동일한 결과 제공
	function displayServerTime() {
		var xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("serverTime").innerHTML=xhr.responseText;
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		}
		xhr.open("get", "clock_two.jsp");
		//xhr.open("get", "clock_two.jsp?dummy="+new Date().getTime());
		xhr.send(null);
	}
	
	displayServerTime();
	setInterval(displayServerTime, 1000);
	
	</script>

</body>
</html>































