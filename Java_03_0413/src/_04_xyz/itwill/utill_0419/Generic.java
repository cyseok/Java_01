package _04_xyz.itwill.utill_0419;

// 제네릭(Generic) : 필드의 자료형 대신 사용될 식별자 (미지정 자료형)
// => Java 자료형 선언시 < > 기호 안에 제네릭 타입(식별자) 선언

// 형식 : public class 클래스명 <제네릭, 제네릭, ...> { }
// => < > 안에 제네릭 타입은 , 기호를 사용하여 나열가능
// => 제네릭 타입이 식별자는 대문자로 작성

// 제네릭으로 전달받을 수 있는 Java 자료형을 상속을 이용해 제한 할 수 있다.(extends)
// => 형식 : extends 부모클래스
// => 제네릭은 반드시 부모클래스를 상속받은 Java자료형만 전달받아 사용이 가능하다.
// ★★★  public class Generic<T extends Number> { }

public class Generic<T> {
	private T field;
	
	public Generic() {
		// TODO Auto-generated constructor stub
	}

	public Generic(T field) {
		super();
		this.field = field;
	}

	public T getField() {
		return field;
	}

	public void setField(T field) {
		this.field = field;
	}
	
	

}
