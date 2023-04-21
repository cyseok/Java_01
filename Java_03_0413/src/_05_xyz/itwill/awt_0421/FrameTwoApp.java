package _05_xyz.itwill.awt_0421;

import java.awt.Button;
import java.awt.Frame;


// GUI 프로그램 UI 구성 및 이벤트 처리를 위해 Frame 클래스를 상속받아 작성하는 것을 권장
public class FrameTwoApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	
	// 생성자에서 프레임을 구정하는 디자인을 설정
	public FrameTwoApp(String title) {  // 생성자를 이용하여 프레임 객체 생성
		super(title);
		
		Button button = new Button("버튼");
		
		// setTitle(title);  -> 프레임의 제목을 변경하는 메소드
		
		// setBounds(int x, int y, int width, int height) : 컴퍼넌트의 출력위치와 크기를 변경하는 메소드
		setBounds(600, 100, 400,300);
		
		
		// component.setResizable(boolean resizable) : 프레임의 크기 변경 여부를 설정
		// false : 변경 불가능, true : 변경 가능(기본값)
		// setResizable(false);
		
		setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new FrameTwoApp("연습장");
		
	}
	

}
