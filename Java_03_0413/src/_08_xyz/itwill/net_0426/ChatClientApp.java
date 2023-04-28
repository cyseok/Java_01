package _08_xyz.itwill.net_0426;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 채팅 클라이언트 프로그램 -> GUI
// => 서버에서 보내온 메시지를 전달받아 JTextArea 컴퍼넌트에 출력 -> 접속 종료시 까지
// => JTextField 컴퍼넌트에서 입력된 메시지를 서버에 전달 -> 이벤트 처리 메소드

public class ChatClientApp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTextArea jTextArea; // 출력 컴퍼넌트
	private JTextField jTextField; // 입력 컴퍼넌트

	// 서버와 연결된 Socket 객체를 저장하기 위한 필드
	private Socket socket;
	
	// 서버에서 보내온 메시지를 전달받기 위한 입력스트림 저장 필드
	private BufferedReader in;
	
	// 서버에게 메시지를 보내기 위한 출력스트림 필드
	private PrintWriter out;
	
	// 대화명을 저장하기 위한 필드
	private String aliasName;

	//=====================================================================================
	public ChatClientApp(String title) {
		super(title);

		jTextArea = new JTextArea();
		jTextField = new JTextField();

		jTextArea.setFont(new Font("굴림체", Font.BOLD, 20));
		jTextField.setFont(new Font("굴림체", Font.BOLD, 20));

		jTextArea.setFocusable(false);

		JScrollPane jScrollPane = new JScrollPane(jTextArea);

		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		getContentPane().add(jTextField, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 400, 500);
		setVisible(true);
		
		// jTextField 컴퍼넌트에서 발행된 ActionEvent를 처리하기 위한 ActionListener 객체 추가
		// ★ 이벤트가 처리되게 한다.
		jTextField.addActionListener(this);
		
		//==================================================================================
		
		try {
			socket = new Socket("192.168.13.26", 5000);
			
			// 소켓의 입력스트림으로 제공받아 대량의 문자데이터를 읽을 수 있는 입력스트림으로 확장
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 소켓의 출력스트림을 제공받아 문자열을 전달할 수 있는 출력스트림으로 확장
			out = new PrintWriter(socket.getOutputStream(), true);
			
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "서버에 접속할 수 없습니다.", 
					"접속오류", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		// 정상적인 대화명을 입력받기 위한 반복문
		while(true) {
			aliasName = JOptionPane.showInputDialog(this, "대화명을 입력해주세요.", 
					"대화명 입력", JOptionPane.QUESTION_MESSAGE);
			
			String regEx = "^[가-힣]{2,6}$";  // 정규표현식 저장
			
			// 정규표현식과 대화명이 같은경우 반복문 종료
			if(Pattern.matches(regEx, aliasName)) break;
			
			JOptionPane.showMessageDialog(this, "정상적인 대화명을 입력해주세요.", 
					"입력오류", JOptionPane.ERROR_MESSAGE);
			
		}
		
		// 입력된 대화명을 서버에 전달
		out.println(aliasName);
		
		// 서버에 보내온 메시지를 반환받아 JTextArea 컴퍼넌트에 추가하여 출력
		// => 프로그램이 종료되기 전까지 무한 반복
		while(true) {
			try {
				jTextArea.append(in.readLine() + "\n");
				
				// JTextArea 컴퍼넌트의 스크롤을 맨 밑으로 이동
				jTextArea.setCaretPosition(jTextArea.getText().length());
				
			} catch (IOException e) {  // 서버프로그램이 종료된 경우 발생
				JOptionPane.showMessageDialog(this, "서버와 연결이 끊어졌습니다.", 
						"접속오류", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}

	}

	public static void main(String[] args) {
		new ChatClientApp("자바채팅");
	}

	// JTextField 컴퍼넌트에서 입력된 문자열을 반환받아 서버에 전달하는 명령
	@Override
	public void actionPerformed(ActionEvent e) {
		String message = jTextField.getText();
		
		if(!message.equals("")) {   // 입력된 메시지가 있는 경우에만
			out.println(message);   // 서버에 메시지 전달
			jTextField.setText("");   // 컴퍼넌트를 다시 초기화 해준다.
		}
		
	}

}


































