package nested_0412;

public class OuterThree {
	
	private int outerNum;
	
	public OuterThree() {
		// TODO Auto-generated constructor stub
	}

	public OuterThree(int outerNum) {
		super();
		this.outerNum = outerNum;
	}

	public int getOuterNum() {
		return outerNum;
	}

	public void setOuterNum(int outerNum) {
		this.outerNum = outerNum;
	}
	
	public void outerDisplay () {
		System.out.println("outerNum = " + outerNum);
	}
	
	public void local () {
		// 클래스를 메소드 내부에 생성 => "로컬클래스"
		class InnerThree {
			
		}
	}
	
}
