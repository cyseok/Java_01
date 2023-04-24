package _06_xyz.itwill.swing_0424;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


// 프레임에서 마우스 버튼을 클릭하면 클릭한 위치의 좌표값을 출력
public class PaintApp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// 클릭한 위치의 좌표값
	private int x, y;  
	// private Point point;
	
	
	public PaintApp(String title) {
		super(title);
		
		// 프레임에서 마우스관련 이벤트가 발생될 경우 이벤트 처리 객체로 이벤트 처리
		// => 익명의 내부클래스를 사용하여 이벤트처리 객체 생성
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// getX() : 좌표값 반환 메소드
				x = e.getX();
				y = e.getY();
				
				// paint() 메소드를 수동으로 호출하는 메소드
				repaint();
			}
		});
	
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setBounds(800, 200, 300, 400);
	setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new PaintApp("Paint");
	}
	
	
	// Window.paint(Graphics g) : 컨테이너(JFrame, JWindow, JDialog 등)을 출력하는 메소드
	// => paint() 메소드는 컨테이너 관련 이벤트가 발생된 경우 자동 호출
	//   => 1. 프로그램이 실행되어 컨테이너가 보여질 경우
	//   => 2. 프로그램이 아이콘에서 해제되어 컨테이너가 보여질 경우
	//   => 3. 컨테이너의 크기가 변경될 경우
	
	// Graphics 객체 : 컨테이너에 그림을 그리기위한 기능을 제공
	// paint() 메소드를 오버라이드 선언하여 컨테이너에 필요한 명령을 실행
	@Override
	public void paint(Graphics g) {
		
		// 부모클래스의 숨겨진 메소드 호출 -> ★★컨테이너 초기화
		super.paint(g);
		
		/*
		g.setColor(Color.red);
		g.drawRect(20, 40, 50, 50);
		g.fillRect(20, 100, 100, 50);
		
		g.setColor(Color.green);
		g.drawOval(25, 175, 50, 50);
		g.fillRect(100, 250, 100, 50);
		
		g.setColor(Color.blue);
		g.drawRect(100, 320, 200, 320);
		g.drawString("홍길동", 100, 350);
		
		*/
		
		g.drawString("[" + x + ", " + y + "]", x, y);
		
		
	}
}






































