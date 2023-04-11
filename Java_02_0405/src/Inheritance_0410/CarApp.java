package Inheritance_0410;

public class CarApp { 
	public static void main(String[] args) {
		
		Car car = new Car("싼타페", "홍길동");
		
		System.out.println("모델명 = " + car.getModelName());
		System.out.println("소유자 = " + car.getUserName());
		System.out.println("====================================");
		
		// Object.toString() : 참조변수에 저장된 객체를 참조하여 "클래스명@메모리주소" 형식의
		//                     문자열로 변환하여 반환하는 메소드
		System.out.println("car.toString() = " + car.toString());
		System.out.println("====================================");
		
		System.out.println("car = " + car);
		// 참조변수를 출력할 경우 자동으로 toString() 메소드가 호출된다
		// Object 클래스의 toString() 메소드가 아닌 Car클래스의 toString()메소드가 호출된다.
		System.out.println("====================================");
		
		// 문자열이 저장된 String 객체를 생성하여 객체의 메모리주소를 참조변수에 저장한 것
		String name = "홍길동";

		// String 클래스에 오버라이드 선언된 toString() 메소드호출
		// => String.toString() : String 객체에 저장된 문자열을 반환하는 메소드
		System.out.println(name);
		System.out.println(name.toString());
		// String 클래스의 참조변수을 출력할 경우 자동으로 String 클래스의 toString() 메소드를 호출한다.
		
	}

}
