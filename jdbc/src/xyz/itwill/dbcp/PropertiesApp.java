package xyz.itwill.dbcp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Properties 파일 : 프로그램 실행에 필요한 값을 제공하기 위한 텍스트 파일
// => 확장자 : ~.Properties
// => 프로그램을 변경하지 않고 Properties파일의 내용을 변경 가능
// => 프로그램 유지보수의 효율성 증가
// => Properties 파일에서 제공되는 값은 문자열만 가능
// => Properties 파일에는 영문자, 숫자, 일부 특수문자를 제외한 나머지문자는 유니코드로 변환됨.

// user.Properties 파일에 저장된 값을 출력하는 프로그램
public class PropertiesApp {
	
	public PropertiesApp() throws IOException {
		// Properties 파일을 읽기 위한 입력스트림 생성
		// Properties 파일의 경로를 제공받아 FileInputStream 클래스로 객체 생성
		// => 프로그램 배포시 파일 경로에 문제 발생 가능
		// FileInputStream in = new FileInputStream("src/xyz/itwill/dbcp/user.properties");
		// └> 권장하는 방법은 아님.
				
		// Object.getClass() : 현재 실행중인 클래스에대한 class객체 반환
		// 클래스.class : 클래스 파일을 이용하여 class 객체를 제공받는 방법
		// Class.getClassLoader() : 클래스를 읽어 메모리에 저장된 ClassLoader객체 반환
		// ClassLoader.getResourceAsStream(String name) : 리소스 파일에 대한 입력 스트림을 생성해 반환
		InputStream in = getClass().getClassLoader().
							getResourceAsStream("xyz/itwill/dbcp/user.properties");
		
		
		// Properties 객체(Map 인터페이스의 자식클래스) 생성
		// => Properties 파일의 내용을 저장하기 위한 객체
		Properties properties = new Properties();
		
		// Properties.load(InputStream inStream) : 입력스트림으로 제공 받아
		// 		Properties객체에 entry를 추가하는 메소드
		properties.load(in);
		
		// Properties.get(Object key) : Entry에서 MapKey를 전달받아 MapValue를 반환하는 메소드
		// => MapValue는 Object 객체로 반환되므로 반드시 명시적 형 변환 해야함.
		String id = (String)properties.get("id");
		String password = (String)properties.get("password");
		String name = (String)properties.get("name");
		
		System.out.println("아이디 = " + id );
		System.out.println("비밀번호 = " + password);
		System.out.println("이름 = " + name );
		
	}
	
	public static void main(String[] args) throws IOException {
		new PropertiesApp();
		
	}

}


























