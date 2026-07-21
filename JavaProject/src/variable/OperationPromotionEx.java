package variable;

public class OperationPromotionEx {

	public static void main(String[] args) {
		// 연산식에서의 자동 타입 변환
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		
		// 정수 연산자일 경우 int 타입이 기본 타입 (4byte)
		// byte byteValue3 = byteValue1 + byteValue2 // 더한 결과가 int type 임-타입불일치 오류 발생
		int intvalue = byteValue1 + byteValue2;

		char cahrValue1 = 'A';
		char charValue2 = 1;
		
		// char 도 정수이므로 연산결과는 ㅑnt형 -> 컴파일 오류 발생
		// char cjarValue3 = charValue1 + charValue2;
		int charValue3 = cahrValue1 + charValue2;
		System.out.println(charValue3); // int 형 변수 값 출력
		System.out.println((char)charValue3); // char 형 출력
		
		int intValue3 =10;
		int intValue4 = intValue3/4; // java의 나누기 연산 -> int/int 결과는 정수
		System.out.println(intValue4); // 10 / 4 -> 2를 반환 (실수 결과 원하면 실수 연산을 해야함)
		
		int intValue5 = 10;
		//int intValue6 = intValue5/4.0; // int / double -> double 형으로 int 가 자동형변환 발생 -> 결과 double 
		double dValue6 = intValue5/4.0;
		System.out.println(dValue6);
		
	}

}
