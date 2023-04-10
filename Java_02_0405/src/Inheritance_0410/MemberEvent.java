package Inheritance_0410;

// 상속(Interitance) : 클래스를 선언할 떄 기존 클래스를 물려받아 사용하는 기능
// => 기존 클래스를 재활용하여 새로운 클래스를 쉽고 빠르게 작성
// => 코드의 중복성을 최소화 하여 프로그램 생산성을 증가하고 유지보수의 효율성 증가
// => 공통적인 속성과 행위를 포함한 다수의 클래스를 선언할 때 
//     공통적인 속성과 행위가 선언된 클래스를 선언하고 상속받아 사용

// 물려주는 클래스 -> 부모클래스 (선조 클래스, 기본클래스, 슈퍼클래스(Super))
// 물려받는 클래스 -> 자식클래스 (후손 클래스, 파생클래스, 서브클래스(Sub))
// 형식 : public class 자식클래스 extends 부모클래스 {
//        자식클래스에서는 부모클래스의 필드 또는 메소드 사용 가능
//            ...  ...
//           }
// => 부모클래스의 생성자는 자식클래스에게 상속되지 않으며 부모클래스의 은닉화 선언된
//    필드와 메소드는 자식클래스에서 접근이 불가능하다.
// => Java에서는 하나의 부모클래스만 상속가능 -> 단일상속

// 자식 클래스의 생성자로 객체를 생성할 경우 부모클래스의 생성자가 먼저 호출되어
// 부모 클래스의 객체가 먼저 생성된 후 자식클래스의 생성자로 객체를 생성하여 상속관계가 성립된다.



// 이벤트 관련 회원정보(아이디, 이름, 이메일)를 저장하기 위한 클래스
// => 회원정보를 저장하기 위한 Member 클래스를 상속받아 작성하는 것을 권장 
//     └-> 재 사용성이 증가된다.
public class MemberEvent extends Member {
	
	/*
	 * 부모 클래스를 상속받아 사용할 수 있으므로 필드 미선언
	private String id;
	private String name;
	*/
	private String email;
	
	// 자식클래스의 메소드에서는 this 키워드로 자식클래스 객체의 필드 또는 메소드를 참조하고
	// 자식클래스 객체의 필드 또는 메소드가 없는 경우 부모클래스 객체의 필드 또는 메소드를 참조한다.
	// => 부모클래스의 필드 또는 메소드가 은닉화 선언된 경우 접근 불가능
	
	public MemberEvent() {
		// TODO Auto-generated constructor stub
	}

	public MemberEvent(String id, String name, String email) {
		super();
		// ★ set으로 다시 선언
		// this.id = id;
		setId(id);
		// this.name = name;
		setName(name);
		this.email = email;
	}
	
	/*
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
	*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void display() {
		System.out.println("아이디 = " + getId());
		System.out.println("이름 = " + getName());
		System.out.println("이메일 = " + email);
	}

}




























