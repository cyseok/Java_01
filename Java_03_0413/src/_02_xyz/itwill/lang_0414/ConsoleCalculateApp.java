package _02_xyz.itwill.lang_0414;

import java.util.Scanner;

//키보드로 사칙 연산식을 입력받아 연산결과를 계산하여 출력하는 프로그램 작성
//ex) 연산식 입력 >> 20 + 10
//  [결과]30
//=> 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*,/,+,-)만 허용
//=> 형식에 맞지 않는 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 종료
//=> 입력 연산식에 공백 입력이 가능하도록 처리


//
public class ConsoleCalculateApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("연산식 입력 -> ");
		
		// 공백을 제거
		String operation = scanner.nextLine().replace(" ", "");
		
		// 연산식들을 배열에 저장
		String[] operatorArray = {"*", "/", "+", "-"};
		
		// 연산자의 시작위치(Index) 저장
		int index = -1;  // 연산자의 시작위치를 저장하기 위한변수, 시작위치가 0이기때문에 -1로 선언한다.
		
		for (String operator : operatorArray) {  // 배열의 요소값을 operator에 저장
			index = operation.lastIndexOf(operator);  // operator에 저장된 연산식들을 문자끝부터 검색해 시작위치 반환
			
			if(index != -1) break;  // 연산식에서 연산자가 검색된 경우 반복문 종료
		}
		
			// 연산자가 없거나 잘못된 위치에 있는 경우
			if (index <= 0 || index >= operation.length() -1) {
				System.out.println("연산식 이상");
				System.exit(0);
				
			}
			
			try {
				// 첫번째 피연산자를 분리해 정수로 저장
				int num1 = Integer.parseInt(operation.substring(0, index));
				
				// 연산자를 분리하여 저장
				String operator = operation.substring(index, index + 1);
				
				// 두번째 피연산자 정수로저장
				int num2 = Integer.parseInt(operation.substring(index + 1));
				
				// 연산자를 비교하여 피연산자에 대한 결과저장
				int result = 0;
				switch(operator) {
				case "*" : result = num1 * num2; break;
				case "/" : result = num1 / num2; break;
				case "+" : result = num1 + num2; break;
				case "-" : result = num1 - num2; break;
				}
				
				System.out.println("결과 = " + result);
				
			} catch (NumberFormatException e) {
				System.out.println("숫자가 아닌 값이 입력됨");
			} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("0으로 나눌 수 없습니다.");
			
			} catch (Exception e) {
				System.out.println("에러");
			}
			
	}
				
}
	











































