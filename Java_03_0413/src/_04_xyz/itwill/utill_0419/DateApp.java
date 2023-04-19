package _04_xyz.itwill.utill_0419;

import java.util.Date;

// Date 클래스 : 날짜와 시간을 저장하고 관련 기능을 메소드로 제공하는 클래스
public class DateApp {
	@SuppressWarnings("deprecation")
	
	public static void main(String[] args) {
		Date now = new Date();
		
		// Date.toString() : Date에 저장된 날짜를 문자열로 반환하는 메소드
		System.out.println("now.toString() " + now.toString());
		System.out.println("now " + now);  // toString()은 자동호출된다.
		
		
		String[] day = {"일", "월", "화", "수", "목", "금", "토"};
		
		
		// getMonth() : 인덱스로 0~11로 출력되기 때문에 +1을 해준다.
		// getDay() : 0~6범위의 정수값이 반환
		String printDate = (now.getYear() + 1900) + "년 " + (now.getMonth() + 1) + "월 " + 
								now.getDate() + "일 " + day[now.getDay()] + "요일";
		System.out.println(printDate);
		
		// getTime() :  Date에 저장된 날짜에 대한 타임스탬프를 반환하는 메소드
		// 타임스탬프 : 1970년 1월 1일을 기준으로 1ms마다 1씩 증가된 정수값
		// => 날짜와 시간을 정수값으로 표현하여 연산하기 위해 사용
		// long currentTime = now.getTime();
		long currentTime =System.currentTimeMillis();
		System.out.println(currentTime);
		
		Date wantDate = new Date(100, 0, 1);
		System.out.println(wantDate);
		
		long wantTime = wantDate.getTime();
		System.out.println("일 " + (currentTime - wantTime) / (1000 * 86400));
		
	}

}












































