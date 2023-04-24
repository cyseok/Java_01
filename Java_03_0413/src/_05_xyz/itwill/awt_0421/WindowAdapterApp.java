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
		
		/// addWindowListener(new WindowEventHandleTwo());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new WindowAdapterApp("윈도우이벤트");
		
	}
	
	// ★ Adapter클래스를 상속받은 자식클래스는 필요한 메소드만 오버라이드 선언하면된다.
	// Adapter클래스 : Listener 인터페이스 중 추상메소드가 2개이상 선언된경우 listener 인터페이스 대신
	//                이벤트 처리를 위해 제공되는 클래스
	
	
	/*
	public class WindowEventHandleTwo extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	*/
	
	/* 바로 위 처럼 작성하는 것 대신에 Annonynous로
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
	});
	이렇게 작성해도 됨. */

}
