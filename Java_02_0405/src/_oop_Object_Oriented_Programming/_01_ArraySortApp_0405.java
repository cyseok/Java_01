package _oop_Object_Oriented_Programming;

import java.util.Arrays;

// 객체지향프로그래밍
// => 객체를 이용하여 프로그램을 작성하는 방식
// => 현실에 존재하는 대상들을 모델링하여 클래스로 선언하고 선언된 클래스로 객체를 생성하여
//     객체의 요소로 프로그램을 작성하는 방법

// => 추상화, 캡슐화, 상속, 다형성

// 1) 추상화(Abstraction)
// 객체 모델링(Object Modeling) : 현실에 존재하는 대상을 속성과 행위로 구분하여 설계
// => 객체 모델링된 대상을 클래스(필드(속성)와 메소드(행위))로 선언
// 클래스는 배포가 가능 : 프로그램의 생산성이 증가 + 유지보수의 효율성 증가



public class _01_ArraySortApp_0405 {
	
	public static void main(String[] args) {
		
		//배열요소 값을 오름차순 정렬해 저장하고 출력하는 프로그램
		int[] array = {30, 50, 10, 40, 20};
		
		System.out.print("정렬 전 -> ");
		
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		// 배열 요소값을 선택정렬 알고리즘을 이용하여 오름차순 정렬
		for(int i = 0; i < array.length-1; i++) {
			for(int j = i+1; j < array.length; j++) {
				if(array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			} 
		}
		System.out.print("정렬 후 -> ");
			for(int num : array) {
				System.out.print(num + " ");
		}
		 System.out.println();
	System.out.println("=================================================================");
		  
		int[] array1 = {30, 50, 10, 40, 20, 70, 60, 90, 80};
		
		// Array 클래스 : 배열의 요소를 제어하는 기능의 메소드를 제공하는 클래스
		// Arrays.toString(Object[] array) : 배열을 전달받아 배열의 요소값들을 문자열로 변환하여 반환
		// Object : 모든 객체의 배열을 전달받는 다는 뜻
		System.out.println("정렬 전 -> " + Arrays.toString(array1));
		
		// Arrays.sort(Object[] array) : 배열을 전달받아 배열의 요소값들을 오름차순 정렬
		Arrays.sort(array1);
		System.out.println("정렬 후 -> " + Arrays.toString(array1));
		
		// 정석은 클래스 가지고 객체를 만든 후 기능을 가져오는것
		 
		 
		 
	
	}

}
