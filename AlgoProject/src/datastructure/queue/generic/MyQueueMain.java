package datastructure.queue.generic;

public class MyQueueMain {

	public static void main(String[] args) {
		// 구현한 Queue 사용
		int queueSize = 5;
		MyQueueGeneric<Character> q = new MyQueueGeneric<>(queueSize);
		
		q.showQueue();
		System.out.println("데이터 수 : " + q.size());
		
		System.out.println("\na, b, c 삽입 수행");
		q.enqueue('a');
		q.enqueue('b');
		q.enqueue('c');
		q.showQueue();
		System.out.println("데이터 수 : " + q.size());
		
		System.out.println("\n첫 번째 값 확인(peek 수행) : " + q.peek());
		
		System.out.println("\ndequeue 수행");
		System.out.println("\n반환(삭제)된 값 : " + q.dequeue());
		q.showQueue();
		System.out.println("데이터 수 : " + q.size());
		
		System.out.println("\n첫 번째 값 확인(peek 수행) : " + q.peek());
		
		System.out.println("\nd, e 삽입 수행");
		q.enqueue('d');
		q.enqueue('e');
		q.showQueue();
		System.out.println("데이터 수 : " + q.size());
		
		System.out.println("\nf 삽입 수행");
		q.enqueue('f'); // 데이터가 4개이고 0 위치가 비었음에도 Full 출력
		// -> rear 와 queueSize - 1 이 동일하면 오버플로우가 발생
		// -> 해결 : 이동 큐, 원형 큐
		
		System.out.println("\nclear 수행");
		q.clear();
		q.showQueue();
		
		System.out.println("\nx enqueue 수행");
		q.enqueue('x');
		q.enqueue('y');
		q.enqueue('z');
		q.showQueue();
		
		System.out.println("x와 같은 값이 있는 인덱스 위치는? " + q.contains('x') + "번 인덱스");
		q.showQueue();
		
	}

}
