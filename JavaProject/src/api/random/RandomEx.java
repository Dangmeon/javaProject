package api.random;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		// seed 값이 없는 랜덤 객체 정수형 난수
		Random random = new Random();
		
		for(int i = 0; i < 10; i++) {
			System.out.print(random.nextInt(10) + 1 + " "); // 1 ~ 10 사이의 난수, 실행시마다 서로 다른 난수

		}
		
		System.out.println();
		// seed 값이 있는 랜덤 객체 정수형 난수
		Random random1 = new Random(3432532);
			
		for(int i = 0; i < 10; i++) {
			System.out.print(random1.nextInt(10) + 1 + " "); // 1 ~ 10 사이의 난수, 실행할 때 마다 종일한 난수 발생
				
		}




		System.out.println();

	}

}
