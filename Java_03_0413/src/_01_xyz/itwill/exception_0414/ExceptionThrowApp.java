package _01_xyz.itwill.exception_0414;

public class ExceptionThrowApp {
	
	// 정적메소드 클래스로 호출
	// 예외가 발생된 명령의 메소드에서 예외처리를 하지않고 발생된 예외 메소드를
	// 호출한 명령으로 전달가능 -> 예외 전달
	// 형식 : 접근제한자 반환형 메소드명 (자료형 매개변수, ...) throws 예외클래스, 예외클래스, ...
	
	public static void display () throws ArrayIndexOutOfBoundsException{
		                        // └->예외 전달
		int[] array = {10, 20, 30, 40};
		
		for(int i = 0; i <= array.length; i++) {
			System.out.println("array[" + i + "] = " + array[i]);
		}
		
	}
	
	
	public static void main(String[] args) {
		try {
		// => 예외가 발생되어 전달되는 메소드를 호출한 명령에서 예외처리하는 것을 권장
		// ExceptionThrowApp.display();  // 정적 메소드는 클래스를 이용하여 호출가능
		display();  // 같은 클래스의 정적메소드는 클래스 표현없이 메소드 호출가능
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("에러");
		}	
	
		// 정리 : 예외를 전달 한 후 마지막에 try catch 사용해주면 된다.(가독성)
	}

}

