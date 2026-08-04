package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListGen {

	public static void main(String[] args) {
		// list 개열 콜렉션 generic 타입으로 생성
		List<String> list = new ArrayList<String>();
		
		list.add("java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "DataBase");
		list.add("MyBatis");
		
		// generic 타입이므로 파라미터타입인 String 제외 오류 발생
		// list.add(100);
		
		int size = list.size();
		
		System.out.println("총 객체 수 : " + size);
		System.out.println();
		
		for(int i = 0; i< list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		System.out.println();

		// 원소 제거
		list.remove(2);
		list.remove(2);
		for(int i = 0; i< list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		System.out.println();
		
		
		list.add("JDBC");
		for(int i = 0; i< list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		System.out.println();
		
		// list.remove(항목 값) : 해당 항목값 중복 저장된 경우 첫번 째 만나는 항목 값 제거
		list.remove("JDBC");
		for(int i = 0; i< list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		System.out.println();
		
		// ArrayList 도 집합 형태이므로 for 문의 반복 객체 사용 가능
		for(String str : list) {
			System.out.println(str + " : " + str.length());
		}
		
	}

}
