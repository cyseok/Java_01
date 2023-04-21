package _05_xyz.itwill.awt_0421;

import java.awt.Frame;

// CUI(Character User Interface) : 문자 중심의 실행 환경에서 동작되는 프로그램
// GUI(Graphic User Interface) : 그래픽 중심의 실행 환경에서 동작되는 프로그램
// => 컴퍼넌트를 이용하여 작성

// java.awt 패키지 : GUI 프로그램을 작성하기 위한 클래스가 선언된 패키지
// => 운영체제(OS)에 종속된 컴퍼넌트 제공
// javax.swing 패키지 : GUI 프로그램을 작성하기 위한 클래스가 선언된 패키지
// => java.awt 패키지의 확장 패키지 -> java 컴퍼넌트 제공

// 컴퍼넌트(component) : GUI프로그램에서 UI(사용자환경)를 구현하기 위한 클래스
// => Button, List, Label, Canvas, Checkbox, Choice, Scrollbar, TextField, TextArea 등
// 컨테이너(Container) : 컴퍼넌트를 배치할 수 있는 컴퍼넌트
// => 독립적 컨테이너 : Frame, Window, Dialog 등
// => 종속적 컨테이너 : Panel, ScrollPane 등 -> 다른 컨테이너에 배치해 사용해야 한다.


public class FrameOneApp {
	public static void main(String[] args) {
		// Frame : 메뉴가 존재하는 컨테이너를 생성하는 클래스
		// 제목 생성
		Frame frame = new Frame("연습장");
		
		//component.setSize(int width, int height) :  컴퍼넌트의 크기를 변경하는 메소드
		// => GUI프로그램에서 크기 또는 위치의 단위는 픽셀
		// 픽셀 : 하나의 색으로 표현하는 점
		frame.setSize(400, 300);
		
		// component.setSize(int width, int height) : 컴퍼넌트의 출력위치를 변경하는 메소드
		frame.setLocation(0, 0);
		
		// component.setVisible(boolean) : 컴퍼넌트를 보이거나 보이지않게 처리하는 메소드
		// => true : 보임, false : 안보임(메모리상에서만 존재)
		frame.setVisible(true);
		
		
		
		
		
	}
	

}




