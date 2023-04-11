package Inheritance_0410;

public class CarApp { 
	public static void main(String[] args) {
		
		Car car = new Car("싼타페", "홍길동");
		
		System.out.println("모델명 = " + car.getModelName());
		System.out.println("소유자 = " + car.getUserName());
		System.out.println("====================================");
		
	}

}
