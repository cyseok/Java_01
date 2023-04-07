package oop_Object_Oriented_Programming;


// 싱글톤 디자인 패턴을 적용하여 작성된 클래스 -> 싱글톤 클래스(Singleton class)
// => 프로그램에 객체를 하나만 제공하기 위한 목적의 클래스를 작성하기 위해 사용한다.
// => 프로그램에 불필요한 객체가 여러개 생성되는 것을 방지하기 위한 디자인 패턴
public class _14_Singleton_0407 {
	
	// 클래스의 객체(메모리 주소)를 저장하기 위한 필드 선언
	// => static 제한자를 사용하여 정적 필드를 선언한다.
	// 객체의 갯수와 상관없이 필드가 하나만 만들어진다. (클래스가 읽어지면서 메소드 영역에 저장될 때)
	// 시스템 필드( '_' 사용) : 클래스 내부에서만 사용하기 위한 필드로 
	// => Getter 메소드와 Setter 메소드를 작성하지 않는다.
	// => 일반적인 필드와 구분하기 위해 필드명을 '_'로 시작하는 것을 권장한다.
	private static _14_Singleton_0407 _instance;
	
	// 생성자를 은닉화 선언 -> public을 private로 변경해준다.
	// => 클래스 외부에서 생성자에 접근하지 못하도록 설정한다. -> 객체 생성 불가능.
	private _14_Singleton_0407() {
		// TODO Auto-generated constructor stub
	}
	
	

	
}
