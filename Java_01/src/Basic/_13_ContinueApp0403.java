package Basic;

//continue : 반복문에서 명령을 처음부터 다시 실행하기 위해 사용하는 제어문

//=> 반복문에서 continue 명령 하단에 작성된 명령을 실행하지 않고 처음부터 다시 실행할 경우 사용

public class _13_ContinueApp0403 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			if (i == 3)
				continue;
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println("==============================================================");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j == 3)
					continue;// for(int j=1;j<=5;j++) 반복문 재실행
				System.out.println("i = " + i + ", j = " + j);
			}
		}
		System.out.println("==============================================================");
		
		// for문 앞에 라벨을 만들어 그 라벨만 종료시킬 수 있다.
		loop: for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j == 3)
					continue loop;// for(int i=1;i<=5;i++) 반복문 재실행
				System.out.println("i = " + i + ", j = " + j);
			}
		}
		System.out.println("==============================================================");
	}

}
