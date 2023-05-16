package xyz.itwill.student;

import java.util.List;

// DAO(Data Access Object) 클래스 : 저장매체에 행 단위 정보를 삽입, 삭제, 변경, 검색하는
//  기능을 제공하는 클래스
// => 저장매체 : 정보를 행 단위로 저장하여 관리하기 위한 하드웨어 또는 소프트웨어 -> DBMS
// => 인터페이스를 상속받아 작성하는 것을 권장 -> 메소드 작성 규칙 제공 : 유지보수 효율성 증가

// STUDENT 테이블에 행을 삽입, 삭제, 변경, 검색하는 기능의 메소드를 제공하는 클래스
// => 하나의 메소드는 매개변수로 객체를 전달받아 하나의 SQL 명령을 실행하고
//     그 결과를 DBMS서버에 전달하고 Java 객체로 매핑하여 환
public class StudentDAOImpl implements StudentDAO {
	
	
	
	@Override
	public int insertStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updateStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int deleteStudent(int no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public StudentDTO selectStudent(int no) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<StudentDTO> selectAllStudentList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<StudentDTO> selectNameStudent(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}

