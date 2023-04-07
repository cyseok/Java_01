package oop_Object_Oriented_Programming;


public class _12_MainArgsApp_0407 {
	
	// main 메소드의 매개변수에 프로그램 실행시 제공받은 문자열들을 배열로 전달받아 저장
	public static void main(String[] args ) { // 문자열들을 배열로 전달하는 것
		
		// main 메소드의 매개변수에 저장된 배열의 요소 갯수를 출력
		System.out.println("args.length = " + args.length);
		
		// main 메소드의 매개변수에 저장된 배열의의 모든 요소값을 일괄적으로 출력
		for( int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = " + args[i]);
		}
		
		// Run -> Run Configurations (문자 배열 추가해서 실행)
		
	}

}
