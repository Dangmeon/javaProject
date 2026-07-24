package exam;

import java.util.Arrays;

public class ArrayEx3 {

	public static void main(String[] args) {

		int num[] = new int[10];
		int count[] = new int[10];
		
		for(int i = 0; i < num.length; i++) {
			int randomNum = (int)(Math.random() * 10);
			num[i] = randomNum;
			
			count[randomNum]++;
			
			System.out.print(num[i]);
		}
		System.out.println();
		for(int i = 0; i < count.length; i++) {
			System.out.println(i + "의 개수 : " + count[i]);
		}
		
	}

}
