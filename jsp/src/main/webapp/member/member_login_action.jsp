<%@page import="oracle.jdbc.driver.Message"%>
<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 정보를 입력받아 로그인 처리하고 [main/main_page.jsp]로 URL 주소를 전달하는 JSP 문서
 => 로그인 인증이 실패한 경우 [member/member_login.jsp] 문서를 요청하기 위한 URL 주소 전달 --%>
<%
	// GET 방식으로 전달된 경우 
	if(request.getMethod().equals("GET")) {
		response.sendRedirect(request.getContextPath() + "/index.jsp?group=error&worker=error_400");//클라이언트에게 URL 주소 전달
		return;
	}

	// 전달값을 반환받아 저장
	String id = request.getParameter("id");
	String passwd = Utility.encrypt(request.getParameter("passwd"));
	
	// 아이디를 전달받아 member 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는 DAO 클래스
	MemberDTO member = MemberDAO.getDAO().selectMember(id);
	
	// 검색된 회원정보가 없는 경우 -> 아이디 인증 실패
	// 검색된 회원정보의 비밀번호와 입력되어 전달된 비밀번호를 비교해 다른경우 -> 비밀번호 인증실패
	if(member==null || member.getPasswd().equals(passwd)) {
		session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
		session.setAttribute("id", id);
		response.sendRedirect(request.getContextPath() + "/index.jsp?group=error&worker=error_400");
		return;
	}
	
	
	 
	
%>

