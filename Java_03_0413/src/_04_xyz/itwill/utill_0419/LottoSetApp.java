package _04_xyz.itwill.utill_0419;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//1~45 범위의 정수형 난수값을 6개 제공받아 출력
//=> 6개의 난수값은 서로 중복되지 않도록하고 오름차순 정렬

public class LottoSetApp {
	public static void main(String[] args) {
		
		// Integer요소만 저장 가능한 Set객체 생성
		Set<Integer> lottoSet = new HashSet<Integer>();
		
		Random random = new Random();
		
		while (true) {
			// 중복제거
			lottoSet.add(random.nextInt(45) + 1); 
			
			// 요소의 개수가 6인경우 반복문 종료
			if (lottoSet.size() == 6) break;
			
		}
		// toArray(new Integer[0] : 모든 요소값을 배열에 저장하는 메소드
		Integer[] lotto = lottoSet.toArray(new Integer[0]);
		
		// ★★ Arrays.sort(Object[] a) : 배열의 요소값을 정렬하는 메소드
		Arrays.sort(lotto);
		
		System.out.println("행운의 숫자 = " + Arrays.toString(lotto));
		
		
		
		
	}

}




































