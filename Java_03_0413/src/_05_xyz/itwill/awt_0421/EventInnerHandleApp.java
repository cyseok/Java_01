package _05_xyz.itwill.awt_0421;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//[Exit] 버튼으로 종료하는 기능

// => 이벤트 처리 클래스를 디자인 클래스의 내부클래스로 작성
// => 내부클래스(이벤트처리클래스)를 외부클래스(디자인클래스)의 내부클래스로 작성
//=> 이벤트 처리 메소드에서 디자인 클래스의 컴퍼넌트 사용 가능
public class EventInnerHandleApp extends Frame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	public  EventInnerHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit = new Button("Exit");  // 이벤트 소스
		exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(exit);
		
		// 외부클래스의 메소드에서는 내부클래스로 객체 생성 가능
		exit.addActionListener(new EventHandle());
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new EventSourceHandleApp("이벤트처리");
	}

	public class EventHandle implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		// TODO Auto-generated method stub
		
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
