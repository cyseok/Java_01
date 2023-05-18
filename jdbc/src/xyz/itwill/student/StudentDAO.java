package xyz.itwill.student;

import java.util.List;

// DAO 클래스가 상속받기 위한 인터페이스
// => 추상 메소드를 이용해 인터페이스를 상속받은 모든 자식클래스(DAO클래스)가
//     동일한 메소드가 선언되도록 작성 규칙 제공
// => DAO 클래스가 변경되어도 프로그램에 영향을 최소화하기 위해 인터페이스 사용

public interface StudentDAO {
	// 학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 개수를 반환하는 메소드
	int insertStudent(UserDTO_1 student);
	
	// 학생정보를 전달받아 STUDENT 테이블에 저장된 정보를 변경하고 변경행 개수를 반환하는 메소드
	int updateStudent(UserDTO_1 student);
	
	// 학번을 전달받아 STUDENT 테이블에 저장된 정보를 삭제하고 삭제행 개수를 반환하는 메소드
	int deleteStudent(int no);
	
	// 학번을 전달받아  STUDENT 테이블에 저장된 정보를 검색하여 반환하는 메소드
	// => 단일행은 값 또는 DTO 객체 반환
	UserDTO_1 selectStudent(int no);
	
	// 이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생 정보 검색
	List<UserDTO_1> selectNameStudentList(String name);
	
	// STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	List<UserDTO_1> selectAllStudentList();
	

}
