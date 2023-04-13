package _07_xyz.itwill.other;

import _07_xyz.itwill.access.PublicMember;

public class PublicMemberOtherUse {
	
	public void run () {
		
		PublicMember member = new PublicMember();
		
		member.num = 100;
		member.display();
	}

}
