package interfaceex.multi;

public class SmartMain {

	public static void main(String[] args) {
		// 다중 인터페이스 구현 객체 확인
		SmartTelevision stv = new SmartTelevision();
		stv.turnOn();
		stv.search(null);
		stv.turnOff();
		
		// 다중 인터페이스 다형성은 거의 사용하지 않는다.
		// IRemoteControl rc = new SmartTelevision(); // Type mismatch: cannot convert from SmartTelevision to IRemoteControl
		// ISearchable sc = new SmartTelevision();
	}

}
