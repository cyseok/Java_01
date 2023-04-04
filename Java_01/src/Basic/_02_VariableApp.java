package Basic;

//리터럴(Literal) : 프로그램에서 사용하기 위해 표현되는 값(Value)
//변수(Variable) : 리터럴(값)을 저장하기 위해 메모리(Memory)에 부여된 이름(식별자)

//변수 선언 - 메모리에 변수 생성
//형식)자료형 변수명;
//=> 자료형(DataType) : 변수에 저장될 리터럴의 형태 - 원시형(PrimitiveType) 또는 참조형(ReferenceType)
//=> 변수명 : 리터럴을 저장하기 위한 메모리 영역을 구분하기 위해 사용되는 식별자(Identifier)

//예약어(키워드) : Java 프로그램을 개발하기 위해 미리 정해져 있는 단어
//사용자 정의 명칭(식별자) : Java 프로그램 개발을 위해 프로그래머 정의하여 사용하는 단어  

//식별자 작성 규칙
//=> 영문자, 숫자, 특수문자(_ 또는 $)를 조합하여 작성 - Java에서는 한글을 식별자로 사용 가능
//=> 숫자로 시작되도록 작성 불가능
//=> 영문자는 대소문자를 구분하여 작성
//=> 기존에 사용된 단어(키워드 또는 식별자)로 식별자 선언 불가능

//Java에서 사용되는 식별자 작성 방법 - 표기법 : 영문자의 소문자를 기본으로 식별자 작성
//=> 파스칼 표기법(PascalCase) : 조합된 단어의 첫문자를 대문자로 표현하여 작성 - 클래스명, 인터페이스명 등
//=> 카멜 표기법(CamelCase) : 첫번째 단어를 제외한 나머지 단어의 첫문자를 대문자로 표현하여 작성 - 변수명, 메소드명 등
//=> 스네이크 표기법(SnakeCase) : 조합된 단어를 _로 구분하여 작성 - 상수(Constant : 상수명은 무조건 대문자로 작성)

public class _02_VariableApp {
	public static void main(String[] args) {
		// 깃허브(GitHub) : 분산 버전 관리 툴인 깃 저장소 호스팅을 제공하는 웹 서비스
		// 깃(Git) : 여러명의 사용자들 간에 파일의 작업을 조율하기 위한 분산 버전 관리 시스템(프로그램)

		int su = 100;
		System.out.print("초기값 = ");
		System.out.println(su);

		su = 250 * 12;
		System.out.println(su);
		int num = 100;
		System.out.println("num = " + num + "(추가)"); // 문자열 + 값
		System.out.println("올해는 " + 2 + 0 + 2 + 3 + "년입니다.");
		System.out.println("" + 2 + 0 + 2 + 3 + "년입니다"); // 값 +문자열은 (""+) 사용
		int num1 = 100;
		int num2 = 200;
		System.out.println("결과 = " + num1 + num2);
		System.out.println("결과 = " + (num1 + num2)); // ()를 이용해 연산먼저 진행

		int kor = 88, eng = 90;
		int tot = kor + eng;
		System.out.println(tot);

		int result = (kor + eng) / 2;
		System.out.println(result);

		int number;
		number = 123;
		System.out.println("number = " + number);
		num += 100;
		System.out.println("num = " + num);

		System.out.println("정수형(10진수 100) = " + 100);
		System.out.println("정수형(8진수 100) = " + 0100);
		System.out.println("정수형(16진수 100) = " + 0 * 100);
		System.out.println("정수형(10진수 100) = " + 100L); // 8Byte

		long t = 2150000000l;
		System.out.println(t); // 4byte -> 8byte "L"붙이기

		long a1 = 100;
		System.out.println("a1 = " + a1);

		System.out.println(12.3f); // 4byte
		System.out.println(12.3); // 8byte
		// println은 아주 작거나 큰 경우 지수형태(E)로 출력
		System.out.println(0.0000000000123);
		System.out.println(1.23E+10);

		float b1 = 1.23456789f; // 7자리까지 가능(9가 반올림됨)
		double b2 = 1.23456789; // 15자리까지 가능
		System.out.println("b1 = " + b1);
		System.out.println("b2 = " + b2);

		long bb = 3000000000l; // int 자리(4byte(21억~)) 넘어가면 L붙이기
		System.out.println(bb);

		double aa = 1234567891456.456;
		System.out.println(aa);

	}

}
