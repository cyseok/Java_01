package _Yunseok_practice;

import java.util.Calendar;
import java.util.Scanner;

public class _0419_C {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("년 -> ");
		
		
		Calendar calendar = Calendar.getInstance();
		
		// 객체에 날짜와 시간중 일을 1일로 변경
		// calendar.set(Calendar.DATE, 1);  : 날짜와 시간중 원하는 대상을 변경하는 메소드
		calendar.set(Calendar.DATE, 1);
		
		// Calendar 객체에 저장된 날짜와 시간중 요일을 반환받아 저장
		 int week = calendar.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("            " + calendar.get(Calendar.YEAR) + "년 " 
	            	+ (calendar.get(Calendar.MONTH) +1) + "월");
		System.out.println("===================================="); 
		System.out.println("   일   월   화   수   목   금   토"); 
		System.out.println("===================================="); 
		
		for(int i = 1; i < week; i++) {
			System.out.print("     ");
		}
		
		// getActualMaximum : 날짜와 시간의 최대값을 반환하는 메소드
		for(int i = 1; i <= calendar.getActualMaximum(Calendar.DATE); i++) {
			if(i <= 9) {
			System.out.print("    " + i);
		} else {
			System.out.print("   " + i);
		}
		
			week++;
			if(week % 7 == 1) {
				System.out.println();
			}
			
			
			
		}
		
	}

}
