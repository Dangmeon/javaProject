package datastructure.linkedlist;

public class LinkedList {
	
	private ListNode head; // Linked list 를 참조하는 참조 변수, Linked list 의 첫 번째 node 를 참조함
	
	// 생성자
	public LinkedList() {
		head = null;
	}
	
	public void insertNodeFirst(String data) {
		ListNode newNode = new ListNode(data);
		
		if(head == null) {
			this.head = newNode;
		}
		newNode.link = head;
		head = newNode;
	}

	// Node 삽입(마지막에 삽입)
	public void insertNode(String data) {
		// 새로운 노드 생성
		ListNode newNode = new ListNode(data);
		
		if(head == null) { // List 에 노드가 없는 경우
			this.head = newNode;
		}else { // List 에 노드가 1개 이상 있는 경우 - 마지막 노드를 찾아서 연결
			// 시작노드 주소인 head 인 참조주소를 임시변수에 저장
			ListNode tempNode = head;
			
			while(tempNode.link != null) {
				tempNode = tempNode.link;
			}
			
			// 마지막 노드 찾았으면 link 에 새로운 노드 참조하도록 연결
			tempNode.link = newNode;
		}
	}
	
	// 노드 중간에 새로운 노드 삽입
	// preNode -> preNode 다음 노드를 참조
	public void insertNode(ListNode preNode, String data) {
		
		ListNode newNode = new ListNode(data);
		//preNode.link = newNode; // preNode.link newNode 주소로 update 된 상태에서
		newNode.link = preNode.link; // preNode.link 를 newNode.link 로 저장하면 나머지 리스트는 연결 불가능
		preNode.link = newNode;
		
	}
	
	///////////////////////////////////////////////////
	///노드 삭제

	// 1. 중간 노드 삭제 (전달된 data 와 값이 동일한 node 삭제)
	// 전달된 data 와 값이 동일한 node 중 첫 번째 node 삭제
	public void deleteNode(String data) {
		ListNode preNode = head; // head 침조하는 첫 번째 노드의 주소
		ListNode tempNode = head.link; // 첫 번째 노드의 link 필드의 값이 두 번째 node
		
		// 찾는 data 가 첫 번째 노드에서 찾아지는 경우
		if(data.equals(preNode.getData())) {
			head = preNode.link; // head 는 두 번째 node 참조
			preNode.link = null;
		}else { // 두 번째 node 부터 data 가 찾아질 때까지 node 이동
			while(tempNode != null) {
				if(data.equals(tempNode.getData())) {
					// data 가 일치하는 node 를 찾은 경우
					if(tempNode.link == null) { // 마지막 노드에서 데이터가 일치하는 경우
						preNode.link = null; // preNode 는 tempNode 이전 node
					}else { // 찾은 노드가 마지막 노드가 아니면
						// preNode : 삭제 노드 이전 노드, tempNode : 삭제할 노드
						preNode.link = tempNode.link;
						tempNode.link = null;
					}
					break;
				}else { // 데이터가 일치하제 않는 경우
					preNode = tempNode;
					tempNode = tempNode.link;
				}
			}
			
		}
	}
	
	// 마지막 노드 삭제 (데이터 상관없이 무조건 마지막 노드 삭제)
	public void deleteNode() { 
		ListNode preNode; // 마지막 노드 이전 노드
		ListNode tempNode; //마지막 노드
		
		// 노드가 없음
		if(head == null) {
			return;
		}
		
		// 노드가 1개인 경우
		if(head.link == null) {
			head = null;
		}else { // 두개 이상인 경우 마지막 노드 찹아야함(마지막 노드의 링크는 null)
			preNode = head;
			tempNode = head.link;
			
			while(tempNode.link != null) {
				preNode = tempNode;
				tempNode = tempNode.link;
			}
			
			// 반복이 종료되면 마지막 노드는 tempNode 가 참조, 마지막 이전 노드는 preNode 가 참조
			preNode.link = null;
		}
	}
	
	// node 검색 : data 응 전달해 해당 data 가 linkedList 에 있는지 확인 후 있으면 해당 노드의 참조를 반환
	public ListNode searchNode(String data) {
		ListNode tempNode = this.head; // 첫 번째 노드 할당
		
		while(tempNode != null) { // 다음 노드가 있는 동안 반복
			if(data.equals(tempNode.getData())) {
				// data 탐색되면 탐색된 node 의 참조 주소가 반환됨
				return tempNode;
			}else {
				tempNode = tempNode.link;
			}
		}
		return tempNode; //안 찾아지면 최종 tempNode 반환(이때 반환되는 값은 null)
	}
	
	// 연결리스트의 모든 노드의 data 출력
	public void printList() {
		ListNode tempNode = this.head;
		
		// head 부터 시작하여 마지막 노드까지 순회하면서 출력
		while(tempNode != null) {
			System.out.print(tempNode.getData() + " ");
			tempNode = tempNode.link;
		}
		System.out.println();
	}
	
	// 연결 리스트를 역순으로 재배치(원본 변경)
	public void reverseList() {
		ListNode nextNode= head; // head 가 참조하는 첫 번째 node 할당
		ListNode currentNode = null;
		ListNode preNode = null;
		
		while(nextNode != null) {
			preNode = currentNode;
			currentNode = nextNode;
			nextNode = nextNode.link;
			currentNode.link = preNode;
		}
		head = currentNode; // 반복문을 벗어나면 currentNode 는 마지막 node 를 참조하게 됨
	}
	
	// 개수
	public int getSize() {
		int count = 0;
		ListNode tempNode = head;
		while(tempNode != null) {
			count++;
			tempNode = tempNode.link;
		}
		return count;
	}
	
} // class 종료
