package _07_xyz.itwill.access_0413;

public class PrivateMemberUse {
	public void run () {
		PrivateMember member = new PrivateMember();
		
		// private 접근 제한자로 설정된 필드와 메소드에 접근할 경우 에러 발생
		// └-> 클래스 내부에서만 접근 가능
		// member.num = 100;
		// member.display();
	}

}
