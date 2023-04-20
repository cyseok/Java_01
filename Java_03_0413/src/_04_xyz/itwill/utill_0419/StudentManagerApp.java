package _04_xyz.itwill.utill_0419;

import java.util.List;

public class StudentManagerApp {
	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
		
		// 저장매페에 학생정보를 삽입하는 메소드 호출
		manager.insertStudent(new Student(1000, "홍길동"));
		manager.insertStudent(new Student(2000, "임꺽정"));
		manager.insertStudent(new Student(3000, "전우치"));
		manager.insertStudent(new Student(4000, "일지매"));
		
		if(manager.insertStudent(new Student(5000, "장길산"))) {
			System.out.println("학생정보 삽입");
		} else {
			System.out.println("이미 저장된 정보, 저장 불가");
		}
		System.out.println("=================================================");
		
		// 2000번인 학생의 정보를 찾아서 출력 
		Student searchStudent = manager.selectStudent(2000);
		if(searchStudent != null) {
			System.out.println(searchStudent);
		} else {
			System.out.println("학생정보를 찾을 수 없습니다.");
		}
		System.out.println("=================================================");
		
		// 2000인 학생의 이름을 변경
		searchStudent.setName("임정");
		if(manager.updateStudent(searchStudent)) {
			System.out.println("변경");
		} else {
			System.out.println("변경불가");
		}
		System.out.println("=================================================");
		
		// 학번이 4000인 정보를 삭제
		if(manager.deleteStudent(4000)) {
			System.out.println("삭제");
		} else {
			System.out.println("삭제불가");
		}
		System.out.println("=================================================");
		
		List<Student> studentList = manager.selStudentsList();
		
		for(Student student : studentList) {
			System.out.println(student);
		}
		System.out.println("=================================================");
		
		
		
		
		
		
	}

}











