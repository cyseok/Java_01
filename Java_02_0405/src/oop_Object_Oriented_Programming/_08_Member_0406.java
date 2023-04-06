package oop_Object_Oriented_Programming;

// import java.lang.reflect.Member;

// 회원정보(ID, PW, E-Mail)를 저장하기 위한 클래스
// => VO(Value Object)클래스 : 특정 대상의 값을 저장하는 객체를 생성하기 위한 클래스

public class _08_Member_0406 {
	
	// 필드선언 : 객체를 생성하면 객체의 필드에는 기본값이 초기값(0, false, null)으로 자동 저장됨.

	private String id;
	private String name;
	private String email;

	// 생성자 선언 : 객체를 생성하기 위한 특별한 형태의 메소드 
	// => 생성자를 선언하지 않으면 매개변수가 없는 기본 생성자 제공
	// => 생성자를 선언하면 매개변수가 없는 기본 생성자 미제공
	// => 객체 필드에 원하는 초기값이 저장된 책체를 생성하기 위해 생성자를 선언한다.
	// 형식 : 접근제한자 클래스명 (자료형 매개변수, 자료형 매개변수, ...) { 명령; 명령; ...}
	// => 반환형을 작성하지 않고 생성자의 이름은 반드시 클래스 이름과 동일하게 작성 ★
	// => 메소드 오버로드를 사용하여 생성자를 어려개 선언가능
	// => 일반적으로 생성자에서는 필드에 필요한 초기값을 저장하기 위한 명령을 작성한다. -> 초기화 작업
	
	// 매개변수가 없는 생성자 선언 -> 기본 생성자 (Default Constructor)
	// => 초기화 작업은 하지않는다. -> 객체 필드에는 기본값이 초기값으로 저장됨
	// => 기본 생성자를 선언하지 않으면 상속시 문제가 발생할 수 있으므로 기본생성자를 선언하는 것을 권장하긴 한다.
	// 이클립스를 사용하여 기본생성자 선언
	 // => [Ctrl]+[Space] -> Constructor 선택
	public _08_Member_0406 () {   // 반드시 만들어야함★
		// TODO Auto-generated constructor stub
		
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
