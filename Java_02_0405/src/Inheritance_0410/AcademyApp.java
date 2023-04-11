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
		// ★★ 위 3개 클래스의 부모이기 때문에 가능하다...
		// => 부모클래스의 참조변수(부모클래스의 객체가 저장됨)에 자식클래스의 생성자로 객체를 생성하여 저장이 가능하다.
		AcademyPerson[] persons = new AcademyPerson[5];
		
		// 자식클래스의 생성자로 객체를 생성하면 부모클래스의 객체를 먼저 생성한 후 자식클래스의 객체를 생성
		// => 배열요소애는 부모클래스의 객체가 저장되어 부모클래스의 메소드를 호출
		// => ★객체 형변환을 이용하면 배열요소를 자식클래스의 객체를 일시적으로 사용하여 자식클래스의 메소드 호출이 가능.
		persons[0] = new AcademyStudent(1000, "홍길동", "웹개발자 과정");
		persons[1] = new AcademyInstructor(2000, "임꺽정", "Java 과정");
		persons[2] = new AcademyStaff(3000, "전우치", "운영관리");
		persons[3] = new AcademyStudent(4000, "일지매", "웹디자인 과정");
		persons[4] = new AcademyStaff(5000, "장길산", "경영회계팀");
		
		// 배열 요소에 저장된 객체를 하나씩 제공받아 참조변수에 저장하여 일괄처리
		for (AcademyPerson person : persons) {
			// 오버라이드 선언된 메소드는 묵시적 객체 형변환에 의해 부모클래스의 메소드를 
			//  호출하지 않고 자식클래스의 메소드를 호출한다.
			// 참조변수에 저장된 자식클래스의 객체에 의해 자식클래스의 메소드가 선택 호출됨.
			// => 오버라이드에 의한 다형성
			person.display();
			// └-> 오버라이드에 의한 묵시적 객체 형변환이 됨.
			System.out.println("======================================");
			
			
		}
	
	}

}
