package _oop_Object_Oriented_Programming;

public class _15_SingletonApp_0407 {
	
	public static void main(String[] args) {
		
		// new 연산자로 생성자를 호출하여 객체 생성
		// => 참조변수에 저장된 객체를 참조하여 메소드 호출
		
		/*
		_14_Singleton_0407 singleton1 = new _14_Singleton_0407();
		_14_Singleton_0407 singleton2 = new _14_Singleton_0407();
		
		System.out.println("singleton1 = " + singleton1);
		System.out.println("singleton2 = " + singleton2);
		
		singleton1.display();
		singleton2.display();
		*/
		
		// └-> ★생성자의 은닉화로 인해 new 연산자로 생성자를 호출하여 객체 생성하는 것이 불가능하다.
		// => 객체를 반환하는 정적 메소드를 호출하여 객체를 반환받아 사용해야 한다. (아래처럼)
		
		_14_Singleton_0407 singleton1 = _14_Singleton_0407.getInstance();
		_14_Singleton_0407 singleton2 = _14_Singleton_0407.getInstance();
		
		System.out.println("singleton1 = " + singleton1);
		System.out.println("singleton2 = " + singleton2);
		// (결과값)
		// singleton1 = oop_Object_Oriented_Programming._14_Singleton_0407@3b6eb2ec
		// singleton2 = oop_Object_Oriented_Programming._14_Singleton_0407@3b6eb2ec
		
		singleton1.display();
		singleton2.display();
		System.out.println("===================================================");
		
		// ★ 아래처럼 한번에 반환받아 사용해야한다.
		// 싱글톤 클래스는 참조변수에 반환받은 객체를 저장하여 메소드를 호출하지 않고
		// 반환받은 객체로 직접 메소드를 호출하여 사용하는 것을 권장한다. 
		_14_Singleton_0407.getInstance().display();
		_14_Singleton_0407.getInstance().display();
		System.out.println("===================================================");
		
		
		
		
	}
	

}
