package _Yunseok_practice;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/// import org.apache.coßmmons.io.FileUtils;

/// import common.FileManager;

public class BookApp extends JFrame implements ActionListener{
	
	JPanel west; // 왼쪽 전체 영역
	 JPanel p_category; // 왼쪽 분류를 묶을 패널
	 JPanel p_form; // 등록양식을 묶을 패널
	 JPanel p_preview; // 미리보기 영역을 묶을 패널

	 

	 // 가운데 영역을 위한 패널들~!!
	 JPanel center_up;
	 Choice c_topcategory;
	 Choice c_subcategory;
	 JButton search;
	 AbstractTableModel model;
	 JTable table;
	 JScrollPane scroll;

	 Choice w_topcategory; // 서쪽영역의 초이스 컴포넌트
	 Choice w_subcategory; // 서쪽영역의 초이스 컴포넌트
	 JLabel la_bookname; // 책이름
	 JLabel la_price; // 가격
	 JLabel la_publisher; // 출판사
	 JLabel la_author; // 저자
	 JLabel la_image; // 이미지
	 JLabel la_preview; // 미리보기
	 JTextField t_bookname; // 책이름 입력
	 JTextField t_price; // 가격 입력
	 JTextField t_publisher; // 출판사 입력
	 JTextField t_author; // 저자 입력

	 JButton bt_openFile; // 파일탐색기 열기
	 JButton bt_regist; // 등록버튼
	 JButton bt_edit; // 수정버튼
	 JButton bt_delete; // 삭제버튼

	 

	 // 이미지 요소들 정의
	 Toolkit kit = Toolkit.getDefaultToolkit();
	 Image preview_img;
	 Image detail_img;
	 Canvas w_can, e_can;// 서쪽과 동쪽 영역의 캔버스

	 
	 LoginForm form; // 로그인 폼 정보 접근 위해 보유한다.

	 

	 Vector top_idx = new Vector();// 상위카테고리의 idx를 보관할 백터 선언
	 Vector sub_idx = new Vector(); // 하위 카테고리의 idx를 보관할 백터 선언

	 int top_selIndex;// 상위 카테고리의 몇번째 아이템을 선택했는지 알수 있는 변수
	 int sub_selIndex;// 하위 카테고리의 몇번째 아이템을 선택했는지 알수 있는 변수

	 

	 // 파일탐색기
	 JFileChooser chooser = new JFileChooser();
	 String filePath; // 이미지 파일 경로
	 String ext; // 확장자 담을 변수..(static으로 메서드 선언해서.. 바로 그냥 쓸수 있어요..)
	    // (우리가 만든 FileManager에 fileExtension()메서드를 통해 얻어온 확장자.

	 

	 public BookApp(LoginForm lf) {
	  this.form = lf;
	  west = new JPanel();

	  p_category = new JPanel(); // 왼쪽상단 패널
	  p_form = new JPanel(); // 왼쪽 중단 패널
	  p_preview = new JPanel(); // 왼쪽하단 패널

	  w_topcategory = new Choice();
	  w_subcategory = new Choice();

	  la_bookname = new JLabel("도서명");
	  la_price = new JLabel("가격");
	  la_publisher = new JLabel("출판사");
	  la_author = new JLabel("저자");
	  la_image = new JLabel("이미지");
	  la_preview = new JLabel("미리보기");

	  t_bookname = new JTextField(10);
	  t_price = new JTextField(10);
	  t_publisher = new JTextField(10);
	  t_author = new JTextField(10);

	  bt_openFile = new JButton("파일찾기");
	  bt_regist = new JButton("도서등록");
	  bt_edit = new JButton("수정");
	  bt_delete = new JButton("삭제");

	 

	  // 미리보기 이미지 정의
	  w_can = new Canvas() {
	   public void paint(Graphics g) {
	    g.drawImage(preview_img, 0, 0, 100, 200, this);
	   }
	  }; // end 캔버스 정의.

	 

	  // 왼쪽상단부터 패널에 붙이기 시작
	  // 1.도서 분류 영역
	  w_topcategory.setPreferredSize(new Dimension(130, 25));
	  w_subcategory.setPreferredSize(new Dimension(130, 25));
	  w_topcategory.add("분류▼");
	  w_subcategory.add("분류▼");

	  p_category.setLayout(new GridLayout(2, 1));
	  p_category.add(w_topcategory);
	  p_category.add(w_subcategory);

	  west.add(p_category);

	 

	  // 2.입력폼 영역
	  p_form.setLayout(new GridLayout(4, 2));
	  p_form.add(la_bookname);
	  p_form.add(t_bookname);

	  p_form.add(la_price);
	  p_form.add(t_price);

	  p_form.add(la_publisher);
	  p_form.add(t_publisher);

	  p_form.add(la_author);
	  p_form.add(t_author);
	  p_form.setPreferredSize(new Dimension(150, 100));

	  west.setBackground(Color.GRAY);
	  west.setPreferredSize(new Dimension(200, 700));
	  west.add(p_form);

	 

	  // 3.미리보기 영역
	  p_preview.setPreferredSize(new Dimension(180, 150));
	  p_preview.setLayout(new BorderLayout());
	  p_preview.add(bt_openFile, BorderLayout.NORTH);
	  p_preview.add(w_can);
	  p_preview.add(bt_regist, BorderLayout.SOUTH);

	  west.add(p_preview); // 왼쪽 전체 패널에 현재 패널 붙이기

	  this.add(west, BorderLayout.WEST);

	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setBounds(100, 100, 900, 700);
	  setVisible(true);

	 

	  // 가운데 영역에 들어갈 녀석들.
	  center_up = new JPanel();
	  c_topcategory = new Choice();
	  c_subcategory = new Choice();
	  search = new JButton("검색");

	  center_up.add(c_topcategory);
	  center_up.add(c_subcategory);
	  center_up.add(search);
	  add(center_up, BorderLayout.NORTH);

	  /// ßmodel = new MyTableModel();
	  table = new JTable(model);
	  scroll = new JScrollPane(table);
	  add(scroll);

	 

	  // 이 윈도우가 보이자 마자 보여질 녀석들(분류목록, 북리스트)
	  getTopList();//도서분류가 보이도록 호출  
	  getBookList();//북 리스트도 테이블에 보이도록

	 

	  // 최상위 분류 선택시 이벤트 구현(내부 익명으로 갈께요)
	  w_topcategory.addItemListener(new ItemListener() {
	   @Override
	   public void itemStateChanged(ItemEvent ie) {
	    // System.out.println(ie.getItem() + "을 아이템 선택했어"); //아이템명이 나오죠!
	    // System.out.println(w_topcategory.getSelectedIndex() +
	    // "번째 아이템 선택했어"); //선택한 컬럼값이 나온다!
	    top_selIndex = w_topcategory.getSelectedIndex();

	 

	    // 최상위 분류를 선택하지 않은 경우만 sub카테고리가 나오게 하자!!
	    if (top_selIndex != 0) {
	     getSubList();
	    } else {
	     w_subcategory.removeAll();
	     w_subcategory.add("분류▼");
	    }// end if~else문
	   }// end 아이템 이벤트
	  }); // end 아이템 리스너

	 

	  // 서브 목록에 대한 이벤트 처리
	  w_subcategory.addItemListener(new ItemListener() {
	   @Override
	   public void itemStateChanged(ItemEvent e) {
	    // 선택한 아이템의 index값을 sub_selIndex변수에 채워준다!!
	    sub_selIndex = w_subcategory.getSelectedIndex();
	   }
	  }); // end 서브목록 아이템 리스너

	 

	  // 버튼에 리스너 달기.
	  bt_openFile.addActionListener(this);
	  bt_regist.addActionListener(this);
	  bt_edit.addActionListener(this);
	  bt_delete.addActionListener(this);

	 

	  // 윈도우창 닫으면 현재 프로그램과 연결된 모든DB 자원 할당 해제.
	  this.addWindowListener(new WindowAdapter() {
	   @Override
	   public void windowClosing(WindowEvent we) {
	    form.closeDB(); // 로그인 폼에 생성해 놓은..
	   }

	  });// end윈도우 어뎁터

	 } // end 생성자

	 

	 /* 최상위 분류 레코드 조회!!============================================
	  * ============================================================= */
	 public void getTopList() {
	  String sql = "SELECT * FROM topcategory ORDER BY topcategory_idx";
	  // 쿼리문 날릴려고 보니.. 로그인폼이 가지고 있는 pstmt가져와야겠네.. 필요하면 보유하라!..
	  try {
	   form.pstmt = form.con.prepareStatement(sql);
	   form.rs = form.pstmt.executeQuery(); // 쿼리실행

	   // 최상위 분류코드에 들어있는 것들 만큼 카테고리에 넣어줘야죠.
	   while (form.rs.next()) {
	    w_topcategory.add(form.rs.getString("title"));

	    // 나중에 사용하기 위해 top_idx백터에 idx값을 보관해둔다!!
	    top_idx.add(form.rs.getInt("topcategory_idx"));
	   }
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	 } // end getTopList()메서드

	 

	 /* 하위 분류 레코드 조회!!============================================
	  * ==============================================================  */
	 public void getSubList() {
	  // String sql="SELECT * FROM subcategory WHERE topcategory_idx="선택한
	  // top카테고리의 idx값"
	  String sql = "SELECT * FROM subcategory WHERE topcategory_idx=?"
	    + top_idx.get(top_selIndex - 1) + "ORDER BY subcategory_idx";
	  try {
	   form.pstmt = form.con.prepareStatement(sql);
	   form.pstmt.setInt(1, (Integer) top_idx.get(top_selIndex - 1));
	   form.rs = form.pstmt.executeQuery();

	   // sub카테고리에 있는 요소들 지우기..(계속 데이터가 쌓여가니까.. while문 돌리기 전에)
	   sub_idx.removeAllElements(); // 백터 모든 요소 삭제
	   w_subcategory.removeAll(); // 리스트에 있는 모든 요소 지우기
	   w_subcategory.add("분류▼"); // 기본 분류넣어주기.

	   // 하위카테고리 리스트에 넣어주기!!
	   while (form.rs.next()) {
	    w_subcategory.add(form.rs.getString("title"));
	    sub_idx.add(form.rs.getInt("subcategory_idx"));
	   }
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	 } // end getsublist()메서드

	 

	 /* 미리보기 기능 정의~!!=================================================
	  * 1) 파일 열기(탐색기 띄운다. )
	  * 2)선택한 파일에 대한 복사기능 구현 (따로 FileCopy클래스로 만들어 줬어요.FileCopy.java)
	  * ==============================================================  */
	 public void filePreview() {
	  int result = chooser.showOpenDialog(getParent());
	  if (result == JFileChooser.APPROVE_OPTION) {
	   // 캔버스에 현재 선택한 이미지를 그리자! = 미리보기
	   File file = chooser.getSelectedFile();
	   filePath = file.getAbsolutePath();// 내가 선택한 이미지의 풀 경로

	   // 확장자 다르면 오류 메시지 띄우기. jpg만 가능하도록..
	   // (FileManager.java클래스에 메서드fileExtension() 만들었어요..
	 ///  ext = FileManager.fileExtension(filePath);
	   if (!ext.equals("jpg") && !ext.equals("JPG")) {
	    form.showMsg("확장자는 jpg만 가능합니다.");
	    return;
	   }

	   // 미리보기에 이미지 그려주기
	   preview_img = kit.getImage(filePath); // kit을 이용해서 이미지를 얻어오자.
	   w_can.repaint();// 이미지 대체한다음에 캔버스 대체해야 되니까 repaint해주자.
	  }
	 }// end fileCopy()메서드

	 

	 /*도서등록 메서드 정의=======================================
	  * 1)DB에 insert
	  *  2)파일복사
	  * ======================================================  */
	 public void regist() throws IOException {
	  int idx = (Integer) sub_idx.get(sub_selIndex - 1); // sub카테고리의 idx를 가지고
	               // 있는 백터..
	  String sql = "INSERT INTO book(book_idx, bookname, price, publisher, author, subcategory_idx)";
	  sql = sql + " VALUES(seq_book.nextval,?,?,?,?,?)";
	  /*
	   * sql=sql+" VALUES(seq_book.nextval,?,?,?,?,?,"+idx+")"; /*바이너리변수(?)는
	   * 출력이 안되요. 마지막 가장 중요한 subcategory_idx만 찍어볼께요. 너무 길어서 idx라는 변수로 뺐어요.
	   */
	  try {
	   form.pstmt = form.con.prepareStatement(sql);
	   form.pstmt.setString(1, t_bookname.getText());
	   form.pstmt.setInt(2, Integer.parseInt(t_price.getText()));
	   form.pstmt.setString(3, t_publisher.getText());
	   form.pstmt.setString(4, t_author.getText());
	   form.pstmt.setInt(5, idx);

	   int result = form.pstmt.executeUpdate();// insert쿼리실행!!
	   if (result != 0) {
	    form.showMsg("등록성공");    
	   }

	 

	   // 방금 넣은 레코드의 idx만 추출~(왜? 이미지명 만들려고)
	   sql = "SELECT max(book_idx) as ridx FROM book"; // 그값을 추출해 오기 위해 가칭
	               // 만들어 주자. ridx로
	               // 가칭줬어요.
	   form.pstmt = form.con.prepareStatement(sql);
	   form.rs = form.pstmt.executeQuery();
	   int book_idx = 0;
	   if (form.rs.next()) {
	    book_idx = form.rs.getInt("ridx"); //

	    // 얻어온 값들을 통해 이미지 경로를 변경해주자..(B프라이머리키(북이가지고있는).확장자)
	    String bookImg = "B" + book_idx + "." + ext; // 이미지명 새로 만들어주기.

	    // 이미지명만 업데이트 시킨다.
	    sql = "UPDATE book SET img=? WHERE book_idx=?";
	    form.pstmt = form.con.prepareStatement(sql);
	    form.pstmt.setString(1, bookImg);
	    form.pstmt.setInt(2, book_idx);
	    form.pstmt.executeUpdate(); // 쿼리실행

	    // 파일복사시작
	  ///  FileUtils ut = new FileUtils();
	 ///   ut.copyFile(new File(filePath), new File("D:/myworkspace/study/products/" + bookImg));
	   }
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }  
	 }

	 /*책목록 가져오기!!========================================== *
	  * =========================================================  */
	 public void getBookList() {
	  String sql = "SELECT * FROM book ORDER BY book_idx ASC";
	  try {
	   form.pstmt = form.con.prepareStatement(sql);
	   form.rs = form.pstmt.executeQuery();
	   // rs를 vector형태로 변환하자!! 백터안에 백터를 넣은 이차원 백터네..
	   // 2차원 백터를 만들어서 우리의 테이블 모델에 전달해주자!!
	   Vector data = new Vector(); // 백터를 담을 큰 백터.   
	   while (form.rs.next()) {
	    Vector vec = new Vector();// 1건의 책에 대한 내용을 담을 백터
	    vec.add(form.rs.getString("bookname"));
	    vec.add(form.rs.getInt("price"));
	    vec.add(form.rs.getString("publisher"));
	    vec.add(form.rs.getString("author"));
	    vec.add(form.rs.getString("img"));
	    vec.add(form.rs.getInt("subcategory_idx"));
	    vec.add(form.rs.getInt("book_idx"));
	    data.add(vec);
	   }
	///   model.setData(data);
	   table.updateUI();
	   table.setAutoCreateRowSorter(true);//소팅기능
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	 }

	 // 버튼 액션 리스너 구현..
	 public void actionPerformed(ActionEvent ae) {
	  Object obj = ae.getSource();
	  // 파일찾기
	  if (obj == bt_openFile) { // ==은 주소값 비교, equals는 값(내용)비교!!
	   filePreview();   
	  }

	  // 도서등록
	  if (obj == bt_regist) {
	  /// regist();
	   getBookList();//목록갱신
	  }

	  // 도서삭제
	  if (obj == bt_delete) {
	  }

	  // 도서수정
	  if (obj == bt_edit) {
	  }
	 } // end 액션 이벤트

	}

