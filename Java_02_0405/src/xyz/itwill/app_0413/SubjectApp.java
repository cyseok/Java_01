package xyz.itwill.app_0413;


// 패키지(package) : 같은 목적의 자료형(참조형)을 명확하게 구분하여 그룹화 하기 위해 사용
// => Java 참조형 : Class, Interface, Enum(열거형)
// => Java 자료형을 보다 쉽게 관리하기 위해 패키지를 사용한다.
// => 패키지의 이름은 도메인을 역방향으로 나열하고 그룹명을 지정하여 작성하는 것을 권장
// ex) itwill.xyz : 도메인 -> xyz.itwill
// 도메인(Domain) : 인터넷에서 개인 또는 그룹이 사용하기 위한 네트워크 식별자

// 패키지에 작성된 소스파일의 처음 위치에는 소스파일이 작성된 패키지를 반드시 명시
// 형식 : package 패키지경로;
// => Java 자료형이 어떤 패키지에 선언된 자료형인지 명확하게 구분하여 사용해야한다.


import xyz.itwill.subject_0413.OracleSubject;
// import 키워드 : 다른 패키지에 작성된 Java자료형을 명확히 표현하여 접근하기 위한 키워드
// 형식 : import 패키지경로.자료형(자료형대신에 '*'을 쓰게되면 모든자료형을 뜻함)
// => package 키워드로 작성된 명령 하단에 선언하며 자료형 선언 위에 선언되어야함
// => 이클립스에서는 다른패키지에 작성된 자료형을 사용할 경우 import 명령을 자동완성기능 제공 
// 제공 -> Ctrl + Space
// => Ctrl + Shift + o -> import명령을 정리하는 단축키 : 불필요한 자료형에 대한 import설정을
//                         제거하거나 필요한 자료형에 대한 import 설정을 추가해준다.


public class SubjectApp {
	public static void main(String[] args) {
		
		// 같은 패키지에 작성된 클래스는 패키지 경로 없이 클래스만 사용하여 접근 가능
		// 다른 패키지에 작성된 클래스는 반드시 패키지 경로를 표현해야만 클래스 접근 가능
		// => 형식 : 패키지경로.클래스명
		// xyz.itwill.subject_0413.OracleSubject = new xyz.itwill.subject_0413.OracleSubject();
		
		// 다른 패키지에 작성된 클래스를 import처리한 경우 패키지 경로 표현없이 클래스 접근 가능
		OracleSubject subject1 = new OracleSubject();
		
	}

}






























