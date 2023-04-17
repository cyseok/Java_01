package _03_xyz.itwll.lang.thread_0417;

// 은행 계좌 정보(잔액)를 저장하기 위한 클래스
// => 입금 및 출력 관련 메소드
public class Account {
	private int balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// 입금 처리 메소드
	public void deposit (int amount, String name) {
		balance += amount;
		System.out.println("[입금] " + name + "님이 " + amount + "원 입금하여 잔액은 " + balance + "원 입니다.");
		
	}
	
	
	// 출금 처리 메소드
	public void withDraw (int amount, String name) {
		
		if (balance < amount) {
			System.out.println("[에러] " + name + "님, 잔액이 " + balance + "원 남아 " + amount + "원 출금 불가" );
			return;   // ★ 리턴 중요
		}
		balance -= amount;
		System.out.println("[출금] " + name + "님이 " + amount + "원 출금되어 잔액은 " + balance + "원 입니다.");
		
	}


}










































