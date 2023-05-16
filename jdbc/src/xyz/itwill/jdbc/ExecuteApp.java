package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteApp {
	public static void main(String[] args) throws SQLException {
		/*
		Connection con = ConnectionFactory.getConnection();
		
		Statement stmt = con.createStatement();
		
		String sql1 = "update student set name = '임걱정' where no = 2000";
		
		int rows = stmt.executeUpdate(sql1);
		
		System.out.println("메시지) " + rows + "명의 학생정보를 변경");
		System.out.println("=====================================================================");
		String sql2 = "select * from student order by no";
		
		ResultSet rs = stmt.executeQuery(sql2);
		
		while (rs.next()) {
			System.out.println("학번 = " + rs.getInt("no") + ", 이름 = " + rs.getString("name"));
		}
	
		System.out.println("=====================================================================");
		ConnectionFactory.close(con, stmt, rs);
		*/
		Connection con = ConnectionFactory.getConnection();
		
		Statement stmt = con.createStatement();
		
		int choice = 1;
		String sql = "";
		if (choice == 1) {
			sql = "update student set name = '임걱정' where no = 2000";
		} else {
			sql = "select * from student order by no";
		}
		
		// Statement.execute(String sql) : SQL명령을 전달하여 실행하는 메소드
		// => 전달되어 실행될 SQL 명령이 명확하지 않은 경우 사용되는 메소드 -> boolean 반환
		// => false : DML or DDL 명령실행, true : SELECT 명령실행
		boolean result = stmt.execute(sql);
		
		if(result) {  // SELECT 명령이 실행된 경우
			// Statement.getResultSet() : Statement객체를 사용하여 실행된 SELECT 명령의 
			//      처리결과를 ResultSet객체로 반환하는 메소드
			ResultSet rs = stmt.getResultSet();
			
			while (rs.next()) {
				System.out.println("학번 = " + rs.getInt("no") + ", 이름 = " + rs.getString("name"));
			}
			
			ConnectionFactory.close(con, stmt, rs);
		} else {  // DML or DDL 명령이 실행된 경우
			// Statement.getUpdateCount() : Statement객체를 사용하여 실행된 DML or DDL 명령의 
			//      처리결과를 정수값으 반환하는 메소드
			int rows = stmt.getUpdateCount();
			
			System.out.println("메시지) " + rows + "명의 학생정보를 변경");
			
			ConnectionFactory.close(con, stmt);
		}
		
		
		
	}

}



































