package _01_xyz.itwill.jdbc_05_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// SQL 명령을 입력받아 DBMS 서버에 전달하여 실행하고 실행 결과를 출력
// => 1. 키보드로 입력 가능한 SQL 명령은 INSERT, UPDATE, DELETE, SELECT 명령만 가능
// => 2. SQL 명령은 Exit 명령을 입력하기 전까지는 반복적으로 입력받아 실행 -> 대소문자 미구분
// => 3. 입력받은 SQL 명령이 잘못된 경우 Error 메시지 출력

public class SqlMinusApp {
	public static void main(String[] args) throws Exception {
		
		// 키보드로 입력받기 위한 입력스트림 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Connection con = ConnectionFactory.getConnection();
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = null;
		
		System.out.println("SQLminus 프로그램을 실행합니다. (종료 : exit)");
		
		while(true) {
			// 키보드로 SQL 명령을 입력받아 저장
			System.out.println("SQL -> ");
			// 키보드로 입력받은 문자열의 모든 공백을 제거한 후 저장
			String sql = in.readLine().trim();
			
			// 키보드의 입력값이 없는 경우 반복문을 처음부터 다시 실행
			if (sql == null || sql.equals("")) continue;
			
			// 키보드 입력값이 exit인 경우 반복문 종료 = 프로그램 종료
			if(sql.equalsIgnoreCase("exit")) break;
			
			// 입력받은 SQL 명령을 전달하여 실행하고 실행결과를 반환받아 출력
			
			// execute, matadata 이용
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("프로그램 종료.");
		
	}

}
