package Basic;

// 2차원 배열 : 1차원 배열(요소의 모임)의 모임

public class _20_DoubleArrayApp_0404 {
	public static void main(String[] args) {
		// 형식 : 자료형[][] 참조변수 = new 자료형 [행 갯수][열갯수]
		// => 행의 갯수 : 2차원 배열에 생성되는 1차원 배열의 갯수    
		// => 열갯수 : 1차원 배열에 생성되는 요소의 갯수
		
		// 모든 요소는 
		int[][] num = new int[2][3];
		System.out.println("num = " + num);
		System.out.println("num[0] = " + num[0]);
		System.out.println("num[1] = " + num[1]);
		
		System.out.println("num[1][2] = " + num[1][2]);
		System.out.println("num[0][1] = " + num[0][1]);
		System.out.println("num[1][0] = " + num[1][0]);
		
		System.out.println("num.length = " + num.length);
		System.out.println("num[0].length = " + num[0].length);
		System.out.println("num[1].length = " + num[1].length);
		System.out.println("============================================================");
		
		for (int i = 0; i < num.length; i++) { // 1차원 배열을 일괄처리 하기 위한 반복문 -> 행
			for (int j = 0; j < num[1].length; j++) { // 요소를 일괄처리 하기 위한 반복문 -> 열
				System.out.print(num[i][j] + "\t");
				
			}
		}
		System.out.println("\n============================================================");
		// int [][] su = new int[][] {{10,20,30},{40,50,60},{70,80,90}};
		int [][] su = {{10,20,30},{40,50,60},{70,80,90}}; 
		// {} 안의최대 숫자 = 3행   /   {}갯수 = 3열
		
		for (int [] array : su) {
			for (int temp : array) {
				System.out.print(temp + "\t");
			}
			System.out.println();
		}
		System.out.println("============================================================");
		
		
	}

}
