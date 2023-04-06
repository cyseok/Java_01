package oop_Object_Oriented_Programming;

public class _06_Overload_0406 {
	
	public void dispayInt (int param) {
		System.out.println("정수값 = " + param);
	}
	
	public void dispayboolean (boolean param) {
		System.out.println("논리값 = " + param);
	}

	public void dispayString (String param) {
		System.out.println("문자열 = " + param);
	}
	
	
	// 메소드 오버로딩(Method Overloading) : 클래스에서 동일한 기능을 제공하는 메소드가
	//  매개변수에 의해 여러개 선언해야 할 경우 메소드의 이름을 같도록 선언하는 기능
	// (정리) 메소드는 같지만 매개변수때문에 어려개 만들어야 할 때 매개변수만 다르게 하는 것
	//        메소드(display)가 같아도 매개변수(int or boolean or String..)가 다르면 따로처리됨
	// => 매개변수의 자료형, 갯수가 달라야한다. (매개변수의 이름말고 자료형이 달라야한다.)
	
	// => 접근제한자와 반환형은 오버로드 선언과 무관하다.
	// 접근 지정자(= 접근 제한자)(Access Modifier) : private, package(default), protected, public
	
	
	public void display (int param) {
		System.out.println("정수값 = " + param);
	}
	
	public void display (boolean param) {
		System.out.println("정수값 = " + param);
	}
	
	public void display (String param) {
		System.out.println("정수값 = " + param);
	}
	
}
