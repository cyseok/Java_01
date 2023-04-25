package _07_xyz.itwill.io_0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

// 키보드로 이름과 태어난 년도를 입력받아 이름과 나이를 계산하여 출력

public class ConsoleIOApp {
	public static void main(String[] args) throws IOException {
		// Java 프로그램 개발을 위해 기본적으로 제공되는 입력스트림을 사용하여
		//  InputStreamReader 클래스의 입력스트림으로 확장하고 확장된 Reader 객체를 전달받아
		// BufferedReader 클래스의 입력스트림으로 확장하여 대량의 문자데이터를 입력받을 수 있도록 함 
		// => 입출력 클래스는 스트림의 다단계 연결을 사용하여 스트림 확장 가능
		// 키보드로 문자열을 입력받기 위한 입력 스트림 생성
		
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		
		// Java 프로그램 개발을 위해 기본적으로 제공되는 모니터 출력스트림(System.out)은
		// PrintStream 클래스로 생성되어 print() 또는 println 메소드를 출력하여 출력가능
		System.out.println("이름입력 -> ");
		
		// BufferedReader.readLine() : 대량의 문자데이터를 읽어 문자열로 반환
		String name = in.readLine();
		
		System.out.println("출생년도 입력 -> ");
		// NumberFormatException 발생
		int birthYear = Integer.parseInt(in.readLine());

		int age = Calendar.getInstance().get(Calendar.YEAR) - birthYear+1;
		System.out.println(name + "님의 나이는 " + age + "살입니다.");
		
	}

}
