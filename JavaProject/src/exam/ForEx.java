package exam;

public class ForEx {

	public static void main(String[] args) {
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			
			if(i % 2 == 0) {
				continue;
			}
			
			System.out.println(i);
			sum += i;
		}
		
		System.out.println("1 ~ 10 홀수의 합 : " + sum);
	}

}
