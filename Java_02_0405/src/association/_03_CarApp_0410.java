package association;

public class _03_CarApp_0410 {
	public static void main(String[] args) {
		
		// 엔진 생성
		_02_Engine_0410 engine = new _02_Engine_0410();
		
		engine.setFuelType("경유");
		engine.setDisplacement(2000);
		
		// engine.dispalyEngine();
		
		
		// 자동차 생성
		_01_Car_0410 carOne = new _01_Car_0410();
		
		carOne.setModelName("쏘렌토");
		carOne.setProductionYear(2020);
		// setter 메소드를 호출하여 매개변수에 엔진정보를 전달받아 필드에 저장한 것
		// => 포함관계 성립
		carOne.setCarEngine(engine);
		// 출력: 엔진정보 = association._02_Engine_0410@1e643faf
		// -> 객체의 메모리 주소가 출력된다.
		
		carOne.displayCar();
		System.out.println("===============================================");
		
		// 다른방법
		// 이렇게도 생성자 만들 수 있음, 엔진을 생성하여 필드에 저장해 포함관계 성립
		// 생성자를 호출하여 매개변수에 엔진정보(_02_Engine_0410 객체)를 전달받아 필드에 저장
		_01_Car_0410 carTwo = new _01_Car_0410("싼타페", 2023, new _02_Engine_0410("휘발유", 3000));
		
		carTwo.displayCar();
		System.out.println("===============================================");
		
		
		
	}

}
