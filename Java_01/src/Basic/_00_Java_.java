package Basic;

public class _00_Java_ {
	public static void main(String[] args) {
		
//0404
		for (int i = 1; i <= 9; i++) {
			for (int j = 3; j <= 8; j++) {
				System.out.print("★");
			} System.out.println();
		} 
		System.out.println("========================================");
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= (5-i); j++) {
				System.out.print("☆");
			} for (int j = 1; j <= i; j++) {
				System.out.print("★");
			} System.out.println();
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
		
	}

}
