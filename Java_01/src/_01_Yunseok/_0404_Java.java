package _01_Yunseok;

public class _0404_Java {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 3; j <= 8; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("========================================");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= (5 - i); j++) {
				System.out.print("☆");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("========================================");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= (5 - i); j++) {
				System.out.print("☆");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("========================================");
		
		int cnt = 0, gae = 1;// cnt : 접는 횟수, gae : 사각형 모양의 갯수

		while (gae < 500) {
			cnt++;
			gae *= 2; } System.out.println(cnt + "번 " + gae + "개");
			
		

	}

}
