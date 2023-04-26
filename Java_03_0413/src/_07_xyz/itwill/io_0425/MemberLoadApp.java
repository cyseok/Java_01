package _07_xyz.itwill.io_0425;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

// 파일에 저장된 회원정보(Member 객체)를 제공받아 출력

public class MemberLoadApp {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:/data/membet.txt"));
		
		System.out.println("[회원목록]");
		
		while(true) {
			
			try {
			// ObjectInputStream.readObject() 메소드 호출시 파일커서가 EOF위치에 있는 경우 EOFException 발생
			Member member = (Member)in.readObject();
			
			
			System.out.println(member);
			
			} catch (EOFException e) {
				
				break;
			}
			
		}
		
		in.close();
	}

}
