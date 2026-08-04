package exam.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String, String> map =new HashMap<>();
		
		map.put("apple", "사과");
		map.put("summer", "여름");
		map.put("candy", "사탕");
		map.put("school", "학교");
		map.put("water", "물");
		
		while(true) {
			System.out.print("찾고 싶은 단어 : ");
			String searchWord = sc.next();
			
			if(searchWord.equals("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			
			if(map.containsKey(searchWord)) {
				System.out.println(map.get(searchWord));
			}else {
				System.out.println(searchWord + "는 없는 단어입니다.");
			}
			
		}
		
		sc.close();
		
	}

}
