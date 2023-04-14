package xyz.itwill.lang_0414;

import java.util.Scanner;

// Java API(Application Prigramming Interface) : 
//          Java 프로그램 개발에 프로그램 기능을 제공 하기 위한 도구
// => 라이브러리를 이용하여 배포된 Java 자료형(클래스, 인터페이스, 열거형)
// API문서를 활용하여 Java 자료형에 대한 설명을 제공받아 사용
// => 온라인 API 문저 : https://docs.oracle.com/en/java/javase//docs/api/index.html


// Java.lang 패키지 : Java 프로그램 개발에 필요한 기본 자료형을 제공하는 패키지
// => Java.lang 패키지의 자료형은 import 처리를 하지 않아도 접근 가능

// Object 클래스 : 모든 Java 클래스가 반드시 상속받는 부모클래스
// => 모든 Java 클래스를 대신하여 사용할 수 있는 대표클래스
// Math 클래스 : 수학관련 기능을 메소드로 제공하는 클래스
// Class 클래스 : 메모리에 저장된 클래스 관련 정보를 저장하기 위한 클래스
// └-> 클래스 객체


// System 클래스 : 표준 입출력 스트림을 제공하거나 시스템관련 기능을 메소드로 제공하는 클래스
//                  └->System.in, System.out


public class SystemApp {
	public static void main(String[] args) {
		// System.in : Java에서 제공되는 표준 입력장치(키보드)에 대한 입력 스트림(객체)이 저장
		Scanner scanner = new Scanner(System.in);
		
		// System.out : Java에서 제공되는 표준 출력장치(모니터)에 대한 출력 스트림(객체)이 저장
		System.out.print("정수값 입력 -> ");
		
		int num = scanner.nextInt();
		
		if (num == 0) {
			System.out.println("[메시지]프로그램을 강제로 종료합니다");
			// System.exit(int status); : 프로그램을 강제로 종료하는 메소드
			System.exit(0);
		}
		
		// System.currentTimeMillis() : 시스템의 현재날짜와 시간에 대한 타임스템프를 반환하는 메소드
		// 타임스탬프 : 날짜와 시간을 정수값으로 표현하기 위해 만들어진 시간 값
		// => 1970년 1월 1일을 기준으로 1/1000초(1ms)당 1씩 증가된 정수값
		// => 날짜와 시간을 정수값으로 표현하여 연산하기 위해 사용
		long startTime = System.currentTimeMillis();
		
		for(int i = 1; i <= num; i++) {
			System.out.println(i + "번째 명령");
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("실행시간 = " + (endTime - startTime) + "ms");
		
		// System.gc() : 메모리를 청소하는 프로그램(Garbage Collector)을 실행하는 메소드
		
		scanner.close();
		
	}

}









































