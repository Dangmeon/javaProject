package datastructure.linkedlist;

public class LinkedList {
	
	private ListNode head;
	
	public LinkedList() {
		head = null;
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
	public void indertNode(ListNode preNode, String data) {
		
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
				}else { // 데이터가 일치하제 않는 경우
					preNode = tempNode;
					tempNode = tempNode.link;
				}
			}
			
		}
	}
	
	
}
