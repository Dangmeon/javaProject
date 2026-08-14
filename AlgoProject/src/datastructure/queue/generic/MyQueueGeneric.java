package datastructure.queue.generic;

import java.util.NoSuchElementException;

public class MyQueueGeneric <E>{

	private int queueSize;
	private int front; // 첫 번쨰 요소 앞
	private int rear; // 마지막 요소
	private int num; // 현재 데이터 수
	private Object[] queue; // 큐 본체
	
	public MyQueueGeneric(int queueSize) {
		this.front = this.rear = -1;
		this.num = 0;
		this.queueSize = queueSize;
		queue = new Object[queueSize];
	}
	
	// front 와 rear 의 값이 동일하면 데이터가 없는 상태
	public boolean isEmpty() {
		if(front == rear) {
			front = rear = -1;
		}
		return front == rear;
	}
	
	// rear 포인터가 큐의 마지막 인덱스와 동일하면 full 상태
	public boolean isFull() {
		return (rear == queueSize -1);
	}

	// 큐에 데이터 삽입
	public void enqueue(E item) {
		if(isFull()) { // 마지막에 저장된 데이터가 큐의 마지막 원소로 저장되면 Full, front 에서 삭제 후 비었어도 검증하지 않음
			System.out.println("enqueue 실패 Queue Full");
		}else {
			queue[++rear] = item;
			num++;
		}
	}
	
	// 큐에서 데이터 삭제
	public E dequeue() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			throw new NoSuchElementException();
		}else {
			num--;
			front++;
			@SuppressWarnings("unchecked")
			E item = (E) queue[front];
			return item; 
		}
	}
	
	// 큐의 첫 번째 데이터 추출(저장된지 가장 오래된 data)
	public E peek() {
		if(isEmpty()) {
			System.out.println("peek 실패");
			throw new NoSuchElementException();
		}else {
			@SuppressWarnings("unchecked")
			E item = (E) queue[front+1];
			return  item;
		}
	}
	
	// 큐 초기화
	public void clear() {
		front = rear = -1;
		System.out.println("clear");
	}
	
	// 큐에 저장된 데이터 수 반환
	public int size() {
		return num;
	}
	
	// 큐에 저장된 모든 데이터를 출력
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
		}else {
			System.out.println("Queue items : ");
			for(int i = front + 1; i <= rear; i++) {
				System.out.println(i + " : " + queue[i] + " ");
			}
			System.out.println();
		}
	}
	
	// 전달된 data 가 queue 에 저장된 데이터인지 확인 후 해당 인덱스 반환
		public int contains(E value) {
			if (isEmpty()) {
				System.out.println("Queue Empty");
		    }else {
			    for (int i = front + 1; i <= rear; i++) {
			        if (queue[i] != null && queue[i].equals(value)) {
			            return i; 
			        }
			    }
		    }
		    return -1; // 해당 value 가 queue 에 없음
		}
}
