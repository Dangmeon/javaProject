package datastructure.collection.vactor;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SafetyEx {

	public static void main(String[] args){
		// 스레드 동기화를 지원하는 vector 콜렉션
		
		List<Integer> list = new Vector();
		int threadCount = 1000;
		
		try {
			ExecutorService executorService = Executors.newFixedThreadPool(32);
			for(int i = 0; i< threadCount; i++) {
				final int value = i;
				executorService.submit(() -> {
					list.add(value);
				});
			}
			
			executorService.shutdown();
			executorService.awaitTermination(5, TimeUnit.SECONDS); 
			// Vector 는 스레드 동기화가 처리된 클래스이므로 동시성 문제 발생하지 않음
			// 스레드 환경에서는 Vector 를 사용함
			
			// 결과 출력
			System.out.println("목표 크기 :  " + threadCount);
			System.out.println("실제 리스트 크기 : " + list.size());
			

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
