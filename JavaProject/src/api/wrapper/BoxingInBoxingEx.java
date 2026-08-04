package api.wrapper;

public class BoxingInBoxingEx {

	public static void main(String[] args) {
		// Boxing : 기본 타입 -> Wrqpper 타입
		// 생성자
		Integer obj1 = new Integer(100);
		Integer obj2 = Integer.valueOf(200);
		Integer obj3 = Integer.valueOf("300");
		
		// 자동 Boxing
		Integer obj4 = 400;

		// UnBoxing
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		int value3 = obj3.intValue();
		
		// 자동 UnBoxing
		int value4 = obj4;

		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);


	}

}
