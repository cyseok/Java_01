package Basic;

//제어문(Control Statement) : 프로그램의 흐름(스레드 - Thread)을 바꾸어 주는 명령
//=> 선택문(if, switch), 반복문(for, while), 기타(break, continue, return)

//if : 조건식에 의해 명령을 선택 실행

//형식-1) if(조건식) { 명령; 명령; ... }
//=> 조건식의 결과가 참(true)인 경우 블럭({}) 내부에 작성된 명령들을 실행
//=> 블럭 내부에 명령이 하나만 작성된 경우 블럭({}) 기호 생략 가능

//형식-2) if(조건식) { 명령; 명령; ... } else { 명령; 명령; ... }
//=> 조건식의 결과가 참(true)인 경우와 거짓(false)인 경우를 구분하여 블럭 내부에 작성된 명령들을 실행

//형식-3) if(조건식) { 명령; 명령; ... } else if(조건식) { 명령; 명령; ... }
//			else if(조건식) { 명령; 명령; ... } else { 명령; 명령; ... }
//=> 조건식이 여러 개인 경우 명령을 구문하여 블럭 내부에 작성된 명령 실행
//=> 마지막 else에 작성된 명령은 모든 조건식이 거짓인 경우 실행 - else 생략 가능 

//프로그램의 흐름을 파악하기 위한 이클립스 기능 - Debug Perspective 사용
//=> 중지점(BreakPoint) 설정 - [F11] : Debug 기능 실행 단축키 - Debug Perspective 변환
// - [F6] : 현재 스레드 위치의 명령을 하나씩 실행 >> 반복 - Debug 처리 완료 
// - 프로그램 강제 종료(Terminate : Ctrl + F2) - Java Perspective 변환 - 중지점 제거

public class _08_IfApp_0331 {
	public static void main(String[] args) {
int num = 12;
		
		if (num >= 80) {
		System.out.println("점수는 " + num + "이고, 80점이상인 A입니다.");
		
		} else if (60 <= num ) {
		System.out.println("점수는 " + num + "이고, 60점이상 80점미만인 B입니다.");
		
		} else if (40 <= num) {
			
		System.out.println("점수는 " + num + "이고, 40점이상 60점미만인 C입니다.");
		}
		else {
			System.out.println("점수는 " + num + "이고, 40점미만인 불합격입니다.");
		}
		System.out.println("===============================================");
		
		if (num % 2 != 0) {
			System.out.println(num + " = 홀수");
		}
		else {
		System.out.println(num + " = 짝수");
		}
		System.out.println("===============================================");
		
		
		
		char munja = 'a';
		//char munjaa = '0';
		// System.out.println(munja + "\n" + munja1);
	
		
		if (munja >= 'A' && munja <= 'z' || munja >= 'a' && munja <= 'z') {
			System.out.println("[결과] " + munja + " = 영문자");
		}
		else {
		System.out.println("[결과] " + munja + " = 비영문자");
		}
		System.out.println("===============================================");
		
		
		// true, flase는 boolean으로도 사용가능하다.
		boolean sw = true;
		
		if (sw) {
			System.out.println("현재 변수값은 [참]입니다.");
		} else {
			System.out.println("현재 변수값은 [거짓]입니다.");
		}
		System.out.println("===============================================");
		
		
		
		boolean sw1 = true;
		
		if (!sw1) {
			System.out.println("현재 변수값은 [참]입니다.");
		} else {
			System.out.println("현재 변수값은 [거짓]입니다.");
		}
		
		System.out.println("===============================================");
		
		
		//변수값이 0~100 범위의 유효값인지 구분하는 출력
		int jumsu = 95;
		
		if (0 <= jumsu && jumsu <= 100) {
			System.out.println("[0~100]범위의 정상적인 점수입니다.");
		} else {
			System.out.println("[0~100]범위를 벗어난 비정상적인 점수입니다.");
		}
		
		System.out.println("===============================================");
		
		/*변수값으로 등급 구분
	 	100 ~ 90 : A / 89 ~ 80 : B / 79 ~ 70 : C / 69 ~ 60 : D / 59 ~ 0 : F */
		String grade;
		if (90 <= jumsu &&  100 >= jumsu ) {
			// System.out.println("grade = " + "\"" + "A" + "\"");
			grade = "A";
			
		} else if (89 >= jumsu && 80 <= jumsu) {
			grade = "B";
			
		} else if (79 >= jumsu && 70 <= jumsu) {
			grade = "C";
			
		} else if (69 >= jumsu && 60 <= jumsu) {
			grade = "D";
		}
		else  {
			grade = "f";
			} 
		System.out.println(jumsu + "점이고, " + grade + "학점입니다.");
	//프로그램 흐름 보기위한 debug perspectivbe 사용
		// breakpoint 설정 = [F11] debug실행단축키 -> [F6] (현재 스레드위치의 명령 하나씩 실행)
		// 실행 후 프로그램강제 종료(Terminate : Ctrl + F2) -> java perspective 변환 -> 중지점제거
	}

}
