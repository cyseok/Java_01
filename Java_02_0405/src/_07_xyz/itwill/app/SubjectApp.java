package _07_xyz.itwill.app;



import _07_xyz.itwill.subject.JavaSubject;
import _07_xyz.itwill.subject.OracleSubject;

// import 자료형의 이름이 같은 경우 사용불가

public class SubjectApp {
	public static void main(String[] args) {
		
		// 같은 패키지에 작성된 클래스는 패키지 경로 없이 클래스만 사용하여 접근 가능
		// 다른 패키지에 작성된 클래스는 반드시 패키지 경로를 표현해야만 클래스 접근 가능
		// => 형식 : 패키지경로.클래스명
		// xyz.itwill.subject_0413.OracleSubject = new xyz.itwill.subject_0413.OracleSubject();
		
		// 다른 패키지에 작성된 클래스를 import처리한 경우 패키지 경로 표현없이 클래스 접근 가능
		OracleSubject subject1 = new OracleSubject();
		
		subject1.display();
		
		JavaSubject subject2 = new JavaSubject();
		subject2.display();
		
		_07_xyz.uniwill.subject.JavaSubject subject3 = new _07_xyz.uniwill.subject.JavaSubject();
		subject3.display();
	}

}






























