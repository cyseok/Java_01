package _03_xyz.itwll.lang.thread_0417;

// 다중 스레드 프로그램
// => 프로그램 개발자가 직접 스레드를 생성하여 다수의 명령을 동시에 실행되도록 만든 프로그램
// => 프로그램의 모든 스레드가 소멸돼야만 프로그램 종료
// => GUI 프로그램, Web 프로그램등은 만들지 않아도 다중 스레드 프로그램으로 작성된다.

// *** 개발자가 스레드를 생성하여 명령을 실행하는 방법 1. Thread 클래스 이용

// 1. Thread 클래스를 상속받은 자식클래스를 작성
// 2. Thread 클래스를 상속받은 자식클래스에서 ★ run() 메소드 오버라이드 선언
// => run() 메소드에는 개발자에 의해 생성된 스레드가 실행되기 위한 명령을 작성
// 3. Thread 클래스를 상속받은 자식클래스로 객체 생성 -> 부모클래스(Thread) 객체 생성
// 4. Thread 객체로 start() 메소드를 호출해준다 -> Thread 객체를 이용해 새로운 스레드 생성
// => 생성된 스레드는 자동으로 Thread 객체의 run() 메소드를 호출하여 run() 메소드의 명령 실행


// *** 개발자가 스레드를 생성하여 명령을 실행하는 방법 2. Runnable 인터페이스 이용

// => 클래스가 이미 다른클래스를 상속받아 Thread 클래스를 상속받지 못하는 경우
// => Runnable 인터페이스를 상속받아 새로운 스레드를 생성
// 1. Runnable 클래스를 상속받은 자식클래스를 작성
// 2. Runnable 인터페이스를 상속받은 자식클래스에서 run() 메소드를  오버라이드 선언
// => run 메소드에는 프로그램 개발자에 의해 생성된 스레드가 실행되기 위한 명령작석
// 3. Thread 클래스로 Thread 객체를 생성 -> Thread 클래스의 생성자 중 매개변수에 Runnable 
//     인터페이스를 상속받은 자식클래스의 객체를 전달하여  Thread 객체를 생성하는 생성자 이용
// 4. Thread 객체로 start 메소드 호출




public class MultiThreadApp {
	
	// JVM에 의해 main 스레드가 자동으로 생성되어 main 메소드를 호출해 명령이 실행된다.
	public static void main(String[] args) throws InterruptedException {
		
		// throws InterruptedException : 메인 메소드에 의해 전달된 예외인데 이것은 JVM에 의해
		//                               자동으로 처리된다.
		
		/*
		// Thread 클래스로 직접 객체를 생성하여 start 메소드 호출
		// => 새롭게 생성된 스레드는 Thread 객체의 명령이 없는 run메소드 호출
		Thread thread = new Thread(); 
		thread.start();
		*/
		
		
		
		//  MultiThreadOne one = new MultiThreadOne();
		//  one.start();  // -> start 메소드로 새로운 스레드를 생성한 것 
		
		//  자식클래스의 오버라이드 선언된 run 메소드가 호출되어 명령 실행
		// one.start();  하나의 Thread 객체는 하나의 스레드만 생성가능
		// => Thread 객체를 사용하여 start 메소드를 여러번 호출할 경우 IllegalThreadStateException 발생
		// => 다중 스레드 프로그램에서 예외가 발생된 경우 예외가 발생된 스레드만 종료(소멸)
		// ★★ 다중스레드에서는 예외가 발생된 스레드를 빼고 실행이 된다.
		
		// new MultiThreadOne().start();   => 위 대신에 이렇게 작성해도됨.
		// └-> Thread 객체를 사용하여 start 메소드외에 다른 메소드를 호출하지 않을 경우
		//       참조변수에 객체를 저장하지않고 객체를 생성하여 직접 메소드를 호출한다.
		
		new MultiThreadOne().start();
		new MultiThreadOne().start();   // 위 대신에 이거 사용 가능
		
		
		
		
		
		
		// MultiThreadTwo two = new MultiThreadTwo();
		// Thread thread = new Thread(new MultiThreadTwo);
		new Thread(new MultiThreadTwo()).start();
		
		
		for(char i ='A'; i <= 'Z'; i++) {
			System.out.print(i); 
			
			// 매개변수로 전달된 시간동안 스레드가 일시중지됨.
			Thread.sleep(300);  // InterruptedException 예외처리 필수!!
			// => throws InterruptedException 이걸로 넘겨도 되지만 try catch를 사용하는 것이 좋다.
			
			
		}
			
	}	
		
}
















