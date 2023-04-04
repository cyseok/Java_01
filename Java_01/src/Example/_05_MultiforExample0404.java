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
		
		for (int i = 5; i >= 1; i--) {
			for (int j =1; j <= (5-i); j++) {
				System.out.print("☆");
			} for (int j= 1; j <= i; j++) {
				System.out.print("★");
			} System.out.println();
		} 
		System.out.println("=========================");
		
		for (int i = 1; i <= 5; i++) {
			for (int j =1; j <= 5; j++) {
				if (i >j) { System.out.print("☆");
					
				} else { System.out.print("★");
				
				}
				} System.out.println();
				
		} 
		
		
		
		// ★★★★★
		// ☆★★★★
		// ☆☆★★★
		// ☆☆☆★★
		// ☆☆☆☆★

		System.out.println("===============================================================");
		
		for (int i = 1; i <= 9; i+=2) {
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			} System.out.println();
		}
		
		System.out.println("=======================");
		
		for ( int i =1; i <= 5; i++) {
			for (int j = 1; j <= i*2-1; j++) {
				System.out.print("★");
			} System.out.println();
		}
		// ★
		// ★★★
		// ★★★★★
		// ★★★★★★★
		// ★★★★★★★★★

	
	
		System.out.println("===============================================================");
		
		for (int i = 1; i <= 5; i++) {
			for (int j =1; j <= 5; j++) {
				if (i ==j || i + j ==6) { 
					System.out.print("★");
				} else {
					System.out.print("☆");
				}
			} System.out.println();
				
		} 
		 // 행열이 같을 때 검은별 출력 or 행과 열을 더했을때 6일떄 검은별
		// ★☆☆☆★ i = 1
		// ☆★☆★☆ i = 2
		// ☆☆★☆☆ i = 3
		// ☆★☆★☆ i = 4
		// ★☆☆☆★ i = 5

		System.out.println("===============================================================");
		
	}

}
