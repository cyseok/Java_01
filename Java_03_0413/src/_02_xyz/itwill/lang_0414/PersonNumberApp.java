package _02_xyz.itwill.lang_0414;

import java.util.Scanner;

// 키보드로 주민번호를 입력받아 생년월일과 성별을 출력
// 중간에 ' - ' 존재
// => 비정상적 주민번호 입력된 경우 재입력하도록 처리
public class PersonNumberApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 주민번호 저장 변수
		String number;
		// 정상적인 주민번호를 입력받기 위한 반복문 -> 입력값 검증
		
		while(true) {
			System.out.print("주민번호[ex.901212-1234567] -> ");
			
			// 입력받은 문자열에서 앞, 뒤 공백제거
			// number = scanner.nextLine().trim();
			
			// 입력받은 문자열에서 모든 공백제거
			number = scanner.nextLine().replace(" ", "");
			
			// 14자리이고 7번째 자리에 - 가 있다면  (밑에 두개 다 동일)
			// if(number.length() == 14 && number.charAt(6) == '-') break; 
			if(number.length() == 14 && number.indexOf("-") == 6) break; 
			System.out.println("error 형식에 맞게 입력바람");
			
		}
		scanner.close();
		
		// 입력된 주민번호에서 8번째 위치의 문자를 저장
		String separation = number.substring(7,8);
		
		// 생년월일을 저장하기 위한 변수 -> 입력받은 주민번호를 분리하여 저장
		String birthday = "";
		if(separation.equals("1") || separation.equals("2")) { //20세기(1900) 출생
			birthday += 19;
		} else if (separation.equals("3") || separation.equals("4")) { // 21세기 (2000)
			birthday += 20;
		}
		birthday += number.substring(0,2) + "년";
		birthday += number.substring(3,4) + "월";
		birthday += number.substring(4,3) + "일";
		
		
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










































