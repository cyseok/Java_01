package Basic;

//1~45 범위의 정수형 난수값을 6개 제공받아 출력
// => 6개의 난수값은 서로 중복되지 않도록하고 오름차순 정렬
// 정렬(sort) : 오름차순(Ascending sort), 내림차순(Descending sort)

public class _19_LottoApp_0404 {
	
	public static void main(String[] args) {
		
		// 6개의 정수 난수값을 저장하기 위한 배열 생성
		int [] lotto = new int[6];  
		
		// 1~45범위의 정수난수를 6개 제공받아 배열요소에 차례대로 저장
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45)+1;
		}
		// 배열의 모든 요소값 출력
		System.out.print("로또 번호 -> ");
		
		for (int number : lotto) {
			System.out.print(number + " ");
		} System.out.println();
		
		System.out.println("=================================");
		
		// 중복제거 + 오름차순 정렬
		// 중복제거는 난수값을 생성할때 이미 생성되어 있는 수들을 비교해 같은 수가 아니면 출력
		
		// 6개의 정수 난수값을 저장하기 위한 배열 생성
		
				int [] lotto1 = new int[6];  
				
				// 1~45범위의 정수난수를 6개 제공받아 배열요소에 차례대로 저장
				for (int i = 0; i < lotto1.length; i++) {
					// 요소에 저장된 새로운 난수값을 기존 요소의 난수값과 모두 비교하여 
					// 같은 값이 있는경우 반복문을 이용하여 새로운 난수값을 다시 제공받아 저장
					// => 새로운 난수값이 기존의 모든 난수값과 다른 경우 반복문 종료
					
					// ****************** 중복제거 ***********************
					while(true) {
						// 1~45범위의 정수난수를 6개 제공받아 배열요소에 차례대로 저장
						lotto1[i] = (int)(Math.random()*45)+1;
						
						// 중복상태를 저장하기 위한 변수  false : 미중복, true : 중복
						boolean result = false;
						
						for (int j = 0; j < i; j++) {  //기존 요소에 저장된 난수값(첨자)을 표현하기위한 반복문
							if (lotto1[i] == lotto1[j]) {
								result = true;
								break;
								
							}
						}
						// 새로운 난수값이 기존 난수값과 중복되지 않는 경우 while 구문 종료
						if (!result) break; 
					}
				}
				// ****************************** 정렬 *******************************
				// 배열의 모든 요소값을 서로 비교해 오름차순 정렬
				// => 선택 정렬(Selection sort Algorithm)을 사용하여 오름차순 정렬 
				// 첫번째 부터 뒤에있는 수랑 비교하며 더 작으면 바꾸고 계속 진행 하고 끝나면
				// 두번째 부터 또 실행
				
				for (int i = 0; i < lotto1.length; i++) {
					
					for(int j = i+1; j <lotto1.length; j++) { // 비교 요소의 첨차를 표현하는 반복문 -> 비교+1 ~ 끝까지
						if (lotto1[i] > lotto1[j]) {
							int temp = lotto[i];
							lotto1[i] = lotto1[j];
							lotto1[j] = temp;
							
				// 0번째 숫자부터 비교하는데 0번째 +1 번째 숫자가  앞의 숫자보다 크면 바꾸고
				// 바꾼 숫자를 기존 숫자로 지정한다.
							
						}
						
					}
					
				}
				
				System.out.print("로또 번호 -> ");
				
				// 숫자 반복해서 출력
				for (int number : lotto1) {
					System.out.print(number + " ");
				} 
				System.out.println();
				
				System.out.println("=================================");
		
	
	}

}
