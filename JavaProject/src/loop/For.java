package loop;

public class For {

	public static void main(String[] args) {
		// for (초기식; 조건식; 증감식;) {반복문장}
		int i; // main 메소드 내 어디서든 사용 가능
		for(i = 0; i <= 10; i++) {
			System.out.println(i);
		}
		System.out.print("i 최종값 : ");
		System.out.println(i);
		
		for(int j = 20; j <= 30; j+=2) { // j 는 for 문 내부의 지역변수 
			System.out.println(j);
		}
//		System.out.println("j 최종값 : ");
//		System.out.println(j);
		
		// 1~ 100까지 더한 값
		int k, sum = 0;
		for(k = 1; k <= 100; k++) {
			sum += k;
		}
		System.out.println("1 ~" + (k-1) + "합 : " + sum);

	}

}
