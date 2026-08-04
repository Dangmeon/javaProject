package collection.list;

import java.util.Arrays;
import java.util.List;

public class ArraysAsList {

	public static void main(String[] args) {
		// Arrays.asList() : 고정된 객체들로 구성된 list 생성 (수정 불가능?)
		List<String> list1 = Arrays.asList("홍길동" , "신용권", "김자바"); // 3개 파라미처값을 ArrayList 로 변환
		
		for(String name : list1) {
			System.out.println(name);
		}
		System.out.println();
		
		// Arrays 객체는 값의 추가와 삭제
		// list1.add("강감자"); // UnsupportedOperationException
		// list1.remove(1); // UnsupportedOperationException
		for(String name : list1) {
			System.out.println(name);
		}
	}

}
