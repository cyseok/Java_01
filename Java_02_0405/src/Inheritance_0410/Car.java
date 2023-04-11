package Inheritance_0410;

// 클래스 선언시 상속받은 부모클래스가 없는 경우 기본적으로 Object 클래스를 자동으로 상속받는다.
// └-> extends Object가 생략되어있다.
// 모든 Java클래스는 무조건 Object클래스를 상속받아 사용가능함.
// Object 클래스 : 모든 Java클래스의 최선조(Root) 클래스
//                  Class Object is the root of the class hierarchy. Every class has Object as a superclass.
//                  All objects, including arrays, implement the methods of this class.

// 자동차 정보(모델명, 소유자명)를 저장하기 위한 클래스
public class Car {   // extends Object가 생략되어있다.
	private String modelName;
	private String userName;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, String userName) {
		super();
		this.modelName = modelName;
		this.userName = userName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
