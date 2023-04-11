package Inheritance_0410;

// 학원 인적자원(강사, 학생, 직원) 관리 프로그램

public class AcademyApp {
	public static void main(String[] args) {
		// 학생정보를(AcademyStudent 객체) 저장하기 위한 요소들이 존재하는 배열 생성
		// 학생정보를 300개 저장할 수 있는 요소가 있는 배열
		/*
		AcademyStudent[] students = new AcademyStudent[300];
		
		// 강사정보(AcademyInstructor 객체)를 저장하기 위한 요소들이 존재하는 배열 생성
		AcademyInstructor[] instructors = new AcademyInstructor[50];
		
		// 직원정보(AcademyStaff 객체)를 저장하기 위한 요소들이 존재하는 배열 생성
		AcademyStaff[] sfaffs = new AcademyStaff[100];
		*/
		
		// 사람정보(AcademyPerson 객체)를 저장하기 위한 요소들이 존재하는 배열 생성
		// => 배열요소에 학생정보(AcademyStudent 객체), 강사정보(AcademyInstructor 객체), 
		//    직원정보(AcademyStaff 객체) 저장이 가능하다
		// ★★ 모든 클래스의 부모이기 때문에 가능하다...
		AcademyPerson[] persons = new AcademyPerson[500];
	}

}
