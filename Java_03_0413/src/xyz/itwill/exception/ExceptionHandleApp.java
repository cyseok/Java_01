package xyz.itwill.exception;

// 예외(exception) : 사용자에 의해 프로그램이 잘못 실행되거나 프로그램이 잘못 개발되어
//                    실행될 경우 발생될 수 있는 프로그램 오류
// => 프로그램 실행시 예외가 발생되면 예외가 발생된 지점에서 프로그램이 강제종료됨.
// => ★★예외가 발생되어 프로그램이 강제로 종료되는 것을 방지하거나 프로그램이 강제로 종료된
//    이유를 알기 위해서 존재하는 예외처리(ExceptionHandle) 필드

// Java에서는 예외를 처리하기 위해 다양한 예외클래스를 제공
// 예외클래스 : 예외 관련 정보를 저장하기 위한 클래스
// => Exception class를 상속받아 작성된 자식클래스
// => 프로그램 실행시 예외가 발생되면 JVM은 해당 예외에 대한 예외클래스로 객체를 생성하여 제공한다.
// Throwable class : 프로그램에서 발생되는 모든 오류정보를 저장하기 위한 부모클래스(오류들의 부모클래스)
// => 자식클래스 : Error 클래스, Exception 클래스

// *예외의 종류*
// 1. 일반 예외 : 프로그램 실행시 예외가 발생될 가능성이 높아 
//                컴파일시 예외처리를 하지 않은 경우 error 발생
// => RuntimeException 클래스를 상속받지 않은 클래스로 예외처리
// 2. 실행 예외 : 프로그램 실행시 예외가 발생될 가능성이 낮아 
//                 예외처리를 하지 않아도 컴파일시 error 미발생
// => RuntimeException 클래스를 상속받은 클래스로 예외처리
// => 실행예외는 예외처리를 하지않은 경우 JVM이 자동으로 예외처리하여 예외메시지 제공\

// *예외처리 방법*
// try ~ catch 구문사용
// 형식 : try {
// 			예외가 발생될 수 있는 명령;

//      } catch(예외클래스 참조변수) {
//			예외처리명령;

//		} finally {
//			예외발생과 상관없이 무조건 진행될 명령;
//		}

// => try 키워드로 생성된 블럭의 명령이 실행할 때 예외가 발생된 경우 JVM이
//    해당 예외에 대한 예외클래스로 객체를 생성한다.
// => try 키워드로 생성된 블럭에서 발생된 예외 관련 객체를 catch 키워드를 이용해
//    설정된 블럭으로 전달하여 참조변수에 저장됨.
//     └-> 참조변수에 저장된 예외 관련 메소드를 호출하여 예외를 처리한다.
// => try 키워드로 생성된 블럭에서 예외처리가 발생되면 프로그램이 종료되지 않고
//    catch 키워드의 블럭으로 프로그램의 흐름(스레드)이 이동하여 예외처리 명령을 실행
// => catch 키워드로 블럭을 여러개 작성 가능 -> 다양한 예외를 구분하여 예외처리 가능
// finally 키워드의 블럭에는 예외 발생과 상관없이 무조건 실행될 명령 작성
// => 사용 자원에대한 제거 명령 실행




public class ExceptionHandleApp {
	
	public static void main(String[] args) {
		
		int[] array = {10, 20, 30, 40, 50};
		
		try {
		// 배열 요소의 첨자가 사용범위를 벗어난 경우 ArrayIndexOutOfBoundsException 발생
		// └-> 실행예외
		for(int i = 0; i <= array.length; i++) { 
			System.out.println("array[" + i + "] = " + array[i]);
			}
			System.out.println("정상실행");
		
		} catch (ArrayIndexOutOfBoundsException e) { // 예외객체를 전달받아 참조변수에 저장
			// 프로그램 사용자에게 예외관련 메시지 출력 => 선택
			// System.out.println("오류"); 
			
			// 프로그램 개발자에게 예외관련 메시지를 기록하여 제공 -> 에러 로그 => 필수
			// => 참조변수에 저장된 예외 관련 객체의 메소드를 호출하여 작성한다.
			// Throwable.getMessage() : 예외 객체에 저장된 예외 메시지를 반환하는 메소드
			System.out.println("예외 -> " + e.getMessage());
			
			//Throwable.printStackTrace() : 예외가 발생된 경로를 역추적하여 발생된 정보를 제공 받아 출력
			e.printStackTrace();
			e.getStackTrace();  // -> 로그파일에 저장
			
		} finally {
			System.out.println("예외상관없이 실행됨");
		}
		
	}

}



















































