package _04_xyz.itwill.utill_0419;

import java.text.DecimalFormat;

// DecimalFormat 클래스 : Number 객체(숫자값)와 String 객체를 서로 반대로 변환하는 클래스
public class DecimalFormatApp {
	
	public static void main(String[] args) {
		
		int money = 100_000_000;
		System.out.println("금액 = " + money + "원");
		
		
		
		// 숫자값에 대한 패턴정보를 문자열로 받아 객체를 생성하는 생성자 사용
		// => 패턴문자 : #(공백으로 치환), 0(0으로 치환), 콤마(,), 소수점(.), 달러($) 
		DecimalFormat decimalFormat = new DecimalFormat("###,###,##0");
		
		// decimalFormat.format(long ) : 패턴정보를 사용해 문자열로 반환
		System.out.println("금액 = " + decimalFormat.format(money) + "원");
		
		// getInstance() : 기본 패턴정보가 저장된 객체를 반환
		System.out.println("금액 = " + decimalFormat.getInstance().format(money) + "원");
		
		// getCurrencyInstance() : 시스템이 사용하는 화폐단위를 붙여준다.
		System.out.println("금액 = " + decimalFormat.getCurrencyInstance().format(money));
		
	}

}







































