package _07_xyz.itwill.io_0425;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamApp {
	public static void main(String[] args) throws IOException {
		
		// DataOutputStream 클래스 : OutputStream 객체를 전달받아 
		//        원하는 자료형의 값을 원시데이터로 전달하는 출력스트림 생성 클래스
		DataOutputStream out = new DataOutputStream(new FileOutputStream("c:/data/data.txt"));
	
		// DataOutputStream.writeInt(int v) : 값을 받아 원시데이터로 변환하여 출력스트림으로 전달하는 메소드
		out.writeInt(100);
		
		// DataOutputStream.writeBoolean(boolean v) : 논리값을받아 출력스트림으로 전달
		out.writeBoolean(true);
		
		// DataOutputStream.writeUTF(String str) : 문자열로 전달받아 출력스트림으로 전달 
		out.writeUTF("홍길동");
		
		out.close();
		
		System.out.println("c:\\data\\data.txt 파일을 확인해 보세요.");
		
		// 정리 : DataOutputStream으로 출력했다면 DataInputStream 으로 읽어들여야한다.
		
	
	
	}

}
