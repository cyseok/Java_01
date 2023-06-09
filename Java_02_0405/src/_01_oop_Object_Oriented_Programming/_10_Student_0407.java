package _01_oop_Object_Oriented_Programming;

// static 키워드 : "객체가 아닌 클래스"로 접근하기 위한 기능을 제공하는 제한자
// => 클래스(내부클래스에서만 가능), 필드, 메소드에 사용가능
// 제한자(Modifier) : 특별한 기능(= 제한)을 제공하기 위해 사용하는 키워드
// => Access Modifier(private, package, protected, public), static, final, abstract 


// 학생정보(학번, 이름, 국어, 영어, 총점)를 저장하기 위한 클래스 -> VO클래스
public class _10_Student_0407 {

	// 객체 필드(= instance field)에  -> 필드 : 객체가 생성될 때 메모리(HeapArea)에 생성되는 필드
	// 학생정보(학번, 이름, 국어, 영어, 총점)선언
	private int num;
	private String name;
	private int kor, eng, total;
	
	// 정적 필드(static field) : 클래스를 읽어 메모리(MethodArea)에 저장될때 생성되는 필드
	// => 객체가 생성되기 전에 메모리에 단 하나만 생성되는 필드
	// (정리) 클래스 내부에 tot이라는 필드가 하나만 생성된다
	// => ★생성자에서 초기화 처리하지 않고, 직접 초기값을 필드에 저장시킨다.
	// => 클래스로 생성된 모든 객체가 정적 필드를 사용할 수 있다. (=공유값) -> 메모리 절약 및 필드값 변경 용이
	// => 클래스 외부에서는 객체가 아닌 클래스를 사용하여 접근 가능
	private static int tot =0;  // "기본값을 초기값"으로 사용할 경우 초기값 저장 생략 가능
	
	
	// 생성자(Constructor) : 객체를 생성하면서 instance field에 원하는 초기값을 저장하기 위해 작성
	public _10_Student_0407 () {
		// TODO Auto-generated constructor stub
	}
	
	
	public _10_Student_0407(int num, String name, int kor, int eng) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.total = total;
		
		// 총점을 계산하여 필드에 저장하는 명령작성 -> 메소드 호출
		// => 코드의 중복성을 최소화 하여 프로그램의 생산성 및 유지보수의 효율성 증가
		// total = kor + eng;
		calTot();
	}
	
	// 인스턴스 메소드(Instance Method) : this 키워드가 제공되는 메소드
	// => this 키워드를 이용하여 인스턴스 필드 및 메소드 접근 가능
	// => 클래스를 사용하여 정적 필드 및 메소드 접근 가능 -> 클래스 생략 가능
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
		calTot();
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
		calTot();
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}
	
	// 은닉화 선언된 메소드 -> 클래스 내부에서만 호출하여 사용하는 메소드이다.
	// => 코드의 중복성을 최소화하기 위한 기능을 제공하는 메소드
	private void calTot () {  // 총점을 계산하기 위한 메소드
		total = kor + eng;
	}

	
	public void display () {
		System.out.print("[" + name + "] 님의 성적 -> ");
		System.out.println("국어 = " + kor + ", 영어 = " + eng + ", 총점 = " + total);
	}

	// 정적 메소드(static method) : this 키워드를 제공하지 않는 메소드
	public static int getTot() {
		
		// this 키워드가 없으므로 인스턴스 필드 밒 메소드 접근 불가능
		// => 클래스를 사용하여 정적 필드 및 메소드 접근 가능 -> 클래스 생략 가능
		// 정적필드는 접근 가능
		// total = kor + eng;
		return tot;
	}


	public static void setTot(int tot) {
		_10_Student_0407.tot = tot;
	}
	
	
	
	

}
 
















































