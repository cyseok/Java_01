package Inheritance_0410;

// 시간제 사원정보(사원번호, 사원이름, 시급, 근무시간)를 저장하기 위한 클래스
// => Employee 클래스를 상속받아 작성한다.

public class Employeetime extends Employee {
	private int moneyPerHour;
	private int workedHour;
	
	public Employeetime() {
		// TODO Auto-generated constructor stub
	}


	public Employeetime(int empNo, String empName, int moneyPerHour, int workedHour) {
		super(empNo, empName);
		this.moneyPerHour = moneyPerHour;
		this.workedHour = workedHour;
	}

	public int getMoneyPerHour() {
		return moneyPerHour;
	}

	public void setMoneyPerHour(int moneyPerHour) {
		this.moneyPerHour = moneyPerHour;
	}

	public int getWorkedHour() {
		return workedHour;
	}

	public void setWorkedHour(int workedHour) {
		this.workedHour = workedHour;
	}
	
	// 급여를 반환하는 메소드
	public int computeTimePay () {
		return moneyPerHour * workedHour;
	}
	
	@Override
	public int computePay() {
		// TODO Auto-generated method stub
		return moneyPerHour * workedHour;
	}

}
