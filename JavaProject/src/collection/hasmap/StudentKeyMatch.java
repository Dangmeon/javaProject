package collection.hasmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentKeyMatch {

	public static void main(String[] args) {
		// HashMap 의 key 사용 예시
		Map<Integer, Integer> mapInt = new HashMap<>();
		
		mapInt.put(1, 95);
		mapInt.put(2, 80);
		
		mapInt.put(1, 98);
		
		Set<Integer> keyInt = mapInt.keySet();
		for(int key : keyInt) {
			System.out.println(mapInt.get(key));
		}

		System.out.println("총 entry 수 : " + mapInt.size());
		System.out.println("key의 값이 같으면 동일 entry");
		System.out.println();

		Student key = new Student("3", "김감자");
		// key 가 참조타입인 경우
		Map<Student, Integer> mapRef = new HashMap<>();
		mapRef.put(key, 98);
		mapRef.put(new Student("1", "왕감자"), 90);
		mapRef.put(new Student("2", "박감자"), 80);
		mapRef.put(new Student("3", "김감자"), 95);
		mapRef.put(new Student("3", "김감자"), 98);

		Set<Student> keyRef = mapRef.keySet();
		for(Student key1 : keyRef) {
			System.out.println(key1.getStdNo() + " " + key1.getStdName() + " " + +mapRef.get(key1));
		}

		System.out.println("총 entry 수 : " + keyRef.size());
		System.out.println("사용자 정의 클래스인 경우 hashCode()와 equals()를 재정의해서 동등객체 조건을 정해야 함");
		System.out.println("사용자 정의 클래스에 동등객체 조건 정의되지 않으면 키의 내용이 중복으로 보일 수 있음");
		
		
	}

}
