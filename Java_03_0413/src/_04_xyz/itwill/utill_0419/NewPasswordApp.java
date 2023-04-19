package _04_xyz.itwill.utill_0419;

import java.util.Random;

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
	
	public static void main(String[] args) {
		System.out.println("새로운 비밀번호 = " + newPasswordOne());
		
		
	}

}
