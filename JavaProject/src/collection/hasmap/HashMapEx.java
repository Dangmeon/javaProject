package collection.hasmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		// Map 컬랙션 생성
		// Map <Key, Value>
		Map<String, Integer> map =new HashMap<>();
		
		// Map 의 key 는 중복될 수 없음, 중복 키가 put 되면 해당 key 의 value 가 put 된 value 로 수정
		
		// 객체 저장 : put(key, value)
		map.put("김감자", 85);
		map.put("왕감자", 90);
		map.put("풋감자", 80);

		// 전체 entry 수 : size()
		System.out.println("총 entry 수 : " + map.size());
		
		// 객체 저장 : key 값을 동일하게
		// map 의 key 기존 entry 와 동일하게 put 되면 추가가 아닌 해당 키릐 value 를 수정함
		// 문자열인 경우 hashCode() 와 equals() 메소드가 재정의되어서 동등객체 판던 기준이 포함되어 있음
		map.put("왕감자", 100);
		System.out.println("총 entry 수 : " + map.size());
		
		// Map.get(key) : 해당 key 의 value 를 반환
		System.out.println("key  왕감자의 value : " + map.get("왕감자"));
		
		// Map.keySet() : 모든 entry 의 key 객체를 반환 (Set 타입으로 반환) - 중복값 허용 x
		Set<String> keySet = map.keySet();
		
		// 모든 collection 관련 인스턴스는 Iterator 인터페이스를 구현해 놨음. iterator()
		// 순환 관련 메서드 사용 가능
		Iterator<String> keyIt = keySet.iterator();

		// map 의 전체 entry 의 value 출력
		while(keyIt.hasNext()) {
			String key = keyIt.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		
		System.out.println();
		for(String k : keySet) {
			Integer value = map.get(k);
			System.out.println("\t" + k + " : " + value);
		}
		
		// map.entrySet() : 모든 entry 반환(Set 타입으로 반환)
		System.out.println();
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		for(Entry<String, Integer> entry : entrySet) {
			// 특정 entry 의 key 를 추출
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();

		// 모든 entry 삭제 : Map.clear()
		map.clear();
		System.out.println("총 entry 수 : " + map.size());
		

	}

}
