package _01_xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetCursorApp {
	public static void main(String[] args) throws SQLException {
		
		Connection con = ConnectionFactory.getConnection();
		
		// Connection.createStatement() : 현재 접속중인 DBMS 서버에 SQL 명령을 전달하기위한 메소드
		Statement stmt = con.createStatement();
		
		String sql = "select * from student order by no";
		
		// Statement.executeQuery(String sql) : SELECT 명령을 전달하여 실행하고 결과를 반환하는 메소드
		// => ResultSet 객체에 저장된 모든 검색행을 행 단위로 처리하기 위해 내부적인 커서를 이용
		// => 커서는 다음행으로만 이동 가능하며 커서위치의 처리행 조작 불가능
		ResultSet rs = stmt.executeQuery(sql);
		
		// ResultSet.next() : 커서를 다음 행으로 이동하는 메소드
		// => 처리행이 없는 경우 false 반환, 있는 경우 true 반환
		while (rs.next()) {
			// ResultSet.getRow() : ResultSet 커서가 위치한 처리행의 행번호(RowIndex)를 반환하는 메소드
			// ResultSet.getXXX(String columnLabel) : 커서가 위치한 처리행의 컬럼값을 반환
			System.out.println(rs.getRow() + "행 : 학번 = " + rs.getInt("no") + ", 이름 = " + rs.getString("name"));
		}
		System.out.println("=============================================================================");
		ConnectionFactory.close(con, stmt, rs);
		
		// createStatement(int resultSetType, int resultSetConcurrency) : 현재 접속중인 DBMS 서버에 SQL 명령을 전달하기위한 메소드
		// 1. int resultSetType
		// => 매개변수에는 전달되는 값에 따라 Statement 객체에 의해 생성되는 ResultSet 객체의
		//    커서에 대한 이동 설정 및 커서가 위치한 처리행의 조작 설정 가능
		// resultSetType : ResultSet 커서의 이동 관련 값(ResultSet 인터페이스 상수)을 전달하여 설정
		// -> 인터페이스 상수
		// ResultSet.TYPE_FORWARD_ONLY : 커서는 다음행으로만 이동 가능 (디폴트값) 
		// ResultSet.TYPE_SCROLL_INSENSITIVE : 커서를 자유롭게 이동 가능
		// ResultSet.TYPE_SCROLL_SENSITIVE
		
		// 2. int resultSetConcurrency : 커서가 위치한 처리행의 조작관련 속성값 전달
		// ResultSet.CONCUR_READ_ONLY : 처리행 조작 불가능 (기본값)
		// ResultSet.CONCUR_UPDATE : 처리행 조작 가능
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 0);
		
		sql = "select * from student order by no";
		rs = stmt.executeQuery(sql);
		
		// ResultSet.first() : ResultSet 커서를 첫번째 행으로 이동
		rs.first();
		// ResultSet.last() : 마지막으로 이동
		rs.last();
		// ResultSet.absolute(int row) : 설정한 숫자 행으로 이동
		rs.absolute(2);
		// ResultSet.afterLast() : 커서를 EOF(End Of File)로 이동
		rs.afterLast();
		
		while(rs.previous()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		System.out.println("==============================================================");
		
		// ResultSet.beforeFirst() : 커서를 마지막으로 이동하는 매소드
		rs.beforeFirst();
		
		while(rs.next()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		
		System.out.println("=============================================================================");
		
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		// ResultSet 커서가 위치한 행을 조작하기 취해서는  SELECT 명령에 * 사용불가
		// sql = "select * from student order by no";
		sql = "select no, name, phone, address, bithday from student order by no";
		rs = stmt.executeQuery(sql);
		
		/*
		rs.absolute(2);
		// updateXXX : 커서가 위치한 행의 컬럼값을 변경하는 메소드
		rs.updateString("name", "임걱정");
		// ResultSet.updateRow() : 변경된 컬럼값이 저장된 행을 실제 테이블에 적용하는 메소드
		rs.updateRow();
		*/
		
		/*
		rs.absolute(3);
		
		//ResultSet.moveToInsertRow() : ResultSet 객체에서 ResultSet 커서가 위치한 다음행에
		//새로운 행을 삽입하고 기존행은 다음행으로 차례대로 이동 처리하는 메소드
		rs.moveToInsertRow();
		
		//새롭게 삽입된 행의 컬럼값을 변경
		rs.updateInt("no", 4000);
		rs.updateString("name", "일지매");
		rs.updateString("phone", "010-6715-9081");
		rs.updateString("address", "서울시 종로구");
		rs.updateString("birthday", "2000-12-31");
		
		//ResultSet.insertRow() : ResultSet 객체에서 삽입된 행을 실제 테이블에 적용하여
		//삽입 처리하는 메소드
		rs.insertRow();
		*/
		
		//ResultSet.deleteRow() : ResultSet 객체에서 ResultSet 커서가 위치한 처리행을 삭제
				//하고 실제 테이블에 적용하여 삭제 처리하는 메소드
		rs.deleteRow();
				
		rs.beforeFirst();
		
		while(rs.next()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
				}
						
				System.out.println("==============================================================");
		
		ConnectionFactory.close(con, stmt, rs);
		
		
		
		
	}

}
