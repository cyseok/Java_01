package _07_xyz.itwill.io_0425;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamApp {
	public static void main(String[] args) throws IOException {
		
		// DataInputStream : InputStream 객체를 전달받아 원하는 자료형의 값으로 변환하여 제공하는 기능의 입력스트림 생성 클래스
		
		DataInputStream in = new DataInputStream(new FileInputStream("c:/data/data.txt"));
		
		// 반드시 파일에 저장된 자료형의 순서대로 값을 읽어서 사용
		
		// DataInputStream.readInt() : 입력스트림으로 원시데이터를 읽어 정수값으로 반환
		int value1 = in.readInt();
		
		// DataInputStream.readBoolean() : 입력스트림으로 원시데이터를 읽어 논리값으로 반환
		boolean value2 = in.readBoolean();
		
		// DataInputStream.readUTF() : 입력스트림으로 원시데이터를 읽어문자열로 반환
		String value3 = in.readUTF();
		
		System.out.println("value1 = " + value1);
		System.out.println("value2 = " + value2);
		System.out.println("value3 = " + value3);
		
		in.close();
		
		
		
	}

}
