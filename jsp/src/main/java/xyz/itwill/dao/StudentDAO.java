package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import xyz.itwill.dto.StudentDTO;

// ★★★
// jdbc 연동하기 전에 webapp -> WEB-INF -> lib -> ojdbc11.jar 파일 넣기
// jdbc 연동하기 전에 webapp -> META-INF -> context.xml 파일 넣기
// JdbcDAO 클래스 가져오기

// STUDENT 테이블에 행을 삽입, 삭제, 변경, 검색하기 위한 기능의 클래스

public class StudentDAO extends JdbcDAO {
	
	private static StudentDAO _dao;
	
	public StudentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao = new StudentDAO();
	}
	
	public static StudentDAO getDAO() {
		return _dao;
	}
	
	// 학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertStudent(StudentDTO student) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			con = getConnection();
			
			String sql = "insert into student values(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			// 객체에 결과값을 담을 수 있다.
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[error] insertStudent 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	//=============================================================================================
	// 학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateStudent(StudentDTO student) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			con = getConnection();
			
			String sql = "update student set name=?, phone=?, address=?, birthday=? where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getPhone());
			pstmt.setString(2, student.getAddress());
			pstmt.setString(3, student.getBirthday());
			pstmt.setInt(4, student.getNo());
			
			// 객체에 결과값을 담을 수 있다.
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[error] updateStudent 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	//=============================================================================================
	// 학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteStudent(int no) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			con = getConnection();
			
			String sql="delete from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			// 객체에 결과값을 담을 수 있다.
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[error] updateStudent 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	//=============================================================================================
	// 학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 검색하여 DTO 객체로 반환하는 메소드
	public StudentDTO selectStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		// 그냥 저장된 행이라 리스트 객체로 할 필요 없다.
		StudentDTO student=null;
		
		try {
			con=getConnection();
			
			String sql="select * from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return student;
	}
	

	
	//=============================================================================================
	// STUDENT 테이블에 저장된 모든 학생정보를 검색하여 List 객체로 반환하는 메소드
	public List<StudentDTO> selectStudentList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<StudentDTO> studentList = new ArrayList<>();
		
		try {
			con = getConnection();
			
			String sql = "select * from student order by no desc";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//ResultSet 커서 위치의 행을 DTO 객체로 표현
				// => ResultSet 커서 위치의 행에 대한 컬럼값은 DTO 객체의 필드에 매핑하여 저장
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				
				// ★★List 객체에 DTO 객체를 요소로 추가
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectStudentList 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return studentList;

	}
}
