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
	
	
	public MemberEvent() {
		// TODO Auto-generated constructor stub
	}
	
	// super 키워드 : 자식클래스의 메소드에서 부모클래스 객체의 메모리 주소를 저장하기 위한 키워드
	// => 자식클래스의 메소드에서 부모클래스 객체의 필드 또는 메소드를 참조하기 위해 사용한다.
	// => 자식클래스의 메소드에서 super 키워드를 쓰지않아도 자식클래스의 메소드에서는 
	//     this키워드로 참조되는 필드와 메소드가 없으면 자동으로 부모클래스 객체의 필드 또는 메소드를 참조한다.

	// super 키워드를 사용하는 경우
	// 1. 자식클래스의 생성자에서 부모클래스의 생성자를 호출하기 위해 super 키워드를 사용한다.
	// => 부모클래스 객체가 생성될 떄 필드에 원하는 초기값 저장 가능
	// 형식 : super(값, 값, ...);
	// => 생략된 경우 부모클래스의 매개변수가 없는 기본 생성자를 호출하여 초기화 처리
	// => 생성자에서 다른 생성자를 호출하는 명령은 반드시 첫번째 명령으로 작성된다.
	// 2. 자식클래스의 메소드에서 오버라이드 선언되어 숨겨진 부모클래스의 메소드를 호출할 경우 super 키워드를 사용한다.
	
	public MemberEvent(String id, String name, String email) {
		
		/*
		// 자식클래스의 메소드에서는 this 키워드로 자식클래스 객체의 필드 또는 메소드를 참조하고
		// 자식클래스 객체의 필드 또는 메소드가 없는 경우 super 키워드를 사용하여 부모클래스 객체의 필드 또는 메소드를 참조한다.
		// => 부모클래스의 필드 또는 메소드가 은닉화 선언된 경우 접근 불가능
		
		super();  // 부모클래스의 매개변수가 없는 기본 생성자 호출(생략가능)
		// ★ set으로 다시 선언
		// this.id = id;
		setId(id);
		// └-> super.setId(id); 로 써야하는데
		// => 자식클래스의 메소드에서 super 키워드를 쓰지않아도 자식클래스의 메소드에서는 
				//     this키워드로 참조되는 필드와 메소드가 없으면 자동으로 부모클래스 객체의 필드 또는 메소드를 참조한다.

		// this.name = name;
		setName(name);
		*/
		
		// 위에 범위주석 부분 대신에
		// super(id,name); 으로 간단하게 쓰면된다(부모클래스의 매개변수가 없는 기본 생성자 호출)
		// └=> Alt + Shift + s 에서 O -> 부모클래스 생성자를 (String,...) 선택해주면된다.(이때는 default로 하면 안된다 )
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
	
	
	// ★★★ 메소드 오버라이딩(Method Overriding) :  상속관계에서 부모클래스의 메소드를 자식클래스에서
	// 재선언하는 기능
	// => 부모클래스의 메소드를 자식클래스의 객체가 사용하기 부적절한 경우 부모클래스의 메소드를
	//    자식클래스에서 재선언하여 사용하는 방법
	// => 부모클래스의 메소드는 숨겨지고(Hide Method) 자식클래스의 메소드만 접근 가능하게 만듬
	// ★ 메소드 오버라이드의 작성 규칙 :  부모클래스의 메소드와 같은 
	//     접근지정자, 반환형, 메소드명, 매개변수, 예외전달을 사용하여 메소드를 작성해야 한다.
	
	
	/*
	public void display() {
		// System.out.println("아이디 = " + id);
		System.out.println("아이디 = " + getId());
		// System.out.println("이름 = " + name);
		System.out.println("이름 = " + getName());
		System.out.println("이메일 = " + email);
	}
	*/
	// 이클립스에서는 부모클래스의 메소드를 자식클래스에서 오버라이드 선언되도록 
	// 자동 완성하는 기능 제공
	// => 오버라이드 선언하고 싶은 부모클래스의 메소드명 입력 -> Ctrl + Space
	//   └-> Override Method 선택
	// @Override 오버라이드 선언된 메소드를 표현하기 위한 어노테이션
	// 어노테이션(Annotation) : API문서에서 특별한 설명을 제공하기 위한 기능의 자료형(인터페이스)
	// => Java Source 작성에 필요한 특별한 기능을 제공하기 위해 사용되는 자료형
	// => @Override, @Deprecated, @SuppressWarings
	// @Deprecated : 유지보수가 중단되어 곧 사라질 수 있는 메소드
	// @SuppressWarings : 경고 제거할 때
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		super.display(); //super를 사용하면 부모클래스에 있는 숨겨진 메소드를 사용할 수 있다.
		System.out.println("이메일 = " + email);
	
	}
	
	
	 
	
	
}




























