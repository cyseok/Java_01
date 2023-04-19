package _04_xyz.itwill.utill_0419;

import java.util.Calendar;

// Calender 클래스 : 날짜와 시간을 저장하고 저장된 날짜와 시간관련 기능 제공 클래스

public class CalenderApp {
	public static void main(String[] args) {
	// Calendar calendar = new Calendar();  -> 숨겨져있어 생성불가
	Calendar calendar = Calendar.getInstance();
	
	// System.out.println("calendar.toString() = " + calendar.toString());
	System.out.println("calendar = " + calendar);
	
	String[] day = {"일", "월", "화", "수", "목", "금", "토"};
	
	// Calendar 객체에 저장된 날짜와 시간에서 Calendar클래스의 상수에 대한 값을 반환
	// 월에는 +1, 요일에는 -1 을 꼭해줘야한다
	// => 월은 0~11, 요일은 1(일)~7(토)이기 때문
	String printDate = calendar.get(Calendar.YEAR) + "년 " + (calendar.get(Calendar.MONTH) +1
			 + "월 " + calendar.get(Calendar.DATE) + "일 " + day[calendar.get(Calendar.DAY_OF_WEEK)- 1 ] + "요일 "
			 + calendar.get(Calendar.HOUR) + "시 " + calendar.get(Calendar.MINUTE) + "분");
	System.out.println("현재 날짜 = " + printDate);
	
	}

}
















































