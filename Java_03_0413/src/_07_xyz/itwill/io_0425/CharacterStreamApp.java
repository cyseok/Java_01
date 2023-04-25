package _07_xyz.itwill.io_0425;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// 문자데이터 기반의 스트림(CharacterStream) : 원시데이터를 가공처리 한 문자데이터를 전달하기위한 출력 스트림
// => 원시데이터를 가공하여 문자데이터(2Byte)로 변환 -> 인코딩(문자형태 - CharSet)
// 값을 2Byte 단위로 입출력하는 스트림

// => InputStream 클래스와 OutputStream 클래스를 최상위 클래스로 설정된 클래스

// 키보드로 원시데이터(1Byte)를 입력받아 출력하는프로그램 작성
// => EOF(End Of File) (입력종료 - Ctrl + z) : 프로그램 종료


public class CharacterStreamApp {
	public static void main(String[] args) throws IOException {
		
	System.out.println("메시지) 값을 입력해주세요. (종료 : Ctrl + z)");
		
	// InputStreamReader 클래스 : InputStream 객체를 전달받아 문자데이터를 입력받기 위한
	//    입력스트림(Reader객체)을 생성하기 위한 클래스
	InputStreamReader in = new InputStreamReader(System.in);
	
	// OutputStreamWriter 클래스 : OutputStream 객체를 전달받아 문자데이터를 출력하기 위한
	//    출력스트림(write 객체)을 생성하기 위한 클래스
	// OutputStreamWriter out = new OutputStreamWriter(System.out);
	
	// PrintWriter 클래스 : OutputStream 객체를 전달받아 문자데이터를 출력하기 위한 
	//     출력스트림(write 객체)을 생성하기 위한 클래스
	// => OutputStream 객체보다 많은 출력 메소드 제공
	PrintWriter out = new PrintWriter(System.out);
	
	int readByte;
	
	while(true) {
		// Reader.read() : 입력스트림에 존재하는 값(2Byte)을 읽어 정수값으로 반환
		readByte = in.read();
		
		if(readByte == -1) break;
		
		// Write.write : 매개변수로 제공받은 값을 문자데이터(2Byte)로 전달
		// => 문자데이터는 출력버퍼에 일정한 크기만큼 저장하고 있다가 
		//     한번에 출력 스트림으로 전달해 처리한다.
		out.write(readByte);
		// System.out.write(readByte);
		
		// Write.flush() : 출력스트림의 버퍼에 존재하는 모든 값을 출력스트림으로 전달
		out.flush();
		
		
	}
	System.out.println("종료");
	
	
	
	}

}
