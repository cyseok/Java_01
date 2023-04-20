package _04_xyz.itwill.utill_0419;

// 학생정보(학번, 이름)를 저장하기 위한 클래스 
// └-> VO클래스 : 값 저장 목적의 객체를 생성하기 위한 클래스 

public class Student {
	private int num;
	private String name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
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
	
	// VO 클래스의 필드값을 반환받아 확인하기 위해 사용
	@Override
	public String toString() {
		
		return "학번 = " + num + ", 이름 = " + name;
	}

}
