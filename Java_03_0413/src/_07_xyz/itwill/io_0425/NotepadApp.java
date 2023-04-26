package _07_xyz.itwill.io_0425;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

// 메모장
public class NotepadApp extends JFrame {

	// private static final long serialVersionUID = 7578094055421136528L;
	// └-> 객체 직렬화 관련 고유값이 필요할 때 사용
	
	private static final long serialVersionUID = 1L;
	
	JTextArea jTextArea;
	JMenuItem init, open, save, exit;
	
	//==================================================================================
	
	// 메뉴바 생성
	
	public NotepadApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("파일(F)");
		jMenu.setMnemonic('F');
		init = new JMenuItem("새로만들기(N)", 'N');
		open = new JMenuItem("열기(O)", 'O');
		save = new JMenuItem("저장(S)", 'S');
		exit = new JMenuItem("종료(X)", 'X');
		
		
		// Ctrl + N 단축키 제공
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 
				InputEvent.CTRL_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 
				InputEvent.ALT_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK));
		
		
		jMenu.add(init);
		jMenu.add(open);
		jMenu.add(save);
		jMenu.addSeparator();
		jMenu.add(exit);
		
		jMenuBar.add(jMenu);
		
		// 생성한 메뉴바 적용
		setJMenuBar(jMenuBar);
		
		
		//==============================================================================
		 // 중앙에 텍스트 공간 생성
		jTextArea = new JTextArea();
		jTextArea.setFont(new Font("굴림체", Font.PLAIN, 20));
		JScrollPane jScrollPane = new JScrollPane(jTextArea);
		
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450, 150, 1000, 600);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new NotepadApp("제목 없음 - Java 메모장");
	}

	

	
	
	
	

}
