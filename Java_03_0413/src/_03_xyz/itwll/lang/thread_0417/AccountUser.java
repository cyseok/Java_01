package _03_xyz.itwll.lang.thread_0417;

// 은행계좌 사용자정보(은행계좌, 사용자명)를 저장하기 위한 클래스
public class AccountUser {
	private Account account;  // 은행 계좌 정보 -> 포함관계
	private String userName;  // 사용자명
	
	public AccountUser() {
		// TODO Auto-generated constructor stub
	}

	public AccountUser(Account account, String userName) {
		super();
		this.account = account;
		this.userName = userName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
