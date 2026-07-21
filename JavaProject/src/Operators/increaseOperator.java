package Operators;

public class increaseOperator {

	public static void main(String[] args) {
		// 단항 연산자 
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("-------------------");
		// 증감연산자 다독으로 사용되면 연산자의 위치는 상관없음
		x++; // x = x + 1
		++x; // x = x + 1
		System.out.println(x);
		System.out.println("-------------------");
		// 증감연산자 다독으로 사용되면 연산자의 위치는 상관없음
		y--; // y = y -  1
		--y; // x = y -  1
		System.out.println(y);

		// 증감연산자 사용시 위치가 중요 : 다른 연산자(대입)와 같이 사용할 경우 증감 연산자 위치가 중요함 
		x = 10; y = 10;
		
		// 증감 연산 변수 앞에 사용
		z = ++x;
		
		System.out.println("-------------------");
		System.out.println(x);
		System.out.println(z);
		// 변수값을 증가시키고 값을 사용함
		
		// 증감 연산 변수 뒤에 사용
		z = y++;
		
		System.out.println("-------------------");
		System.out.println(y); // y 는 1 증가 
		System.out.println(z); // z 는 y 가 증가되기 전 값이 저장
		// 변수의 값을 먼저 사용하고 나중에 증가
		
		// 증감 연산과 다른 연산자왁 ㅏㅌ이 사용 (대입아닌 다른 연산자)
		x = 1; y = 1;
		
		z = ++x + 10; // x 를 먼저 증가시키고 나머지 연산
		int z1 = y++ + 10; // 증감연산 제외한 나머지 연산을 진행하고 y 를 증가
		System.out.println("-------------------");
		System.out.println(x);
		System.out.println(z); // y 는 1 증가 
		System.out.println(y);
		System.out.println(z1); // z 는 y 가 증가되기 전 값이 저장
		
		// 논리 부정 연산 : !
		System.out.println("-------------------");
		boolean bl = true;
		System.out.println(!bl);
		
		// 비트 반전 연산자 : ~  비트 데이터에 대해  0 -> 1 1 -> 0 반전
		// byte, short, int, ling 타입만 피연산자가 될 수 있다.
		System.out.println(~10); // 양수 10 00000000 00000000 00000000  00001010 -> 11111111 11111111 11111111 11110101
		
	}

}
