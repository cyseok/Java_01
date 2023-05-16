package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// PreparedStatement 객체 : 현재 접속중인 DBMS 서버에 SQL명령을 전달해 실행하기 위한 기능제공
// 장점 : inparameter를 사용하여 SQL명령에 Java 변수값을 문자값으로 포함하여 사용 가능
// => inparameter를 사용하여 가독성이 증가, 유지보수 효율성 증가
// => InSQL 해킹 기술을 무효화 처리 -> inparameter로 전달받은 사용자 입력값은 SQL명령에서 무조건 문자값으로 처리됨
// 단점 : 하나의 prepareStatement는 저장된 하나의 SQL 명령만 전달하여 실행 가능

public class PreparedStatementApp {
	
	public static void main(String[] args) throws Exception {
		
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 키보드로 학생정보를 입력받아 저장
		System.out.println("[학생정보 입력]");
		System.out.print("학번 입력 -> ");
		int no = Integer.parseInt(in.readLine());
		System.out.print("이름 입력 -> ");
		String name = in.readLine();
		System.out.print("전화번호 입력 -> ");
		String phone = in.readLine();
		System.out.print("주소 입력 -> ");
		String address = in.readLine();
		System.out.print("생년월일 입력 -> ");
		String birthday = in.readLine();
		System.out.println("=========================================================");
		
		/*
		
		
		// STUDENT 테이블에 키보드로 입력받은 학생정보를 삽입처리
		
		Connection con = ConnectionFactory.getConnection();
		
		// Connection.prepareStatement(String sql) : Connection 객체로부터 SQL 명령이 저장된
		//   prepareStatement 객체를 반환하는 메소드
		// => prepareStatement 객체에 저장되는 SQL 명령에는 [?] (=inparameter)기호 사용가능
		// inparameter : Java 변수값을 제공받아 SQL 명령의 문자값으로 표현하기 위한 기호
		// => 반드시 inparameter에는 Java 변수값을 이용해 완전한 SQL 명령을 완성해야한다.
		String sql1 = "insert into values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql1);
		// PreparedStatement.setXXX(int parameterIndex, XXX value)
		// => inparameter에 Java 변수값을 전달하는 메소드
		// => XXX : Java 자료형
		// => parameterIndex :  inparameter의 위치값 (1부터 1씩 증가)
		// => 반드시 inparameter에는 Java 변수값을 이용해 완전한 SQL 명령을 완성해야한다.
		
		ps.setInt(1, no);
		ps.setString(2, name);
		ps.setString(2, phone);
		ps.setString(2, address);
		ps.setString(2, birthday);
		
		
		// PreparedStatement.executeUpdate() : PreparedStatement 객체에 저장된  DML 명령을 실행하고
		//    조작행 개수를 정수값(int)으로 반환하는 메소드
		int rows = ps.executeUpdate();
		System.out.println("결과) " + rows + "명의 학생정보 삽입");
		System.out.println("=========================================================");
		
		String sql2 = "select * from student order by no";
		
		ps = con.prepareStatement(sql2);
		
		// PreparedStatement.executeQuery() : SELECT 명령을 실행하고 모든 검색행이 
		//     저장된 ResultSet 객체를 반환하는 메소드
		ResultSet rs = ps.executeQuery();
		
		System.out.println("[학생정보 출력]");
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name")
			+", 전화번호 = "+rs.getString("phone")+", 주소 = "+rs.getString("address")
			+", 생년월일 = "+rs.getString("birthday").substring(0, 10));
		}
		System.out.println("=========================================================");
		ConnectionFactory.close(con, ps, rs);
		
		*/
		
		// 키보드로 이름을 입력받아 STUDENT 테이블에 저장된 학생 정보 중 
		//  해당 이름의 학생 정보를 출력하는 JDBC 프로그램
		
		Connection con = ConnectionFactory.getConnection();
		
		String sql1 = "select * from student where name = ? order by no";
		PreparedStatement ps = con.prepareStatement(sql1);
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			do {
				System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name")
				+", 전화번호 = "+rs.getString("phone")+", 주소 = "+rs.getString("address")
				+", 생년월일 = "+rs.getString("birthday").substring(0, 10));
				
			} while (rs.next());
			
		} else {
			System.out.println("검색된 학생 정보가 없습니다.");
		}
		System.out.println("=========================================================");
		ConnectionFactory.close(con, ps, rs);
		
	}

}


























