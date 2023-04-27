package _08_xyz.itwill.net_0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// UDP 프로그램 : DatagramSocket 클래스와 DatagramPacket 클래스를 이용하여 작성
// => 값을 전달하는 컴퓨터와 값을 전달받는 컴퓨터로 구분하여 처리

// 메시지를 입력받아 다른 컴퓨터에게 전달하는 UDP프로그램

public class MessageSendApp {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("전달 메시지 입력 -> ");
		
		String message = in.readLine();
		
		// DatagramSocket : 다른 컴퓨터와 연결하기 위한 정보를 저장하는 클래스
		// => 데이터를 보내는 컴퓨터는 기본생성자를 사용해 DatagramSocket객체 생성
		DatagramSocket socket = new DatagramSocket();
		
		// 연결할 컴퓨터의 네트워크 식별자가 저장된 InetAddress 객체를 반환받아 저장
		InetAddress address = InetAddress.getByName("192.163.13.26");
		
		// String.getBytes() : String 객체의 저장된 문자열을 byte배열로 변환하여 반환
		byte[] data = message.getBytes();
		
		// DatagramPacket : 연결 컴퓨터에게 보낼 패킷정보를 저장하는 클래스
		// => DatagramPacket : DatagramPacket(byte[] buf, int length, InetAddress address, int port)
		//    의 생성자를 사용하여 데이터를 보내기 위한 패킷정도가 저장된 DatagramPacket 객체 생성
		DatagramPacket packet = new DatagramPacket(data, data.length, address, 4000);
		
		// DatagramSocket.send(DatagramPacket p) : 매개변수로 전달 받은 DatagramSocket의 객체정보를 이용하여
		//   패킷을 전달하는 메소드
		socket.send(packet);
		
		// DatagramSocket.close() : DatagramSocket 객체를 제거하는 메소드
		socket.close();
		
		System.out.println("결과) 연결 컴퓨터에게 메시지를 보냈습니다.");
		
		
		
		
		
	}
}






































