package _07_xyz.itwill.io_0425;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//파일에 저장된 값을 원시데이터로 제공받아 모니터에 출력
//=> EOF(End Of File) : 입력 종료(Ctrl + z) 신호를 입력하면 프로그램 종료
public class FileWriteApp {
	public static void main(String[] args) throws IOException {
		System.out.println("메시지) 값을 입력해주세요. (종료 : Ctrl + z)");
		// 입력스트림을 InputStreamReader 클래스의 입력스트림으로 확장
		// => 따라서 원시데이터가 아닌 문자데이터를 입력 받을 수 있음.
		InputStreamReader in = new InputStreamReader(System.in);
		
		
		// FileWriter(String fileName) : 파일에 원시데이터를 전달하기 위한 출력스트림 생성 클래스
		// FileWriter(String fileName) :  생서자를 이용하여 매개변수로 파일 경로를 전달받아 파일 출력 스트림 생성
		// 파일이 없는 경우 FileNotFoundException 발생
		// => 예외처리를 하지않을 경우 파일 경로의 파일을 자동으로 생성하여 출력스트림을 제공해준다.
		// => 파일경로 파일이 있는 경우 덮어씌운다.(Overwrite)
		
		
		FileWriter out = new FileWriter("c:/data/char.txt");
		
		int readByte;
		
		while(true) {
			
			readByte = in.read();
			
			if (readByte == 1) break;
				
			out.write(readByte);
			
		}
		in.close();
		
		System.out.println("c:\\data\\char.txt 파일을 확인해 보세요.");
	}

}

































