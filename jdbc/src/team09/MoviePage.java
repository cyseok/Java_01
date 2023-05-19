package team09;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MoviePage extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public static final int NONE = 0;
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int UPDATE = 3;
	public static final int UPDATE_CHANGE = 4;
	public static final int SEARCH = 5;

	JTextField MOVIE_NO_TF, MOVIE_TITLE_TF, MOVIE_GENRE_TF, MOVIE_COUNTRY_TF, MOVIE_TIME_TF, MOVIE_DIRECTIO_TF;
	JButton addB, deleteB, updateB, searchB, cancelB;

	JTable table;

	int cmd;

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MoviePage() throws Exception {
		
		setTitle("◆◆◆ 영화 관리 프로그램 ◆◆◆");
		/*
		 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setBounds(100, 100, 450,
		 * 300); contentPane = new JPanel(); contentPane.setBorder(new EmptyBorder(5, 5,
		 * 5, 5));
		 * 
		 * // Dimension : 컴퍼넌트 크기를 저장하기 위한 객체 Dimension dim =
		 * getToolkit().getScreenSize(); setLocation(dim.width / 2 - getWidth() / 2,
		 * dim.height / 2 - getHeight() / 2); setContentPane(contentPane);
		 */

		setSize(800, 400);

		// Dimension : 컴퍼넌트 크기를 저장하기 위한 객체
		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1));

		JPanel pMOVIE_No = new JPanel();
		pMOVIE_No.add(new JLabel("영화 번호"));
		pMOVIE_No.add(MOVIE_NO_TF = new JTextField(10));
		
		JPanel pMOVIE_Name = new JPanel();
		pMOVIE_Name.add(new JLabel("영화제목"));
		pMOVIE_Name.add(MOVIE_TITLE_TF = new JTextField(10));

		JPanel pMOVIE_Genre = new JPanel();
		pMOVIE_Genre.add(new JLabel("장르"));
		pMOVIE_Genre.add(MOVIE_GENRE_TF = new JTextField(10));

		JPanel pMOVIE_Time = new JPanel();
		pMOVIE_Time.add(new JLabel("상영시간"));
		pMOVIE_Time.add(MOVIE_TIME_TF = new JTextField(10));
		
		JPanel pMOVIE_Country = new JPanel();
		pMOVIE_Country.add(new JLabel("국가"));
		pMOVIE_Country.add(MOVIE_COUNTRY_TF = new JTextField(10));
		
		JPanel pMOVIE_DIRECTOR = new JPanel();
		pMOVIE_DIRECTOR.add(new JLabel("감독"));
		pMOVIE_DIRECTOR.add(MOVIE_DIRECTIO_TF = new JTextField(10));

		left.add(pMOVIE_No);
		left.add(pMOVIE_Name);
		left.add(pMOVIE_Genre);
		left.add(pMOVIE_Time);
		left.add(pMOVIE_Country);
		left.add(pMOVIE_DIRECTOR);

		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5));

		bottom.add(addB = new JButton("삽  입"));
		addB.addActionListener(this);

		bottom.add(updateB = new JButton("변  경"));
		updateB.addActionListener(this);

		bottom.add(deleteB = new JButton("삭  제"));
		deleteB.addActionListener(this);

		bottom.add(searchB = new JButton("검  색"));
		searchB.addActionListener(this);

		bottom.add(cancelB = new JButton("초기화"));
		cancelB.addActionListener(this);

		Object[] title = { "No", "영화제목", "장르", "상영시간", "국가", "감독" };

		table = new JTable(new DefaultTableModel(title, 0));
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		JScrollPane sp = new JScrollPane(table);

		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE;
		initialize();

		displayAllMovie();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void initialize() {
		MOVIE_NO_TF.setEditable(false);
		MOVIE_TITLE_TF.setEditable(false);
		MOVIE_GENRE_TF.setEditable(false);
		MOVIE_COUNTRY_TF.setEditable(false);
		MOVIE_TIME_TF.setEditable(false);
		MOVIE_DIRECTIO_TF.setEditable(false);
	}

	public void setEditable(int n) {
		switch (n) {
		case ADD:
			MOVIE_TITLE_TF.setEditable(true);
			MOVIE_GENRE_TF.setEditable(true);
			MOVIE_COUNTRY_TF.setEditable(true);
			MOVIE_TIME_TF.setEditable(true);
			MOVIE_DIRECTIO_TF.setEditable(true);
			break;
		case DELETE:
			MOVIE_NO_TF.setEditable(true);
			break;
		case UPDATE:
			MOVIE_NO_TF.setEditable(true);
			break;
		case UPDATE_CHANGE:
			MOVIE_NO_TF.setEditable(false);
			MOVIE_TITLE_TF.setEditable(true);
			MOVIE_GENRE_TF.setEditable(true);
			MOVIE_COUNTRY_TF.setEditable(true);
			MOVIE_TIME_TF.setEditable(true);
			MOVIE_DIRECTIO_TF.setEditable(true);
			break;
		case SEARCH:
			MOVIE_TITLE_TF.setEditable(true);
			break;
		case NONE:
			MOVIE_NO_TF.setEditable(false);
			MOVIE_TITLE_TF.setEditable(false);
			MOVIE_GENRE_TF.setEditable(false);
			MOVIE_COUNTRY_TF.setEditable(false);
			MOVIE_TIME_TF.setEditable(false);
			MOVIE_DIRECTIO_TF.setEditable(false);
		}
	}

	public void setEnable(int n) {
		addB.setEnabled(false);
		deleteB.setEnabled(false);
		updateB.setEnabled(false);
		searchB.setEnabled(false);

		switch (n) {
		case ADD:
			addB.setEnabled(true);
			setEditable(ADD);
			cmd = ADD;
			break;
		case DELETE:
			deleteB.setEnabled(true);
			setEditable(DELETE);
			cmd = DELETE;
			break;
		case UPDATE:
			updateB.setEnabled(true);
			setEditable(UPDATE);
			cmd = UPDATE;
			break;
		case UPDATE_CHANGE:
			updateB.setEnabled(true);
			setEditable(UPDATE_CHANGE);
			cmd = UPDATE_CHANGE;
			break;
		case SEARCH:
			searchB.setEnabled(true);
			setEditable(SEARCH);
			cmd = SEARCH;
			break;
		case NONE:
			addB.setEnabled(true);
			deleteB.setEnabled(true);
			updateB.setEnabled(true);
			searchB.setEnabled(true);
		}
	}

	public void clear() {
		MOVIE_NO_TF.setText("");
		MOVIE_TITLE_TF.setText("");
		MOVIE_GENRE_TF.setText("");
		MOVIE_COUNTRY_TF.setText("");
		MOVIE_TIME_TF.setText("");
		MOVIE_DIRECTIO_TF.setText("");
	}

	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();
	}

	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoviePage frame = new MoviePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/////

	public void actionPerformed(ActionEvent ev) {
		Component c = (Component) ev.getSource();
		try {
			if (c == addB) {
				if (cmd != ADD) { // 첫번째 [삽입] 버튼을 누른 경우 - NONE 상태
					setEnable(ADD); // 컴퍼넌트의 활성화 상태 변경 - ADD 상태 변경
				} else { // 두번째 [삽입] 버튼을 누른 경우 - ADD 상태
					// 학생정보를 입력받아 STUDENT 테이블에 삽입하는 메소드 호출
//					addMovie();
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) { // 첫번째 [변경] 버튼을 누른 경우 - NONE 상태
					setEnable(UPDATE); // 입출력 컴퍼넌트의 활성화 상태 변경 - UPDATE 상태 변경

				} else { // 두번째 [변경] 버튼을 누른 경우 - UPDATE_CHANGE 상태
					// 학번을 제외한 학생정보의 변경값을 입력받아 STUDENT 테이블에 저장된 학생정보를 변경하는 메소드 호출
//					modifyUser();
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) { // 첫번째 [삭제] 버튼을 누른 경우 - NONE 상태
					setEnable(DELETE); // 입출력 컴퍼넌트의 활성화 상태 변경 - DELETE 상태 변경
				} else { // 두번째 [삭제] 버튼을 누른 경우 - DELETE 상태
					// 입력된 학번으로 STUDENT 테이블에 저장된 해당 학번의 학생정보를 삭제하는 메소드 호출
//					removeUser();
				}
			} else if (c == searchB) {
				if (cmd != SEARCH) { // 첫번째 [검색] 버튼을 누른 경우 - NONE 상태
					setEnable(SEARCH); // 입출력 컴퍼넌트의 활성화 상태 변경 - SEARCH 상태 변경
				} else { // 두번째 [검색] 버튼을 누른 경우 - SEARCH 상태
					// 입력된 이름으로 STUDENT 테이블에 저장된 해당 이름이 포함된 학생정보를
					// 검색하는 출력하는 메소드 호출
//					searchNameUSer();
				}
			} else if (c == cancelB) {
				displayAllMovie();
				initDisplay();
			}
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e);
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////
	// 미완

	public void displayAllMovie() {
		List<MovieDTO> MovieList = MovieDAOImpl.getDao().selectAllMovieList();

		if (MovieList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 movie정보가 없습니다.");
			return;
		}

		// JTable.getModel() : JTable 컴퍼넌트의 행 정보가 저장된 TableModel 객체를 반환
		// => DefaultTableModel 클래스로 명시적 객체 형변환
		// DefaultTableModel 객체 : JTable 컴퍼넌트의 행과 열을 조작할 수 있는 메소드 제공
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// JTabel 컴퍼넌트 초기화 -> 기존 출력행 삭제 처리
		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0); // JTabel 컴퍼넌트 첫번째 행을 제거
		}

		// List 객체의 요소를 하나씩 제공받아 반복처리
		for (MovieDTO movie : MovieList) {
			// Vector 객체 생성 -> JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
			Vector<Object> rowData = new Vector<>();
			// StudentDTO 객체의 필드값을 vector 객체의 요소로 추가
			rowData.add(movie.getMOVIE_NO());
			rowData.add(movie.getMOVIE_TITLE());
			rowData.add(movie.getMOVIE_GENRE());
			rowData.add(movie.getMOVIE_TIME());
			rowData.add(movie.getMOVIE_COUNTRY());
			rowData.add(movie.getMOVIE_DIRECTOR());

			model.addRow(rowData);

		}

	}
/*
	// 미완
	public void addMovie() {
		
//		String MOVIE_NO_Temp = MOVIE_NAME_TF.getText();
//		if (MOVIE_NO_Temp.equals("")) {
//			JOptionPane.showMessageDialog(this, "영화넘버를 반드시 입력해 주세요.");
//			MOVIE_NAME_TF.requestFocus();
//			return;
//		}
//
//		String noReg = "^[1-9][0-9]{3}$";
//
//		if (!Pattern.matches(noReg, MOVIE_NO_Temp)) {// 정규표현식과 입력값의 입력패턴이 다른 경우
//			JOptionPane.showMessageDialog(this, "넘버는 ~~~~ 입력해 주세요.");
//			MOVIE_NAME_TF.requestFocus();
//			return;
//		}
//
//		int MOVIE_NO = Integer.parseInt(MOVIE_NO_Temp);// 문자열을 정수값으로 변환하여 변수에 저장
//
//		if (MovieDAOImpl.getDao().selectAllMovieList(MOVIE_NO) != null) {
//			JOptionPane.showMessageDialog(this, "이미 사용중인 학번을 입력 하였습니다.");
//			MOVIE_NAME_TF.requestFocus();
//			return;
//		}

		
		String MOVIE_TITLE = MOVIE_GENRE_TF.getText();

		if (MOVIE_TITLE.equals("")) {
			JOptionPane.showMessageDialog(this, "영화제목을 반드시 입력해 주세요.");
			MOVIE_GENRE_TF.requestFocus();
			return;
		}

		String MOVIE_TITLEReg = "^[가-힣]{2,5}$";
		if (!Pattern.matches(MOVIE_TITLEReg, MOVIE_TITLE)) {
			JOptionPane.showMessageDialog(this, "영화제목은은 2~5 범위의 한글로만 입력해 주세요.");
			MOVIE_GENRE_TF.requestFocus();
			return;
		}

		String MOVIE_COUNTRY = MOVIE_COUNTRY_TF.getText();

		if (MOVIE_COUNTRY.equals("")) {
			JOptionPane.showMessageDialog(this, "국가를 반드시 입력해 주세요.");
			MOVIE_COUNTRY_TF.requestFocus();
			return;
		}

		String MOVIE_COUNTRYREG = "[가-힣][a-z][A-Z]$";
		if (!Pattern.matches(MOVIE_COUNTRYREG, MOVIE_COUNTRY)) {
			JOptionPane.showMessageDialog(this, "국가를 형식에 맞게 입력해 주세요.");
			MOVIE_COUNTRY_TF.requestFocus();
			return;
		}

		String MOVIE_GENRE = MOVIE_TIME_TF.getText();

		if (MOVIE_GENRE.equals("")) {
			JOptionPane.showMessageDialog(this, "장르를 반드시 입력해 주세요.");
			MOVIE_TIME_TF.requestFocus();
			return;
		}
		
		String MOVIE_GENREReg = "[가-힣][a-z][A-Z]$";
		if (!Pattern.matches(MOVIE_GENREReg, MOVIE_GENRE)) {
			JOptionPane.showMessageDialog(this, "장르를 형식에 맞게 입력해 주세요.");
			MOVIE_COUNTRY_TF.requestFocus();
			return;
		}

		String USER_EMAIL = MOVIE_DIRECTIO_TF.getText();

		if (USER_EMAIL.equals("")) {
			JOptionPane.showMessageDialog(this, "생년월일을 반드시 입력해 주세요.");
			MOVIE_DIRECTIO_TF.requestFocus();
			return;
		}

//		String USER_EMAILReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
//		if(!Pattern.matches(USER_EMAILReg, USER_EMAIL)) {
//			JOptionPane.showMessageDialog(this, "생년월일을 형식에 맞게 입력해 주세요.");
//			USER_EMAIL_TF.requestFocus();
//			return;
//		}

		MovieDTO movie = new MovieDTO();
		movie.setUSER_NO(MOVIE_NO);
		movie.setUSER_ID(MOVIE_TITLE);
		movie.setUSER_PW(MOVIE_COUNTRY);
		movie.setUSER_NAME(MOVIE_GENRE);
		movie.setUSER_EMAIL(USER_EMAIL);

		int rows = UserDAOImpl.getDao().insertUser(movie);

		JOptionPane.showMessageDialog(this, rows + "명의 user정보를 삽입 하였습니다.");

		displayAllMovie();// STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력
		initDisplay();// 모든 컴퍼넌트 초기화

	}

	public void modifyUser() {

		int USER_NO = Integer.parseInt(MOVIE_TITLE_TF.getText());// 학번을 반환받아 저장

		// JTextField 컴퍼넌트에 입력된 변경값을 반환받아 저장
		String USER_ID = MOVIE_GENRE_TF.getText();

		if (USER_ID.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
			MOVIE_GENRE_TF.requestFocus();
			return;
		}

		String USER_IDReg = "^[가-힣]{2,5}$";
		if (!Pattern.matches(USER_IDReg, USER_ID)) {
			JOptionPane.showMessageDialog(this, "이름은 2~5 범위의 한글로만 입력해 주세요.");
			MOVIE_GENRE_TF.requestFocus();
			return;
		}

		String USER_PW = MOVIE_COUNTRY_TF.getText();

		if (USER_PW.equals("")) {
			JOptionPane.showMessageDialog(this, "전화번호를 반드시 입력해 주세요.");
			MOVIE_COUNTRY_TF.requestFocus();
			return;
		}

		String USER_PWReg = "(01[016789])-\\d{3,4}-\\d{4}";
		if (!Pattern.matches(USER_PWReg, USER_PW)) {
			JOptionPane.showMessageDialog(this, "전화번호를 형식에 맞게 입력해 주세요.");
			MOVIE_COUNTRY_TF.requestFocus();
			return;
		}

		String USER_NAME = MOVIE_TIME_TF.getText();

		if (USER_NAME.equals("")) {
			JOptionPane.showMessageDialog(this, "주소를 반드시 입력해 주세요.");
			MOVIE_TIME_TF.requestFocus();
			return;
		}

		String USER_EMAIL = MOVIE_DIRECTIO_TF.getText();

		if (USER_EMAIL.equals("")) {
			JOptionPane.showMessageDialog(this, "생년월일을 반드시 입력해 주세요.");
			MOVIE_DIRECTIO_TF.requestFocus();
			return;
		}

		String USER_EMAILReg = "(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if (!Pattern.matches(USER_EMAILReg, USER_EMAIL)) {
			JOptionPane.showMessageDialog(this, "생년월일을 형식에 맞게 입력해 주세요.");
			MOVIE_DIRECTIO_TF.requestFocus();
			return;
		}

		MovieDTO user = new MovieDTO();
		user.setUSER_NO(USER_NO);
		user.setUSER_ID(USER_ID);
		user.setUSER_PW(USER_PW);
		user.setUSER_NAME(USER_NAME);
		user.setUSER_EMAIL(USER_EMAIL);

		int rows = UserDAOImpl.getDao().insertUser(user);

		JOptionPane.showMessageDialog(this, rows + "명의 user정보를 삽입 하였습니다.");

		displayAllMovie();// STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력
		initDisplay();// 모든 컴퍼넌트 초기화

	}

	public void removeUser() {

		String USER_ID = MOVIE_GENRE_TF.getText();
		if (USER_ID.equals("")) {
			JOptionPane.showMessageDialog(this, "USER_ID_TF을 반드시 입력해 주세요.");
			MOVIE_GENRE_TF.requestFocus();
			return;
		}

		String USER_IDReg = "^[1-9][0-9]{3}$";
		if (!Pattern.matches(USER_IDReg, USER_ID)) {
			JOptionPane.showMessageDialog(this, "USER_ID_TF은 4자리 숫자로만 입력해 주세요.");
			MOVIE_GENRE_TF.requestFocus();
			return;
		}

		int no = Integer.parseInt(USER_ID);

		// 학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 삭제하는
		// DAO 클래스의 메소드 호출
		int rows = UserDAOImpl.getDao().deleteUser(no);

		if (rows > 0) {
			JOptionPane.showMessageDialog(this, rows + "명의 학생정보를 삭제 하였습니다.");
			displayAllMovie();
		} else {
			JOptionPane.showMessageDialog(this, "삭제할 학번의 학생정보가 없습니다.");
		}

		initDisplay();

	}

	public void searchNameUSer() {

		String USER_NAME = MOVIE_TIME_TF.getText();

		if (USER_NAME.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
			MOVIE_TIME_TF.requestFocus();
			return;
		}

		String USER_NAMEReg = "^[가-힣]{2,5}$";
		if (!Pattern.matches(USER_NAMEReg, USER_NAME)) {
			JOptionPane.showMessageDialog(this, "이름은 2~5 범위의 한글로만 입력해 주세요.");
			MOVIE_TIME_TF.requestFocus();
			return;
		}

		// 이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 반환
		// 하는 DAO 클래스의 메소드 호출
		List<MovieDTO> userList = UserDAOImpl.getDao().selectNameUserList(USER_NAME);

		if (userList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "검색된 학생정보가 없습니다.");
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// JTable 컴퍼넌트 초기화 - 기존 출력행 삭제 처리
		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}

		for (MovieDTO user : userList) {
			// Vector 객체 생성 -> JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
			Vector<Object> rowData = new Vector<>();
			// StudentDTO 객체의 필드값을 vector 객체의 요소로 추가
			rowData.add(user.getUSER_NO());
			rowData.add(user.getUSER_ID());
			rowData.add(user.getUSER_PW());
			rowData.add(user.getUSER_NAME());
			rowData.add(user.getUSER_EMAIL());

			model.addRow(rowData);
		}
	}

	*/
	
}
