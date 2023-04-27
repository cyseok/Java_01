package _08_xyz.itwill.net_0426;

import java.io.IOException;
import java.net.ServerSocket;

// TCP 프로그램 : ServerSocket 클래스와 Socket 클래스를 이용하여 작성
// => 서버와 클라이언트가 소켓을 사용하여 1대1로 연결되어 데이터를 송수신하는 네트워크 프로그램

// 서버(Server) : 외부의 컴퓨터(클라이언트)가 '접속할 수 있는 환경'과 서비스를 제공하기위한 컴퓨터
// => ServerSocket 클래스를 사용하여 서버 프로그램 작성

// 클라이언트(Client) : 서버에 접속하여 서비를 제공받는 컴퓨터
// => Socket클래스를 사용하여 클라이언트 프로그램 작성

 // ServerSocket 클래스를 사용하여 사용가능한 포트번호를 검색하는 프로그램
public class ServerSocketApp {
	public static void main(String[] args) {
		
		for(int i = 2000; i < 9000; i += 1000) {
			try {
				
				// ServerSocket 클래스 : 서버 프로그램을 작성하기 위해 사용하는 클래스
				// => ServerSocket 클래스의 ServerSocket(int port) 생성자를 이용하여 매개변수로
				//    전달받은 포트번호를 활성화하여 ServerSocket객체 생성
				// => ServerSocket 객체를 생성하여 클라이언트가 접속할 수 있는 환경 제공
				// => 매개변수로 전달받은 포트번호를 이미 다른 네트워크 프로그램이 사용중인 경우 IOException 발생
				
				ServerSocket serverSocket = new ServerSocket(i);
			
				System.out.println("메시지)" + i + "번 포트는 네트워크 프로그램에서 사용가능");
				
				// ServerSocket.close() : ServerSocket객체를 제거하는 메소드
				// => 클라이언트가 접속할 수 있는 환경 소멸
				serverSocket.close();
			} catch(IOException e) {
				System.out.println("메시지)" + i + "번 포트는 이미 다른 네트워크 프로그램에서 사용중");
				
			}
		}
	}

}
