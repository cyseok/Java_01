package xyz.itwill06.oop;

//Proxy 클래스 : 핵심관심모듈의 메소드에 횡단관심모듈의 메소드를 삽입하여 동작하는 기능을 제공하는 클래스 - Aspect
public class AopProxy implements Aop {
	// 핵심관심모듈로 선언된 클래스의 객체를 저장하기 위한 필드 생성
	// => 필드의 자료형을 인터페이스로 선언하여 모든 자식 클래스의 객체 저장
	private Aop target;//인터페이스를 상속(AopOne,AopTwo는 자식클래스)
	
	// 횡단관심모듈로 선언된 클래스의 객체를 저장하기 위한 필드 생성
	private AopLogger logger;
	
	// 필드에 객체를 생성하여 저장하거나 매개변수로 객체를 전달받아 저장 - 의존성 주입(DI)
	// 생성자 생성(target만)
	public AopProxy(Aop target) {
		super();
		this.target = target;
		logger=new AopLogger();//logger은 만들어서 저장
	}
	// 인터페이스에 추상메소드(PointCut)를 오버라이드 선언하여 핵심관심코드와 횡단관심코드를 결합하여 실행되도록 작성 - Weaving
	// => 핵심관심모듈의 메소드 호출 전 또는 후에 횡단관심모듈의 메소를 호출하여 실행되도록 설정 - JoinPoint
	@Override
	public void display1() {
		logger.beforeLog();
		target.display1();
	
	}
	@Override
	public void display2() {
		logger.beforeLog();
		target.display2();
	}
	
	@Override
	public void display3() {
		logger.beforeLog();
		target.display3();
	}
}
