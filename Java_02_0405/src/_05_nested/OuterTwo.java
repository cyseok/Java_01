package _05_nested;

public class OuterTwo {
	
	private int outerNum;
	
	public OuterTwo() {
		// TODO Auto-generated constructor stub
	}

	public OuterTwo(int outerNum) {
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
		
		
		// 외부클래스는 정적 내부클래스로 객체를 생성하여 
		//  접근제한자에 상관없이 정적 내부클래스 필드 또는 메소드 참조가능
		InnerTwo innerTwo = new InnerTwo(200);  // 객체를 생성하여 사용가능
		System.out.println("innerNum = " + innerTwo.innerNum);
		innerTwo.innerDisplay();
		
		// 외부클래스에서는 정적 내부클래스를 사용하여 정적필드 또는 정적메소드 접근 가능하다.
		System.out.println("staticNum = " + InnerTwo.staticNum);
	}
	
	// 정적 내부클래스(static InnerClass) : static 제한자를 사용하여 클래스를 선언한다.
	// => 정적 내부클래스에서는 static 제한자를 사용하여 필드 또는 메소드 선언이 가능하다.
	public static class InnerTwo {
		private int innerNum;
		private static int staticNum = 300;
		
		public InnerTwo() {
			// TODO Auto-generated constructor stub
		}

		public InnerTwo(int innerNum) {
			super();
			this.innerNum = innerNum;
		}

		public int getInnerNum() {
			return innerNum;
		}

		public void setInnerNum(int innerNum) {
			this.innerNum = innerNum;
		}

		public static int getStaticNum() {
			return staticNum;
		}

		public static void setStaticNum(int staticNum) {
			InnerTwo.staticNum = staticNum;
		}
		
		public void innerDisplay () {
			System.out.println("innerNum = " + innerNum);
			System.out.println("staticNum = " + staticNum);
			
		// 정적 내부클래스에서는 외부클래스의 필드 또는 메소드 참조 불가능
		// => 외부클래스의 정적필드 또는 정적메소드는 참조 가능
		//	System.out.println("outerNum = " + outerNum);
		//	outerDisplay();
			
			
			
		}
		
	}

}



















