package _07_xyz.itwill.access;

public class PublicMemberUse {
	public void run () {
		PublicMember member = new PublicMember();
		
		member.num = 100;
		member.display();
	}

}
