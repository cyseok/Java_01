package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO(Data Access Object) 클래스 : 저장매체에 행 단위 정보를 삽입, 삭제, 변경, 검색하는
//  기능을 제공하는 클래스
// => 저장매체 : 정보를 행 단위로 저장하여 관리하기 위한 하드웨어 또는 소프트웨어 -> DBMS
// => 인터페이스를 상속받아 작성하는 것을 권장 -> 메소드 작성 규칙 제공 : 유지보수 효율성 증가
// => 싱글톤 디자인 패턴을 적용하여 작성하는 것을 권장 -> 프로그램에 하나의 객체만 제공되는 클래스

// STUDENT 테이블에 행을 삽입, 삭제, 변경, 검색하는 기능의 메소드를 제공하는 클래스
// => 하나의 메소드는 매개변수로 객체를 전달받아 하나의 SQL 명령을 실행하고
//     그 결과를 DBMS서버에 전달하고 Java 객체로 매핑하여 반환
// => ★ JdbcDAO 클래스를 상속받아 DAO 클래스의 메소드에서 JdbcDAO 클래스 메소드 호출 가능
public class StudentDAOImpl extends JdbcDAO implements StudentDAO {
	
	private static StudentDAOImpl _dao;
	
	public StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao = new StudentDAOImpl();
	}
	
	public static StudentDAOImpl getDao() {
		return _dao;
	}
	
	// ★오버라이드
	//====================================================================
	// 학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 개수를 반환하는 메소드
	@Override
	public int insertStudent(UserDTO_1 student) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			con = getConnection();
			
			String sql = "insert into student values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error) insertStudent() 메소드의 SQL 오류 = " + e.getMessage());
			
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//====================================================================
	// 학생정보를 전달받아 STUDENT 테이블에 저장된 정보를 변경하고 변경행 개수를 반환하는 메소드
	@Override
	public int updateStudent(UserDTO_1 student) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			con = getConnection();
			
			String sql = "update student set name=?, phone=?, address=?, birthday=? where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error) updateStudent() 메소드의 SQL 오류 = " + e.getMessage());
			
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//==========================================================================
	// 학번을 전달받아 STUDENT 테이블에 저장된 정보를 삭제하고 삭제행 개수를 반환하는 메소드
	@Override
	public int deleteStudent(int no) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			con = getConnection();
			
			String sql = "delete from student where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error) deleteStudent() 메소드의 SQL 오류 = " + e.getMessage());
			
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//================================================================================
	// 학번을 전달받아  STUDENT 테이블에 저장된 정보를 검색하여 반환하는 메소드
	@Override
	public UserDTO_1 selectStudent(int no) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO_1 student = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from student where no=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			// ResultSet 객체에 저장된 검색행을 Java 객체로 매핑 처리
			if(rs.next()) {  // 검색행이 있는 경우
				student = new UserDTO_1();
				// 처리행의 컬럼값을 반환받아 DTO 객체의 필드값으로 변경
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				
			}
		} catch (SQLException e) {
			System.out.println("error) selectStudent() 메소드의 SQL 오류 = " + e.getMessage());
			
		} finally {
			close(con, pstmt, rs);
		}
		// 검색행이 없는 경우[NULL], 있는경우 DTO 객체 반환 -> 하나의 검색행 반환
		return student;  
		
	}
	
	//================================================================================
	// 이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생 정보 검색
	
	@Override
	public List<UserDTO_1> selectNameStudentList(String name) {
		// TODO Auto-generated method stub
				Connection con=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				List<UserDTO_1> studentList=new ArrayList<>();
				
				try {
					con=getConnection();
					
					String sql="select * from student where name=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, name);
					
					rs=pstmt.executeQuery();
					
					//검색행이 0개 이상인 경우 반복문 사용
					while(rs.next()) {
						//하나의 검색행을 DTO 객체로 매핑 처리
						UserDTO_1 student=new UserDTO_1();
						student.setNo(rs.getInt("no"));
						student.setName(rs.getString("name"));
						student.setPhone(rs.getString("phone"));
						student.setAddress(rs.getString("address"));
						student.setBirthday(rs.getString("birthday").substring(0, 10));
						
						//DTO 객체를 List 객체의 요소로 추가 
						studentList.add(student);
					}
				} catch (SQLException e) {
					System.out.println("[에러]selectNameStudentList() 메소드의 SQL 오류 = "+e.getMessage());
				} finally {
					close(con, pstmt, rs);
				}
				return studentList;
	}
	
	
	//================================================================================
	// STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	@Override
	public List<UserDTO_1> selectAllStudentList() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<UserDTO_1> studentList=new ArrayList<>();
		
		try {
			con=getConnection();
			
			String sql="select * from student order by no";
			pstmt=con.prepareStatement(sql);

			rs=pstmt.executeQuery();
			
			// 검색행이 0개 이상인 경우 반복문 사용
			while(rs.next()) {
				//하나의 검색행을 DTO 객체로 매핑 처리
				UserDTO_1 student = new UserDTO_1();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				
				//DTO 객체를 List 객체의 요소로 추가 
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllStudentList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return studentList;
	}


	

}

