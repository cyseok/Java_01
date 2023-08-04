package xyz.itwill07.aop;

import org.springframework.stereotype.Component;

@Component//자동으로 스프링 빈으로 등록됨(context:component-scan 등록 후)
public class AopAnnotationBean {
	public void display1() {
		System.out.println("### AopAnnotationBean 클래스의 display1() 메소드 호출 ###");
	}
	public void display2() {
		System.out.println("### AopAnnotationBean 클래스의 display2() 메소드 호출 ###");
	}
	public void display3() {
		System.out.println("### AopAnnotationBean 클래스의 display3() 메소드 호출 ###");
		throw new RuntimeException();//인위적 예외 발생
	}
}