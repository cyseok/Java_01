package oop;

import java.util.Arrays;

//배열요소 값을 오름차순 정렬해 저장하고 출력하는 프로그램

public class _01_ArraySortApp_0405 {
	
	public static void main(String[] args) {
		
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
		  
		int[] array1 = {30, 50, 10, 40, 20};
		
		// Array 클래스 : 배열의 요소를 제어하는 기능의 메소드를 제공하는 클래스
		// Arrays.toString(Object[] array) : 배열을 전달받아 배열의 요소값들을 문자열로 변환하여 반환
		System.out.println("정렬 전 -> " + Arrays.toString(array1));
		
		// Arrays.sort(Object[] array) : 배열을 전달받아 배열의 요소값들을 오름차순 정렬
		Arrays.sort(array1);
		System.out.println("정렬 후 -> " + Arrays.toString(array1));
		 
		 
		 
		 
	}

}
