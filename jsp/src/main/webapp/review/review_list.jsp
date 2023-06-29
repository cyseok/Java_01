<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@page import="java.util.List"%>
<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- review 테이블을 검색해 목록을 전달하는 JSP 문서
=> 게시글을 페이지로 구분하여 검색 처리 -> 페이징 처리 --%>
<%
	// 검색처리에 필요한 전달값(검색대상과 검색 단어)을 반환받아 저장
	String search = request.getParameter("search");
	if(search==null) {
		search="";
	}
	
	String keyword = request.getParameter("keyword");
	if(keyword==null) {
		keyword="";
	}


	// 페이징 처리에 필요한 전달값을 반환받아 저장
	// => 페이징 처리에 필요한 전달값이 없는 경우 1번째 페이지의 게시글 목록을 검색하여 응답
	int pageNum = 1;
	if(request.getParameter("pageNum")!=null) {  // 전달값이 있는 경우
		pageNum= Integer.parseInt(request.getParameter("pageNum"));
	}
	
	// 하나의 페이지에 검색되어 출력될 게시글의 개수 설정 -> 전달값으로 반환받아 저장 가능하다.
	int pageSize = 10;
	
	// review 테이블에 저장된 전체 게시글의 개수를 검색하여 반환하는 DAO 클래스의 메소드 호출
	// => 게시글 검색기능 미구현시 호출되는 메소드
	int totalReview = ReviewDAO.getDAO().selectRiviewCount(search, keyword);
	
	// 전체 페이지의 개수를 계산하여 저장
	// 나머지가 있으면 + 1
	// int totalPage = totalReview/pageSize + totalReview % pageSize == 0 ? 0 : 1;
	int totalPage = (int)Math.ceil((double)totalReview/pageSize);
	
	// 전달받은 페이지 번호가 비정상적인 경우
	if(pageNum <= 0 || pageNum > totalPage) {
		pageNum=1;  // 1번쨰 페이지 게시글 목록 검색
		
	}
	
	// 요청한 페이지 번호에 대한 시작 게시글의 행 번호 저장
	// ex) 1page : 1, 2page : 11, 3page : 21  ....
	int startRow = (pageNum-1) * pageSize +1;

	// 요청한 페이지 번호에 대한 종료 게시글의 행 번호 저장
	// ex) 1page : 10, 2page : 20, 3page : 30  ....
	int endRow = (pageNum) * pageSize;
	
	// 마지막 페이지의 종료 행 번호가 검색 게시글의 개수보다 많은 경우
	if(endRow > totalReview) {
		endRow = totalReview;  
	}
	
	// 페이징 정보 + 게시글 검색 정보 전달 후 => review 테이블을 검색해 List 객체로 반환하는  DAO 호출
	List<ReviewDTO> reviewList=ReviewDAO.getDAO().selectReviewList(startRow, endRow, search, keyword);
	
	//세션에 저장된 권한 관련 속성값을 객체로 반환받아 저장
	// => 로그인 상태의 사용자에게만 글쓰기 권한 제공
	// => 비밀글인 경우 로그인 상태의 사용자가 게시글 작성자이거나 관리자인 경우에만 사용 권한 제공
	MemberDTO loginMener=(MemberDTO)session.getAttribute("loginMember");
	
	//서버 시스템의 현재 날짜를 제공받아 저장
	// => 게시글 작성날짜와 현재 날짜를 비교하여 게시글 작성날짜를 다르게 출력되도록 응답 처리
	String currentDate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
%>
<p>제품 후기</p>