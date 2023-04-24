package _06_xyz.itwill.swing_0424;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// javax.swing 패키지의 클래스를 이용하여 GUI 프로그램을 작성하는 방법
// awt와의 차이점

// 1. java.awt 패키지의 컴퍼넌트 또는 컨테이너 관련 클래스 대신 javax.swing 패키지의 컴퍼넌트와
//     컨테이너 관련 클래스를 사용하여 UI 구현
// => AWT 컴퍼넌트(=컨테이너) 관련 클래스 이름 앞에 'J'를 붙이면 Swing 컴퍼넌트임.

// 2. 프레임의 [닫기] 버튼을 누른경우 동작되는 기능을 기본적으로 제공해준다.
// => [닫기]를 누른 경우 동작되는 기능을 변경해준다.
//               └-> JFrame.setDefaultCloseOperation(int operation) 메소드를 호출해준다
// => operation 매개변수에는 WindowConstants의 상수를 전달함
//      - WindowConstants.DO_NOTHING_ON_CLOSE : 아무런 동작도 실행되지 않도록 설정
//      - WindowConstants.HIDE_ON_CLOSE : 프레임이 보이지 않도록 설정
//      - WindowConstants.DISPOSE_ON_CLOSE : 메모리를 정리하고 프로그램을 종료하는 상수
//      - WindowConstants.EXIT_ON_CLOSE : 프로그램을 종료하는 상수

// 3. 프레임을 직접 변경하지 않고 프레임의 container객체를 반환받아 변경 처리
// => 프레임의 배치관리자 변경, 프레임의 배경색 변경, 프레임의 컴퍼넌트 부착등

// JTextField 컴퍼넌트에서 메시지를 입력 후 엔터를 누르면 JTextArea 컴퍼넌트에 메시지를 추가후 출력
// => ActionEvent 발생
public class Swing extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JTextField jTextField;
	JTextArea jTextArea;
	
	public Swing(String title) {
		super(title);
		
		jTextField = new JTextField();
		jTextArea = new JTextArea("홍길동님이 입장했습니다.\n");
		
		// Swing 프로그램에서는 운영체제에서 제공되는 모든 글꼴 사용 가능
		jTextField.setFont(new Font("굴림체", Font.BOLD, 20));
		jTextArea.setFont(new Font("굴림체", Font.BOLD, 20));
		
		jTextArea.setBackground(Color.GRAY);
		
		// 입력 초점을 false -> 출력 컴퍼넌트로만 사용
		jTextArea.setFocusable(false);
		
		// JFrame.getContentPane() : 프레임의 컨테이너 기능의 객체를 반환하는 메소드
		Container container = getContentPane();
		
		JScrollPane jSrollPane = new JScrollPane(jTextArea);
		// container.add(jTextArea, BorderLayout.CENTER);
		container.add(jSrollPane, BorderLayout.CENTER);
		container.add(jTextField, BorderLayout.SOUTH);
		
		// jTextField컴퍼넌트에서 ActionEvent가 발생될 경우 이벤트 처리할 클래스로 객체를 생성하여 이벤트 처리기능 등록
		jTextField.addActionListener(new TextEventHandel());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setBounds(800, 200, 400, 500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Swing("Swing");
	}
	
	public class TextEventHandel implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TextCompnenet.getText() : JTextField 컴퍼넌트 또는 jTextArea컴퍼넌트에 입력된 문자열 반환
			String text = jTextField.getText();
			
			if(!text.equals("")) {   // 입력된 문자열이 존재한 경우
				
				// TextCompnenet.append : JTextField , jTextArea컴퍼넌트에 입력된 문자열 반환
				jTextArea.append("나) " + text + "\n");
				
				// JTextComponent.setCaretPosition(int position) : 스크롤을 이동하는 메소드
				jTextArea.setCaretPosition(jTextArea.getText().length());  // 스크롤을 맨 아래로 계속 이동시킴
				
				// TextCompnenet.setText : JTextField , jTextArea컴퍼넌트에 입력된 문자열 변경
				jTextField.setText("");
			}
			
		}
		
		
	}
}




































