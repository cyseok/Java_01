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

// 클래스 작성시 필드와 메소드에 접근 지정자를 사용하여 접근 허용 유무를 설정할 수 있다. 
// 접근 지정자(= 접근 제한자)(Access Modifier) : private, package(default), protected, public
// => 클래스, 필드, 생성자, 메소드 선언할 때 접근 허용을 설정하기 위한 키워드

// private : 클래스 내부에서만 접근 가능하도록 허용
// => 필드, 생성자, 메소드를 은닉화 처리하기 위해 사용 -> 클래스 외부에서 접근할 경우 error 발생
// 일반적으로 필드에 사용하는 접근 제한자 -> 객체로 필드의 직접적인 접근을 제한하기 위해 사용한다.
// 데이터 은닉화(Data Hiding) : 값을 숨겨 보호하기 위한 기능

// public : 모든 패키지의 클래스에서 접근 가능하도록 허용
// 일반적으로 메소드에 사용하는 접근 제한자 -> 클래스를 사용하는  프로그램 작성에 
// 필요한 모든 에서 접근할 수 있도록 허용



// 자동차를 객체 모델링하여 클래스로 작성
// => 자동차의 속성 : 모델명, 엔진상태, 현재속도 -> 필드
// => 행위 : 시동 켜기(on), 시동 끄기(off), 속도증가, 속도감소, 중지 -> 메소드

public class _04_Car_0406 {  // 객체를 만들기 위한 클래스 생성한 것 ( 실행목적X )
	
	// 필드(Field)
	// 모델명 -> String  
	private String modelName ;
	
	// 엔진상태 -> boolean  // false : off , true : on
	private boolean engineStatus;
	
	// 현재속도 -> int
	private int currentSpeed;
	
	// 생성자 : 생성자를 하나도 만들지않으면(선언하지않으면) 매개변수가 없는 
	//           기본생성자(Default Constructor)가 자동으로 생성된다.
	
	// 메소드 : 필드를 사용하여 메소드의 명령으로 필요한 기능이 제공되도록 작성
	
	// 시동 on
	void StartEngine() {
		engineStatus = true;
		System.out.println(modelName + " 시동 o"
				+ ""
				+ "n");
	}
	
	// 시동 off
	void stopEngine() {  // 속도가 0이어야 off 되게 작성
		if (currentSpeed != 0) {
			currentSpeed = 0;
			System.out.println("정지상태");
			
			// 코드의 중복성을 최소화하여 프로그램의 생산성 및 유지보수의 효율성을 
			//  증가시킬 수 있어 위 " currentSpeed = 0;  System.out.println("정지상태");  "
			//   대신에  speedZero(); 사용가능
		}
		engineStatus = false;
		System.out.println(modelName + " 시동 off ");
	}
	
	// 속도증가
	void speedUp(int speed) {  // 매개변수 생성
		if (!engineStatus /* 엔진 off 상태*/) {  // if문 쓰는이유 :  시동이 off일때 속도가 변하는 상황 제거
			System.out.println(modelName + "시동 off 상태");
			return;  // 다시 되돌아 갈 수 있게 return; 사용해줌
			// 위 return을 사용하는 것 대신에 speedZero(); 사용해도 된다.
		}
		
		// 최고 속도 제한 생성위한 if문
		if (currentSpeed + speed > 150) {
			speed = 150 - currentSpeed;
		}
		
		currentSpeed += speed;
		System.out.println(modelName + "의 속도" + speed +"km/h 증가, 현재 속도는 " + currentSpeed + "km/h"  );
	}
	
	// 속도감소
	void speedDown (int speed) {  // 매개변수 생성
		if (!engineStatus /* 엔진 off 상태*/) {
			System.out.println(modelName + "시동 off 상태");
			return;  // 다시 되돌아 갈 수 있게 return; 사용해줌
		}
		
		if (currentSpeed < speed) {
			speed = currentSpeed;
		}
		
		currentSpeed -= speed;
		System.out.println(modelName + "의 속도" + speed +"km/h 감소, 현재 속도는 " + currentSpeed + "km/h"  );
	}
	
	// 중지
	
	void speedZero () {  // 매개변수 필요x
		// 속도가 0일때만 "정지상태" 출력
		if (currentSpeed == 0) {
			System.out.println(modelName + " 정지상태");
		}
		
	}
	
	// 은닉화 처리된 필드를 위해 필드값을 변환하는 getter 메소드와 빌드값을 변경하는 sptter메소드 선언
    //  └-> 캡술화
	
	// 캡슐화(Encapsulation) :  표현대상의 속성(필드)과 행위(메소드)를 하나의 자료형(클래스)으로 작성
	// => (좁은 의미)필드를 은닉화 처리하여 보호하고 메소드를 이용하여 처리되도록 설정
	
	// Getter 메소드 : 클래스의 외부에서 필드값을 사용할 수 있도록 필드값을 반환하는 메소드
	// => 필드의 자료형이 [boolean]인 경우 메소드 이름은 [is 필드명] 으로 작성
	// 형식 : public 반환형 get필드형 () { return 필드명; }
	
	public String getModelName ( ) {
		return modelName;
	}
	
	// Setter 메소드 : 매개변수로 값을 전달받아 매개변수에 저장된 값으로 필드값을 변경하는 메소드
	// 형식 : public void set필드명 (자료형 변수명) { 필드명 = 변수명; }
	// => 매개변수에 저장된 값에 대한 검증

	public void setModelName (String modelName) {
		// this : 메소드 내부에서 클래스의 객체를 표현하는 키워드
		// => this 키워드를 사용하여 필드 표현
		 this.modelName = modelName;  // 명칭이 같다면(매개변수와 필드 구분이 안되므로) this를 추가해 필드로 선언한다
	 }
	
	// 이클립스에서는 은닉화 처리된 필드에 대한 Getter 메소드와 Setter 메소드를 생성하는 기능
	// Source -> Generate Getters and Setters 
	// └-> [Alt]+[Shift]+[s] -> 팝업메뉴 [R] -> 필드 선택 -> Genetate
	
	public boolean isEngineStatus() {
		return engineStatus;
	}

	public void setEngineStatus(boolean engineStatus) {
		this.engineStatus = engineStatus;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	

}


































































