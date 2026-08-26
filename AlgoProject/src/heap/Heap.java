package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
	private final Comparator<? super E> comparator;
	
	private static final int DEFAULT_CAPACITY = 10; // 최소 (기본) 크기
	
	private int size; // 요소의 개수
	
	private Object[] array; // heap 자료 저장 배열
	
	
	///////////////// 생성자 ///////////////////
	///
	public Heap() { // 초기 공간 할당없는 생성자
		this(null);
	}
	
	public Heap(Comparator<? super E> comparator) {
		this.comparator = comparator;
		this.size = 0;
		this.array = new Object[DEFAULT_CAPACITY];
	}
	
	public Heap(int capacity) {
		this(capacity, null);
	}
	
	public Heap(int capacity, Comparator<? super E> comparator) {
		this.comparator = comparator;
		this.size = 0;
		this.array = new Object[capacity];
	}	
	
	///////////// Heap 의 불변 설정을 위한 계산 메소드 ///////////////
	///
	
	// 부모 노드 인덱스 계산 반환
	private int getParent(int index) {
		return index/2;
	}
	
	// 왼쪽 자식 노드 인덱스 계산 반환
	private int getLeftChild(int index) {
		return index * 2;
	}
	
	// 오른쪽 자식 노드 인덱스 계산 반환
	private int getRightChild(int index) {
		return index * 2 + 1;
	}
	
	///////////// resize /////////////
	/// 새로운 용량을 파라미터로 받는다
	///
	private void resize(int newCapacity) {
		// 배열 새로 생성
		Object[] newArray = new Object[newCapacity];
		
		// 새 배열에 기존에 있던 배열 요소들을 모두 복사
		for(int i = 1; i <= size; i++) {
			newArray[i] = array[i];
		}
		
		// 기존 배열 객체 연결 끊고(null) 새 배열 연결
		this.array = null;
		this.array = newArray;
	}
	
	///////// heap 에 자료 저장 -> add(target) -> shiftUp(size, target(저장할 값)) ///////////
	///
	public void add(E value) {
		// 배열이 꽉 차있을 결루 현재 크기의 두 배로 확장
		if(size + 1 == array.length) {
			resize(array.length * 2);
		}
		// 인덱스 계싼을 위해 배열은 1번 index 부터 사용
		shiftUp(size + 1, value); // 추가되는 위치와 넣을 값을 전달
		size++; // 정상적으로 추가 후 재배치가 끝나면 사이즈를 증가
	}
	
	////////// idx : 추가 위치, target : 저장할 값 //////////
	///
	public void shiftUp(int idx, E target) {
		if(comparator != null) {
			shiftUpComparator(idx, target, comparator);
		}else{
			ShiftUpComparable(idx, target);
		}
	}
	
	private void shiftUpComparator(int idx, E target, Comparator<? super E> comp) {
		while(idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent]; // 부모 노드 값 추출
			
			// 타겟 노드 값과 부모 노드 값 비교 : 1 또는 0은 기준 객체가 더 큼
			if(comp.compare(target, (E)parentVal) >= 0) {
				// 교환 필요 없이 현재 위치에 저장
				break;
			};
			// 비교 결과가 음수면
			// 부모 노드가 타겟 노드보다 크면
			// 현재 위치의 값을 부모 노드 값으로 교체, 타겟 노드 위치를 부모 노드 위치로 변경
			array[idx] = parentVal;
			idx = parent;
		}
		// 반복을 종료하면 target 의 최종 위치가 정해짐 : idx
		array[idx] = target;
	}
	
	@SuppressWarnings("unchecked")
	private void ShiftUpComparable(int idx, E target) {
		// Comparable 사용위해 기준 객체 타입을 Comparable 타입으로 형변환
		Comparable<? super E> comp = (Comparable<? super E>)target;
				
		while(idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent]; // 부모 노드 값 추출
			
			// 타겟 노드 값과 부모 노드 값 비교 : 1 또는 0은 기준 객체가 더 큼
			if(comp.compareTo((E)parentVal) >= 0) {
				// 교환 필요 없이 현재 위치에 저장
				break;
			};
			// 비교 결과가 음수면
			// 부모 노드가 타겟 노드보다 크면
			// 현재 위치의 값을 부모 노드 값으로 교체, 타겟 노드 위치를 부모 노드 위치로 변경
			array[idx] = parentVal;
			idx = parent;
		}
		// 반복을 종료하면 target 의 최종 위치가 정해짐 : idx
		array[idx] = target;
	}
	
	///////// remove 메소드 /////////
	/// Heap 은 root 노드를 삭제함
	/// root 노드 삭제 후 heap 재구성
	/// remove() -> shiftDown(idx, target)
	@SuppressWarnings("unchecked")
	public E remove() {
		if(array[1] == null) {
			throw new NoSuchElementException();
		}
		
		E result = (E)array[1];
		
		E target; // 타겟이 될 요소
		if(size == 1) {
			target = null;
		}else {
			target = (E)array[size];
		}
		
		array[size] = null; // 마지막 노드 삭제
		
		// root 가 삭제되므로 heap 재구성
		shiftDown(1, target); // 재배치할 타겟 노드 전달
		
		return result;
	}
	
	
	private void shiftDown(int idx, E target) {
		if(comparator != null) {
			shiftDownComparator(idx, target, comparator);
		}else {
			shiftDownComparatable(idx, target);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void shiftDownComparator(int idx, E target, Comparator<? super E> comp) {
		// 삭제할 index 의 노드를 삭제
		array[idx] = null;
		size--;
		
		int parent = idx;
		int child;
		
		while((child = getLeftChild(parent)) <= size) {
			int right = getRightChild(parent);
			Object childVal = array[child]; // 타겟과 비교할 값
			
			// 왼쪽 자식노드 값이 오른쪽 자식노드 값보다 크면 childVal 값을 변경
			if(right <= size && comp.compare((E)childVal, (E)array[right]) > 0) { // childVal 값이 크다
				child = right;
				childVal = array[child];
			}
			
			// target 값이 자식노드 값보다 작으면 반복문을 종료
			if(comp.compare(target, (E)childVal) <= 0) {
				break;
			};
			
			// 자식 노드 값보다 target 이 크면
			array[parent] = childVal;
			parent = child;
		}
		
		// 반복문 종료 후 target 의 위치가 정해짐(parent)
		array[parent] = target;
		
		/*
		 * 	삭제 후에는 배열 사이즈가 기본 크기인 10보다는 크고 요소 개수가 전체 배열 크기의 1/4일 경우
		 * 	배열 사이즈를 반을 줄임
		 * */
		
		if(array.length > DEFAULT_CAPACITY && size < array.length/4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length/2));
		}
	}
	
	@SuppressWarnings("unchecked")
	private void shiftDownComparatable(int idx, E target) {
		// 삭제할 index 의 노드를 삭제
		array[idx] = null;
		size--;
		
		int parent = idx;
		int child;
		
		while((child = getLeftChild(parent)) <= size) {
			Comparable<? super E> comp = (Comparable<? super E>) target;
			
			int right = getRightChild(parent);
			Object childVal = array[child]; // 타겟과 비교할 값
			
			// 왼쪽 자식노드 값이 오른쪽 자식노드 값보다 크면 childVal 값을 변경
			if(right <= size && ((Comparable<? super E>)childVal).compareTo((E)array[right]) > 0) { // childVal 값이 크다
				child = right;
				childVal = array[child];
			}
			
			// target 값이 자식노드 값보다 작으면 반복문을 종료
			if(comp.compareTo((E)childVal) <= 0) {
				break;
			};
			
			// 자식 노드 값보다 target 이 크면
			array[parent] = childVal;
			parent = child;
		}
		
		// 반복문 종료 후 target 의 위치가 정해짐(parent)
		array[parent] = target;
		
		/*
		 * 	삭제 후에는 배열 사이즈가 기본 크기인 10보다는 크고 요소 개수가 전체 배열 크기의 1/4일 경우
		 * 	배열 사이즈를 반을 줄임
		 * */
		
		if(array.length > DEFAULT_CAPACITY && size < array.length/4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length/2));
		}
	}
	
	public int size() {
		return this.size;
	}
	
	@SuppressWarnings("unchecked")
	public E peek() {
		if(array[1] == null) {
			throw new NoSuchElementException();
		}
		return (E)array[1];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(array, size + 1);
	}
}
