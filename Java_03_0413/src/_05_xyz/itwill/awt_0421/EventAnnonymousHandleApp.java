package _05_xyz.itwill.awt_0421;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import _05_xyz.itwill.awt_0421.EventInnerHandleApp.EventHandle;

// 이벤트 처리 클래스를 익명의 내부클래스로 작성

public class EventAnnonymousHandleApp extends Frame {
	
	private static final long serialVersionUID = 1L;
	
	public EventAnnonymousHandleApp (String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit = new Button("Exit");  // 이벤트 소스
		exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(exit);
		
		// 외부클래스의 메소드에서는 내부클래스로 객체 생성 가능
		exit.addActionListener(new ActionListener() {
			
			// 이벤트 처리 객체를 익명의 내부 클래스를 사용하여 생성
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new EventAnnonymousHandleApp("이벤트처리");
	}

	

}
































