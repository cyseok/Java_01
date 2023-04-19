package _04_xyz.itwill.utill_0419;

import java.util.Random;
import java.util.UUID;

// 새로운 비밀번호를 생성하여 제공

public class NewPasswordApp {
	
	// 비밀번호 반환 메소드 -> Random 클래스 이용
	public static String newPasswordOne() {
		Random random = new Random();
		
		// 비밀번호로 사용될 문자들이 저장된 문자열 생성
		String str = "abcdefgfijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~!@#$%^&*";
		
		// StringBuffer 객체 생성
		StringBuffer password = new StringBuffer();
		
		for (int i = 1; i <= 10; i++) {
			password.append(str.charAt(random.nextInt(str.length())));
		}
		
		return  password.toString();
		
	}
	
	public static String newPasswordTwo() {
		
		// UUID 클래스 : 범용적으로 사용되는 식별자를 생성하는 메소드를 제공하는 클래스
		// UUID.randomUUID() : 자동으로 식별자를 생성하여 식별자가 저장된 UUID 객체를 반환
		// => UUID 객체에 저장된 식별자는 숫자와 영문(소문자), ' - '(4개)로 구성된 36개의 문자 저장
		// toString() : 식별자를 문자열(String객체)로 반환하는 메소드
		return UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
		
		
		
		
	}
	public static void main(String[] args) {
		System.out.println("새로운 비밀번호(1) = " + newPasswordOne());
		System.out.println("새로운 비밀번호(2) = " + newPasswordTwo());
		
		
	}

}






































