package _01_oop_Object_Oriented_Programming;

public class _07_OverloadApp_0406 {
	
	public static void main(String[] args) {
		
		 _06_Overload_0406 overload = new  _06_Overload_0406();
		 
		overload.dispayInt(100);
		// 메소드의 매개변수에 잘못된 값을 전달할 경우 error 발생
		//  overload.dispayInt(false);
		overload.dispayboolean(false);
		overload.dispayString("홍길동");
		System.out.println("======================================================");
		
		// 오버로드 선언된 메소드는 매개변수에 전달되는 값에 따라 메소드를 선택하여 호출한다.
		// => 메소드 오버로드에 의한 다형성
		// (정리) => 매개변수에 따라서 알맞는 메소드가 선택되어 호출된다.
		
		// 다형성((polymorphism) : 같은 이름의 메소드를 호출할 경우 상태에 메소드를 선택 호출
		// 되는 기능 : 메소드 오버로드, 메소드 오버라이드
		
		overload.display(200);
		overload.display(true);
		overload.display("홍길동");
		// (정리) => 매개변수에 따라서 알맞는 메소드가 선택되어 호출된다.
		
		// 전달받은 값에 대한 자료형의 매개변수가 없는경우 error 발생
		// overload.display(12.1);
		System.out.println("======================================================");
		
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}

}
