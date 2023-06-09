package _03_Inheritance_0410;

// 상속관계의 클래스에서 참조변수와 객체와의 관계

public class MemberCastApp {
	public static void main(String[] args) {
		// 부모클래스 참조변수 = new 부모클래스();
		// => 부모클래스의 생성자로 객체를 생성하여 부모클래스의 참조변수에 저장
		Member member1 = new Member();
		
		// 참조변수에 저장된 부모클래스의 객체를 사용하여 부모클래스의 메소드를 호출
		member1.setId("asd123");
		member1.setName("홍길동");
		
		member1.display();
		System.out.println("================================================================");
		
		// 자식클래스 참조변수 = new 자식클래스();
		// => 부모클래스의 생성자로 부모클래스 객체를 생성하고 자식클래스의 생성자로 
		//    자식클래스 객체를 생성하여 자식클래스의 참조변수에 자식클래스의 객체를 저장할 수 있다.
		MemberEvent member2 = new MemberEvent();
		
		// 참조변수에 저장된 자식클래스의 객체를 사용하여 자식클래스의 메소드를 호출할 수
		// 있고, 상속관계에 의해 부모클래스 객체를 참조하여 부모클래스도 호출할 수 있다.
		member2.setId("qwe456");
		member2.setName("홍홍홍");
		member2.setEmail("asf@af.afs");
		
		member2.display();
		
		// 자식클래스 참조변수 = new 자식클래스();
		// => 부모클래스의 생성자로 부모클래스 객체를 생성하고 자식클래스의 참조변수에
		//     부모클래스의 객체를 저장하는 것은 불가능하다.
		// └=> MemberEvent member3 = new Member();
		System.out.println("============================================================");
		
		// 부모클래스 참조변수 = new 부모클래스();
		// => 부모클래스의 생성자로 부모클래스 객체를 생성하고 자식클래스의 생성자로 
		//    자식클래스 객체를 생성하여 부모클래스의 참조변수에 부모클래스의 객체를 저장할 수 있다.
		Member member4 = new MemberEvent();  // 부모 객체를 사용한 것(참조변수)
		
		
		// 참조변수에 저장된 부모클래스의 객체를 사용하여 부모클래스의 메소드를 호출할 수 있다.
		// => 참조변수로 자식클래스 객체를 참조할 수 없으므로 자식클래스도 호출 불가능
				
		member4.setId("qweqwe123");
		member4.setName("전우치");
		// member4.setEmail -> 접근 불가
		
		// 객체 형변환을 이용하면 부모클래스의 참조변수로 자식클래스의 메소드를 호출할 수 있다.
		// => 명시적 객체 형변환(강제 형변환), 묵시적 객체 형변환(자동 형변환)
		// => ★ 객체 형변환은 상속관계 클래스에서만 사용 가능
		
		// 명시적 객체 형변환 : Cast 연산자를 사용하여 부모클래스 참조변수의 자료형을 일시적으로
		// 자식클래스로 변경하면 일시적으로 참조변수에 자식클래스의 객체가 자동 저장됨.
		// => 명시적 객체 형변환에 의해 자식클래스로 자료형이 변경된 참조변수는 자식클래스의 객체가 저장되므로
		//    자식클래스의 메소드가 호출 가능하다.
		MemberEvent event = (MemberEvent) member4;
		//                                └-> 부모가 아닌 자식으로 일시적 형변환
		// event.setEmail("asfafafaf");  변환하면 아래처럼 쓸 수 있음
		// (.)연산자보다 Cast 연산자가 먼저 실행되도록 ()연산자 사용해준다.
		((MemberEvent)member4).setEmail("asfafafaf");
		
		// ((MemberEvent)member4).display();
		// 묵시적 객체 형변환 
		// => 부모클래스의 메소드를 자식클래스에서 오버라이드 선언하면 부모클래스의 메소드의 숨겨진 메소드 대신
		//    자식클래스의 메소드를 호출하기 위해 참조변수의 자료형을 자동으로 자식클래스로 변경하여
		//    일시적으로 자식클래스의 객체가 참조변수에 저장되어 자식클래스의 메소드를 호출한다. 
		
		member4.display();  // ((MemberEvent)member4).display(); : 이렇게 형변환해서 쓰지않아도 자식클래스에서
		//                                                         자동으로 호출된다.
		System.out.println("============================================================");
		
		// 정리 : 형변환으로 부모로 참조를 할 수 있게 하면 모든 자식을 사용할 수 있다
		
		
		
	}

}





















































