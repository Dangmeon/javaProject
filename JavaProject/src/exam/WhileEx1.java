package exam;

public class WhileEx1 {

	public static void main(String[] args) {
		
		int num = 0;
		int sum = 0;
		
		while(num <= 100) {
			
			if(num % 2 == 0) {
				sum += num;
			}
			num++;
		}
		
		System.out.print("1~100 짝수의 합 : " + sum);

	}

}
