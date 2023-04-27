package _08_xyz.itwill.net_0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트에서 보내온 메시지를 제공받아 출력하는 서버프로그램 작성
public class EchoServerApp {
	
	public static void main(String[] args) {
		
		ServerSocket echoServer = null;
		
		try {
				echoServer = new ServerSocket(3000);
				
				System.out.println("메시지) Echo Server Running...");
				
				while(true) {
					Socket socket = echoServer.accept();
					
					// 소켓의 입력 스트림을 제공받아 대량의 문자데이터를 얻어올 수 있는 입력스트림 확장
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					System.out.println("[" + socket.getInetAddress().getHostAddress() 
							 + "]님이 보내온 메시지 = " + in.readLine());
					
					socket.close();

				}
				
		} catch (IOException e) {
			System.out.println("error) 서버 네트워크 문제");
			
		}
		
	}

}
