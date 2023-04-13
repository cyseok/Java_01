package _03_Inheritance_0410; // 04/11

// 사원 급여 관리 프로그램

public class EmployeeApp {
	public static void main(String[] args) {
		
		// 부모클래스로 참조변수를 생성하여 자식클래스로 객체를 생성하여 저장이 가능
		/*
		Employee employee1 = new Employee();
		Employee employee2 = new EmployeeRegular();
		Employee employee3 = new Employeetime();
		Employee employee4 = new EmployeeContract();
		*/
		Employee[] empArray = new Employee[5];
		
		empArray[0] = new EmployeeRegular(1000, "홍길동", 9600000);
		empArray[1] = new Employeetime(2000, "임꺽정", 50000, 150);
		empArray[2] = new EmployeeContract(3000, "전우치", 9600000);
		empArray[3] = new Employeetime(4000, "일지매", 20000, 100);
		empArray[4] = new EmployeeRegular(1000, "장길산", 60000000);
		
		for (Employee employee : empArray) {
			System.out.println("사원번호 = " + employee.getEmpNo());
			
			System.out.println("사원번이름= " + employee.getEmpName());
			/*
			if (employee instanceof EmployeeRegular) {
				System.out.println("급여 = " + ((EmployeeRegular)employee).computeSalary());
			} else if (employee instanceof Employeetime) {
				System.out.println("급여 = " + ((Employeetime)employee).computeTimePay());
			} else if (employee instanceof EmployeeContract) {
				System.out.println("급여 = " + ((EmployeeContract)employee).computeContract());
			}
			System.out.println("========================================");
			*/
			
			// 자식클래스에서 부모클래스의 메소드를 오버라이드 선언하면 묵시적 객체 형변환에의해
			// 자동으로 참조변수가 자식클래스로 형변환 되어 자식클래스의 메소드 호출이 가능
			System.out.println("사원급여 = " + employee.computePay());
			// └-=> 자동으로 오버라이드된 결과를 출력한다
			
			// 사원은 인센티브 결과를 반환받아 출력
			System.out.println("인센티브 = " + employee.computeIncentive());
			System.out.println("========================================");
		
		}
		
	}

}
