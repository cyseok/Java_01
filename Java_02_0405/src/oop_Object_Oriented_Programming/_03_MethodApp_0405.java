package oop_Object_Oriented_Programming;


// 실행이 목적인 클래스 -> main 메소드를 반드시 작성
public class _03_MethodApp_0405 {
	
	
	public static void main(String[] args) { 
		
		//(String[] args)  => 매개변수(프로그램 실행기 JVM(Java Virtual Machine)에 의해 자동호출하는 특별한 메소드)
		// => 같은 패키지에 작성된 클래스는 패키지 표현없이 클래스 사용가능
		// => 참조변수를 사용하여 객체의 필드 또는 메소드 접근가능
		
		_02_Method_0405 method = new _02_Method_0405();
		// new _02_Method_0405() -> 객체
		//  method -> 참조변수
		
		// 참조변수를 출력할 경우 "자료형@메모리주소" 형식의 문자열을 제공받아 출력
		System.out.println("method = " + method);
		System.out.println("==========================================================");
		
		// 메소드 호출방법 -> 객체를 이용하여 메소드를 호출하면 프로그램의 흐름(스레드)은 객체의 메소드로 이동하여 
		//                     메소드의 명령을 실행하고 메소드가 종료되면 다시 되돌아와 다음 명령을 실행한다.
		// 요약 : 다른 클래스 객체의 메소드로 가서 실행한 후 다시 돌아온다.
		method.displayOne(); // 매개변수가 없기 때문에 ()는 공란
		method.displayTwo(); 
		method.displayOne(); 
		System.out.println("==========================================================");
		
		method.printOne();
		System.out.println("==========================================================");
		
		method.printTwo(50); //// 매개변수에 정상적인 값( ()안에 )을 전달해야 호출된다.
		System.out.println("==========================================================");
		
		method.printTwo(80);
		method.printTwo(-50);  // 잘못된 숫자에 대한 검증필요
		
		// method.printTwo(80.0);  int 매개변수에 double 매개변수는 불가
		
		System.out.println("==========================================================");
		
		// 여러개의 매개변수 설정 가능
		method.printThree(35, 79);
		method.printThree(19, 99);
		method.printThree(67, 12);  // 잘못된 숫자에 대한 검증 필요
		System.out.println("==========================================================");
		
		// 반환값이 존재하는 메소드 호출
		// 메소드를 호출하면 반환되는 값이 존제 -> 반환값을 변수에 저장
		// => 메소드의 반환값을 지속적으로 사용하고자 할 경우 반환값을 변수에 저장
		// returnTot의 값을 result에 저장한후 출력
		int result = method.returnTot(30, 70);
		System.out.println("[합계]메소드 호출의 반환값 = " + result);
		
		
		// 메소드의 반환값을 일시적으로 사용할 경우에는 아래처럼 반환값을 변수에 저장하지않아도 된다.
		System.out.println("[합계]메소드 호출의 반환값 = " + method.returnTot(30, 70));
		System.out.println("==========================================================");
		
		boolean result1 = method.isOddEven(10);
		if (result1) {
			System.out.println("매개변수로 전달된 값은 [짝수]");
		} else {
			System.out.println("매개변수로 전달된 값은 [홀수]");
		}
			
			// 조선식 대신 메소드의 반환값을 이용하여 명령을 선택 실행한다.
			if (method.isOddEven(9)) {
				System.out.println("매개변수로 전달된 값은 [짝수]");
			} else {
				System.out.println("매개변수로 전달된 값은 [홀수]");
		}
		
		System.out.println("==========================================================");
		
		// 배열의 메모리 주소를 반환하는 메소드를 호출하면 반환된 메모리 주소를 참조변수에 저장
		int [] array = method.returnArray();
		
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println("==========================================================");
	
		System.out.println("합계 = " + method.sumOne(10, 20, 30));
		// System.out.println("합계 = " + method.sumOne();  -> error
		// System.out.println("합계 = " + method.sumOne(10, 20));  -> error
		// System.out.println("합계 = " + method.sumOne(10, 20, 30, 40));  -> error
		System.out.println("==========================================================");
		
		// System.out.println("합계 = " + method.sumTwo(10, 20, 30));  -> error
		// 매개변수의 배열의 "메모리 주소"를 전달하여 메소드 호출
		System.out.println("합계 = " + method.sumTwo(new int[] {10, 20, 30})); 
		System.out.println("합계 = " + method.sumTwo(new int[] {})); 
		System.out.println("==========================================================");
		
		System.out.println("합계 = " + method.sumThree(10, 20, 30));
		System.out.println("합계 = " + method.sumThree());
		System.out.println("합계 = " + method.sumThree(10, 20));
		System.out.println("합계 = " + method.sumThree(10, 20, 30, 40, 50));
		


		  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
