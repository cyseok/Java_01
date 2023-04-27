package _08_xyz.itwill.net_0426;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

// NTP 서버에 접속하여 서버에서 보내온 날짜와 시간을 제공받아 출력하는 클라이언트 프로그램
public class TimeClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		
		try {
			// Socket 클래스 : TCP 프로그램에서 다른 컴퓨터와의 연결을 위한 정보를 저장하는 클래스
			// => 다른 컴퓨터의 소켓과 연결되어 값을 송수신할 수 있는 입출력 스트림 제공
			// => Socket 클래스의 Socket(String host, int port) 생성자를 이용하여 매개변수에 
			//     ★접속 컴퓨터의 네트워크 식별자와 활성화된 포트번호를 전달하여 Socket 객체 생성 -> 서버 접속
			//            └-> 서버         └-> 호스트이름 or IP 주소
			
			// UnknownHostException 및 IOException 발생 -> 일반 예외이므로 반드시 예외처리
			Socket socket = new Socket("192.168.1.73", 2000);
			
			// System.out.println("socket = " + socket);
			//=======================================================================
			
			// Socket.getInputStream() : socket 객체의 입력스트림(InputStream 객체)을 반환하는 메소드
			InputStream stream = socket.getInputStream();
			
			// InputStream 객체를 전달받아 객체를 받을 수 있는 입력스트림으로 확장
			ObjectInputStream in = new ObjectInputStream(stream);
			
			// 입력 스트림을 이용하여 서버에서 보내온 Date 객체를 저장
			Date date = (Date)in.readObject();
			
			// Date 객체에 저장된 날짜와 시간을 원하는 형식의 문자열로 변환하여 출력
			System.out.println("결과) 서버에서 보내온 날짜와 시간 = " 
			+ new SimpleDateFormat("yyyy년 MM월 dd알 HH시 mm분 ss초").format(date));
			
			
			//===================================================================
			// socket.close(); : Socket 객체를 제거하는 메소드 -> 접속 해제
			socket.close();
			
		} catch (UnknownHostException e) {
			System.out.println("error) 서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("error) 서버에 접속 할 수 없습니다.");
			
		}
	}

}
