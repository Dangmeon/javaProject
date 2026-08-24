package sort;

import java.util.Arrays;

public class RadixSortMain {
	
	private static final int MAX_COUNT = 15;

	public static void main(String[] args) {
		int[] arr = new int[MAX_COUNT];
		
		for(int i = 0; i < MAX_COUNT; i++) {
			// 0 ~ MAX_COUNT  범위내의 난수를 생성
			arr[i] = (int)(Math.random() * MAX_COUNT);
		}
		
		System.out.println("원본 배열 : " + Arrays.toString(arr));
		System.out.println();
		// RadixSort.sort(arr);
		int[] radixSortArr = arr.clone(); // 원본 유지 위해 복사본 생성
		RadixSort.sort(radixSortArr);
		System.out.println("Radix Sort : " + Arrays.toString(radixSortArr));
		System.out.println();

	}

}
