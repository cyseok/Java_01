package _07_xyz.itwill.io_0425;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//파일에 ★저장된 값★을 원시데이터로 제공받아 모니터에 출력
public class FileReaderApp {
	public static void main(String[] args) throws IOException {
		
		FileReader in = null;
		
		try {
			
			// 무조건 예외처리 해야함.
			in = new FileReader("c:/data/char.txt");
		} catch (FileNotFoundException e) {
			System.out.println("error) c:\\data\\char.txt파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		//  OutputStreamWriter out = new OutputStreamWriter(System.out);
		PrintWriter out = new  PrintWriter(System.out);
		
		System.out.println("메시지) c:\\data\\char.txt 파일에 저장된 내용입니다.");
		
		int readByte;
		
		while(true) {
			readByte = in.read();
			
			if(readByte == 1) break;
			
			out.write(readByte);
			out.flush();
		}
		// FileReader.close() : 파일 입력 스트림을 제거하는 메소드
		in.close();
		
		// System.out.println("c:\\data\\char.txt 파일을 확인해 보세요");
	}
}
