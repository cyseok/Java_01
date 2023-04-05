package Example;

public class _10_ArrayExample_0404 {
	
	public static void main(String[] args) {
		
		//사람들의 나이를 저장한 배열 생성하여 참조변수에 저장		
				int[] age={27,16,22,36,57,60,43,23,14,29,44,52,59,51,39,33,11};
				
				//배열에 저장된 모든 사람들의 나이 평균을 계산하여 출력하세요.
				int total = 0;
				
				
				System.out.println("===============================================================");
				//배열에 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산하여 출력하세요.
				//ex) 10대 = 3명
				//    20대 = 4명
				//    ...
				//    60대 = 1명
				int age10 = 0, age20 = 0, age30 = 0, age40 = 0, age50 = 0, age60 = 0;
				
				for (int nai : age ) {
					if (nai >= 10 && nai < 20) age10++;
					else if (nai >= 20 && nai < 30) age20++;
					else if (nai >= 30 && nai < 40) age30++;
					else if (nai >= 40 && nai < 50) age40++;
					else if (nai >= 50 && nai < 60) age50++;
					else if (nai >= 60 && nai < 70) age60++;
				}
				
				System.out.println("10대 = " + age10 + "명");
				System.out.println("20대 = " + age20 + "명");
				System.out.println("30대 = " + age30 + "명");
				System.out.println("40대 = " + age40 + "명");
				System.out.println("50대 = " + age50 + "명");
				System.out.println("60대 = " + age60 + "명");
			
				
				System.out.println("===============================================================");
			
				
				int [] count = new int[6];
			
				for(int nai : age) {
					if (nai >= 10 && nai < 20) age[0]++;
					else if (nai >= 20 && nai < 30) age[1]++;
					else if (nai >= 30 && nai < 40) age[2]++;
					else if (nai >= 40 && nai < 50) age[3]++;
					else if (nai >= 50 && nai < 60) age[4]++;
					else if (nai >= 60 && nai < 70) age[5]++;
				}
				for (int i = 0; i < count.length; i++) {
					System.out.println((i+1) + "0대 = " + count[i] + "명");
				}
				System.out.println("===============================================================");
				
	
	
	
	
	
	
	
	
	
	
	
	}

}
