<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 변경 게시글을 전달받아 review 테이블에 저장된 게시글을 변경하고 [review/review_detail.jsp] 문서로 이동하는
URL 주소를 클라이언트에게 전달하여 응답하는 문서
=> [review/review_detail.jsp] 문서로 글번호, 페이지번호, 검색대상, 검색단어 전달
=> 로그인 상태의 사용자 중 작성자 or 관리자만 응답처리 --%>
<%@include file="/security/login_check.jspf %>
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect(request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}
	
	// 전달 파일을 저장할 서버 디렉토리의 파일 시스템 경로를 반환받아 저장
	String saveDirectory = request.getServletContext().getRealPath("/review_images");
	
	
	// MultipartRequest 객체 생성 -> 모든 전달 파일을 서버 디렉토리에 업로드해 저장
	MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory, 20*1024*1024,
			"utf-8", new DefaultFileRenamePolicy()); 
	// DefaultFileRenamePolicy -> 이름을 바꾸기 위해..
	
	/*
	// 전달값을 반환받아 저장
	int ref=Integer.parseInt(multipartRequest.getParameter("ref"));
	int restep=Integer.parseInt(multipartRequest.getParameter("restep"));
	int relevel=Integer.parseInt(multipartRequest.getParameter("relevel"));
	String pageNum=multipartRequest.getParameter("pageNum");
	String subject=multipartRequest.getParameter("subject");
	
	int status=1;
	
	if(multipartRequest.getParameter("secret")!=null) {  // 비밀글
		status=Integer.parseInt(multipartRequest.getParameter("secret"));
	}
	
	String content=multipartRequest.getParameter("content");
	
	// 업로드 처리된 파일명을 반환받아 저장
	String reviewimg = multipartRequest.getParameter("reviewimg");
	
	*/
	
	
%>



























