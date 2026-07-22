package loop;

public class While1 {

	public static void main(String[] args) {
		// 조건식만 필수로 존재하는 반복문 (while)
		
//		while(1==1) { // 1== 1 은 무조건 참이기 떄문에 해당 while 은 무한루프에 들어간다.
//			System.out.println("몇 번 실행되나요?");
//		}
		
		// 조건 검사시 거짓에 도달해 종료할 수 있도록 while 문 구성
		// 0~ 10 까지 출력
		int i =0; // 초기식
		
		while(i <= 10) { // 조건
			System.out.println(i);
			i++; // 증가감
		}
		
		
		// 1 ~ 11까지 출력
		i =0; // 초기식
		
		while(i <= 10) { // 조건
			i++; // 증가감
			System.out.println(i);
		}

	}

}
