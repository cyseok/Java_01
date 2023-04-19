package _04_xyz.itwill.utill_0419;

import java.util.Random;

// Java.utill 패키지 : 프로그램 작성에 유용한 기능을 제공하는 클래스가 선언된 패키지

// Scanner 클래스 : 값을 입력 받는 메소드를 제공하는 클래스
// Array 클래스 : 배열의 요소를 처리하기 위한 메소드를 제공하는 클래스

// Random 클래스 : 난수값 메소드 제공

public class RandomApp {
	public static void main(String[] args) {
		Random random = new Random();
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 난수 값 -> " + random.nextInt(45));
			
			
			
		}
		
	}

}









































