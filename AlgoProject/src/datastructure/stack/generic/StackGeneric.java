package datastructure.stack.generic;

import java.util.EmptyStackException;

// generic 타입의 클래스로 구성하고 객체 생성시 타입 결정
public class StackGeneric <E>{
	
	private int stackSize; // 스택 크기
	private int top; // 스택 포인터
	private Object[] stackArr; // 스택 -> 모든 타입 처리가능하도록 Object 타입으로 구성 -> generic 으로 형변환
	
	// 생성자 : 스택 초기화
	// 배열 index 는 0부터 시작하므로 top 은 -1로 초기값 설정
	public StackGeneric(int stackSize) {
		this.stackSize = stackSize;
		this.top = -1;
		this.stackArr = new Object[stackSize];
	}
	
	// stack 기능 구현
	
		//스택이 비어있는가?
		public boolean isEmpty() {
			return top == -1;
		}
		
		// 스택이 가득 찼는지?
		public boolean isFull() {
			return top == stackSize -1; // 전체 배열 원소수 -1이 마지막 index 값
		}
		
		// push 되는 데이터 타입 generic
		public void push(E item) {
			if(isFull()) {
				System.out.println("Stack Full. Overflow");
			}else {
				// Object 타입 배열에 저장 -> generic 타입이므로 나중에 item 의 타입은 결정됨
				// Object 는 최상위 클래스이므로 어떤 타입도 저장 가능
				stackArr[++top] = item;
			}
		}
		
		// 
		public E pop() {
			if(isEmpty()) {
				System.out.println("Stack Empty. Underflow");
				// generic 타입을 반환해야하는 경우에 예외 상황이면 예외를 던지는 방법을 많이 사용함
				throw new EmptyStackException();
			}else {
				// Object 타입을 E 타입으로 형변환 (E)
				@SuppressWarnings("unchecked")
				E item = (E) stackArr[top--];
				return  item;
			}
		}
		
		public E peek() {
			if(isEmpty()) {
				System.out.println("Stack Empty");
				throw new EmptyStackException();
			}else {
				@SuppressWarnings("unchecked")
				E item = (E) stackArr[top];
				return item;
			}
		}
		
		// 스택을 비움
		public void clear() {
			// top 을 -1로 초기화
			top = -1;
		}
		
		// 스택 내 저장된 모든 데이터 출력
		//dump
		public void showStack() {
			if(isEmpty()) {
				System.out.println("Stack Empty");
			}else{
				System.out.print("Stack items : ");
				for(int i = 0; i <= top; i++) {
					System.out.print(i + " : " + stackArr[i] + " ");
				}
				System.out.println("\ntop : " + top);
			}
		}
		
		//////////////// 연습문제2를 위한 showStack /////////////////////////
		public void showParkingStack() {
			if(isEmpty()) {
				System.out.println("주차장이 비었습니다.");
			}else {
				System.out.println("현재 주차장 현황");
				for(int i = 0; i <= top; i++) {
					System.out.println((i + 1) + "번 자리 : " + stackArr[i] +" 자동차");
				}
			}
		}
		
		
		///////////////////////////// 연습문제 풀이 /////////////////////////////////
		///
		public int size() {
			// stack 의 data 수 return
			if(isEmpty()) {
				return 0;
			}else {
				return top + 1;
			}
		}
		
		public int getCapacity() {
			// 전체 stack 용량 return
			return stackArr.length;
		}
		
}
