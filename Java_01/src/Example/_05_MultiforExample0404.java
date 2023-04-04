package Example;

public class _05_MultiforExample0404 {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("★");
			} System.out.println();
		}
		// ★★★★★
		// ★★★★
		// ★★★
		// ★★
		// ★

		System.out.println("===============================================================");
		
		for (int i = 1; i <= 5; i++) {
			for (int j =1; j <= (5-i); j++) {
				System.out.print("★");
			} for (int j= 1; j <= i; j++) {
				System.out.print("☆");
			} System.out.println();
		} 
		// ★★★★★
		// ☆★★★★
		// ☆☆★★★
		// ☆☆☆★★
		// ☆☆☆☆★

		System.out.println("===============================================================");
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			} System.out.println();
		}
		// ★
		// ★★★
		// ★★★★★
		// ★★★★★★★
		// ★★★★★★★★★

		System.out.println("===============================================================");
		// ★☆☆☆★
		// ☆★☆★☆
		// ☆☆★☆☆
		// ☆★☆★☆
		// ★☆☆☆★

		System.out.println("===============================================================");
	}

}
