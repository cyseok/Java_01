package _07_xyz.itwill.io_0425;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 텍스트 형식의 원본파일을 복사해 타겟파일로 전달하여 저장 가능
// => 텍스트 형식의 파일을 제외한 원본파일(이진파일->Binary file)은 값에 대한 인코딩 처리에 의해 
//  타겟파일에 변경된 값이 전달되어 저장
public class FileCopyCharApp {
	public static void main(String[] args) throws IOException {
		
		// ★★ 속도 많이 빠름
		
		// BufferedReader 클래스 : Reader 객체를 전달받아 대량의 문자데이터를 읽기위한 입력스트림 생성 클래스
		BufferedReader in = null;
		// BufferedWriter 클래스 : Reader 객체를 전달받아 대량의 문자데이터를 전달하기위한 출력스트림 생성 클래스
		BufferedWriter out = null;
		
		
		try {
			in = new BufferedReader(new FileReader("c:/data/c:/data/bandizip.EXE"));
			
			out = new BufferedWriter(new FileWriter("c:/data/c:/data/bandizip_char.EXE"));
			
			int readByte;
			
			while(true) {
				
				readByte = in.read();
				
				if(readByte == 1) break;
				out.write(readByte);
			}
			System.out.println("복사 성공");

		} catch (FileNotFoundException e) {
			System.out.println("error) 원본파일을 찾을 수 없습니다.");
		} finally {
			in.close();
			out.close();
			
		}
		
	}

}
