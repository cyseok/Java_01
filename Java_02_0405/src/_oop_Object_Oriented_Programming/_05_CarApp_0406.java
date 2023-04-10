package _oop_Object_Oriented_Programming;

// 클래스로 객체를 생성하는 방법
// 형식 : 클래스명 참조변수 = new 클래스명 ();
// => new 연산자로 클래스의 생성자를 호출하여 객체를 생성하고 생성된 객체의 메모리 주소를 참조변수에 저장 
// 참조변수에 저장된 객체는 (.) 연산자를 사용하여 필드 또는 메소드에 접근하여 프로그램을 작성한다.


// Car 클래스를 객체로 생성하여 작성된 프로그램
public class _05_CarApp_0406 {
	
	public static void main(String[] args) {
		
		// Car 클래스로 객체를 생성하여 참조변수에 저장
		// => 하나의 클래스로 서로 다른 객체를 여러개 생성가능
		// => 클래스는 객체를 생성하기 위한 틀(Template)
		// => 객체를 생성하면 객체의 필드에서는 기본값을 초기값으로 자동 저장
		//                                      └-> (숫자형 : 0, 논리형 : false, 참조형 : null)
		// 형식 : 클래스명 참조변수 = new 클래스명 ();  
		_04_Car_0406 carOne = new _04_Car_0406();
		_04_Car_0406 carTwo = new _04_Car_0406();
		_04_Car_0406 carThree = new _04_Car_0406();
		
		System.out.println("carOne = " + carOne);
		System.out.println("carTwo = " + carTwo);
		System.out.println("carThree = " + carThree);
		System.out.println("=============================================================");
		
		// 참조변수.필드명 : 참조변수에 저장된 객체가 (.) 연산자를 사용하여 필드에 접근
		// => 객체의 필드에는 기본값이 초기값으로 자동저장
		// 문제점) 객체를 사용하여 필드에 직접적인 접근은 허용하면 필드에 비정상적인 값이 저장될 수 있다.
		// 해결법) 클래스의 필드를 은닉화 처리하여 선언 하여
		//          은닉화 선언된 필드에 접근할 경우 error가 발생하도록 만들어준다.
		
	   // 객체의 필드값 변경
		
		/* private 변경 전 (기존)
		carTwo.modelName = "산타페";
		carTwo.engineStatus = false;
		carTwo.currentSpeed = 0;
		*/
		carOne.setModelName("싼타페"); // (은닉화) *** 필드값을 변경하는 Setter 메소드 호출
		carOne.setEngineStatus(false);
		carOne.setCurrentSpeed(0);
		
		
		// 객체의 필드값 사용
		/*
		 * System.out.println("first car modelName = " + carOne.modelName);
		System.out.println("first car engineStatus = " + carOne.engineStatus);
		System.out.println("first car currentSpeed = " + carOne.currentSpeed); 
		*/
		
		System.out.println("first car modelName = " + carOne.getModelName());
		System.out.println("first car engineStatus = " + carOne.isEngineStatus());
		System.out.println("first car currentSpeed = " + carOne.getCurrentSpeed());		
		System.out.println("==========================================================");
		
		
		
		// N객체 필드가 초기값을 사용한다.
		System.out.println("second car modelame = " + carTwo.getModelName());
		System.out.println("second car engineStatus = " + carTwo.isEngineStatus());
		System.out.println("second car currentSpeed = " + carTwo.getCurrentSpeed());
		
		System.out.println("==========================================================");
		
		// 매개변수를 다시 정해준다. -> 정해주는 것 보다 메소드를 호출해 사용하는 것이 정석
		
		/*  (기존)
		carTwo.modelName = "쏘나타";
		carTwo.engineStatus = true;
		carTwo.currentSpeed =80;
		
		
		System.out.println("second car modelName = " + carTwo.modelName);
		System.out.println("second car engineStatus = " + carTwo.engineStatus);
		System.out.println("second car currentSpeed = " + carTwo.currentSpeed);
		*/
		
		carTwo.setModelName("쏘나타");
		carTwo.setEngineStatus(true);
		carTwo.setCurrentSpeed(80);
		
		System.out.println("second car modelName = " + carTwo.getModelName());
		System.out.println("second car engineStatus = " + carTwo.isEngineStatus());
		System.out.println("second car currentSpeed = " + carTwo.getCurrentSpeed());
		
		
		System.out.println("==========================================================");
		
		// 참조변수.메소드명(값, 값, ...) : 참조변수에 저장된 객체가 (.) 연산자를 사용하여 메소드를 호출한다.
		carOne.StartEngine();
		carOne.speedUp(50);
		carOne.speedUp(30);
		carOne.speedUp(20);
		carOne.speedDown(80);
		carOne.speedZero();
		carOne.stopEngine();
		System.out.println("==========================================================");
	
	
	
	
	
	
	
	
	
	}

}















































