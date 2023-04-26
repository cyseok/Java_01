package _07_xyz.itwill.io_0425;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

// 메모장

// JFileChooser를 이용해서 다시 만들어보기
public class NotepadApp extends JFrame {

	// private static final long serialVersionUID = 7578094055421136528L;
	// └-> 객체 직렬화 관련 고유값이 필요할 때 사용
	
	private static final long serialVersionUID = 1L;
	
	JTextArea jTextArea;
	JMenuItem init, open, save, exit;
	
	//==================================================================================
	
	//JFileChooser 클래스 : 파일을 선택하기 위한 다이얼로그를 생성하기 위한 컴퍼넌트 클래스
	// FileDialog 클래스 : 파일을 선택하기 위한 다이얼로그를 생성하기 위한 클래스
	FileDialog openDialog, saveDialog;
	
	
	//==================================================================================
	// 현재 작업중인 문서 파일의 경로를 저장하는 필드
	private String filepath;
	
	//==================================================================================
	// 메뉴바 생성 (생성자)
	
	public NotepadApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("파일(F)");
		jMenu.setMnemonic('F');
		
		// 메뉴아이템을 선택할 경우 ActionEvent 발생
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
		
		//==============================================================================
		// Dialog 생성
		openDialog = new FileDialog(this, "열기", FileDialog.LOAD);
		saveDialog = new FileDialog(this, "저장", FileDialog.SAVE);
		
		//==============================================================================
		// 이벤트 처리 메소드
		init.addActionListener(new NodepadEventHandle());
		open.addActionListener(new NodepadEventHandle());
		save.addActionListener(new NodepadEventHandle());
		exit.addActionListener(new NodepadEventHandle());
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450, 150, 1000, 600);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new NotepadApp("제목 없음 - Java 메모장");
	}

	
	//=================================================================================
	// Inner class로 이벤트 처리 class 생성
	
	public class NodepadEventHandle implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource = e.getSource();
			
			if(eventSource == init) {
				// 새로만들기했을 때
				jTextArea.setText("");  // JTextArea 컴퍼넌트 초기화
				filepath = "";   // 필드값 초기화
				setTitle("제목없음 - Java 메모장");  // 프레임 제목 초기화
				
			} else if(eventSource == open) {
				
				// 열기 관련 파일 다이얼로그를 화면에 출력
				// => 파일을 선택하거나 선택취소한 경우 다이얼로그는 자동으로 숨겨짐
				openDialog.setVisible(true);
				
				// FileDialog.getFile() : 선택된 파일의 이름을 반환하는 메소드
				if(openDialog.getFile() == null) return;  // 파일 선택을 취소한 경우 메소드종료
				
				// FileDialog.getDirectory() : 선택된 파일의 디렉토리 경로를 반환하는 메소드
				filepath = openDialog.getDirectory() + openDialog.getFile();  // 선택된 파일의 경로 저장
				
				//=================================================================================
				// open 예외처리
				
				try {
					// 파일의 경로를 제공받아 파일 입력스트림 생성
					BufferedReader in = new BufferedReader(new FileReader(filepath));
					
					jTextArea.setText("");  // JTextArea 컴퍼넌트 초기화
					
					while(true) {
						// 파일에 저장된 값을 한줄씩 읽어 문자열로 저장
						String text = in.readLine();                          
						
						if(text == null) break;
						
						// 변수에 저장된 문자열을 JTextArea 컴퍼넌트에 추가하고 출력함
						jTextArea.append(text + "\n");
					}
					
					in.close();
					
					// 파일 열기시 불러온 파일의 이름으로 이름을 바꿈
					setTitle(openDialog.getFile() + " - Java 메모장");
					
					// FileNotFoundException은 IOException의 하위 예외라서 먼저 위에 작성해준다.
				} catch(FileNotFoundException e1) {
					
					JOptionPane.showMessageDialog(null, "파일을 찾을 수 없습니다.");
					
				} catch(IOException e1) {
					
					JOptionPane.showMessageDialog(null, "프로그램 문제 발생");
					
				}
				
			} else if(eventSource == save) {
				if(filepath == null || filepath.equals("")) {

				// 저장관련 다이얼로그를 화면에 출력
				saveDialog.setVisible(true);
				
				// 파일선택을 취소한 경우 메소드종료시킴.
				if(saveDialog .getFile() == null) return;
				
				// FileDialog.getDirectory() : 선택된 파일의 디렉토리 경로를 반환하는 메소드
				filepath = saveDialog.getDirectory() + saveDialog.getFile();  // 선택된 파일의 경로 저장
				
				setTitle(saveDialog.getFile() + " - Java 메모장");
				
				}	
				try {
					// 파일의 경로를 제공받아 파일 출력스트림 생성
					BufferedWriter out = new BufferedWriter(new FileWriter(filepath));
					
					// JTextArea 컴퍼넌트의 모든 문자열을 반환받아 저장
					String text = jTextArea.getText();
					
					// 반환받은 문자열을 출력스트림으로 전달하여 저장
					out.write(text);
					
					out.close();
					
					setTitle("*" + getTitle());
				} catch(IOException e1) {
					JOptionPane.showMessageDialog(null, "프로그램 문제 발생");
					
				}
				
			} else if(eventSource == exit) {
				System.exit(0);
			}
			
		}
		
	}
	
}







































