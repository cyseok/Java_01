package _06_xyz.itwill.swing_0424;

import java.io.FileOutputStream;
import java.io.IOException;

// 키보드로 입력된 값을 원시데이터로 제공받아 파일로 전달하여 저장하는 프로그램 작성
//=> EOF(End Of File) : 입력 종료(Ctrl + z) 신호를 입력하면 프로그램 종료
// 
public class FileOutputStreamApp {
	public static void main(String[] args) throws IOException {
		
		System.out.println("메시지) 값을 입력해주세요. (종료 : Ctrl + z)");
		
		// FileOutputStream(String name) : 파일에 원시데이터를 전달하기 위한 출력스트림 생성 클래스
		// FileOutputStream(String name) 생서자를 이용하여 매개변수로 파일 경로를 전달받아 파일 출력 스트림 생성
		// 파일이 없는 경우 FileNotFoundException 발생
		// => 예외처리를 하지않을 경우 파일 경로의 파일을 자동으로 생성하여 출력스트림을 제공해준다.
		// => 파일경로 파일이 있는 경우 덮어씌운다.(Overwrite)
		
		// => FileOutputStream(String name, boolean append) : 내용 추가에 대한 상태값을 전달받음
		// => false : 덮어씌우기(기본값), true : 파일내용 이어서 쓰기
		FileOutputStream out = new FileOutputStream("c:/data/byte.txt");
		
		int readByte;
		
		while(true) {
			// 입력값을 원시데이터로 반환받아 저장
			readByte = System.in.read();
			
			if(readByte == 1) break;
			
			// 파일 출력 스트림으로 원시데이터를 전달받아 저장 -> save
			out.write(readByte);
		}
		// ★★★ FileOutputStream.close() : 출력스트림 제거
		// => 파일에는 입출력스트림이 하나씩만 생성 가능하기 때문에 꼭 제거해준다.
		out.close();
	
		
		System.out.println("c:\\data\\byte.txt 파일을 확인해 보세요.");
		
	}

}





















