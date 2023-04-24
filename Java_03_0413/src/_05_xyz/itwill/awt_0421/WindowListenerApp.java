package _05_xyz.itwill.awt_0421;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// Frame에서는 WindowEvent 발생
// => WindowListener 인터페이스를 상속받은 자식클래스를 사용하여 이벤트처리

public class WindowListenerApp extends Frame{
	
	private static final long serialVersionUID = 1L;
	
	public WindowListenerApp(String title) {
		super(title);
		
		// 프레임에서 windowevent가 발생될 경우 이벤트 처리 할 객체를 등록
		addWindowListener(new WindowEventHandleOne());
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new WindowListenerApp("윈도우이벤트");
		
	}
	
	// Listener 인터페이스를 상속받은 자식클래스(이벤트처리클래스)는 무조건 인터페이스의 모든 추상메소드 오버라이드 선언
	//=> 불필요한 추상메소드까지 오버라이드 선언되어 버린다.
	// 정리 :불필요하지만 모든 메소드를 오버라이드 해야한다.
	public class WindowEventHandleOne implements WindowListener {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// System.out.println("windowOpened 메소드 호출");
		}
		@Override
		public void windowClosed(WindowEvent e) {
			// System.out.println("windowClosed 메소드 호출");
			
		}
		@Override
		public void windowClosing(WindowEvent e) {
			// System.out.println("windowClosing 메소드 호출");
			System.exit(0);
			
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
			// System.out.println("windowDeactivated 메소드 호출");
			
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
			// System.out.println("windowDeiconified 메소드 호출");
			
		}
		@Override
		public void windowIconified(WindowEvent e) {
			// System.out.println("windowIconified 메소드 호출");
			
		}
		@Override
		public void windowActivated(WindowEvent e) {
			// System.out.println("windowActivated 메소드 호출");
			
		}
		
		
	}

	
}
