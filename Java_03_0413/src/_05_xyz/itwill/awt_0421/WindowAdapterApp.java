package _05_xyz.itwill.awt_0421;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



// 프레임의 [닫기] 버튼으로 프로그램을 종료하는 기능
public class WindowAdapterApp extends Frame {
	
	private static final long serialVersionUID = 1L;
	
	public WindowAdapterApp(String title) {
		super(title);
		
		addWindowListener(new WindowEventHandleTwo());
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new WindowAdapterApp("윈도우이벤트");
		
	}
	
	// ★ Adapter클래스를 상속받은 자식클래스는 필요한 메소드만 오버라이드 선언하면된다.
	
	public class WindowEventHandleTwo extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
	}

}
