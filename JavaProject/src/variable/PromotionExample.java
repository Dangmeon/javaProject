package variable;

public class PromotionExample {

	public static void main(String[] args) {
		// 자동 형변환 
	byte byteValue = 10;
	int intValue = byteValue; // btye -> 4byte byteValue 의 리터럴이 대입되는 시점에 정수 타입으로 확장
	
	char charValue = '가';
	intValue = charValue; // 묵시 자동 형변환  2byte -> 4byte
	
	intValue = 500;
	long longValue = intValue; // 4byte -> 8byte
	
	double doubleValue = intValue; // 작은 크기의 정수가 큰 크기의 실수로 저장(자동형변환) 
	System.out.println(doubleValue);
	
	// 크기가 큰실수를 정수변수에 저장할 경우 데이터 손실 발생 - 개발자가 결정해야 함(강제 타입 변환 필요) 
	//intValue = doubleValue;  // Type mismatch: cannot convert from double to int
	
	
	}

}
