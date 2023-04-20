package _04_xyz.itwill.utill_0419;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// List 인터페이스를 상속받은 컬랙션 클래스 : ArrayList, Vector, LinkedList 등
// => 요소를 차례대로 저장한다. 첨자를 이용하여 요소 구분할 수 있다.(순서가 존재하기 때문)

public class ListApp {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		// List.add(E element) : List 객체에 요소를 추가하는 메소드
		list.add("홍길동");
		list.add("임꺽정");
		list.add("전우치");
		list.add("일지매");
		
		// list.toString() : 모든 요소를 반환하는 메소드
		System.out.println("list.toString() = " + list.toString());
		System.out.println("list = " + list);
		System.out.println("==============================================================");
		
		// list는 Set과 다르게 중복으로 추가 가능
		list.add("임꺽정");
		System.out.println("list = " + list);
		System.out.println("==============================================================");
		
		// list.size() : 요소의 개수
		System.out.println("요소의 개수 = " + list.size());
		System.out.println("==============================================================");
		
		// list.get(2) : index위치에 저장된 요소값 반환
		System.out.println("3번째 위치 = " + list.get(2));
		System.out.println("==============================================================");
		
		// list.add(index, E element) : index위치에 요소를 삽입하는 메소드
		list.add(4, "장길산");
		System.out.println("list = " + list);
		System.out.println("==============================================================");
		
		// list.remove(E element) : 삭제하는 메소드, 첫번째로 검색된 요소를 삭제
		// list.remove("홍길동");
		list.remove(5);
		System.out.println("list = " + list);
		// 보통 인덱스(숫자)를 이용해 삭제한다.
		System.out.println("==============================================================");
		
		// list.set(index, E element) : 인덱스 위치의 요소 변경
		list.set(1, "임정");
		System.out.println("list = " + list);
		System.out.println("==============================================================");
		
		// ============================================================================
		// list 객체에 저장된 모든 요소의 일괄처리 -> 일반 for 구문 사용
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		System.out.println("==============================================================");
		
		// list 객체에 저장된 모든 요소의 일괄 처리 -> Iterator 객체 사용
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		System.out.println("==============================================================");
		
		// list 객체에 저장된 모든 요소의 일괄 처리 -> 향상된 for 구문 사용
		for(String str : list) {
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println("==============================================================");
		
		// Collections.sort() : 객체의 요소를 정렬하는 메소드
		// Collections 클래스 : 객체 요소를 관리하는 기능을 제공하는 메소드
		Collections.sort(list);
		System.out.println("list = " + list);
		System.out.println("==============================================================");
		
		// list.clear() : list 모든요소를 삭제하여 초기화
		list.clear();
		
		// list.isEmpty() : 요소가 저장되어 있는경우 false, 없으면 true 반환
		if(list.isEmpty()) {
			System.out.println("list 객체에 저장된 요소가 없습니다.");
		}
		System.out.println("==============================================================");
		
		// Arrays.asList(E... element) : 0개 이상의 요소가 저장된 객체를 생성하여 반환하는 메소드 
		List<Integer> numberList = Arrays.asList(10, 20, 30, 40, 50);
		System.out.println("numberList = " + numberList);
		System.out.println("==============================================================");
		
		
		
		
		
		
	}

}










