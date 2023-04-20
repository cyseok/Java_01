package _04_xyz.itwill.utill_0419;

import java.util.ArrayList;
import java.util.List;

// 학생정보를 관리(삽입,삭제,변경,검색 CRUD)하기 위한 기능 제공 클래스
// => BO(Business Objcet) 클래스 = Manager클래스 : 데이터 처리 클래스

public class StudentManager {
	
	// 다수의 학생정보를 저장하기 위한 필드 -> List 객체 : 저장매체
	private List<Student> studentList = new ArrayList<Student>();
	
	
	// 학번을 전달받아 기존의 학생정보와 비교하여 같은 학번의 정보가 저장된 Index를 반환하는 메소드
	private int getStudentIndex(int num) {
		int index = -1;
		
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getNum() == num) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	
	
	
	
	
	// 학생정보를 전달받아 저장매체에 삽입하고 삽입결과를 boolean 논리값으로 반환
	// => false : 삽입실패, true 삽입성공
	// => 매개변수로 전달받은 학생정보의 학번이 중복될 경우 삽입실패처리한다.
	public boolean insertStudent(Student student) {
		/*
		 * for(Student stu : studentList) {
		 
			if(stu.getNum() ==stu.getNum()) {  // 학생정보가 동일한 경우
				return false;
			}
		}
	*/
		// 같은 학번의 학생정보가 있는경우 삽입실패처리
		if(getStudentIndex(student.getNum()) != -1) {
			return false;
		}
		
		studentList.add(student);
		return true;
	}
	
	
	
	
	// 학번을 전달받아 기존의 학생정보를 삭제하고 삭제결과를 논리값으로 반환
	public boolean deleteStudent(int num) {
		
		int index = getStudentIndex(num);
		if(index == - 1 ) {  // 저장매체에 해당 학번의 정보가 없는 경우
			return false;
		}
		studentList.remove(index);
		return true;
		
	}
	
	
	
	
	
	
	
	// 학생정보를 전달받아 기존의 학생정보를 변경하고 변경결과 반환
	public boolean updateStudent(Student student) {
		
		int index = getStudentIndex(student.getNum());
		if(index == - 1 ) {  // 저장매체에 해당 학번의 정보가 없는 경우
			return false;
		}
		studentList.set(index, student);
		
		studentList.set(0, student);
		return true;
		
	}
	
	
	
	
	// 학번을 전달받아 기존 학생정보를 검색하여 반환하는 메소드
	public Student selectStudent(int num) {
		int index = getStudentIndex(num);
		
		if(index == - 1 ) {
			return null;
		}
		return studentList.get(index);
	}
	
	
	
	// 모든 학생정보 검색해 반환
	public List<Student> selStudentsList () {
		return studentList;
	}

}























