package _05_nested_0412;

public class AnonymousApp {
	public static void main(String[] args) {
		
		// 인터페이스를 사용하여 참조변수 생성은 가능하지만 객채 생성은 불가능하다
		// => 인터페이스는 클래스가 상속받기 위한 자료형
		// => 인터페이스를 상속받은 자식클래스는 인터페이스에 선언된 모든 추상메소드를
		//    반드시 오버라이드 선언해야한다.
		// => 인터페이스를 상속받은 자식클래스로 객체를 생성하여 인터페이스로 생성된
		//     참조변수에 저장 가능.
		//   Anonymous anonymous = new Anonymous();  -> 불가능
		
		// 인터페이스를 상속받은 이름이 없는 자식클래스를 선언하고 인터페이스의 메소드를
		//   "오버라이드 선언"하여 객체 생성이 가능하다. -> 익명의 내부클래스(로컬클래스)
		// => 익명의 내부클래스(Anonymous InnerClass) : 인터페이스 또는 추상클래스를 상속받은 이름이 없는 자식클래스로
		//                                               익명의 내부클래스로 하나의 객체를 생성하여 사용해야한다.		
		// => 익명의 내부클래스 : 상속받은 인터페이스 또는 추상클래스의 모든 추상메소드를 오버라이드 선언해야한다.
		
		Anonymous anonymous = new Anonymous() {
			
			@Override
			public void display() {
				// TODO Auto-generated method stub
				System.out.println("익명의 내부클래스의 오버라이드 메소드 호출~");
				
			}
		};
		anonymous.display();
		
		
	}

}
