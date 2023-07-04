<%@page import="org.apache.catalina.valves.RemoteIpValve"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 글번호를 전달받아 review 테이블에 저장된 게시글을 검색하여 클라이언트에게 전달하여 응답하는 JSP 문서
=> 페이지 번호, 검색대상, 검색단어는 반환받아 [review_list.jsp] 문서를 요청할 때 전달 --%>
<%

	if(request.getParameter("num")==null) {  // 전달값이 없는 경우
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;
		
	}

	// 전달값을 반환 받아 저장
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("num");
	String search = request.getParameter("search");
	String keyword = request.getParameter("keyword");
	
	// 글 번호를 전달받아 review 테이블에 저장된 게시글을 검색하여 DTO 객체로 반환하는 DAO 클래스
	ReviewDTO review = ReviewDAO.getDAO().selectReview(num);
	
	if(review==null) {  // 검색된 게시글이 없는 경우 -> 에러페이지 이동
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;
	}
	
	// 세션에 저장된 권한 관련 속성값을 저장
	// => 검색된 게시글이 비밀글인 경우 권한을 비교하기 위해 필요
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	if(review.getStatus()==2) {  // 비밀글인 경우
		// 비로그인이거나 로그인 사용자가 게시글 작성자와 관리자가 아닌 경우 -> 에러페이지 이동
		if(loginMember==null || !loginMember.getId().equals(review.getReviewid()) && loginMember.getMemberStatus()!=9) {
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
	out.println("</script>");
	return;
		}
	}
	
	// 글번호를 전달받아 review 테이블에 저장된 게시글의 조회수를 1 증시키시는 DAO 클래스 호출
	ReviewDAO.getDAO().updateReadcount(num);
%>
<style type="text/css">
#review_detail {
	width: 500px;
	margin: 0 auto;
}

table {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 5px;
}

th {
	width: 100px;
	background: black;
	color: white;
}

td {
	width: 400px;
}

.subject, .content {
	text-align: left;
}

.content {
	height: 300px;
	vertical-align: middle;
}

#review_menu {
	text-align: right;
	margin: 5px;
}

</style>
<div id="review_detail">
	<h1>제품후기</h1>
	<table>
		<tr>
			<th>작성자</th>
			<td>
				<%=review.getName() %>
				<%-- 관리자인 경우 --%>
				<% if(loginMember!=null && loginMember.getMemberStatus()==9) { %>
					[<%=review.getIp() %>]
				<%} %>
			</td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td><%=review.getRegdate() %></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=review.getReadcount()+1 %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td class="subject">
				<% if(review.getStatus()==2) { %>
					[비밀글]
				<% } %>
				<%=review.getSubject() %>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td class="content">
				<%=review.getContent().replace("\n", "<br>")%>
				<br>
				<% if(review.getReviewimg()!=null) { %>
					<img src="<%=request.getContextPath()%>/review_images/<%=review.getReviewimg()%>" width="200">
				<% } %>	
			</td>
		</tr>		
	</table>
	
	<div id="review_menu">
		<%-- 로그인 상태의 사용자 중 게시글 작성자이거나 관리자인 경우에만 태그를 출력하여 링크 제공 --%>
		<% if(loginMember!=null && (loginMember.getId().equals(review.getReviewid()) 
				|| loginMember.getMemberStatus()==9)) { %>
		<button type="button" id="modifyBtn">글변경</button>
		<button type="button" id="removeBtn">글삭제</button>
		<% } %>
		<%-- 로그인 상태의 사용자인 경우에만 태그를 출력하여 링크 제공 --%>
		<% if(loginMember!=null) { %>
		<button type="button" id="replyBtn">답글쓰기</button>
		<% } %>
		<button type="button" id="listBtn">글목록</button>
	</div>
</div>

<script type="text/javascript">
$("#modifyBtn").click(function() {
	location.href="<%=request.getContextPath()%>/index.jsp?group=review&worker=review_modify"
			+"&num=<%=review.getNum()%>&pageNum=<%=pageNum%>&search=<%=search%>&keyword=<%=keyword%>";
});

$("#removeBtn").click(function() {
	if(confirm("게시글을 삭제 하시겠습니까?")) {
		location.href="<%=request.getContextPath()%>/review/review_remove_action.jsp?num=<%=review.getNum()%>";
	}
});

$("#replyBtn").click(function() {
	location.href="<%=request.getContextPath()%>/index.jsp?group=review&worker=review_write"
		+"&ref=<%=review.getRef()%>&restep=<%=review.getRestep()%>&relevel=<%=review.getRelevel()%>&pageNum=<%=pageNum%>";
});

$("#listBtn").click(function() {
	location.href="<%=request.getContextPath()%>/index.jsp?group=review&worker=review_list"
		+"&pageNum=<%=pageNum%>&search=<%=search%>&keyword=<%=keyword%>";
});
</script>












































