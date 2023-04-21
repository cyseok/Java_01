package _05_xyz.itwill.awt_0421;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class PanelApp extends Frame{
	
	private static final long serialVersionUID = 1L;
	
	public PanelApp(String title) {
		super(title);
		
		// TextField 클래스 : 한 줄의 문자열을 입출력하는 컴퍼넌트를 구현하기 위한 클래스
		TextField textField = new TextField();
		// TextField 클래스 : 여러 줄의 문자열을 입출력하는 컴퍼넌트를 구현하기 위한 클래스
		TextArea textArea = new TextArea();
		
	
		
		
		
		// Panel 클래스 : 컴퍼넌트를 배치하여 그룹화하기 위한 종속적인 컨테이너 클래스
		Panel panel = new Panel();  // FlowLayout이 기본 배치관리자
		
		
		Button red = new Button("RED");
		Button green = new Button("green");
		Button blue = new Button("blue");
		
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		
		add(panel, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
		
		
		/*컴퍼넌트는 위치에 하나씩만 설정가능
		add(red, BorderLayout.NORTH);
		add(green, BorderLayout.NORTH);
		add(blue, BorderLayout.NORTH);
		패널 클래스로 인해 위쪽 처럼 바뀜 */
		
		
		// Component.setFont(Font f) : 컴퍼넌트의 글자관련 속성을 변경하는 메소드
		// Font(String name, int style, int size) 생성자로 Font 객체 생성
		// => name : 글자의 글꼴, style : 글꼴 스타일, size : 글자크기
		// => 글자의 글꼴 스타일은 Font 클래스에서 제공하는 상수 사용
		// => 컨테이너에 적용된 클자관련 속성은 컨테이너에 배치된 컴퍼넌트에 적용
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		
		textArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		textField.setFont(new Font(Font.SANS_SERIF, Font.BOLD+Font.ITALIC, 8));
		
		// Component.setForeground(Color c) : 컴퍼턴트의 글자색을 변경하는 메소드
		// Color 클래스 : 색상 정보를 저장하기 위찬 클래스
		// => Color 클래스의 Color(int red, int green, int blue) 생성자로 Color객체 생성
		// => red, green, blue는 0~255 범위의 정수 값으로 표현
		// Color 클래스는 대표색을 상수로 제공
		red.setForeground(new Color(255, 0, 0));
		// red.setForeground(Color.RED);
		green.setForeground(new Color(0, 255, 0));
		green.setForeground(Color.GREEN); 
		blue.setForeground(new Color(0, 0, 255));
		
		textArea.setBackground(Color.yellow);
		
		
		// Component.setEnabled(boolean b) : 컴퍼넌트의 활성화 상태여부 변경
		red.setEnabled(false);  // 컴퍼넌트 비활성화
		// TextComponent.setEnabled(boolean b) : 텍스트 컴퍼넌트의 입력초점 위치여부를 변경
		textArea.setFocusable(false);  // -> 입력초점 미제공 : 입력불가능
		
		
		
		setBounds(600, 100, 300, 400);
		setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new PanelApp("Panel");
	}

}






























