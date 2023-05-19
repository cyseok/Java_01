package team09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	JoinPage dialog = new JoinPage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("      로그인");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 60));
		lblNewLabel.setBounds(63, 39, 435, 190);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(157, 261, 232, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 292, 232, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("로그인");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = textField.getText();
				System.out.println(temp);
			}
		});
		
		btnNewButton.setBounds(409, 261, 71, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setBounds(304, 323, 85, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		
		
	}
	
//	public class actionListener implements ActionListener {
//		
//		private Object btnNewButton_1;
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// getSource : 이벤트가 발생된 컴퍼넌트(= 컨테이너)를 반환하는 메소드
//			// => 컴퍼넌트가 object 타입의 객체로 반환됨
//			Object eventSource = e.getSource();
//			
//			// 각각 변수에 저장된 메모리 주소를 비교해 각각 맞게 반환해준다.
//			if(eventSource == btnNewButton_1) {
//				join.getWindows();
//			} 
//			
//		}
//		
//	}
	
}
	
	
	
	



/*
 * 
		
	}
 * 
 * */































