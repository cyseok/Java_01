package _04_xyz.itwill.utill_0419;

import java.util.ArrayList;
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
		// 보통 인덱스(숫자)를 이용해 삭제한다.
		System.out.println("==============================================================");
		
		// list.set(index, E element) : 인덱스 위치의 요소 변경
		list.set(1, "임정");
		System.out.println("==============================================================");
		
		
		
		
		
		
		
		
		
		
		
	}

}










