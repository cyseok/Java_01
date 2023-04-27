package _08_xyz.itwill.net_0426;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.stream.Stream;

// NTP(Network Time Protocol) Server : 날짜와 시간을 제공하는 서버 컴퓨터


// 접속된 클라이언트에게 서버 컴퓨터의 현재 날짜와 시간을 전달하는 서버프로그램 작성
public class TimeServerApp {
	
	public static void main(String[] args) {
		 ServerSocket ntpServer = null;
		 
		 try {
			 // ServerSocket 객체 생성 : 포트를 활성화하려 클라이언트가 접속할 수 있는 환경 제공
			 ntpServer = new ServerSocket(2000);
			 
			 // ServerSocket.toString() : ServerSocket 객체에 저장된 접속 관련 정보를 문자열로 반환
			 System.out.println("ntpServer = " + ntpServer);
			 // => ServerSocket[addr=0.0.0.0/0.0.0.0,localport=2000]
			 
			 System.out.println("메시지) NTP Server Running...");
			 
			 while(true) {  // 다수의 클라이언트가 접속할 수 있도록 무한루프 생성
				 
				 // ★★ ServerSocket.accept() : 클라이언트의 접속되면 클라이언트에 값을 주고 받는 Socker 객체를 반환
				 // => 클라이언트가 접속되기 전까지 스레드는 일시 중지 되고 클라이언트가 접속시
				 //     클라이언트의 소켓과 연결될 소켓을 생성해 반환하고 스레드 재실행 
				 Socket socket = ntpServer.accept();
				 
				// System.out.println("socket = " + socket);
				 
				 //======================================================================================
				 /*
				 //-------------------------------------------------------
				 // Socket.getOutputStream() : 소켓 객체에 저장된 출력스트림(OutputStream)을 반환하는 메소드
				 OutputStream out = socket.getOutputStream();
				 
				 // OutputStream 객체를 전달받아 객체를 전달할 수 있는 출력스트림으로 확장한 것
				 ObjectOutputStream out2 = new ObjectOutputStream(out);
				 
				 // 출력스트림을 이용하여 시스템의 현재 날짜와 시간이 저장된 Date 객체를 생성하여 전달
				 // => 클라이언트에게 날짜와 시간정보를 전송해줌.
				 out2.writeObject(new Date());
				 */
				 
				 //-------------------------------------------------------
				 
				 // 위 3줄의 식별자 대신에 한번에 작성하면 좋다
				 new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				 
				 
				 //======================================================================================
				 
				 // 로그 처리 -> 기록
				 // Socket.getInetAddress() : 서버의 소켓과 연결된 외부 컴퓨터의 네트워크 식별자가 저장된 
				 //                            InetAddress객체를 반환하는 메소드
				 System.out.println("정보) 클라이언트[" + socket.getInetAddress().getHostAddress() + "]에게 날짜와 시간을 제공");
				 
				 // 클라이언트와의 접속 해체
				 socket.close();
			 }
		 } catch (IOException e) {
			System.out.println("error) 서버 네트워크에 문제가 발생되었습니다.");
		}
		 
		 
		 
	}
	
}




















