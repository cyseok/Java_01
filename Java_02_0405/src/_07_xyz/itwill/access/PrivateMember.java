package _07_xyz.itwill.access;

// 접근 제한차(Access Modifier) : 클래스, 필드, 메소드에 대한 접근 설정을 위한 키워드
// => private, package(default), protected, public

// private : 클래스 내부에서만 접근 가능하며 클래스 외부에서는 접근이 불가능하다.

public class PrivateMember {
	private int num;
	
	
	@SuppressWarnings("unused")
	private void display () {
		System.out.println("num = " + num);
	}

}
