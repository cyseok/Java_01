package association;

// 엔진 정보(연료 타입, 배기량)를 저장하기 위한 클래스

public class _02_Engine_0410 {
	private String fuelType;
	private int displacement;
	
	
	public _02_Engine_0410() {
		// TODO Auto-generated constructor stub
	}
	
	
	public _02_Engine_0410(String fuelType, int displacement) {
		super();
		this.fuelType = fuelType;
		this.displacement = displacement;
	}


	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
	public void dispalyEngine() {
		System.out.println("연료 타입 = " + fuelType);
		System.out.println("배기량 = " + displacement);
	}
	
	

}











































