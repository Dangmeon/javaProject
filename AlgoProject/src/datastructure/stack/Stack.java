package datastructure.stack;

// 배열을 활용한 Stack 구현
// CHar형 data 를 저장하는 Stack
public class Stack {

	private int stackSize; // 스택 크기
	private int top; // 스택 포인터
	private char[] stackArr; // 스택
	
	// 생성자 : 스택 초기화
	// 배열 index 는 0부터 시작하므로 top 은 -1로 초기값 설정
	public Stack(int stackSize) {
		this.stackSize = stackSize;
		this.top = -1;
		this.stackArr = new char[stackSize];
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
	
	// push -> 데이터 삽입
	// 삽입시 overflow 체크
	public void push(char item) {
		if(isFull()) {
			System.out.println("Stack Full. Overflow");
		}else {
			// top 을 증가한 후 데이터 저장
			stackArr[++top] = item;
		}
	}
	
	// pop -> 데이터 삭제
	// 삭제할 데이터가 있는지 확인 : underflow
	public char pop() {
		if(isEmpty()) {
			System.out.println("Stack Empty. Underflow");
			return 'E';
		}else {
			// 현재 top 위치의 data 반환하고 top -1
			return stackArr[top--];
		}
	}
	
	// 저장된 데이터 중 가장 최근에 저장된 데이터를 반환
	// top 위치의 데이터 반환만
	// 스택이 비어있는지 확인
	public char peek() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
			return 'E';
		}else {
			return stackArr[top];
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
