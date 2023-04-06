package opp__Yunseok_Practice;

public class _0406_Method_01 {
	
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
		return tot;
	}
	
	
	boolean isOddEven(int num) {
		if (num % 2 != 0) {
			return false;
		} else {
			return true;
		}
	}
	
	int [] returnArray () {
		int [] array = {10, 20, 30, 40, 50};   // array에 배열을 저장한다.
		return array;  // 배열의 메모리 주소를 반환 = 배열을 반환하는 것
	}
	
	
	int sumOne(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	
	int sumTwo(int[] array) {
		int tot = 0;
		for (int num : array) {
			tot += num;
		}
		return tot;
	}
	
	
	int sumThree(int...array) {
		int tot = 0;
		for (int num : array) {
			tot += num;
		}
		return tot;
	}

}
