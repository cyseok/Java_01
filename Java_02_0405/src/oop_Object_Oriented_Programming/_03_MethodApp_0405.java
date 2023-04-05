package oop_Object_Oriented_Programming;


// 실행이 목적인 클래스 -> main 메소드를 반드시 작성
public class _03_MethodApp_0405 {
	
	
	public static void main(String[] args) { 
		
		//(String[] args)  => 참조변수(프로그램 실행기 JVM(Java Virtual Machine)에 의해 자동호출하는 특별한 메소드)
		// => 같은 패키지에 작성된 클래스는 패키지 표현없이 클래스 사용가능
		// => 참조변수를 사용하여 객체의 필드 또는 메소드 접근가능
		
		_02_Method_0405 method = new _02_Method_0405();
		
		// 참조변수를 출력할 경우 "자료형@메모리주소" 형식의 문자열을 제공받아 출력
		System.out.println("method = " + method);
		System.out.println("==========================================================");
		
		// 메소드 호출방법 -> 객체를 이용하여 메소드를 호출하면 프로그램의 흐름(스레드)은 객체의 메소드로 이동하여 
		//                     메소드의 명령을 실행하고 메소드가 종료되면 다시 되돌아와 다음 명령을 실행한다.
		// 요약 : 다른 클래스 객체의 메소드로 가서 실행한 후 다시 돌아온다.
		method.displayOne(); // 매개변수가 없기 때문에 ()는 공란
		method.displayTwo(); 
		method.displayOne(); 
		System.out.println("==========================================================");
		method.printOne();
		System.out.println("==========================================================");
		
		method.printTwo(50); //// 매개변수에 정상적인 값( ()안에 )을 전달해야 호출된다.
		System.out.println("==========================================================");
		
		method.printTwo(80);
		
		// method.printTwo(80.0);  int 매개변수에 double 매개변수는 불가
		System.out.println("==========================================================");
		
		// 여러개의 매개변수 설정 가능
		method.printThree(35, 79);
		System.out.println("==========================================================");
		
		
		
		
		
	}

}
