package _07_xyz.itwill.app;

import java.util.Date;
import java.util.Scanner;

// 키보드로 이름과 태어난 년도를 입력받아 나이를 계산하여 이름과 나이를 출력
// ex) 이름 입력 -> 홍길동
//     태어난 년도 -> 2000
//     [결과] 홍길동님의 나이는 24살입니다.
public class CalcAgeApp {
	public static void main(String[] args) {
		
		//Scanner 클래스로 객체를 생성하여 참조변수에 저장
		Scanner scanner = new Scanner(System.in);
		
		// 키보드를 이용하여 사용자로부터 이름과 태어난 년도를 입력받아 변수에 저장
		System.out.print("이름 입력 -> ");
		String name = scanner.nextLine();
		
		System.out.print("태어난 년도 -> ");
		int birthYear = scanner.nextInt();
		
		// java.util.Date 클래스로 객체를 생성하여 참조변수에 저장
		// Date 클래스 : 날짜와 시간정보를 저장하기 위한 클래스
		// Date 클래스의 기본생성자를 사용하여 객체를 생성하면 시스템(운영체제)의
		//    현재 날짜와 시간이 Date 객체에 자동으로 저장된다.
		Date now = new Date();
		
		// Date.getYear() : Date 객체에 저장된 날짜와 시간에서 년도를 정수값으로 반환하는 메소드
		// => 1900년을 기준으로 1년에 1씩 증가된 년도값이 반환된다.
		// => @Deprecated 어노테이션이 적용된 메소드
		// Deprecatrd 어노테이션 : 메소드 사용을 권장하지 않도록 설정하는 어노테이션
		// @Deprecated 어노테이션이 적용된 메소드를 호출할 경우 경고발생
		//@SuppressWarnings 어노테이션 : 경고메시지를 제거하는 어노테이션
		// => value 속성을 사용하여 경고관련 속성값을 설정
		// => value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능
				
		// @SuppressWarnings(value = "deprecation")
		@SuppressWarnings("deprecation")
		int currentYear = now.getYear() + 1900;
		
		
		// int age = 2023 - birthYear + 1;
		int age = currentYear - birthYear + 1;
		
		System.out.println("[결과]" + name + "님의 나이는 " + age + "살입니다.");
		
		scanner.close();
		
		
	}

}

























