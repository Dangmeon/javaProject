package extendsex.poly2;

public class DriverMain {

	public static void main(String[] args) {
		// 매개변수의 다형성
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		// drive 매소드의 매개변수가 super class 타입이므로 다형성을 활용
		driver.drive(bus); // 파라미터가 super class 로 형변환
		driver.drive(taxi);

	}

}
