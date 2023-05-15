package _01_xyz.itwill.jdbc_05_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// Statement 객체 : 현재 접속중인 DBMS 서버에 SQL 명령을 전달하여 실행하기 위한 기능을 제공하는 메소드

// => 장점 : 하나의 Statement 객체를 사용하여 다수의 sql 명령을 전달해 실행 가능하다. 

// => 단점 : SQL 명령에 JAVA 변수값을 포함할 경우 문자열 결합 기능을 사용해야 함.
// => 문자열 결합을 이용할 경우 가독성 및 유지보수 효율성 감소
// => InSQL 해킹 기술에 취약(SQL 명령을 포함시키는 해킹 기술)

public class StatementApp {
	public static void main(String[] args) throws Exception {
		
		// 키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하고 STUDENT 테이블에 저장된
		//  모든 학생정보를 검색하여 출력하는 JDBC 프로그램 작성
		
		// 키보드로 학생정보를 입력받기 위한 입력스트림 작성
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
		
		Connection con = ConnectionFactory.getConnection();
		
		Statement stmt = con.createStatement();
		
		String sql1 = "insert into student values("+no+",'"+name+"','"+phone+"','"+address+"','"+birthday+"')";
		int rows = stmt.executeUpdate(sql1);
		
		System.out.println("결과) " + rows + "명의 학생정보 삽입");
		System.out.println("=========================================================");
		
		String sql2 = "select * from student order by no";
		ResultSet rs = stmt.executeQuery(sql2);
		
		System.out.println("[학생정보 출력]");
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name")
			+", 전화번호 = "+rs.getString("phone")+", 주소 = "+rs.getString("address")
			+", 생년월일 = "+rs.getString("birthday").substring(0, 10));
		}
		System.out.println("=========================================================");
		ConnectionFactory.close(con, stmt, rs);
		
		
		
		
	}

}






























