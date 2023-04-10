package association_0410;

public class CarApp {
	public static void main(String[] args) {
		
		// 엔진 생성
		Engine engine = new Engine();
		
		engine.setFuelType("경유");
		engine.setDisplacement(2000);
		
		// engine.dispalyEngine();
		
		
		// 자동차 생성
		Car carOne = new Car();
		
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
		Car carTwo = new Car("싼타페", 2023, new Engine("휘발유", 3000));
		
		carTwo.displayCar();
		System.out.println("===============================================");
		
		// 엔진정보만 확인
		System.out.print(carOne.getModelName() + "의 엔진정보 -> ");
		engine.dispalyEngine();
		System.out.println("===============================================");
		
		// 참조변수를 만들지 않고 필드에 저장되어 있는 정보 가져온다
		// " carTwo.getCarEngine().dispalyEngine(); "
		
		System.out.print(carTwo.getModelName() + "의 엔진정보 -> ");
		// 자동차(Car객체)에 저장된 엔진정보(engine 필드값 - Engine 객체)를 Getter메소드로
		//  반환 받아 Engine 객체의 메소드 호출
		carTwo.getCarEngine().dispalyEngine();
		
		
		
	}

}
