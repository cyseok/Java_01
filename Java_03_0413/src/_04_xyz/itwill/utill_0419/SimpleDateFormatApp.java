package _04_xyz.itwill.utill_0419;

import java.text.SimpleDateFormat;
import java.util.Date;

// java.text 패키지 : 값을 변환하는 기능을 제공하는 클래스

// SimpleDateFormat 클래스 : Date 객체와 String 객체를 서로 변환

public class SimpleDateFormatApp {
	public static void main(String[] args) {
		Date now = new Date();
		
		// SimpleDateFormat 클래스로 객체를 생성하기 위한 변수에 Date에 대한 패턴정보를 이용
		// => 객체를 생성하기 위해 생성자를 사용
		// => 패턴정보 : 패턴문자(날짜와 시간을 임의의 문자로 표현)를 사용하여 표현된 문자열
		// => 패턴문자 : y(년), M(월), d(일), E(요일), h(12시간), H(24시간), AM or PM,  m(분), s(초)
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		
		// dateFormat.format() : Date객체에 저장된 정보를 SimpleDateFormat의 패턴정도를 사용해 문자열로 반환
		String printDate = dateFormat.format(now);
		
		System.out.println("현재 날짜 = " + printDate);
		
		// 패턴정보를 변경
		dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("현재 = " + dateFormat.format(now));
		
		
		
	}

}










































