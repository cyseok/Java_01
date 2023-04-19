package _04_xyz.itwill.utill_0419;

import java.util.Random;
import java.util.Scanner;

// 숫자야구 게임 : 0~9범위의 정수 3개를 제공받아 맞추는 게임
// 조건
// - 서로다른 3개의 정수 출력, 0으로 시작 불가
// - 숫자와 위치가 같으면 스트라이크, 다르면 볼
// - 15번 기회 제공, 끝난경우 난수값 출력
public class BaseballGameApp {
	public static void main(String[] args) {
		 Random random = new Random();
		 
		 // 3개의 정수난수값 저장 배열
		 int[] dap = new int[3];
		 
		 // 규칙에 맞는 값이 배열에 저장되도록 하기 위한 반복문
		 while (true) {
			 for(int i =0; i < dap.length; i++) {
				 dap[i] = random.nextInt(10);
			 }
			 // 첫번째가 0이 아니고 중복이 없는 조건
			 if(dap[0] != 0 && dap[0] != dap[1] && dap[1] != dap[2] && dap[2] != dap[0]) break;
		 }
		 
		 Scanner scanner = new Scanner(System.in);
		 
		 int[] num = new int[3];  // 입력값을 저장하기 위한 배열
		 
		 boolean result = false;
		 // => false : 정답을 못맞춘 경우, true : 정답인경우
		 
		 for(int cnt = 1; cnt <= 10; cnt++) {
			 int strike = 0, ball = 0;
			 
			 loop: while(true) {
				 System.out.print(cnt + "번째 입력 -> ");
				 String input = scanner.nextLine();
				 
				 if(input.length() != 3) {  // 비정상적인 값인 경우
					 System.out.println("3자리 숫자 입력바람");
					 
					 continue;  // while로 올라가서 다시 실행한다.
				 }
				 
				 // 문자를 추출하여 배열요소에 저장
				 for(int i = 0; i < num.length; i++) {
					 // 문자코드(Character Code) : 0 -> 48,  9 -> 57
					 //ex) '4' - '0' = 52 - 48 = 4
					 // 정리 :  숫자값에 있는 코드에서 0 숫자값의 코드를 빼준다 => 문자값을 정수값으로
					 num[i] = input.charAt(i) - '0';
					 
					 if(num[i] < 0 || num[i] > 9) {
						 System.out.println("지정범위 숫자만 입력가능");
						 continue loop;
					 }
				 }
				 
				 if (num[0] != 0 && num[0] != num[1] && num[1] != num[2] && num[2] != num[0]) break;
				 System.out.println("0으로 시작되거나 중복된 숫자가 있습니다.");
				 
			 }
			 
			// 배열의 요소값과 입력값이 저장된 배열의 요소값을 교차비교
			 for(int i = 0; i < dap.length; i++) {  // 난수값이 배열요소를 처리하기 위한 반복문
				 for(int j = 0; j < num.length; j++) {   // 입력값이 저장된 배열요소를 처리하기 위한 반복문
					 if(dap[i] == num[j]) {   // 요소값이 같은 경우
						 if(i == j) {   // 요소값이 저장된 위치가 같은경우
							 strike++;
						 } else {
							 ball++;
						 }
					 }
					  
				 }
			 }
			 
			 // 처리결과 출력
			 if(strike == 3) {
				 System.out.println("정답입니다. " + cnt + "번 시도");
				 break;
			 } 
			 System.out.println("결과 : " + strike + "스트라이크" + ball + "볼");
			 
		 }
		 if(!result) {
			 System.out.println("정답을 맞추지 못했습니다. 정답은 ");
			 
			 for (int su : num) {
				 System.out.print(su);
			 }
			 System.out.println("입니다.");
		 }
		 scanner.close();
		 
	}

}









































