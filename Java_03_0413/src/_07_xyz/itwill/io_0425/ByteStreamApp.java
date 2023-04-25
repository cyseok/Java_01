package _07_xyz.itwill.io_0425;

import java.io.IOException;

// java.io 패키지 : 입력과 출력 관련 클래스가 선언된 패키지

// 스트림 : 값을 전달하기 위한 목적으로 생성된 입력클래스와 출력클래스의 객체
// => 시냇물이 흐르는 모양을 모델링해 값이 한쪽 방향으로만 전달되고 순차적으로 처리됨

// 원시데이터 기반의 스트림(Byte Stream) : 가공되지 않은 원시테이터 전달
// => 값을 1Byte 단위로 입출력
// => InputStream 클래스, OutputStream 클래스가 최상위 클래스로 관계가 설정

// 키보드로 데이터를 입력받아 모니터에 출력
// => EOF(End Of File) : 입력 종료(Ctrl + z) 신호를 입력하면 프로그램 종료
public class ByteStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("메시지) 값을 입력해주세요. (종료 : Ctrl + z)");
		
		// 입력값 저장 변수
		int readByte;
		
		while(true) {
			// System.in : Java 프로그램 개발을 위해 기본적으로 제공되는 키보드 입력스트림
			// => InputStream 클래스를 기반으로 제공되는 입력스트림
			// 키보드를 누르면 키보드의 문자값이 입력스트림으로 전달
			// InputStream.read() : 입력스트림에 존재하는 값을 원시데이터(1Byte)로 읽어 int로 반환하는 메소드
			// => 입력스트림에 값이 없는 경우 스레드는 일지 중지
			// => 입력스트림에 엔터가 입력될 경우 다시 실행
			// => 입력스트림 또는 출력스트림 관련 메소드 IOException 발생
			// => ★★ IOException은 일반 예외이므로 반드시 예외처리 필요
			readByte = System.in.read();
			
		}
		
		
		
		
	}
	

}
























