package _04_xyz.itwill.utill_0419;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Map인터페이스를 상속받은 컬렉션 클래스 - HashMap, Hashtable, Properties
// => 이름(key => ★★고유값, 중복불가) 객체(value)를 하나의 그룹으로 묶어 Map객체에 저장
// => 엔트리(Entry) : Map객체에 이름과 객체를 하나로 묶어 저장하는 단위
// => 이름을 이용하여 객체를 빠르게 검색하기 위한 컬렉션 클래스

public class MapApp {
	public static void main(String[] args) {
		
		// 이름(k)과 객체(v)에 대한 2개 타입
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		// Map.put(K key, V value) : Map 객체에 엔트리를 추가하는 메소드
		// => Map객체에 저장되는 엔트리는 이름(key)을 set객체로 저장
		// => 이름은 중복저장 불가능
		map.put(1000, "홍길동");
		map.put(3000, "ㅇ");
		map.put(4000, "ㄴ");
		map.put(5000, "ㄹ");
		map.put(2000, "ㅁ");
		
		System.out.println("map = " + map);
		System.out.println("============================================");
		
		// 이름이 중복된경우 객체가 변경됨.
		map.put(2000, "ㅁㅁ");
		System.out.println("map = " + map);
		System.out.println("============================================");
		
		map.remove("4000");
		System.out.println("map = " + map);
		System.out.println("============================================");
		
		// 엔트리를 검색하여 엔트리 객체를 반환
		// 엔트리가 없는 경우 null반환
		String name = map.get("1000");
		System.out.println("name = " + name);
		System.out.println("============================================");
		
		// Map.keySet() : Map객체에 저장된 모든 엔트리의 이름(key)을 Set객체로 반환
		Iterator<Integer> iteratorKey = map.keySet().iterator();
		
		while (iteratorKey.hasNext()) {
			Integer key = iteratorKey.next();
			String value = map.get(key);
			System.out.println(key + " = " + value);
		}
		System.out.println("============================================");
		
		// 향상된 for 구문 이용
		for(Integer key : map.keySet()) {
			System.out.println(key + " = " + map.get(key));
		}
		System.out.println("============================================");
		
		// map.values() : 모든 엔트리의 객체(Value)를 컬렉션 객체(List)로 반환
		Iterator<String> iteratorValue = map.values().iterator();
		
		while(iteratorValue.hasNext()) {
			String value = iteratorValue.next();
			System.out.println(value);
		}
		System.out.println("============================================");
		
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("============================================");
		
		
	}

}































