package _01_xyz.itwill.jdbc;

// Class 객체(Clazz)를 수동으로 생성하는 방법
// 1. Class.forName(String className) 메소드를 호출하는 방법
// 2. Object.getClass() 메소드를 호출해 현재 사용중인 클래스에 대한 Class 객체를 반환받는 방법
// 3. [클래스명.class] 형식으로 표현하는 방법

public class StaticBlockApp {
	public static void main(String[] args) throws ClassNotFoundException {
		// 1. JVM은 ClassLoader 프로그램을 이용해 클래스를 읽어 메모리에 저장
		// 2. new 연산자로 메모리에 저장된 클래스(Class 객체 - Claszz)의 생성자를
		//     호출하여 객체(Object - instance)생성 -> 메모리의 Heap 영역에 생성
		// 3. 생성된 객체의 메모리 주소(= Hashcode)를 제공받아 참조변수를 생성해 저장
		// -> 참조 변수는 메모의 Stack 영역에 생성
	//	StaticBlock sb = new StaticBlock();
		
		// 참조변수에 저장된 메모리 주소로 객체를 참조하여 메소드 호출
	//	sb.display();
		
		// Class.forName(String className) : 문자열로 표현된 패키지가 포함된 클래스를 전달받아
		// ClassLoader 프로그램을 사용해 클래스를 읽어 메모리에 저장하는 메소드
		// => Class 객체(=Clazz) 반환
		// => ClassNotFoundException : 해당 패키지에 클래스가 없는 경우 발생 - 일반예외(예외처리 반드시 필요)
		Class.forName("xyz.itwill.jdbc.StaticBlock"); // -> 클래스를 수동으로 메모리에 저장
		StaticBlock sb = new StaticBlock();
		sb.display();
	}

}
