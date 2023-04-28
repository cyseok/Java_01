package _08_xyz.itwill.net_0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SQLOutputImpl;

// 채팅서버 프로그램 -> 다중 스레드 프로그램
// => 클라이언트에서 보내온 메시지를 전달받아 접속된 모든 클라이언트에게 전달하는 기능
// => 클라이언트와 연결된 소켓은 새로운 스레드를 생성하여 독립적으로 입출력되도록 설정

public class ChatServerApp {
	
	// 현재 접속중인 모든 클라이언트 소켓정보를 저장하기 위한 List 객체 저장 필드
	private List<SocketThread> clientList;
	
	public ChatServerApp() {
		ServerSocket chatServer = null;
		
		try {
			// 포트를 활성화하여 클라이언트가 접속할 수 있는 환경 제공
			 chatServer = new ServerSocket(5000);
			 System.out.println("메시지) 채팅서버 동작중...");
			 
			 
			 // ArrayList 객체를 필드에 저장 
			 clientList = new ArrayList<>();
			 
			 
			 
			  while(true) {
				  
				  try {
				  // 클라이언트가 접속되면 클라이언트와 연결된 Socket 객체를저장
				  Socket socket = chatServer.accept();
				  
				  System.out.println("접속로그) " + socket.getInetAddress().getHostAddress()
						  + "의 컴퓨터에서 서버에 접속하였습니다.");
				  
				  // 클라이언트와 연결된 객체가 저장된 SocketThread 객체 생성
				  // => Thread 클래스를 상속받은 스레드 클래스
				  SocketThread socketThread = new SocketThread(socket);
				  
				  // List 객체의 요소로  SocketThread 객체 추가
				  clientList.add(socketThread);
				  
				  // 스레드 객체를 이용하여 새로운 스레드 생성
				  // => 새로운 스레드는 run() 메소드를 호출하여 명령을 독립적으로 실행 
				  socketThread.start();
				  } catch (IOException e) {
					  System.out.println("error) 클라이언트의 접속관련 문제가 발생");
				}
			  }
			
		} catch (IOException e) {
			System.out.println("error) 서버가 정상적으로 동작되지 않았습니다.");
		}
		
	}
	//=====================================================================================
	
	
	public static void main(String[] args) {
		
		new ChatServerApp();
		
	}
	
	
	// 현재 접속중인 모든 클라이언트에게 메시지를 전달하는 메소드
	public void sendMessage(String message) {
		
		// List 객체에 저장된 요소(SocketThread)를 차례대로 제공받아 반복
		for(SocketThread socketThread : clientList) {
			
			// SocketThread 객체의 out 필드에 저장된 출력스트림을 사용하여 메시지 전달
			// => ★외부클래스는 내부클래스로 객체를 생성하여 접근제한자에 상관없이 필드와 메소드 접근 가능
			socketThread.out.println(message);
			
			
		}
		
	}
	
	
	//======================================================================================
	
	// 클라이언트와 연결된 소켓을 이용하여 '입출력 기능을 제공'하는 스레드 클래스
	// => 독립적인 입출력 기능을 제공하기 위해 새로운 스레드를 생성하여 명령을 실행하도록
	//    Thread 클래스를 상속받아  run() 메소드를 오버라이드 선언
	public class SocketThread extends Thread {
		
		private Socket clinet;
		
		// 클라이언트에서 보내온 메시지를 읽기 위한 입력 스트림을 저장하기 위한 필드
		private BufferedReader in;
		
		// 클라이언트에서 메시지를 보내기 위한 출력스트림을 저장하기 위한 필드
		private PrintWriter out;
		
		public SocketThread(Socket client) {
			this.clinet = client;
			
		}
		
		//================================================================================
		
		// 새로운 스레드가 실행할 명령을 작성하기 위한 메소드
		// => 클라이언트에서 보내온 메시지를 전달받아 모든 클라이언트에게 전달하는 명령
		@Override
		public void run() {
			
			// 클라이언트에 대화명을 저장하기 위한 변수 선언
			String aliasName = "";
			try {
			// 소켓의 입력스트림으로 제공받아 대량의 문자데이터를 읽을 수 있는 입력스트림으로 확장
			in = new BufferedReader(new InputStreamReader(clinet.getInputStream()));
			
			// 소켓의 출력스트림을 제공받아 문자열을 전달할 수 있는 출력스트림으로 확장
			// PrintWriter(OutputStream out, boolean autoFlush)의 생성자를 사용하여 PrintWriter 객체에 저장
			// autoFlush 매개변수에 true를 전달하면 버퍼를 사용하지 않고, 무조건 출력스트림으로 데이터 전달.
			out = new PrintWriter(clinet.getOutputStream(), true);
			
			// 클라이언트에서 보내온 대화명을 반환받아 저장
			// => 클라이언트가 대화명을 보내기 전까지 스레드 일시중지.
			aliasName = in.readLine();
			
			// 현재 접속중인 모든 클라이언트에게 입장메시지 전달
			// => ★내부클래스에서는 외부클래스의 필드 또는 메소드 접근 제한자에 상관없이 접근가능
			sendMessage("[" + aliasName + "] 님이 입장 하였습니다.");
			
			// 클라이언트에서 보내온 메시지를 전달받아 현재 접속중인 모든 클라이언트에게 전달
			// => 클라이언트가 접속을 종료할때까지 반복
			// => 클라이언트가 접속을 종료한 경우 IOException 발생
			while(true) {
				sendMessage("[" + aliasName + "]" + in.readLine());
			}
			
			} catch (IOException e) {
				// 클라이언트가 접속을 종료한 경우 실행될 명령작성
				// List 객체에 저장된 요소중 접속중인 클라이언트 정보(SocketThread 객체) 삭제
				clientList.remove(this);
				
				// 현재 접속중인 사용자에게 퇴장 메시지 전달
				sendMessage("[" + aliasName + "] 님이 퇴장 하였습니다.");
				
				System.out.println("해제로그) " + clinet.getInetAddress().getHostAddress() 
						+ "의 연결이 해제되었습니다.");

			}
		}
	}
}

































