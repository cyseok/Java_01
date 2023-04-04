package Basic;

import java.util.Scanner;

// 가위바위보 게임 프로그램
// => 사용자가 이길경우 반복실행, 질경우 대결종료
// => 대결종료 후 사용자의 승리 횟수 출력

public class _17_RpaGameApp_0404 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = 0; // 사용자 승리 횟수를 저장하기위한 변수
		
		// 가위바위보 대결(반복)
		while (true) { 
			// 컴퓨터에게 가위바위보중 하나 제공받아 저장
			// => 정수값 : 1은 가위, 2는 바위, 3은 보
			// => 1~3 범위의 정수값을 난수로 제공받아 저장
			
			int computer = (int)(Math.random()*3)+1;
			
			// 사용자에게 가위바위보중 하나 입력받아 저장
			// => 입력값이 1~3범위의 정수값이 아닌경우 에러 후 재입력메시지 호출
			
			int user;
			
			
			
			while(true) {//입력값 검증을 위한 반복문
				
				System.out.print("가위바위보[1:가위,2:바위,3:보] >> ");
				user=scanner.nextInt();
				
				if(user>=1 && user<=3) break;
				//정상적인 값이 입력된 경우 반복문 종료
				System.out.println("[에러]가위,바위,보 중 하나를 선택하여 입력해 주세요.");
				
			} 
			
				
			// 컴퓨터와 사용자의 가위바위보 출력
			System.out.print("[입력] 컴퓨터 -> ");
			switch (computer) {
			case 1 : System.out.print("가위"); break;
			case 2 : System.out.print("바위"); break;
			case 3 : System.out.print("보"); break;
			}
			
			System.out.print(", 사용자 -> ");
			switch(user) {
			case 1 : System.out.print("가위"); break;
			case 2 : System.out.print("바위"); break;
			case 3 : System.out.print("보"); break;
			} System.out.println();
			
			
			if (computer == user) {
				System.out.println("비김");
			} else if (computer == 1 && user == 2 || computer == 2 && user == 3 || computer == 3 && user == 1 ) {
				System.out.println("사용자 승리");
			} else {
				System.out.println("컴퓨터승리");
				break;
		
		} System.out.println();
		
		}
		System.out.println("=====================================");
		// 승리횟수 출력
		if (count == 0) {
			System.out.println("[메시지] 사용자 승리 횟수 \"0\"");
			
		} else {
			System.out.println("[메시지] 사용자 승리 횟수 " + count );
		
		}
		scanner.close();
	}

}
