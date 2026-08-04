package threads.sync;

public class SyncMain {

	public static void main(String[] args) {
		// 동기화없는 스레드 간의 공통 객체 사용 예
		Calculator clac = new Calculator(); // 동기화 되지 않은 공통 객체
		Calculator2 clac2 = new Calculator2(); // 동기화된 공통객체 인스턴스
		
		User1 user1 = new User1();
		user1.setCalculator(clac2); // 공통 객체 전달
		user1.start();  //스레드 실행, memory => 100 설정
		
		User2 user2 = new User2();
		user2.setCalculator(clac2); // 공통 객체 전달, User1 과 User2 동일 객체 사용
		user2.start();  //스레드 실행, memory => 50 설정

		System.out.println();
	}

}
