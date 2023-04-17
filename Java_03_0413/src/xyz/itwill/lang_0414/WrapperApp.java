package xyz.itwill.lang_0414;

// Wrapper 클래스 : 원시형을 클래스로 선언한 자료형을 일괄적으로 표현하기 위한 이름
// └-> byte, short, integer, long, float, double, character, boolean 
// => 원시형 대신 객체로 표현하기 위해 사용하는 클래스
public class WrapperApp {
	public static void main(String[] args) {
		/*
		int num1 = 100, num2 = 200;
		int num3 = num1 + num2;
		System.out.println("num3 = " + num3);
		*/
		
		/*
		// Integer num1 = new Integer(100);
		// Integer.valueOf(Object i) : 매개변수로 값을 전달받아 정수값의 Integet 객체를 반환하는 메소드
		Integer num1 = Integer.valueOf(100); 
		Integer num2 = Integer.valueOf("200"); // 문자열을 전달받아도 내부적으로는 정수값으로 저장됨 
		// Integer.intValue() : Integer 객체에 저장된 정수값을 반환하는 메소드
		Integer num3 = Integer.valueOf( num1.intValue() + num2.intValue());
		System.out.println("num3 = " + num3.intValue());
		-> 복잡하고 불편하다  */  
		
		
		// Wrapper 클래스는 오토박싱과 오토언박싱 기능을 제공받아 객체를 생성하거나 사용 가능
		// 오토박싱 : 원시형 리터럴(값)을 JVM이 자동으로 Wrapper 클래스의 객체로 생성하여 반환하는 기능
		Integer num1 = 100, num2 = 200;
		Integer num3 = num1 + num2;
		System.out.println("num3 = " + num3);
		
		
		
		
	}

}
