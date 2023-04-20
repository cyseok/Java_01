package _04_xyz.itwill.utill_0419;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// 생년월일을 입력받아 살아온 날짜(일)을 계산
// ex) 2000-01-02
// 예외처리리 후 종료
public class DayCalculateApp {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		System.out.println("생년월일 입력(2000-01-01) -> ");
		
		try {
			// 예외처리
			birthday = dateFormat.parse(scanner.nextLine());
		} catch (ParseException e){
			System.out.println("형식 에러");
			System.exit(0);
		} finally {
			scanner.close();
		}
		
		// 살아온 날짜를 계산하여 출력
		long day = (System.currentTimeMillis() - birthday.getTime()) / (1000*60*60*24);
		System.out.println(day + "일");
		
		
		
	
		
		
	}
	
}






































