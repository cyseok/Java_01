package _01_oop_Object_Oriented_Programming;

import java.io.IOException;

// Runtime 클래스 : Java 프로그램에서 운영체제(Operation System) 관련 정보을 제공하는 기능의 
//                  메소드가 선언된 클래스

public class _13_RunTimeApp_0407 {
	
	public static void main(String[] args) throws IOException { // exec 예외처리한 것
		
		// static -> 정적메소드 이므로 클래스로 접근해야 함
		
		// 생성자가 은닉화 선언되어 있어 new 연산자로 생성 불가능
		// => Runtime 클래스는 프로그램에 객체를 하나만 제공하기 위한 클래스 -> 싱글톤 글래스
		// Runtime runtime = new Runtime();
		
		
		// Runtime.getRuntime() : Runtime 객체를 반환하는 메소드
		// => 정적 메소드이므로 클래스를 이용하여 호출가능
		// => getRuntime() 메소드를 여러번 호출해도 같은 객체를 반환한다.
		Runtime runtime1 = Runtime.getRuntime();
		Runtime runtime2 = Runtime.getRuntime();
		
		System.out.println("runtime1 = " + runtime1);
		System.out.println("runtime2 = " + runtime2);
		// => runtime1 = java.lang.Runtime@6a5fc7f7
		// => runtime2 = java.lang.Runtime@6a5fc7f7
		
		// (정리) get으로 호출해서 사용하는 것은 메모리 절약때문이다.
		//        같은 값을 갖고있는 객체가 여러개 만들어지지 않도록 하나의 클래스만을
		//        생성하도록 하는 것 -> 싱글톤 클래스

		System.out.println("=========================================================");
		
		System.out.print("메모리를 정리하기 전 JVM 사용 메모리의 크기 -> ");
		// Runtime.totalMemory() : JVM이 사용가능한 전체 메모리의 크기를 반환하는 메소드
		// Runtime.FreeMemory() : JVM이 사용가능한 여유 메모리의 크기를 반환하는 메소드
		
		System.out.println(runtime1.totalMemory()-runtime1.freeMemory() + "Byte");
		
		// runtime1.gc() : 메모리를 정리하는 프로그램(Garbage Collector)을 실행하는 메소드
		// => System.gc(); -> 정적메소드, 클래스를 호출할 필요가 없다
		runtime1.gc();
		
		System.out.print("메모리를 정리한 후 JVM 사용 메모리의 크기 -> ");
		System.out.println(runtime1.totalMemory()-runtime1.freeMemory() + "Byte");
		
		// Runtime.exec(String command) : 운영체제에 명령을 전달하여 실행하는 메소드
		runtime2.exec("calc.exe");
		
		System.out.println("=========================================================");
		
		
		
		
	}

}
