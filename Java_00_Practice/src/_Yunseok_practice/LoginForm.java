package _Yunseok_practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

 

public class LoginForm extends JFrame implements ActionListener{
 JPanel center, center1, center2, south;
 JLabel title, la_id, la_passwd;
 JTextField t_id;
 JPasswordField t_passwd;
 JButton login;
 
 //데이터베이스 관련 객체들 정의
 String driver="oracle.jdbc.driver.OracleDriver";
 String url="jdbc:oracle:thin:@192.168.0.113:1521:orcl";
 String uid="user0523";
 String upasswd="user0523";
 
 Connection con;
 PreparedStatement pstmt;
 ResultSet rs; 
 
 public LoginForm(){
  center = new JPanel();
  center1 = new JPanel();
  center2 = new JPanel();
  south = new JPanel();
  title = new JLabel("관리자 인증");
  la_id = new JLabel("I   D  ");
  la_passwd= new JLabel("P/W  ");
  t_id= new JTextField(20);
  t_passwd = new JPasswordField(20);
  login = new JButton("Login");
  
  add(title, BorderLayout.NORTH);
  
  center.setLayout(new GridLayout(2,1));
    
  center1.add(la_id);
  center1.add(t_id);
  center2.add(la_passwd);
  center2.add(t_passwd);
  
  center.add(center1);
  center.add(center2);    
  add(center);
  
  south.add(login);
  add(south, BorderLayout.SOUTH);
    
  login.addActionListener(this);
  
  setBounds(200,100,300,150); // x축: 200, y축: 100, w: 300, h:150
  setVisible(true);
  
  /*DB 접속시도*/
  if(connect()){
   //JOptionPane.showMessageDialog(getParent(), "접속성공^ - ^");
   showMsg("접속성공^ - ^");
   t_id.requestFocus(); //커서올려놓기   
  }else{
   //JOptionPane.showMessageDialog(getParent(), "접속실패T ^ T");
   showMsg("접속실패T ^ T");
  }
  
 }//end 생성자
 
 /*-----------------------------------------------------------------
  * DB 접속 기능 정의
  * ----------------------------------------------------------------*/
 public boolean connect() {
  boolean result=false;
  try {
   Class.forName(driver);
   con = DriverManager.getConnection(url,uid,upasswd);
   if(con!=null){
    result= true;
    //JOptionPane.showMessageDialog(getParent(), "접속성공^ - ^");
   }else{
    result= false;
    //JOptionPane.showMessageDialog(getParent(), "접속실패T ^ T");
   }
  } catch (ClassNotFoundException e) {  
   e.printStackTrace();
  } catch (SQLException e) {
   e.printStackTrace();
  }
  return result;  
 }
 
 
 /*-----------------------------------------------------------------
  * 로그인 처리 메서드 정의
  * 1) 입력폼의 유효성 체크
  * 2) DBtable로 부터 관리자의 정보 존재 여부 확인*
  * ----------------------------------------------------------------*/
 public void loginCheck(){
  if(t_id.getText().length()==0){
   showMsg("아이디를 입력해주세요");
   t_id.requestFocus();
   return; //그냥넘어가면 안되니까 다시 리턴해주자..
  }
  //  if(t_passwd.getText().length()==0){ 곧없어진다고 하네.. 다른거 써야겠어.
  char[] ch=t_passwd.getPassword();
  String passStr = new String(ch);
  if(passStr.length()==0){
   showMsg("비밀번호를 정확히 입력해주세요");
   t_passwd.requestFocus();
   return;
  }
  /*입력한 아이디및 패스워드가 존재하는지 여부 판단*/
  String sql="select * from admin where adminid=? and adminpasswd=?";
  try {
   pstmt=con.prepareStatement(sql);
   pstmt.setString(1, t_id.getText());
   pstmt.setString(2, passStr);
   
   rs=pstmt.executeQuery();//쿼리수행
   
   if(rs.next()){
    showMsg("로그인되었습니다.");
    this.setVisible(false);//로그인창 가리기..
    
    //책어플리케이션 메인화면 띄우기!!
    new BookApp(this);
    
   }else{
    showMsg("로그인 정보가 올바르지 않습니다.");
   }
  } catch (SQLException e) {
   e.printStackTrace();
  }  
 }
 
 /*================================================================
  * 접속해제 메서드 정의 :
  * ================================================================*/
 public void closeDB(){
  if(rs!=null){
   try {
    rs.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
   try {
    pstmt.close();
   } catch (SQLException e) {  
    e.printStackTrace();
   }   
   try {
    con.close();
   } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
 }
 
 /*버튼 액션 정의*/
 public void actionPerformed(ActionEvent e) {
  loginCheck();
 }

 
 
 
 /*-----------------------------------------------------------------
  * 메세지 출력 전담 메서드 정의
  * 이 메서드를 호출하는 개발자는 표현하고 싶은 메소드를 String형으로 전달하면 됨.
  * -----------------------------------------------------------------*/
 public void showMsg(String msg){
  JOptionPane.showMessageDialog(getParent(), msg);  
 }
 
 public static void main(String[] args) {
  new LoginForm();
 } 
}//end 클래스