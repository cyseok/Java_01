package nested_0412;

import nested_0412.OuterTwo.InnerTwo;

public class OuterTwoApp {
	public static void main(String[] args) {
		OuterTwo outerTwo = new OuterTwo(100);
		
		outerTwo.outerDisplay();
		System.out.println("=======================================");
		
		// 정적 내부클래스의 생성자를 호출하여 객체 생성이 가능하다.
		// └-> 객체 내부클래스와의 차이가있다.
		InnerTwo innerTwo = new InnerTwo(200);
		
		innerTwo.innerDisplay();
		System.out.println("=======================================");
		
		
		
		
	}

}





















