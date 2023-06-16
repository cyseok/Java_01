package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// [multipart/form-data]로 전달된 값은 request 객체로부터 입력스트림(ServletInputStream)을
//  제공받아 임시파일에 저장한 후 전달값과 전달파일을 구분하여 처리
// => [multipart/form-data]로 전달된 경우 [multipart/form-data]를 처리하는 클래스를 사용하여 처리하는 것을 권장

// [multipart/form-data]를 처리하는 클래스가 포함된 라이브러리를 다운받아 프로젝트에 빌드처리
// => Apache에서 배포한  commons-fileupload 라이브러리 클래스 사용 - 선택적 파일 업로드
// => Oreilly에서 배포한  cos 라이브러리 클래스 사용 - 무조건 파일 업로드

//Oreilly 그룹에서 배포한 cos 라이브러리를 다운로드 프로젝트 빌드 처리
//1.http://www.servlets.com 사이트 접속 >> COS File Upload Library 메뉴 클릭 >> cos-22.05.zip 다운로드
//2.cos-22.05.zip 파일 압축 풀기 >> cos-22.05 폴더 이동 >> lib 폴더 이동 >> cos.jar 복사
//3.프로젝트 >> src/main/webapp >> WEB-INF >> lib >> cos.jar 붙여넣기
//=> /WEB-INF/lib 폴더에 라이브러리 파일(jar 파일)을 붙여넣기 하면 자동으로 라이브러리 빌드 처리

// 입력페이지(fileupload.html)에서 전달된 값과 파일명을 클라이언트에게 전달하여 응답하는 서블릿
// => 전달받은 서버 디렉토리  저장 -> 파일 업로드 처리됨
@WebServlet("/Upload.itwill")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("fileupload.html");
			return;
		}
			
			
			/* 이건 못씀..[multipart/form-data] 때문
			request.setCharacterEncoding("utf-8");
			
			// ★form 태그의 [multipart/form-data]로 전달된 입력값은 HttpServletRequest 객체의
			//  getParameter() 메소드를 호출하여 반환 불가능
			String uploader = request.getParameter("uploader");
			*/
		
			// 전달파일을 저장하기 위한 서버 디렉토리
			// => 이클립스의 작업 디렉토리(WorkSpace)가 아닌 WAS프로그램이 사용하는 
			//     웹디렉토리(WebApps)파일 시스템 경로 반환
			// !주의) WAS 프로그램이 실행될 때 이클립스의 작업 디렉토리의 파일을 이용하여 
			//         웹디렉토리의 자원(Context)으로 저장 -> 동기화 처리
			// => 작업디렉토리에 업로드 파일이 없으므로 동기화 처리되면 웹디렉토리에 업로드된 파일 소멸
			// 
			// 
			String saveDirectory = request.getServletContext().getRealPath("/upload");
			// System.out.println("saveDirectory = " + saveDirectory);
			
			// cos 라이브러리의 MultipartRequest 클래스로 객체생성
			// => 모든 전달파일을 제공받아 서버 디렉토리에 저장 -> 자동 업로드 처리
			// [multipart/form-data]로 전달받은 값과 피일을 처리하기 위한 MultipartRequest 객체 생성
			// => 
			// MultipartRequest(HttpServletRequest request, String saveDirectory[, int maxPostSize] 
			// 		[, String encoding] [, FileRenamePolicy policy]) 생성자를 이용하여 객체 생성
			// => request : 요청정보가 저장된 HttpServletRequest 객체 전달
			// => saveDirectory : 전달파일이 저장될 서버 디렉토리 파일의 시스템 경로 전달
			// => maxPostSize : 전달파일의 용량을 제한하는 크기 전달 (단위는 Byte) -> 생략시 무제한이 디폴트ㄴ
			// => encoding : 전달값을 제공받기 위한 대한 문자형태 전달 -> 생략시 서유럽어가 디폴트
			// => policy : FileRenamePolicy 객체 전달 -> 생략시 파일 덮어씌우기가 디폴트값
			// FileRenamePolicy 객체 : 업로드될 파일의 이름과 같은 이름의 파일이 
			//  서버 디렉토리에 이미 존재할 경우 업로드될 파일의 이름을 변경하는 기능을 제공
			// => FileRenamePolicy 인터페이스를 상속받은 자식클래스로 객체 생성
			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 20*1024*1024, 
					"utf-8", new DefaultFileRenamePolicy());
			
			// 전달값을 반환받아 저장 -> MultipartRequest 객체 이용
			// => .getParameter(String name) or getParameterValues(String name) 이용한다.ㄴ
			String uploader = mr.getParameter("uploader");
			
			/*
			// MultipartRequest 객체를 이용해 전달파일명을 저장
			// getOriginalFileName(String arg) : 매개변수로 전달된 이름의 파일명을 반환하는 메소드 
			String fileone = mr.getOriginalFileName("fileone");
			String filetwo = mr.getOriginalFileName("filetwo");
			*/
			
			//MultipartRequest.getFilesystemName(String name) : 매개변수로 전달된 이름의 파일명
			//(업로드된 처리된 파일명)을 반환하는 메소드
			// => FileRenamePolicy 객체를 사용한 경우 호출하는 메소드
			String fileone=mr.getFilesystemName("fileone");
			String filetwo=mr.getFilesystemName("filetwo");
	  
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>파일업로드</h1>");
			out.println("<hr>");
			out.println("<p>이름 ="+uploader+"</p>");
			out.println("<p>파일-1 ="+fileone+"</p>");
			out.println("<p>파일-2 ="+filetwo+"</p>");
			out.println("</body>");
			out.println("</html>");
	}

}
