package datastructure.queue.generic;

public class MyQueueMoveMain {

	public static void main(String[] args) {
		// 구현한 Queue 사용
		int queueSize = 3;
		MyQueueMoveGeneric<Character> q = new MyQueueMoveGeneric<>(queueSize);
		
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
		System.out.println("\n반환(삭제)된 값 : " + q.dequeue());
		q.showQueue();
		System.out.println("데이터 수 : " + q.size());
		
		System.out.println("\nenqueue 수행");
		q.enqueue('d');
		q.showQueue();
		
		System.out.println("c와 같은 값이 있는 인덱스 위치는? " + q.contains('c') + "번 인덱스");
		
//		System.out.println("\n첫 번째 값 확인(peek 수행) : " + q.peek());
//		
//		System.out.println("\nd, e 삽입 수행");
//		q.enqueue('d');
//		q.enqueue('e');
//		q.showQueue();
//		System.out.println("데이터 수 : " + q.size());
//		
//		System.out.println("\nf 삽입 수행");
//		q.enqueue('f');
//		
//		System.out.println("\nclear 수행");
//		q.clear();
//		q.showQueue();
//		
//		System.out.println("\nx enqueue 수행");
//		q.enqueue('x');
//		q.showQueue();
		
	}

}
