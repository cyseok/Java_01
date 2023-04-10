package oop_Object_Oriented_Programming;

// ★★★★★
// this 키워드 : 메소드에 숨겨져있는 키워드
// => 메소드 내부에 숨겨져있는 키워드로, 메소드를 호출한 객체의 "메모리 주소(hash)"를 
//     자동으로 전달 받아 자동으로 전달받아 저장하는 키워드
// => 메소드 내부의 명령에서 객체의 필드 또는 메소드를 사용하기 위한 this 키워드 사용
// => 매소드 내부에서 객체를 대신 표현하기 위해 사용하는 키워드
// => this 키워드를 사용하지 않아도 자동으로 객체의 필드 또는 메소드에 접근하여 사용가능

// 메소드에 this 키워드가 존재해야 되는 이유
// => 필드는 객체마다 메모리(HeapArea)에 따로 독립적으로 생성되지만 메소드는 객체와 상관없이
//     메모리(MethodArea)에 하나만 생성된다.  -> 프로토타입클래스(Prototype Class) (자바 자체가 프로토타입클래스이다.)
// => 메소드에서 필드를 사용할 떄 this 키워드를 사용하여 객체를 명확이 구분해 필드에 접근하도록 사용한다.

// ★★★this 키워드를 사용해야 할 때
// 1. 메소드에서 "매개변수의 이름을 필드의 이름과 동일하게 작성"한 경우 필드를 표현하기 위해 사용
// => 생성자 및 Setter 메소드에서 사용 (어떤 값인지 명확하게 구분하기 위해서 동일하게 쓰게된다.)
// 2. 생성자에서 다른 생성자를 호출하여 초기화 작업을 할 경우
// => 자바에선 이 경우는 없다
// 3. 이벤트 처리 프로그램 또는 다중 스레드 프로그램의 메소드에서 객체 자체를 표현 할 경우
// 



// 회원정보(ID, PW, E-Mail)를 저장하기 위한 클래스
// => VO(Value Object)클래스 : 특정 대상의 값을 저장하는 객체를 생성하기 위한 클래스

public class _08_Member_0406 {
	
	// 필드선언 : 객체를 생성하면 객체의 필드에는 기본값이 초기값(0, false, null)으로 자동 저장됨.

	private String id = "NoId";
	private String name = "NoName";
	private String email = "NoEmail";
	// null 대신에 기본값을 바꿨다.

	// 생성자 선언 : 객체를 생성하기 위한 특별한 형태의 메소드 
	// => 생성자를 선언하지 않으면 매개변수가 없는 기본 생성자 제공
	// => 생성자를 선언하면 매개변수가 없는 기본 생성자 미제공
	// => 객체 필드에 원하는 초기값이 저장된 책체를 생성하기 위해 생성자를 선언한다.
	// 형식 : 접근제한자 클래스명 (자료형 매개변수, 자료형 매개변수, ...) { 명령; 명령; ...}
	// => ★ 반환형을 작성하지 않고 생성자의 이름은 반드시 클래스 이름과 동일하게 작성 ★
	// => 메소드 오버로드를 사용하여 생성자를 어려개 선언가능
	// => 일반적으로 생성자에서는 필드에 필요한 초기값을 저장하기 위한 명령을 작성한다. -> 초기화 작업
	
	// 매개변수가 없는 생성자 선언 -> 기본 생성자 (Default Constructor)
	// => 초기화 작업은 하지않는다. -> 객체 필드에는 기본값이 초기값으로 저장됨
	// => ★ 기본 생성자를 선언하지 않으면 상속시 문제가 발생할 수 있으므로 기본생성자를 선언하는 것을 권장하긴 한다.
	// 이클립스를 사용하여 기본생성자 선언
	 // => [Ctrl]+[Space] -> Constructor 선택
	
	/*
	public _08_Member_0406 () {   // 반드시 만들어야함★
		// TODO Auto-generated constructor stub
	}
	*/
	
	public _08_Member_0406 () {
		// System.out.println();
		// this (값, 값, ...)  -> "생성자"에서 this 키워드로 다른 생성자를 호출하는 명령 
		// => this  키워드로 생성자를 호출하는 명령은 첫번째 명령으로 작성
		//     다른명령이 먼저 실행될 경우 error 발생
		this ("NoId", "NoName", "NoEmail");
	}
	
	
	// 매개변수가 있는 생성자 => 매개변수에 전달되어 저장된 값을 필드의 초기값으로 저장
	// 이클립슬ㄹ 사용하여 매개변수가 있는 생성자 선언가능
	// [Alt]+[Shift]+[s] -> 팝업메뉴 [O] -> 필드 선택 -> Generate
	
	// 메소드 선언
	public _08_Member_0406 (String id) {
		this.id = id;
	}
	
	// [Alt]+[Shift]+[s] -> 팝업메뉴 [O] -> 필드 선택 -> Generate
	public _08_Member_0406(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	/*
	public _08_Member_0406(String a, String b, String c) {
		super();
		a = id;
		b = name;
		c = email;
	}  this없이 이렇게 작성하게 되면 매개변수에 전달내용을 모르기 때문에 this 사용
	 */
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// 필드값을 확인하기 위해 필드값을 출력하는 메소드
	public void display() {
		System.out.println("ID = " + id);
		System.out.println("Name = " + name);
		System.out.println("E_mail = " + email);
		
	}
	
	

}
