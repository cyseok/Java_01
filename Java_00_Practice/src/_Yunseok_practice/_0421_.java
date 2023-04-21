package _Yunseok_practice;

import java.util.Scanner;

public class _0421_ {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int number = scanner.nextInt();
		
		System.out.print("년 월일) 2000-04");
	
		scanner.close();
		
		int[] separation = new int[6]; 

		
		
		
		
		
		
		
		// 생년월일을 저장하기 위한 변수 -> 입력받은 주민번호를 분리하여 저장
		String birthday = "";
		if(separation.equals("1") || separation.equals("2")) { //20세기(1900) 출생
			birthday += 19;
		} else if (separation.equals("3") || separation.equals("4")) { // 21세기 (2000)
			birthday += 20;
		}

		
		
		// 성별저장 
		String gender = "";
		if(separation.equals("1") || separation.equals("3")) { 
			gender = "남자";
		} else if (separation.equals("2") || separation.equals("4")) {
			gender = "여자";
		}
		System.out.println("생년월일 = "  + birthday + ", 성별 = " + gender);
		
	}
}
