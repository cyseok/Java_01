package _06_xyz.itwill.swing_0424;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableApp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public JTableApp(String title) {
		super(title);
		
		String[] columnName = {"학번","이름", "전화번호"};
		String[][] rowData = {{"1000", "홍길동","010-1234-5678"}, 
				{"2000", "임꺽정","010-4565-6454"}, {"3000", "전우치","010-1234-5678"}, 
				{"4000", "일지매","010-1234-5678"}, {"5000", "장길산","010-1234-5678"}};
		
		// DefaultTableModel 클래스 : 테이블 관련 정보를 저장하는 클래스
		// => 테이블의 행 또는 열을 조작할 수 있는 메소드 제공
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, columnName);
		
		//=================================================================
		
		// Vector 클래스 : 다수의 객체를 저장하기 위한 컬렉션클래스
		Vector<String> vector = new Vector<>();
		vector.add("6000");
		vector.add("홍경례");
		vector.add("010-7777-7777");
		// .addRow() : 테이블에 행을 추가하는 메소드
		defaultTableModel.addRow(vector);
		
		//==================================================================
		
		// JTable 클래스 : 값을 행과 열로 구성된 표로 출력
		JTable jTable = new JTable(defaultTableModel);
		
		JScrollPane jScrollPane = new JScrollPane(jTable);
		
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 500, 300);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new JTableApp("JTable 컴퍼넌트");
	}

}
