package _03_xyz.itwll.lang.thread_0417;

public class SingleThread {
	public void display() {
		System.out.println("SingleThread 클래스의 display() 메소드 시작");
		System.out.println(Thread.currentThread().getName() + "스레드에 의해 main() 메소드의 명령실행");
		System.out.println("SingleThread 클래스의 display() 메소드 종료");
	}

}