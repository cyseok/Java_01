package association;

// 클래스와 클래스의 관계 (= 객체관계)
// => UML(Unified Modeling Language)을 사용하여 클래스 다이어그램으로 표현

// 1. 일반화 관계(Genearalization) :  상속 관계(inheritance) (= x is a Y)
// => 클래스를 선언할 때 기존 클래스를 상속받아 작성
// => ex) 사원 클래스와 관리자 클래스의 관계(관리자는 사원이다(O), 사원은 관리자이다(X))
// 2. 실체화 관계(Realization) : 상속 관계
// => 클래스를 선언할 때 기존 인터페이스를 상속받아 작성
// => 인터페이스 : 현실에 존재하는 대상을 클래스 보다 추상적으로 표현하기 위한 자료형
// 3. 연관 관계(Association) : 포함 관계 (= X has a Y)
// => 직접 연관 관계(Direct Association) : 한 방향으로만 도구로써 기능을 제공하는 관계
// => 컴퓨터 << CPU + MainBoard + Memory
// 4. 집합 연관 관계(Aggregation) : 포함관계로 설정된 객체들의 생명주기가 다른 포함 관계
// => 컴퓨터 << 프린터
// 5. 복함 연관 관계(Composition) : 포함관계로 설정된 객체들의 생명주기가 같은 포함 관계
// => 게임 << 캐릭터
// 6. 의존 관계(Dependency) :  포함 관계로 설정된 객체를 변형해도 다른 객체에 영향을 주지 않는 포함 관계
// => TV << 리모콘

// 자동차 정보(모델명, 생산년도, 엔진정보)를 저장하기 위한 클래스
public class _01_Car_0410 {
	
	private String modelName;
	private int productionYear;
	// 엔진정보를 저장하기 위한 필드 생성 -> Engine 클래스가 자료형으로 선언된 필드
	// => 필드에는 Engine 객체를 제공받아 저장 -> 포함 관계
	// └-> 생성자 or Setter 메소드를 이용하여야 한다.
	
	// ★★★★★ 생성한 클래스를 선언한다.(관계를 맺고있는 필드에 값을 저장시켜야한다.)
	private _02_Engine_0410 carEngine; 
	
	
	
	public _01_Car_0410() {
		// TODO Auto-generated constructor stub
	}
	

	public _01_Car_0410(String modelName, int productionYear, _02_Engine_0410 carEngine) {
		super();
		this.modelName = modelName;
		this.productionYear = productionYear;
		this.carEngine = carEngine;
	}


	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public _02_Engine_0410 getCarEngine() {
		return carEngine;
	}

	public void setCarEngine(_02_Engine_0410 carEngine) {
		this.carEngine = carEngine;
	}
	
	// 자동차 정보(필드값)를 출력하는 메소드
	public void displayCar() {
		System.out.println("모델명 = " + modelName);
		System.out.println("생산년도 = " + productionYear);
		
		/*
		System.out.println("엔진정보 = " + carEngine);
		// 그냥 출력시 : 엔진정보 = association._02_Engine_0410@1e643faf
		// -> 객체의 메모리 주소가 출력되서 필드에 저장된 객체를 이용하여 메소드를 호출해야 한다.
		// => 포함관계로 설정된 클래스(객체)의 메소드를 호출하여 원하는 기능 구형
		// => 포함관계가 설정되지 않은 상태에서 메소드가 호출될 경우 NullPointException 발생
		// └-> 객체를 제공받아 저장해야한다는 뜻 ( 이렇게 만들어줘야함 -> carOne.setCarEngine(engine); )
		// 따라서 밑에 gettter메소드로 호출해줘야한다
		System.out.println("연료타입 = " + carEngine.getFuelType());
		System.out.println("배기량 = " + carEngine.getDisplacement());
		*/
		
		carEngine.dispalyEngine();  // 위에 주석처리 대신 사용가능하고, 코드 중복성을 최소화 할 수 있다.
		
	}
	

}






























