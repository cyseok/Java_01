package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMataDataApp {
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		
		Statement stmt = con.createStatement();
		
		String sql = "select * from student order by no";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println("학번 = " + rs.getInt("no") + ", 이름 = " + rs.getString("name"));
		}
		System.out.println("===================================================================");
		// ResultSet.getMetaData() : 검색행(ResultSet)에 대한 부가적인 정보가 저장된 객체를 반환하는 메소드
		ResultSetMetaData rsmd = rs.getMetaData();
		
		// ResultSetMetaData.getColumnCount() : 검색행의 컬럼 개수를 반환하는 메소드
		int columnCount = rsmd.getColumnCount();
		System.out.println("검색행의 컬럼 개수 = " + columnCount);
		System.out.println("===================================================================");
		for (int i = 1; i <= columnCount; i++) {  // 검색대상의 개수만큼 반복처리
			// ResultSetMetaData.getColumnLabel(int columnIndex) : 첨자위치의 컬럼명 반환 
			String columnLabel = rsmd.getColumnLabel(i);
			
			// ResultSetMetaData.isNullable(int column : 첨자위치 컬럼에대한 NULL 허용 유무값(0,1) 반환 메소드
			int isNull = rsmd.isNullable(i);
			String nullResult = "NULL";
			
			// ResultSetMetaData.columnNoNulls : NULL을 허용하지 않는 상수 = 0
			if(isNull == ResultSetMetaData.columnNoNulls) {
				nullResult = "NOT NOLL";
			}
			
			// ResultSetMetaData.getColumnTypeName(int column) : 첨자위치 컬럼에 대한 오라클 자료형 반환 메소드
			String columnTypeName = rsmd.getColumnTypeName(i);
			
			// getColumnDisplaySize(int column) : 첨자위치 컬럼에 대한 출력 크기를 반환하는 메소드
			int columnDisplaySize = rsmd.getColumnDisplaySize(i);
			
			System.out.println("컬럼명 = " + columnLabel);
			System.out.println("NULL 허용 유무 = " + nullResult);
			System.out.println("컬럼의 자료형 = " + columnTypeName);
			System.out.println("컬럼의 출력크기 = " + columnDisplaySize);
			System.out.println("===================================================================");
		}
		
		ConnectionFactory.close(con, stmt, rs);
		
	}

}
