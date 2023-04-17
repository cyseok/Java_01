package _03_xyz.itwll.lang.thread_0417;


public class AccountUserApp {
	public static void main(String[] args) {
		// Account 클래스로 객체를 생성하여 저장 -> 은행계좌 생성
		Account account = new Account(10000);  // 잔액 = 10000원
		
		/*
		// 단일스레드를 이용하여 은행계좌를 사용하는 사용자를 여러개 생성
		// => 은행계좌를 사용하는 사용자를 여러개 생성하여 같은 은행계좌를 사용하도록 설정
		AccountUser one = new AccountUser(account, "홍길동");
		AccountUser two = new AccountUser(account, "임꺽정");
		AccountUser three = new AccountUser(account, "전우치");
		
		// 단일 스레드를 이용하여 은행계좌 사용자를 이용한 은행계좌의 입금 처리
		one.getAccount().deposit(one.getUserName(), 5000);
		two.getAccount().deposit(two.getUserName(), 5000);
		three.getAccount().deposit(three.getUserName(), 5000);
		*/
		
		
		// 스레드가 여러개 생성되어 run메소드를 실행(입금, 출금처리)함.
		new AccountUser(account, "홍길동").start();
		new AccountUser(account, "임꺽정").start();
		new AccountUser(account, "전우치").start();
		
		// └-> 결과가 일관적이지 않다. 
		// => 같은 객체의 메소드를 다수의 스레드가 실행(필드값을 변경하는 행위)할 경우 부정확한 결과가 발생될 수 있다.
		// => 해결법 : 스레드 동기화를 이용하여 스레드에 해단 메소드 호출 제어
		
		// ★★★ 스레드 동기화(Thread synchronize) : 스레드에 의해 메소드 호출시 메소드의 모든 명령을
		//    실행하기 전까지 다른 스레드로 메소드를 호출하지 못하도록 방지하는 것
		// => 다른 스레드가 이미 실행중인 경우 잠시 일시 중지하여 기존 스레드가 끝난 후 실행시킴
		// └-> Lock 기능 제공
		
		// 스레드 동기화 처리방법
		
		// 1. synchronize 키워드를 사용하여 메소드 선언 = 동기화 메소드
		// => 형식 : 접근제한자 synchronize 반환형 메소드명 (자료형 매개변수, ...) { 명령; ... }
		// 2. synchronized 키워드로 블럭을 설정하여 메소드를 호출
		// 형식 : synchronized (객체) { 객체.메소드 명(값, ... );  }
		// => synchronized 영역의 객체로 호출되는 모든 메소드는 동기화 처리되어 실행
		
		
		
		
	}

}














































