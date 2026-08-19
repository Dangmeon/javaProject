package datastructure.tree.binarysearch;

import java.util.Comparator;

public class BinarySearchTree<E> {

	private Node<E> root; // 루트 (최상단)노드
	private int size; // 요소(노드)의 개수

	private final Comparator<? super E> comparator; // <? super E> 제네릭 타입 E와 E의 모든 부모 클래스 포함

	// type 에 비교정의객체가 구현되어 있는 타입인 경우
	public BinarySearchTree() {
		this(null);
	}

	// type 에 비교정의객체가 구현되어 있는 있지 않은 타입인 경우에는 Comparator 인터페이스를 구현한 구현객체가 전달되어야 함
	public BinarySearchTree(Comparator<? super E> comparator) {
		this.comparator = comparator;
		this.root = null;
		this.size = 0;
	}

	/*
	 * 노드 추가를 위한 addUsingXXX() 매소드는 반환 타입이 E 타입임 중복원소를 삽입할 경우 해당 value 를 반환하고 삽입이
	 * 완료되면 null 을 반환함
	 */

	public boolean add(E value) {
		if (comparator == null) {
			return addUsingComparable(value) == null;
		}
		return addUsingComparator(value, comparator) == null;
	}

	// 전달되는 객체에 따라 Comparable 또는 Comparator 중 하나의 사용이 가능하도록 2개의 매서드 생성
	// Comparable 을 이용한 add 메소드
	private E addUsingComparable(E value) {
		Node<E> current = root; // 탐색할 노드를 가리키는 current
		Node<E> currentParent; // current 직전의 탐색 노드를 가리키는 노드
		// 삽입할 노드가 비교될 수 있도록 변수 생성 (add 대상의 value 가 비교 가능하도록 Comparable 타입으로 변환)
		@SuppressWarnings("unchecked")
		Comparable<? super E> compValue = (Comparable<? super E>) value;
		int compResult; // 비교 결과( 양수, 음수, 0)

		// current 가 null 즉, root 가 null 이면 root 에 새 노드 연결 후 null 반환
		if (current == null) {
			root = new Node<E>(value);
			size++;
			return null; // 노드 추가 완성 시 null 반환
		}

		// 기존 트리에 노드가 1개 이상 있는 경우
		do {
			// 삽입 위치를 유지하는 변수 update
			currentParent = current;
			// 새로운 노드의 값과 현재 노드의 값 비교
			compResult = compValue.compareTo(current.value);

			// 비교 결과에 따라 방향 결저으 동일하면 value 그대로 return
			if (compResult < 0) { // 새로운 노드 value 가 현재 value 보다 작음
				current = current.left;
			} else if (compResult > 0) {
				current = current.right;
			} else {
				return value;
			}
		} while (current != null);

		// 순회가 완료되어서 삽입해야 할 위치를 찾았다면
		Node<E> newNode = new Node<>(value, currentParent); // 부모 노드 링크에 값을 전닿라는 예시
		// Node<E> newNode = new Node<>(value);

		if (compResult < 0) {
			currentParent.left = newNode;
		} else {
			currentParent.right = newNode;
		}

		size++;
		return null; // add 가 성공함
	}

	// Comparator 을 이용한 add 메소드 - Comparable 이용한 메소드와 비교 메소드만 다르고 다른 절차는 동일함
	private E addUsingComparator(E value, Comparator<? super E> comp) {
		Node<E> current = root;
		Node<E> currentParent;
		
		int compResult; 

		if (current == null) {
			root = new Node<E>(value);
			size++;
			return null; 
		}

		// 기존 트리에 노드가 1개 이상 있는 경우
		do {
			currentParent = current;
			// 전달된 comparator 이용 비교 진행 - compare(obj1, obj2)
			compResult = comp.compare(value, current.value);

			// 비교 결과에 따라 방향 결저으 동일하면 value 그대로 return
			if (compResult < 0) { // 새로운 노드 value 가 현재 value 보다 작음
				current = current.left;
			} else if (compResult > 0) {
				current = current.right;
			} else {
				return value;
			}
		} while (current != null);

		// 순회가 완료되어서 삽입해야 할 위치를 찾았다면
		Node<E> newNode = new Node<>(value, currentParent); // 부모 노드 링크에 값을 전닿라는 예시
		// Node<E> newNode = new Node<>(value);

		if (compResult < 0) {
			currentParent.left = newNode;
		} else {
			currentParent.right = newNode;
		}

		size++;
		return null; // add 가 성공함
	}
	
	
	///////////////////삭제(remove) 메서드/////////////////////////
	///
	public E remove(E value) {
		if(comparator == null) {
			return removeUsingComparable(value);
		}
		return removeUsingComparator(value, comparator);
	}
	
	// Comparable 을 이용한 삭제 메소드
	public E removeUsingComparable(E value) {
		Node<E> currentParent;
		Node<E> current = root;
		boolean hasLeft = false;
		int resComp;
		
		// current(root) 가 null 인 경우
		if(root == null) {
			return null;
		}
		
		@SuppressWarnings("uncecked")
		Comparable<? super E> compValue = (Comparable<? super E>)value;
		
		// 삭제할 node 를 찾는 역할을 함, current.value 와 compValue 가 동일하면 삭제 노드를 찾게 됨, 찾으면 break
		// current 가 null 이면 해당 value 의 node 가 없음
		do { 
			resComp = compValue.compareTo(current.value);
			if(resComp == 0) { // 삭제할 노드 찾음
				break;
			}
			
			// 삭제할 노드 못찾음
			currentParent = current;
			if(resComp < 0) {
				hasLeft = true;
				current = current.left;
			}else {
				hasLeft = false;
				current = current.right;
			}
			
		}while(current != null);
		
		if(current == null) { // 찾는 값이 없음
			return null; // 삭제 실패
		}
		
		if(currentParent == null) { // 찾는 값이 root 에 있음
			deleteNode(current); // deleteNode -> node 삭제 후 재배치 역할
			size--;
			return value;
		}
		
		if(hasLeft) { // true 면 currentParent 의 왼쪽 노드가 삭제되었음
			currentParent.left = deleteNode(current);
		}else { // currentParent 의 오른쪽 노드가 삭제되었음
			currentParent.right = deleteNode(current);
		}
		
		size--;
		return value;
	}
	
	// Comparator 을 이용한 삭제 메소드
	public E removeUsingComparator(E value, Comparator<? super E> comp) {
	
	}
	
	// 실제 노드를 삭제하는 메소드, 삭제 후 대체되고 난 뒤의 위치 노드를 반환
	// 삭제 후 재배치된 삭제 노드의 자식노드의 참조를 반환
	private Node<E> deleteNode(Node<E> node){
		
	}
	
}
