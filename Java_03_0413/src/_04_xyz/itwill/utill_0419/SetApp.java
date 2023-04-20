package _04_xyz.itwill.utill_0419;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 컬렉션 클래스(Collection Class) : 자료구조를 사용하여 객체를 효율적으로 관리(추가,삭제,검새)하기 위한
///          기능을 제공하는 데이터 수집 클래스들을 표현
// => Collection 인터페이스(set 인터페이스, List 인터페이스), Map인터페이스 중 하나를 상속받아 작성된 클래스

// Set 인터페이스를 상속받은 컬랙션 클래스 : HashSet, TreeSet
// └=> 객체의 저장순서가 없으며 메모리 주소와 객체에 저장된 값이 동일한 객체 중복저장 불가능.

public class SetApp {
	public static void main(String[] args) {
		
		// 제네릭을 사용하지 않고 HashSet 클래스로 객체 생성 -> 권장하지 않음.
		// => HashSet 객체에는 모든 자료형의 객체를 Object 타입으로 저장할 수 있다.
		// => HashSet 객체에 저장된 객체를 반환받아 사용할 경우 반드시 '명시적 객체 형 변환'을 사용해야 함.
		//  HashSet set = new HashSet();  -> 권장하지 않음
		
		// 제네릭을 사용하여 HashSet 클래스로 객체 생성 -> 권장
		// => HashSet 클래스의 제네릭타입에 전달된 객체만 저장가능.
		// => ★ HashSet 객체에 저장된 객체는 명시적 객체 형 변환없이 사용 가능
		// HashSet<String> set = new HashSet<String>();
		
		// 참조변수는 클래스가 상속받은 인터페이스(부모)를 이용하여 선언하는 것을 권장.
		// => 참조변수에는 인터페이스를 상속받은 모든 자식클래스의 객체 저장 가능.
		// => 클래스간의 결합도를 낮추어 유지보수의 효율성을 증가시킴.
		Set<String> set = new HashSet<String>();
		
		// Set.add(E element) : Set 객체에 요소를 추가하는 메소드
		// 요소(element) : 컬랙션 클래스의 객체에 저장되는 객체
		set.add("홍길동");
		set.add("임꺽정");
		set.add("전우치");
		
		// set.toString() : set 객체에 저장된 모든 요소들을 반환
		System.out.println("set.toString() = " + set.toString());
		System.out.println("set = " + set);
		// 동일한 객체가 중복저장되지 않는다.
		System.out.println("========================================================");
		
		//  set.size() : 요소의 개수
		System.out.println("요소의 개수 = " + set.size());
		System.out.println("========================================================");
		
		// set.remove : 동일한 요소를 삭제하는 메소드
		set.remove("임꺽정");
		System.out.println("set = " + set);
		System.out.println("========================================================");
		
		//  set.iterator() : Set 객체에 저장된 요소를 반복처리할 수 있는 Iterator객체를 반환
		// Iterator 객체 : 컬랙션 클래스의 객체 요소를 반복처리 하기 위한 기능 제공
		// => 반복 지시하는 객체 = 반복 지시자 : 커서를 사용하여 컬랙션 객체의 요소를 반복 처리
		Iterator<String> iterator = set.iterator();
		
		
		// Iterator 객체를 사용하여 Set객체에 저장된 모든 요소를 일괄처리
		// iterator.hasNext() : Iterator 객체로 처리가능한 요소의 존재를 알려줌
		// => false : 미존재, true : 존재
		while(iterator.hasNext()) {
			// iterator.next() : 커서위치의 요소를 반환
			// => 커서위치를 반환 한 후, 다음 요소 위치로 자동 이동
			String str = iterator.next();
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println("========================================================");
		
		// Iterator<String> iterator = set.iterator();
		
		// 향상된 for구문을 사용하여 set 객체에 저장된 모든 요소 일괄처리
		// => 향상된 for구문을 사용하면 내부적으로 Iterator 객체를 사용하여 반복처리
		for(String str : set) {
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println("========================================================");
		
		
		
		
		
		
	}

}



























