package Example;

import java.util.Scanner;

//컴퓨터로부터 제공받은 정수 난수값을 키보드로 입력하여 맞추는 프로그램을 작성하세요.
//=> 1~100 범위의 정수 난수값을 제공받도록 작성
//=> 난수값을 맞출 수 있는 기회는 10번만 제공되도록 작성
//=> 키보드 입력값이 1~100 범위가 아닌 경우 메세지 출력 후 재입력
//=> 난수값과 입력값이 같은 경우 입력 횟수 출력 후 프로그램 종료
//=> 난수값과 입력값이 다른 경우 "큰값 입력" 또는 "작은값 입력" 형식의 메세지 출력
//=> 난수값을 10번 안에 맞추지 못한 경우 난수값이 출력되도록 작성

public class _09_UpAndDownExample_0404 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int random = (int)(Math.random()*100)+1;
		
		// 정답상태를 저장하기 위한 변수
		// false : 불일치, true : 일치
		
		// 난수값을 입력받아 맞추는 기회 10번제공
		for (int i =1; i <=10; i++) {
			
			// 사용자로부터 정수값을 입력받아 변수에 저장
			// => 비정상적인 값이 입력된경우 에러메시지 출력
			 int input;
			 
			 while(true) {
				 System.out.print(i + "번째 시도, 1~100 정수값입력 -> ");
				 
				 input = scanner.nextInt();
				 
				 if(input >= 1 && input <= 100) break;
				 System.out.println("[error] 1~100정수값으로 입력해주세요");
			 }  System.out.println((int)(Math.random()*100)+1);
			
			// 난수값과 입력값을 비교하려 결과 출력
			 if (random == input) {
				 System.out.println("[일치]" + i + "번시도"); break;
			 } else {
				 System.out.println("[불일치]" + i + "번시도");
			 }
		} System.out.println("종료");
		
		
		scanner.close();
		
		
		
		
		
		
	
			
		

	}

}
