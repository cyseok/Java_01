package oop_Object_Oriented_Programming;


// 학생정보(학번, 이름, 국어, 영어, 총점)를 저장하기 위한 클래스 -> VO클래스
public class _10_Student_0407 {

	// 필드에 학생정보(학번, 이름, 국어, 영어, 총점)선언
	private int num;
	private String name;
	private int kor, eng, total;
	
	
	// 생성자(Constructor)
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
	
	
	
	
	
	
	
	

}
 
















































