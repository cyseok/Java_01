package _04_xyz.itwill.utill_0419;

import java.util.Scanner;
import java.util.regex.Pattern;

// 정규 표현식(RegularExpression) : 메타문자(Meat Character), 회피문자(Escape Character)등을
//   사용하여 일정한 규칙의 문자열을 표현하는 방법 -> 사용자 입력값에 대한 검증

// ^문자 : 문자(열) 로 시작됨을 의미
// 문자$ : 문자(열) 로 종료됨을 의미
//  . : 임의의 문자 하나를 의미 (\ 문자는 표현 불가능)
// [문자1문자2문자3] : 나열된 문자 중 하나를 의미
// [^문자1문자2문자3] : 나열된 문자를 제외한 문자중 하나를 의미
// [문자1-문자2] : [문자1]에서 [문자2] 범위의 문자중 하나를 의미
// 문자열1|문자열2|문자열3 : 나열된 문자열 중 하나를 의미
// 문자열+ : 문자열이 한 번 이상 반복됨
// 문자열* : 문자열이 0번 이상 반복
// 문자열? : 문자열이 0번 또는 1번 존재함
// 문자열{숫자} : 문자열이 {숫자}만큼 반복
// 문자열{숫자1,숫자2} : 문자열이 {숫자1}부터 {숫자2} 범위만큼 반복
// (?!)문자열 : 문자열에서 대소문자를 구분하지 않음
// (?=문자열) : 문자열이 반드시 포함됨
// (!=문자열) : 문자열이 반드시 포함되지 않음 

// \s : 공백이 있는 문자열
// \S : 공백이 없는 문자열
// \w : 영문자, 숫자, _, 로 구성된 문자열
// \W : 영문자, 숫자, _, 로 구성된 문자를 제외하고 구성된 문자
// \d : 숫자 형태의 문자로만 구성된 문자열
// \D : 숫자 형태의 문자를 제외하고 구성된 문자열
// \메타문자 : 메타문자가 일반문자로 표현됨 -> ex) \. : 문자.

//==================================================================================
// 값을 입력받아 형식에 맞는 값인지 비교
// => 형식에 맞지 않은 값은 error
public class RegularExpressionApp {
	private static final String loop = null;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 아이디를 입력받아 형식과 비교
		// 아이디 형식 : 영문자로 시작 / 영문자, 숫자, (_)조합의 6~15범위 / 
		System.out.print("아이디 입력 : ");
		String id = scanner.nextLine();
		
		if(id == null || id.equals("")) { // 사용자의 입력값이 없는 경우 메시지 출력
			System.out.println("error : 아이디를 입력해주세요.");
			System.exit(0);
		}
		
		// 아이디 패턴을 정규표현식으로 표현해 저장
		// 영문자로 시작되고 [[a-zA-Z0-9_] 문자들이 5번에서 14번 반복
		String idReg = "^[a-zA-Z][a-zA-Z0-9_]{5,14}$";
		// String idReg = "^[a-zA-Z]\\w.{5,14}$";
		
		
		// Pattern.matches(String regEx Character input) : 정규표현식과 입력값을 비교해 다르면 false, 같으면 true 반환
		if(!Pattern.matches(idReg, id)) {
			System.out.println("error : 아이디를 형식에 맞게 입력해주세요.");
			System.exit(0);
		}
		System.out.println("＃형식에 맞는 아이디");
		
		//==============================================================================================
		
		// 비밀번호 형식 : 8~20범위 숫자 / 영문자, 숫자, 특수문자가 반드시 1번씩 이상 포함/ 
		
		System.out.print("비밀번호 입력 : ");
		
		String password = scanner.nextLine();
		
		if(password == null || password.equals("")) {
			
			System.out.println("error : 비밀번호를 입력해주세요.");
			System.exit(0);
			
		}
		
		// -는 범위를 지정하는 의미가 되서 맨마지막에 입력해야함.
		// ^는 맨앞에 오면 안됨.
		String passwordReg = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+=-].{8,20})";
		
		if(!Pattern.matches(passwordReg, password)) {
			
			System.out.println("error : 비밀번호를 형식에 맞게 입력해주세요.");
			System.exit(0);
			
		}
		System.out.println("＃형식에 맞는 비밀번호");
		
		//==============================================================================================
		
		// 이메일 형식 : 아이디@도메인
	
		 System.out.print("이메일 입력 : ");
		
		String email = scanner.nextLine();
		
		if(email == null || email.equals("")) {
			
			System.out.println("error : 이메일을 입력해주세요.");
			System.exit(0);
			
		}
		
		String emailReg = "^([a-zA-Z0-9_-] + @[a-zA-Z0-9_-] + (\\.[a-zA-Z0-9_-] +)+)*$";
		// \\.: 회피문자 (자바에서는 역슬래시(\) 두 번 사용해야함)
		// + : 한번이상 반복, * : 0번이상 반복
		
		if(!Pattern.matches(emailReg, email)) {
			System.out.println("error : 이메일을 형식에 맞게 입력해주세요.");
			System.exit(0);
		}
		System.out.println("＃형식에 맞는 이메일");
		
		scanner.close();
		
		
	
	}
}












































