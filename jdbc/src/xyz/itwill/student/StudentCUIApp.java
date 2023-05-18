package xyz.itwill.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;


// 학생정보를 관리하는 프로그램 작성
// => 메뉴 선택에 따른 학생정보 삽입, 변경, 삭제, 검색 기능을 제공
// => 입력과 출력은 프로그램에서 구현, 데이터 처리는 DAO 클래스의 메소드를 호출해 처리함

public class StudentCUIApp {
	
	// 키보드 입력 스트림 저장 필드
	private BufferedReader in; 
	
	public StudentCUIApp() {
		// 키보드로 입력받는 입력스트림을 필드에 생성
		in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] menu = {"1. 학생정보 삽입","2. 학생정보 변경", "3. 학생정보 삭제", 
				"4. 학생정보 검색", "5. 학생목록 출력", "6. 프로그램 종료"};
		
		System.out.println("[학생 관리 프로그램]");
		
		while(true) {
			for(String item : menu) {
				System.out.println(item);
			}
			
			int choice;
			
			try {
				System.out.print("메뉴 선택[1~6] -> ");
				// 문자열을 입력받아 정수값으로 변경하여 저장
				choice = Integer.parseInt(in.readLine());
				
				// 메뉴 선택을 잘못한 경우 예외발생
				if(choice < 1 || choice > 6) throw new Exception();
			} catch (Exception e){
				System.out.println("error) 메뉴를 잘못 선택 하였습니다.");
				System.out.println();
				continue;  // while 구문 재실행
			}
			System.out.println();
			
			if(choice == 6) break;  // while 구문 종료
			
			// 메뉴 선택에 따른 기능 구현 -> 메소드 호출
			switch(choice) {
			case 1 : addStudent(); break;
			case 2 : modifyStudent(); break;
			case 3 : removeStudent(); break;
			case 4 : searchStudent(); break;
			case 5 : displayAllStudent(); break;
			}
			System.out.println();
		}
		System.out.println("메시지) 학생관리 프로그램 종료");
	}
	
	//=================================================================================
	public static void main(String[] args) {
		new StudentCUIApp();
	}
	
	// 1. 학생정보 삽입 메뉴를 선택할 경우 호출되는 메소드
	// => 키보드로 학생 정보를 입력받아 STUDENT 테이블에 삽입하고 처리결과를 출력
	public void addStudent() {
		System.out.println("###학생정보 삽입###");
		
		try {
			// 학생정보를 입력받아 저장 -> 입력값 검층처리
			// => 검증에 실패한 경우 재입력처리
	
			int no;  // 학번을 저장 변수
			
			while(true) {  // 학번입력값 검증 반복문
				System.out.println("학번 입력(4자리) -> ");
				// 입력값을 noTemp에 저장
				String noTemp = in.readLine();
				
				if(noTemp == null || noTemp.equals("")) {   // 입력값이 없는 경우
					System.out.println("입력오류) 학번을 입력해주세요.");
					continue;  // 반복문 재실행 명령
				}
				
				// 학번에대한 입력 패턴이 저장된 정규표현식
				String noReg = "^[1-9][0-9]{3}$";
				
				if(!Pattern.matches(noReg, noTemp)) {  // 정규표현식과 입력값의 입력패턴이 다른경우
					System.out.println("입력오류) 학번은 4자리 숫자로 입력해주세요.");
					continue;  // 반복문 재실행 명령
				}
				
				no = Integer.parseInt(noTemp);  // 문자열을 정수로 변환해 저장
				
				//===============================================================
				// 입력된 학번이 STUDENT 테이블에 저장되어있는 기존 정보와 중복된경우 재입력 처리
				// 학번을 전달받아 STUDENT 테이블에 저장된 정보를 검색해 반환하는 DAO메소드 호출
				// => null 반환 (=학생정보 미검색) or StudentDTO 객체반환(=학생정보 검색)
				UserDTO_1 student = StudentDAOImpl.getDao().selectStudent(no);
				
				if(student != null) {  // 입력되어있는 학생정보가 검색된 경우
					System.out.println("입력오류) 이미 사용중인 학번을 입력하였습니다.");
					continue;  // 반복문 재실행 명령
				}
				
				break;  // 반복문 종료
			}
			
			//======================================================================
			String name;  // 이름을 저장하기 위한 변수
			
			while(true) {  // 학번입력값 검증 반복문
				System.out.println("이름 입력 -> ");
				// 입력값을 noTemp에 저장
				name = in.readLine();
				
				if(name == null || name.equals("")) {   // 입력값이 없는 경우
					System.out.println("입력오류) 이름을 입력해주세요.");
					continue;  // 반복문 재실행 명령
				}
				
				// 이름에대한 입력 패턴이 저장된 정규표현식
				String nameReg = "^[가-힣]{2,5}$";
				
				if(!Pattern.matches(nameReg, name)) {  // 정규표현식과 입력값의 입력패턴이 다른경우
					System.out.println("입력오류) 이름은 2~5범위의 한글로 입력해주세요.");
					continue;  // 반복문 재실행 명령
				}
				
				break;
			}
			
			//====================================================================
			// 전화번호 입력
			String phone;  // 전화번호를 저장하기 위한 변수
			
			while(true) {  // 학번입력값 검증 반복문
				System.out.println("전화번호 입력 -> ");
				// 입력값을 noTemp에 저장
				phone = in.readLine();
				
				if(phone == null || phone.equals("")) {   // 입력값이 없는 경우
					System.out.println("입력오류) 전화번호를 입력해주세요.");
					continue;  // 반복문 재실행 명령
				}
				
				// 이름에대한 입력 패턴이 저장된 정규표현식
				String phoneReg = "(010-\\d{4}-\\d{4})";
				
				if(!Pattern.matches(phoneReg, phone)) {  // 정규표현식과 입력값의 입력패턴이 다른경우
					System.out.println("입력오류) 전화번호를 형식에 맞게 입력해주세요.");
					continue;  // 반복문 재실행 명령
				}
				
				break;
			}
			
			//=====================================================================
			// 주소 입력
			String address;  // 주소를 저장하기 위한 변수
			
			while(true) {  // 학번입력값 검증 반복문
				System.out.println("주소 입력 -> ");
				// 입력값을 noTemp에 저장
				address = in.readLine();
				
				if(address == null || address.equals("")) {   // 입력값이 없는 경우
					System.out.println("입력오류) 주소를 입력해주세요.");
					continue;  // 반복문 재실행 명령
				}
				// 주소의 패턴을 만들순 없어서 생략
				
				break;
			}
			
			//======================================================================
			// 생년월일 입력
			String birthday;  // 생년월일을 저장하기 위한 변수
			
			while(true) {  // 학번입력값 검증 반복문
				System.out.println("생년월일 입력 -> ");
				// 입력값을 noTemp에 저장
				birthday = in.readLine();
				
				if(birthday == null || birthday.equals("")) {   // 입력값이 없는 경우
					System.out.println("입력오류) 생년월일을 입력해주세요.");
					continue;  // 반복문 재실행 명령
				}
				
				// 생년월일에대한 입력 패턴이 저장된 정규표현식
				String birthdayReg = "(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3(01))";
				
				if(!Pattern.matches(birthdayReg, birthday)) {  // 정규표현식과 입력값의 입력패턴이 다른경우
					System.out.println("입력오류) 생년월일을 형식에 맞게 입력해주세요.");
					continue;  // 반복문 재실행 명령
				}
				
				break;
			}
			
			//========================================================================
			// 키보드로 입력받은 학생정보를 STUDENT 테이블에 삽입하는 DAO 클래스의 메소드 호출
			
			// 학생정보를 저장하기 위해 StudentDTO 객체 생성
			UserDTO_1 student = new UserDTO_1();  
			
			// 입력받은 값으로 StudentDTO 필드값 변경
			student.setNo(no);
			student.setName(name);
			student.setPhone(phone);
			student.setAddress(address);
			student.setBirthday(birthday);
		
			// 학생정보를 전달받아 STUDENT 테이블에 삽입하는 DAO 클래스 메소드 호출
			int rows = StudentDAOImpl.getDao().insertStudent(student);
			
			System.out.println("처리결과) " + rows + "명의 학생정보 삽입");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//=================================================================================
	// 2. 학생정보 변경
	// => 학번을 입력받아 STUDENT 테이블에 저장된 학생 정보를 출력
	// => 키보드로 학번을 제외한 나머지 값을 입력받아 저장정보를 변경 후 출력
	public void modifyStudent() {
		System.out.println("###학생정보 변경###");
		
		try {
			// 학생정보를 입력받아 저장 -> 입력값 검층처리
			// => 검증에 실패한 경우 재입력처리
	
			int no;  // 학번을 저장 변수
			
			while(true) {  // 학번입력값 검증 반복문
				System.out.println("학번 입력(4자리) -> ");
				// 입력값을 noTemp에 저장
				String noTemp = in.readLine();
				
				if(noTemp == null || noTemp.equals("")) {   // 입력값이 없는 경우
					System.out.println("입력오류) 학번을 입력해주세요.");
					continue;  // 반복문 재실행 명령
				}
				
				// 학번에대한 입력 패턴이 저장된 정규표현식
				String noReg = "^[1-9][0-9]{3}$";
				
				if(!Pattern.matches(noReg, noReg)) {  // 정규표현식과 입력값의 입력패턴이 다른경우
					System.out.println("입력오류) 학번은 4자리 숫자로 입력해주세요.");
					continue;  // 반복문 재실행 명령
				}
				
				no = Integer.parseInt(noTemp);  // 문자열을 정수로 변환해 저장
				
				break;
			}
				
				//===============================================================
				// 입력된 학번이 STUDENT 테이블에 저장되어있는 기존 정보와 중복된경우 재입력 처리
				// 학번을 전달받아 STUDENT 테이블에 저장된 정보를 검색해 반환하는 DAO메소드 호출
				// => null 반환 (=학생정보 미검색) or StudentDTO 객체반환(=학생정보 검색)
				UserDTO_1 student = StudentDAOImpl.getDao().selectStudent(no);
				
				if(student == null) {  // 입력되어있는 학생정보가 검색된 경우
					System.out.println("처리결과) 변경할 학생정보가 없습니다.");
					return;
				}
				// 검색된 학생정보 출력
				System.out.println("====================================================================");
		 		System.out.println("학번\t이름\t전화번호\t주소\t생년월일");
		 		System.out.println("====================================================================");
		 		System.out.println(student);
		 		System.out.println("====================================================================");
		 		
		 		//키보드로 학번를 제외한 값을 입력받아 저장 - 입력값 검증
				System.out.println("[메세지]변경값 입력 >> 변경하지 않을 경우 엔터만 입력해 주세요.");

				String name;
				while(true) {
					System.out.print("이름 입력 -> ");
					name=in.readLine();
					
					String nameReg = "^[가-힣]{2,5}$";
					if(name != null && !name.equals("") && !Pattern.matches(nameReg, name)) {
						System.out.println("입력오류) 이름은 2~5 범위의 한글로만 입력해 주세요.");
						continue;	
					}
					
					break;
				}
				
				String phone;
				while(true) {
					System.out.print("전화번호 입력 -> ");
					phone = in.readLine();
					
					String phoneReg = "(010)-\\d{4}-\\d{4}";
					if(phone != null && !phone.equals("") && !Pattern.matches(phoneReg, phone)) {
						System.out.println("입력오류) 전화번호를 형식에 맞게 입력해 주세요.");
						continue;	
					}
					
					break;
				}
				
				System.out.print("주소 입력 -> ");
				String address = in.readLine();
				
				String birthday;
				while(true) {
					System.out.print("생년월일 입력 -> ");
					birthday = in.readLine();

					String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
					if(birthday != null && !birthday.equals("") && !Pattern.matches(birthdayReg, birthday)) {
						System.out.println("입력오류) 생년월일을 형식에 맞게 입력해 주세요.");
						continue;	
					}
					
					break;
				}
				
				//입력받은 변경값을 이용하여 학번으로 검색되어 반환받은 StudentDTO 객체의 필드값 변경
				// => 변경값이 있는 경우에만 필드값 변경
				if(name != null && !name.equals("")) student.setName(name);
				if(phone != null && !phone.equals("")) student.setPhone(phone);
				if(address != null && !address.equals("")) student.setAddress(address);
				if(birthday != null && !birthday.equals("")) student.setBirthday(birthday);
				
				//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하는 DAO 클래스의 메소드 호출
				int rows=StudentDAOImpl.getDao().updateStudent(student);
				
				System.out.println("[처리결과]"+rows+"명의 학생정보를 변경 하였습니다.");
		 		
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	//===================================================================================
	// 3. 학생정보 삭제
	// => 학번을 입력받아 학생정보를 삭제하고 출력
	public void removeStudent() {
		System.out.println("###학생목록 삭제###");
		
		try {
			//키보드로 학번을 입력받아 저장 - 입력값 검증
			int no;
			while(true) {
				System.out.print("학번 입력 -> ");
				String noTemp=in.readLine();
				
				if(noTemp == null || noTemp.equals("")) {//입력값이 없는 경우
					System.out.println("입력오류) 학번을 반드시 입력해 주세요.");
					continue;
				}
				
				String noReg="^[1-9][0-9]{3}$";
				if(!Pattern.matches(noReg, noTemp)) {
					System.out.println("입력오류) 학번은 4자리 숫자로만 입력해 주세요.");
					continue;	
				}
				
				no=Integer.parseInt(noTemp);//문자열을 정수값으로 변환하여 변수에 저장
				
				break;
			}
			
			//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 삭제하는
			//DAO 클래스의 메소드 호출
			int rows=StudentDAOImpl.getDao().deleteStudent(no);
			
			if(rows > 0) {//삭제행이 있는 경우
				System.out.println("처리결과) "+rows+"명의 학생정보를 삭제 하였습니다.");
			} else {//삭제행이 없는 경우 - 입력받은 학번의 학생정보가 없는 경우
				System.out.println("처리결과) 삭제할 학번의 학생정보가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//===================================================================================
	// 4. 학생정보 검색
	// => 이름을 입력받아 테이블에 저장된 해당 학생정보를
	public void searchStudent() {
		System.out.println("###학생정보 검색###");

		try {
			String name;
			while(true) {
				System.out.print("이름 입력 -> ");
				name = in.readLine();
				
				if(name == null || name.equals("")) {
					System.out.println("입력오류) 이름을 반드시 입력해 주세요.");
					continue;
				}
				
				String nameReg = "^[가-힣]{2,5}$";
				if(!Pattern.matches(nameReg, name)) {
					System.out.println("입력오류) 이름은 2~5 범위의 한글로만 입력해 주세요.");
					continue;	
				}
				
				break;
			}
			
			//이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 반환
			//하는 DAO 클래스의 메소드 호출
			List<UserDTO_1> studentList=StudentDAOImpl.getDao().selectNameStudentList(name);

			
			
			if(studentList.isEmpty()) {
				System.out.println("[처리결과]검색된 학생정보가 없습니다.");
				return;
			}
			
			System.out.println("==============================================================");
			System.out.println("학번\t이름\t전화번호\t주소\t\t생년월일");
			System.out.println("==============================================================");
			for(UserDTO_1 student : studentList) {
				System.out.println(student);
			}
			System.out.println("==============================================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	//=================================================================
	// 5. 학생목록 출력
	// => STUDENT 테이블의 모든 학생정보를 검색하여 출력하는 메소드
	
	public void displayAllStudent() {
		System.out.println("###학생목록 출력###");
		
		// => STUDENT 테이블의 모든 학생정보를 검색해 반환하는 DAO클래스 메소드 호출
 		List<UserDTO_1> studentList = StudentDAOImpl.getDao().selectAllStudentList();
 		
 		if(studentList.isEmpty()) {  // 검색된 학생정보가 없는 경우
 			System.out.println("처리결과) 저장된 학생정보가 없습니다.");
 			return;
 		}
		
 		System.out.println("====================================================================");
 		System.out.println("학번\t이름\t전화번호\t주소\t생년월일");
 		System.out.println("====================================================================");
 		
 		// List 객체의 요소를 제공받아 반복처리
 		for(UserDTO_1 student : studentList) {
 			System.out.println(student);  
 			// StudentDTO 클래스의 toString 메소드 호출 -> StudentDTO 객체의 필드값 반환
 			System.out.println(student);
 		}
 		System.out.println("==========================================================");
 		
	}

}































