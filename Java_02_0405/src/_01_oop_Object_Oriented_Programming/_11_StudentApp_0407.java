package _01_oop_Object_Oriented_Programming;

import java.sql.SQLOutput;

public class _11_StudentApp_0407 {
	
	public static void main(String[] args) {
		_10_Student_0407 student1 = new _10_Student_0407(1000, "홍길동", 90, 90);
		_10_Student_0407 student2 = new _10_Student_0407(2000, "임꺽정", 94, 98);
		_10_Student_0407 student3 = new _10_Student_0407(3000, "전우치", 91, 80);
		_10_Student_0407 student4 = new _10_Student_0407(4000, "일지매", 76, 82);
		_10_Student_0407 student5 = new _10_Student_0407(5000, "장길산", 84, 86);
		
		// student1.calTot();   
		// student2.calTot();
		// student3.calTot();
		// student4.calTot();
		// student5.calTot();
		// └-> 변경사항이 있을 때 곤란
		
		student1.display();
		student2.display();
		student3.display();
		student4.display();
		student5.display();
		System.out.println("==========================================");
		
		// 나중에 변수를 바꾸는 것
		student1.setKor(100);
		// student1.calTot();
		student1.setEng(80);
		student1.display();
		System.out.println("==========================================");
		
		
		// 객체를 저장할 수 있는 참조요소가 5개인 "배열"을 만든 것
		// => 배열의 참조요소에는 기본적으로 [null]이 초기값으로 저장
		_10_Student_0407[] students = new _10_Student_0407[5];  // => 참조요소 생성, 객체(x)
		
		students[0] = new _10_Student_0407(1000, "홍길동", 90, 90);
		students[1] = new _10_Student_0407(2000, "임꺽정", 94, 98);
		students[2] = new _10_Student_0407(3000, "전우치", 91, 80);
		students[3] = new _10_Student_0407(4000, "일지매", 76, 82);
		students[4] = new _10_Student_0407(5000, "장길산", 84, 86);
		
		// 반복문을 사용하여 배열의 참조요소에 저장된 객체의 메소드를 일괄적으로 호출하여 처리
		// 참조변수(배열의 참조요소)에 [null]이 저장된 상태에서 참조변수로 객체의 메소드를
		//   호출할 경우 NullPointerException이 발생 -> 예외가 발생된 시점에서 프로그램 종료
		for (int i = 0; i < students.length; i++) {
			
			// if문을 사용해서 NullPointerException 방지하는 방법
			// ┖=> null이 아닌경우 메소드 호출하도록 함
			if (students[i] != null) {  
				students[i].display();
			}
		}
		
		 
  		// _10_Student_0407[] students = new _10_Student_0407[] {};
		_10_Student_0407[] students1 = {new _10_Student_0407(1000, "홍길동", 90, 90)
			, new _10_Student_0407(2000, "임꺽정", 94, 98), new _10_Student_0407(3000, "전우치", 91, 80)
			, new _10_Student_0407(4000, "일지매", 76, 82), new _10_Student_0407(5000, "장길산", 84, 86)};      
		// => 이렇게 생성하면 초기값으로 null이 들어가지않는다.(미리 다 선정하는 것)
	
		
		System.out.println("==================================================");
		
		
		
		int tot = 0;
		// 배열의 참조요소에 저장된 객체의 메모리 주소를 차례대로 제공받아 변수에 저장하여
		// 처리하는 향상된 for 구문을 사용하여 일괄처리
		// NullPointerException은 나오지않는다.
		// 형식 : for (자료형 변수명 : 배열명) {
		// 					문장
		// 			}
		for(_10_Student_0407 student : students) {
			student.display();
			tot += student.getTotal();
			
			// 정적 필드는 public 접근 제한자로 설정된 경우엔 클래스를 이용하여 접근가능
			// => 객체로 접근 가능하지만 경고발생
			
			// student.tot += student.getTotal();
			// 정적 필드가 private 접근 제한자로 설정된 경우 메소드를 이용하여 접근 가능
			// => 객체가 아닌 클래스로 접근하여 호출할 수 있다.
			student.setTot(student.getTot() + student.getTotal());
		}
		
		System.out.println("==================================================");
		
		// 모든 학생들의 점수들의 합계를 계산하여 출력
		System.out.println("총합계 = " + tot);
		System.out.println("==================================================");
		System.out.println("총합계 = " + _10_Student_0407.getTot());
		System.out.println("==================================================");
		
		
		
	}
	
	
	
}





















































