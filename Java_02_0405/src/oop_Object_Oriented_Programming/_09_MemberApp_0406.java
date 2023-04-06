package oop_Object_Oriented_Programming;

public class _09_MemberApp_0406 {
	
	public static void main(String[] args) {
		
		// new 연산자로 Member 클래스의 매개변수가 없는 기본 생성자를 호출하여 객체 생성
		// => 생성된 객체의 필드에는 기본값이 초기값으로 자동 저장
		// => new연산자로 호출한 생성자가 없는 경우 error 발생 -> 객체 생성 불가능
		_08_Member_0406 member1 = new _08_Member_0406();
		
		// Getter 메소드를 호출하여 Member 객체의 필드값을 반환 받아 출력
		System.out.println("ID = " + member1.getId());
		System.out.println("Name = " + member1.getName());
		System.out.println("E_mail = " + member1.getEmail());
		System.out.println("==========================================");
		
		// Setter 메소드를 호출하여 Membet 메소드의 객체 필드값(현재 null) 변경
		member1.setId("abc123");
		member1.setName("홍길동");
		member1.setEmail("abc123@naver.com");
		
		System.out.println("ID = " + member1.getId());
		System.out.println("Name = " + member1.getName());
		System.out.println("E_mail = " + member1.getEmail());
		System.out.println("==========================================");
		
		member1.setId("abc123");
		member1.setName("홍길동");
		member1.setEmail("abc123@naver.com");
		
		member1.display();
		System.out.println("==========================================");
		
		// 매개변수가 있는 생성자를 호출하여 객체를 생성한 것
		_08_Member_0406 member2 = new _08_Member_0406("agsgad");
		member2.display();
		System.out.println("==========================================");
		
		_08_Member_0406 member3 = new _08_Member_0406("agsgad");
		member3.display();
		
		
	}

}
