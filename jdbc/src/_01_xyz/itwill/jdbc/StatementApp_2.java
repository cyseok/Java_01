package _01_xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// 이름을 입력받아 STUDENT 테이블에 저장된 학생정보 중 
//  해당 이름의 학생정보를 출력하는 JDBC프로그램

public class StatementApp_2 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("[학생정보 입력]");
		System.out.print("이름 입력 -> ");
		String name = in.readLine();
		
		System.out.println("=========================================================");
		
		Connection con = ConnectionFactory.getConnection();
		
		Statement stmt = con.createStatement();
		
		String sql1 = "select * from student where name = '"+name+"' order by no";
		ResultSet rs = stmt.executeQuery(sql1);
		System.out.println("결과) ");
		
		if(rs.next()) {
			
			do {
				System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name")
				+", 전화번호 = "+rs.getString("phone")+", 주소 = "+rs.getString("address")
				+", 생년월일 = "+rs.getString("birthday").substring(0, 10));
				
			} while (rs.next());
			
		} else {
			System.out.println("검색된 학생 정보가 없습니다.");
		}
		
		
	}

}
