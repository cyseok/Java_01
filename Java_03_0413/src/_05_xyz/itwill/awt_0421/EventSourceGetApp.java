package _05_xyz.itwill.awt_0421;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 색상버튼을 누르면 캔버스의 색을 변경하는 프로그램
public class EventSourceGetApp extends Frame {
	
	private static final long serialVersionUID = 1L;
	
	// 이벤트 처리 클래스의 메소드에서 사용될 컴퍼넌트 또는 컨터이너는 필드로 선언해야함
	// => 내부클래스의 이벤트 처리메소드에서 필드를 사용하여 이벤트 처리 가능
	Button red, green, blue, white;
	Canvas canvas;
	
	public EventSourceGetApp(String title) {
		super(title);
		
		red = new Button("Red");
		green = new Button("Green");
		blue = new Button("Blue");
		white = new Button("White");
		
		canvas = new Canvas();
		
		// 패널생성
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(1, 4));  // 버튼배치 방식 변경
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(white);
		
		// 패널의 위치를 설정
		add(panel, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		
		// 글자변경
		panel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		
		// 
		
		// Exit 활성화
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		// RedButtonEventHandle 클래스를 이용
		// 컴퍼넌트 마다 이벤트 처리클래스를 다르게 설정
		/*
		 red.addActionListener(new RedButtonEventHandle());
		green.addActionListener(new GreenButtonEventHandle());
		blue.addActionListener(new BlueButtonEventHandle());
		white.addActionListener(new WhiteButtonEventHandle());
		*/
		
		// 컴퍼넌트마다 이벤트를 처리하는 클래스가 동일하다.
		// => 이벤트 처리 메소드에서 이벤트가 발생된 컴퍼넌트를 구분하여 실행될 수 있게 작성해준다.
		red.addActionListener(new ColorButtonHandle());
		green.addActionListener(new ColorButtonHandle());
		blue.addActionListener(new ColorButtonHandle());
		white.addActionListener(new ColorButtonHandle());
		
		setBounds(800, 200, 400, 400);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		new EventSourceGetApp("이벤트처리");
	}
	
	
	/*
	public class RedButtonEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.red);
		}
	}
	
	public class GreenButtonEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.green);
		}
	}
	
	public class BlueButtonEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.blue);
		}
	}
	
	public class WhiteButtonEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.white);
		}
	}
	
	*/
	
	// 색 별로 클래스를 만드는것이 아닌 아래처럼 하나로 통합해 만들어봄, if문을 이용함
	
	public class ColorButtonHandle implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// getSource : 이벤트가 발생된 컴퍼넌트(= 컨테이너)를 반환하는 메소드
			// => 컴퍼넌트가 object 타입의 객체로 반환됨
			Object eventSource = e.getSource();
			
			// 각각 변수에 저장된 메모리 주소를 비교해 각각 맞게 반환해준다.
			if(eventSource == red) {
				canvas.setBackground(Color.red);
				
			} else if (eventSource == green) {
				canvas.setBackground(Color.green);
			} else if (eventSource == blue) {
				canvas.setBackground(Color.BLUE);
			} else if (eventSource == white) {
				canvas.setBackground(Color.white);
			}
			
		}
		
		
	}

}












































