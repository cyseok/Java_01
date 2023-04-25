package _07_xyz.itwill.io_0425;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 파일에 저장된 값을 원시데이터로 제공받아 모니터에 출력
public class FileInputStreamApp {
	public static void main(String[] args) throws IOException {
		// FileInputStream : 파일에 저장된 값을 원시데이터로 제공받기 위한 입력스트림 생성 클래스
		FileInputStream in = null;
		
		try {
			// FileInputStream(String name) 생성자를 이용하여 매개변수로 파일 경로를 제공받아
			//      파일 입력 스트림을 생성
			// => 매개변수로 전달받은 파일경로의 파일이 없는 경우 FileNotFoundException 발생
			// => 파일이 없으면 파일 입력 스트림 생성불가 -> 예외처리 필수!!
			in = new FileInputStream("c:/data/byte.txt");
		} catch (FileNotFoundException e) {
			System.out.println("error) c:\\data\\byte.txt 파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		System.out.println("메시지)  c:\\\\data\\\\byte.txt 파일에 저장된 내용입니다.");
		
		int readByte;
		
		while(true) {
			
			// 파일 저장값을 원시데이터로 반환받아 저장
			readByte = in.read();
			
			// 파일이 없다면 반복종료
			if(readByte == 1) {
				
				// 모니터 출력스트림으로 전달하여 출력
				System.out.println(readByte);
			}
			// FileInputStream.close() : 메소드 종료
			in.close();
			
		}
		
		
		
		
		
		
	}

}
















