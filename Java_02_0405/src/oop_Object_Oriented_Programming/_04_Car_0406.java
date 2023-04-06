package oop_Object_Oriented_Programming;

// 클래스 : 객체(Object)를 생성하기 위한 자료형 -> 참조형
// => Java에서는 객체 대신 인스턴스(Instace) 사용
// => 현실에 존재하는 사물 또는 관념을 클래스라는 자료형을 표현하여 
//    프로그램에서 동작할 수 있도록 객체로 생성하여 사용한다.

// 클래스 선언 형식
// 형식 : [public] class 클래스명 {
//            필드(Field) :  표현대상의 속성(값)을 저장하기 위한 변수 -> 멤버변수

//             생성자(constructor) : 클래스로 객체를 생성하기 위한 특별한 메소드
//             *** 생성자는 클래스에 없으면 클래스를 못만든다. 작성되어있지않으면
//                 기본 생성자로 취급한다

//              메소드(Method) : 표현 대상의 행위를 명령으로 제공하기 위한 함수 -> 멤버함수

//        }

// => 메소드는 필드에 "저장된 값(= 사용한 명령)"을 이용하여 필요한 기능이 제공되도록 작성
// => 클래스 내부에 선언된 모든 메소드는 필드에 접근 가능


// 자동차를 객체 모델링하여 클래스로 작성
// => 자동차의 속성 : 모델명, 엔진상태, 현재속도 -> 필드
// => 행위 : 시동 켜기(on), 시동 끄기(off), 속도증가, 속도감소, 중지 -> 메소드

public class _04_Car_0406 { // 객체를 만들기 위한 클래스 생성한 것 ( 실행목적X )
	
	// 필드(Field)
	// 모델명 -> String  
	String modelName ;
	
	// 엔진상태 -> boolean  // false : off , true : on
	boolean engineStatus;
	
	// 현재속도 -> int
	int currentSpeed;
	
	// 생성자 : 생성자를 하나도 만들지않으면(선언하지않으면) 매개변수가 없는 
	//           기본생성자(Default Constructor)가 자동으로 생성된다.
	
	// 메소드 : 필드를 사용하여 메소드의 명령으로 필요한 기능이 제공되도록 작성
	
	// 시동 on
	void StartEngine() {
		engineStatus = true;
		System.out.println(modelName + " 시동 on");
	}
	
	// 시동 off
	void stopEngine() {
		engineStatus = false;
		System.out.println(modelName + " 시동 off ");
	}
	
	// 속도증가
	void speedUp(int speed) {  // 매개변수 생성
		currentSpeed += speed;
		System.out.println(modelName + "의 속도" + speed +"km/h 증가, 현재 속도는 " + currentSpeed + "km/h"  );
	}
	
	// 속도감소
	void speedDown (int speed) {  // 매개변수 생성
		currentSpeed -= speed;
		System.out.println(modelName + "의 속도" + speed +"km/h 감소, 현재 속도는 " + currentSpeed + "km/h"  );
	}
	
	// 중지
	void speedZero () {  // 매개변수 필요x
		currentSpeed = 0;
		System.out.println(modelName + " 멈춤");
	}
	
	
	
	
	
	
	

}


































































