package xyz.itwill.exception_0414;

import java.util.InputMismatchException;
import java.util.Scanner;

// 키보드로 정수값을 입력받아 저장된 비밀번호와 비교하여 비교결과 출력

public class PasswordMatchApp {
	public static void main(String[] args) {
		/*
		int password = 123456;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("비밀번호 입력 -> ");
		int number = scanner.nextInt();
		
		if (number == password) {
			System.out.println("같습니다.");
		} else {
			System.out.println("다릅니다.");
		}
		scanner.close();
		*/
		
		int password = 123456;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
		System.out.print("비밀번호 입력 -> ");
		int number = scanner.nextInt();
		
		if(number != password) {
			// 인위적으로 예외 객체를 생성하여 예외를 발생시키는 방법
			// 형식 : throw new 예외클래스 (String message);
			//                    (└-> 예외클래스의 생성자를 가리킴) 
			
			// throw new Exception();
			
			
			// ★★ if문이 너무많이 발생하게 되서 예외를 일부로 발생시킨 후
			//  그 예외들을 처리하면서 결과들을 출력해준다.
		throw new PasswordMismatchException("결과, 비빌번호가 틀립니다.");
		}
		// 예외가 발생되지 않은 경우 실행될 명령
		System.out.println("맞습니다.");
		
		} catch (InputMismatchException e) {
			System.out.println("에러, 숫자만 입력가능합니다.");
		} catch (PasswordMismatchException e) {	
			System.out.println(e.getMessage());
			
		} catch (Exception e) {
			System.out.println("이상한 에러");
		} finally {
			scanner.close();  // finally 생성 후 그 안쪽에 실행시켜준다.
		}
	}

}







































