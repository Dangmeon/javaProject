package recursion;

public class Recursion1 {

	// sum( n) = n + (n - 1) + (n - 2) + (n - 3)+ ... + 1
	// sum(5) = 5 + 4 + 3 + 2 + 1 = 5 + sum(4)
	// sum(4) = 4 + 3 + 2 + 1 = 4 + sum(3)
	// sum(3) = 3 + 2 + 1 = 3 + sum(2)
	// sum(2) = 2 + sum(1)
	// sum(1) = 1 + sum(0)
	// sum(0) : return 0
	
	
	/* 먼저 실행된게 밑으로 깔림
	 * sum(1) 1 + 0 -> 사라짐
	 * sum(2) 2 + 1 -> 사라짐
	 * sum(3) 3 + 3 -> 사라짐
	 * sum(4) 4 + 6 -> 사라짐
	 * sum(5) 5 + 10 -> 호출한 곳으로 리턴
	 * 
	 * */
	public static void main(String[] args) {
		
		System.out.println(sum(10));
	
	}
	
	static int sum(int n) {
		if(n == 0) {
			return 0;
		}else {
			return n + sum(n-1);
		}
	}

}
