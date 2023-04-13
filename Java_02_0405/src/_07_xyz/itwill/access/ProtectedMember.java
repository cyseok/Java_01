package _07_xyz.itwill.access;

// Protected 접근 제한자 : 같은 패키지의 클래스에서 접근 가능하도록 설정
// => 다른 패키지의 클래스에서 접근 불가능
// => 다른 패키지의 클래스에서 protected 접근 제한자의 필드 또는 메소드의 클래스를
//    상속 받은 경우 접근이 가능하다.

public class ProtectedMember {
	
	protected int num;
	
	protected void display () {
		
		System.out.println("num = " + num);
		
	
		
	}

}
