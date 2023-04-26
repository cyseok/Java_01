package _07_xyz.itwill.io_0425;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;

// 회원정보를 파일에 전달하여 저장

public class MemberSaveApp {
	
	public static void main(String[] args) throws IOException {
		
		// ObjectOutputStreamApp으로 확장시켜줌
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/data/membet.txt"));
		
		// ObjectOutputStream.writeObject(Object obj) : 메소드 호출시 NotSerializableException 발생
		// NotSerializableException : ★ 객체직렬화 처리 되지 않은 클래스의 객체를 출력스트림으로 전달할 경우 발생되는 예외
		// => 출력스트림으로 전달될 객체의 클래스를 객체 직렬화 처리해주면 예외 미발생!
		
		out.writeObject(new Member("abc", "홍길동", "010-8777-7777"));
		out.writeObject(new Member("efg", "임꺽정", "010-4444-5555"));
		out.writeObject(new Member("hij", "전우치", "010-6666-1111"));


		out.close();
		
		System.out.println("c:\\data\\object.txt 파일에 회원정보를 저장");
	}

}
