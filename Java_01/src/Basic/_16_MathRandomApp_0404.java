package Basic;

// 난수값 : 컴퓨터로 부터 불규칙적으로 제공되는 숫자값
// 컴퓨터로부터 난수값을 제공받아 출력하는 프로그램

public class _16_MathRandomApp_0404 {
	public static void main(String[] args) {
		
		// Math class : 수학관련 기능 제공 클래스
		// Math.random() : 0.0보다 크거나같고 1.0보다 작은 실수 난수값을 반환하는 메소드
		
		for (int i=1; i<=5; i++) {
			System.out.println(i + "번째 실수 난수값 = " + Math.random());
		}
		System.out.println("======================================================");
		
		// int(Math.random()*100) -> 0 <= 난수값 < 100    -> 0~99
		for (int i=1; i<=5; i++) {
			System.out.println(i + "번째 정수 난수값 = " + ((int)(Math.random()*45)+1));
		}
		System.out.println("======================================================");
		
		
	}

}
