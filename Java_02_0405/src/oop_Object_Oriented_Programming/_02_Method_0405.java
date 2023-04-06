package oop_Object_Oriented_Programming;

import javax.sql.rowset.serial.SQLOutputImpl;

// 메소드(Method) : 클래스 내부에 선언된 함수 = 멤버함수(C언어에서 불림)
// => 필드(멤버변수)를 이용하여 필요한 기능을 제공하기 위한 명령들의 모임
// => 명령(Statement)은 "메소드 내부"에서만 작성가능

// 함수(Function) : 값을 제공받아 계산하여 결과를 반환하는 명령들의 모임 -> 기능제공

// 메소드 선언 방법
// 형식 : 자료형(반환형) 메소드명 (자료형 변수명, 자료형 변수명, ...) {
//                           명령;
//                           명령;
//     }

// => 반환형(ReturnType) : 메소드를 호출하여 얻을 수 있는 결과값에 대한 자료형
// => 무반환형(= Void 자료형) : 메소드를 호출하여 얻을 수 있는 결과값이 없는 경우 사용하는 자료형

// 메소드의 () 기호 안에는 변수를 나열하여 선언 = 매개변수(Parameter = Argument(C언어에서 사용))
// => 메소드에 작성된 명령을 실행하기 위해 메소드 "호출시" 전달된 값은 저장하기 위한 변수
// => 메소드에 작성된 명령을 실행하기 위한 "값이 필요없는 경우 매개변수" 생략가능

// 메소드 호출(Invoke) : 메소드에 작성된 명령을 실행하여 필요한 기능제공
// 형식 : 객체.메소드명 (값, 값, ...)
// => 객체가 저장된 참조변수를 사용하려 객체의 메소드 호출
// => 메소드 호출시 매개변수에 차례대로 값을 전달하여 메소드 호출
// => 매개변수에 값이 정상적으로 전달되지 않으면 메소드 호출 불가 -> 에러발생

// return 키워드 : 메소드를 강제로 종료하기 위한 키워드'
// 형식 -1 : if (조건식) return;
// => 메소드의 반환형을 [void]로 작성
// 형식 -2 : return 대상(=반환값);
// => 메소드를 종료하면서 대상(=반환값(변수 or 연산식))의 값을 반환하여, 메소드를 호출하는 명령에게 제공
// => 메소드의 반환형을 "대상의 자료형"과 반드시 같도록 작성해야 함.
//===================================================================================


// 객체 생성이 목적인 메소드 -> main 메소드 미작성
public class _02_Method_0405 { 
	
	// 무반환형 -> "void 자료형" (결과값이 없는 경우)
	void displayOne() {
		System.out.println("Method 클래스의 displayOne() 메소드 호출");
		
	}
	
	void displayTwo () { 
		System.out.println("Method 클래스의 displayTwo() 메소드 호출");
	}
	
	void printOne () {
		int tot = 0;
		for (int i = 1; i <= 100; i++) {
			tot += i;
		}
		System.out.println("1부터 100까지 정수의 합계 = " + tot );
	}
	
	void printTwo (int num) { // (int num -> parameter = 매개변수)
		// 매개변수에 정상적인 값을 전달해야 호출된다.
		
		// 입력값(매개변수에 저장된 값)에 대한 검증
		if (num <= 0) { 
			System.out.println("[error] 매개변수에는 0보다 큰 값 입력바람");
			return;  // 메소드 종료 -> 메소드를 호출한 쪽으로 다시 되돌아감(아래는 실행이 안된다는 의미)
		}
		int tot = 0;
		for (int i = 1; i <= num; i++) {
			tot += i;
		}
		System.out.println("1부터 " + num + "까지 정수의 합계 = " + tot );
	}
	
	void printThree (int num1, int num2) { // 자료형 변수명, 자료형 변수명, ...
		// 매개변수에 정상적인 값을 전달해야 호출된다.
		if(num1 > num2) { // 비정상적인 값이 전달된 경우
			System.out.println("큰 숫자를 뒤에 입력바람");
			return; // return으로 인해 아래식이 실행되지않고 다시 되돌아가버린다
			
			/* ************************
			 종료시킬 수도 있지만 숫자를 치환시켜 실행에 문제없게 할 수도 있다.
			 if (num1 > num2) {  
			  int temp = num1;
			  num1 = num2;
			  num2 = temp;
			  }
			 **************************/ 
			 
		}
		
		int tot = 0;
		for (int i = num1; i <= num2; i++) {
			tot += i;
		}
		System.out.println(num1+ "~" + num2 + "까지 정수의 합계 = " + tot );
	}
	
	int returnTot(int num1, int num2) {  // int값을 반환하려면 void말고 int를 사용한것처럼 같아야한다. 
		int tot = 0;
		for (int i = num1; i <= num2; i++) {
			tot += i;
		}
		// 변수에 저장된 값을 메소드를 종료하여 메소드를 호출하는 명령에게 반환
		// => 반환되는 값의 자료형과 메소드의 반환형의 자료형이 동일해야한다.
		return tot;
	}
	
	
	// 매개변수로 정수값을 전달 받아 홀수와 짝수를 구분하여 반환하는 메소드
	// => false 반환 : 홀수, true 반환 : 짝수
	boolean isOddEven(int num) {
		if (num % 2 != 0) {
			return false;
		} else {
			return true;
		}
	}
	
	// 배열을 반환하는 메소드
	int [] returnArray () {
		int [] array = {10, 20, 30, 40, 50};   // array에 배열을 저장한다.
		return array;  // 배열의 메모리 주소를 반환 = 배열을 반환하는 것
		
		// *** return  {10, 20, 30, 40, 50};  // 배열(X) ->error
		// *** return new int[] {10, 20, 30, 40, 50}; // 배열(O) new 연산자를 꼭 사용해야한다.
	}
	
	
	// 매개변수 3개에 전달된 정수들의 합계를 계산하여 반환하는 메소드
	int sumOne(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	
	// 매개변수로 배열을 전달받아 배열의 모든 요소값들의 합계를 계산하여 반환하는 메소드
	// int num 말고 int[] array
	int sumTwo(int[] array) {
		int tot = 0;
		for (int num : array) {
			tot += num;
		}
		return tot;
	}
	
	
	/// (...) : 매개변수 생략기호를 사용하여 賣매개변수를 작성하면 전달값 0개 이상을 전"달받아 메소드에서 배열처럼 사용가능
	int sumThree(int...array) {
		int tot = 0;
		for (int num : array) {
			tot += num;
		}
		return tot;
	}
	
	
	
	
	
	
}





















































