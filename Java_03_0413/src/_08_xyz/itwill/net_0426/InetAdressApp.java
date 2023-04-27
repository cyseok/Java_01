package _08_xyz.itwill.net_0426;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.event.AncestorEvent;

// 네트워크(Network) : 두 대 이상의 컴퓨터에서 값을 송수신하기 위한 기능

// 인터넷(Internet) : 모든 컴퓨터를 연결한 네트워크 통신망
// => TCP/IP 프로토콜

// 프로토콜(protocol) : 인터넷을 사용하기 위한 네트워크 통신규약
// 프로토콜 구조 : 네트워크 계층 -> 인터넷 계층(IP) -> 전송 계층(TCP, UDP) -> 응용계층(FTP, HTTP, SMTP등)
// 호스트(Host) : 네트워크 기능을 사용하는 컴퓨터(프로그램)

// 1. 네트워크 계층 - 이더넷, 라우터, 스위치허브
// => 이더넷(Ethernet) : 호스트에서 사용하기 위한 통신 장비
// => 라우터(Router) : 네트워크 그룹끼리 연결하기 위한 통신 장비
// => 스위치허브(SwitchHub) : 호스트와 호스트, 호스트와 네트워크 그룹을 연결하기 위한 통신 장비

// IP(Internet Protocol) : 인터넷을 사용하기 위한 네트워크 주소(= IP 주소)에 대한 통신규약 -> IPv4, IPv6

// TCP(Transmission Control Protocol) : 연결형 프로토콜(네트워크 기능을 이용한 연결 후 통신 가능)
// => 신뢰할 수 있는 데이터 전송의 통신규약
// => 소켓(Socket) 통신 : 1대1 연결

// UDP(User Datagram  Protocol) : 비연결형 프로토콜(네트워크 기능을 이용한 연결 설정 없이 통신 가능)
// => 신뢰할 수 없는 데이터 전송의 통신규약 -> 사용자 데이터그램 프로토콜
// => 고속통신 : 1대다 연결

// 2. 응용 계층 : 전송 계층을 기반으로 생성된 다수의 프로토콜 -> 응용 프로그램

// IP 주소 : 인터넷을 사용하기 위해 컴퓨터에 부여되는 네트워크 식별자
// => IPv4 : 32Bit를 이용해 IP주소 표현 -> 10진수 0~255 범위의 정수값 4개를 [.]으로 구분하여 표현
// => IPv6 : 128Bit를 이용해 IP주소 표현 -> 16진수 0000~XXXX 범위의 정수값 8개를 [:]로 구분하여 표현
// => 공인 IP주소와 사설 IP주소(A Class : 10.0.0.0~10.255.255.255, 
//     B Class : 172.16.0.0~172.31.255.255, C Class : 192.168.0.0~192.168.255.255) 

// Netmask 주소 : 네트워크 그룹(= Subnet)을 표현하기 위한 주소
// => A Class : 255.0.0.0      = 16,777,216개 사용가능 ->  0.x.x.x ~ 127.x.x.x
// => B Class : 255.255.0.0    = 65,536개 사용가능 ->     128.x.x.x ~ 191.x.x.x
// => C Class : 255.255.255.0  = 256개 사용가능 ->        192.x.x.x ~ 232.x.x.x

// Geteway 주소 : 라우터에 부여된 IP주소

// DNS 서버 : 도메인(호스트 이름)을 IP주소로 변환하는 기능을 제공하는 컴퓨터

// 도메인(Domain) : 인터넷을 사용하기 위해 네트워크 그룹 또는 호스트에게 부여되는 문자로 된 네트워크 식별자
// => 도메인 그룹에 등록되어 있어야 호스트 사용 가능 -> 도메인 호스트 

// 포트번호(Port Number) : 인터넷을 이용하여 데이터를 송수신 하기 위한 고유의 통신 경로
// => 네트워크 프로그램은 반드시 0~ 65535 범위의 포트 중 하나를 사용하여 데이터 전송
// => 0 ~ 1023 : Well-Known Port(HTTP : 80, HTTPS : 443, SMTP : 25, POP3 : 110 등) -> 루트(root) 권한으로만 포트를 열 수 있다
// => 1024 ~ 49151 : 등록된 포트(registered port) - 네트워크 프로그램 작성시 사용 가능한 포트
// => 49152 ~ 65535 : 동적 포트(dynamic port) - 일시적으로 사용하는 임시 포트 -> Private Port

// 패킷(Packet) : 인터넷에서 데이터를 전송하기 위한 단위 -> Java에서는 Byte 배열로 표현 가능

// 방화벽(Firewall) : 네트워크 접속 및 데이터 전송 차단 or 허용을 위한 시스템(프로그램)

public class InetAdressApp {
	
	public static void main(String[] args) throws UnknownHostException {
		
		// InetAddress 클래스 : 네트워크 식별자(IP주소 및 호스트이름)를 저장하는 클래스
		// InetAddress.getLocalHost() : 현재 사용중인 컴퓨터의 네트워크 식별자가 저장된 InetAddress객체를 반환하는 메소드
		// => UnknownHostException 발생(일반예외(반드시 처리)) : 호스트이름의 컴퓨터를 검색할 수 없는 경우 발행되는 예외
		// 현재 사용중인 컴퓨터는 기본적으로 [124.0.0.1]의 IP주소가 제공되고 [localhost]라는 호스트이름으로 설정
		InetAddress myComputer = InetAddress.getLocalHost();
		
		// InetAddress.toString() : InetAddress 객체에 저장된 네트워크 식별자를 문자열로 반환
		System.out.println("myComputer = " + myComputer);
		
		// InetAddress.getHostName() : InetAddress 객체에 저장된 네트워크 식별자의 호스트이름을 문자열로 반환
		System.out.println("myComputer = " + myComputer.getHostName());
		
		// InetAddress.getHostAddress() : InetAddress 객체에 저장된 네트워크 식별자의 IP주소를 문자열로 반환
		System.out.println("myComputer = " + myComputer.getHostAddress());
		System.out.println("==========================================================================");
		
		// InetAddress.getByName(String host) : 매개변수로 전달받은 호스트이름에 대한 네트워크 식별자가 저장된
		//         InetAddress 객체를 반환하는 메소드
		InetAddress itwill = InetAddress.getByName("www.itwill.xyz");
		
		System.out.println("[www.itiwll.xyz]의 IP주소 = " + itwill.getHostAddress());
		System.out.println("==========================================================================");
		
		// InetAddress.getAllByName(String host) : 호스트이름에 대한 네트워크 식별자가 저장된 InetAddress객체의 배열을 반환
		InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
		
		for(InetAddress address : naver) {
			System.out.println("[www.naver.com]의 IP주소 = " + address.getHostAddress());
		}
		System.out.println("==========================================================================");
		
		
		
		
		
		
		
		
		
		
		
	}

}





























































