package _03_Inheritance_0410;

public class MemberApp {
	
	public static void main(String[] args) {
		
		Member member1 = new Member();
		
		member1.setId("abc123");
		member1.setName("홍길동");
		
		member1.display();
		System.out.println("===================================");
		
		Member member2 = new Member("zxc789", "임꺽정");
		member2.display();
		System.out.println("===================================");
		
		
		
	
	}
	

}
