package _03_Inheritance;

public class MemberEventApp {
	public static void main(String[] args) {
		
		// 자식 클래스의 생성자로 객체를 생성할 경우 부모클래스의 생성자가 먼저 호출되어
		// 부모 클래스의 객체가 먼저 생성된 후 자식클래스의 생성자로 객체를 생성하여 상속관계가 성립된다.
		// 생성자로 객체를 생성하여 상속관계 자동으로 성립
		// => 자식클래스의 참조변수에는 자식클래스 객체의 메모리 주소를 저장하여 자식클래스 객체의
		// 필드와 메소드를 참조하지만 상속관계에 의해 부모클래스 객체의 필드 또는 메소드를 참조가능하다.
		
		MemberEvent member1 = new MemberEvent();   // 기본생성자 호출
		
		
		member1.setId("abc123");
		member1.setName("홍길동");
		member1.setEmail("abc@itwill.zxv");
		
		member1.display();
		System.out.println("===============================");
		
		MemberEvent member2 = new MemberEvent("zxc789", "임꺽정", "zx@itwill.zxc");
		member2.display();
		System.out.println("==================================");
		
		// 위에 처럼 다른 방식으로 처리가능하다. 
	}

}
