<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@page import="xyz.itwill.dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if(request.getMethod().equals("GET")) {
	session.setAttribute("message", "비정상적인 방법으로 페이지를 요청 하였습니다.");
	response.sendRedirect("displayStudent.jsp");  //클라이언트에게 URL 주소 전달
	return;
	}

	//POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경
	request.setCharacterEncoding("utf-8");
	
	//전달값을 반환받아 변수에 저장
	int no=Integer.parseInt(request.getParameter("no"));
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String address=request.getParameter("address");
	String birthday=request.getParameter("birthday");

	//DTO 클래스로 객체를 생성하여 전달값으로 필드값 변경
	StudentDTO student=new StudentDTO();
	student.setNo(no);	
	student.setName(name);	
	student.setPhone(phone);	
	student.setAddress(address);	
	student.setBirthday(birthday);
	
	if(StudentDAO.getDAO().selectStudent(no)==null) { //학생번호가 없는 경유
		session.setAttribute("message", "존재하지않는 학생번호를 입력 하였습니다. 다시 입력해 주세요.");
		session.setAttribute("student", student);
		response.sendRedirect("updateFormStudent.jsp"); //클라이언트에게 URL 주소 전달
		return;
	}
	StudentDAO.getDAO().updateStudent(student);
	
	response.sendRedirect("displayStudent");
%>
