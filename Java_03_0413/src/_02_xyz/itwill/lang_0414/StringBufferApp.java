package _02_xyz.itwill.lang_0414;

// StringBuffer 클래스 : 문자열을 저장하기 위한 클래스(문자열들을 직접 조작할 수 있다.)
// => 문자관련 메소드 제공	
// 외로 String 객체는 문자열 조작하기 위한 메소드 제공 X, 결과를 반환만 해준다.
// String 클래스보다 StringBuffer 클래스의 메소드가 문자열 처리 속도가 우수하다

public class StringBufferApp {
	public static void main(String[] args) {
		// StringBuffer 클래스는 new 연산자로 생성자를 호출하여 객체 생성
		StringBuffer sb = new StringBuffer("ABC");
		
		 // 문자열반환 메소드
		System.out.println("sb.toString() = " + sb.toString());
		System.out.println("sb = " + sb);  // toString 생략해도 자동호출된다.
		
		// StringBuffer 객체에 저장된 문자열을 String 객체로 생성하여 저장
		String str = sb.toString();  // ★ StringBuffer 객체가 String 객체로 변환된다.
		System.out.println(str);
		System.out.println("===========================================================");
		
		// append : 문자열에 값을 추가
		// => String 객체에 저장된 문자열에 += 연산자를 사용한 것과 동일함.
		sb.append("DEF");
		System.out.println(sb);
		
		str += "DEF";
		System.out.println(sb);
		System.out.println("===========================================================");
		
		// 형식 : insert(int index, Object o)
		// x번째 문자열에 문자를 추가한다.
		sb.insert(4, "X");
		System.out.println(sb);  //  ABCDXEF
		System.out.println("===========================================================");

		// 문자제거 메소드
		sb.deleteCharAt(2);
		System.out.println(sb);   //  ABDXEF
		System.out.println("===========================================================");
		
		// 지점을 설정해 제거하는 메소드
		sb.delete(4, 6);
		System.out.println(sb);   //  ABDX
		System.out.println("===========================================================");
		
		// 순서가 바뀜(역순)
		sb.reverse();
		System.out.println(sb);  //  XDBA
		System.out.println("===========================================================");
		
		
		
		
		
		
		
		
		
		
	}

}





























