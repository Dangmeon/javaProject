package exam.constructor_ex1;

public class PartTime1 extends Worker1{
	
	private int hour;
	private int uniPrice;
	
	// 상속받은 클래스인 sub class 의 객체 인스턴스 생성하면, super class 의 인스턴스도 생성
	public PartTime1(String joominNo, String name, int hour, int uniPrice) {
		super(joominNo, name);
		this.hour = hour;
		this.uniPrice = uniPrice;
	}
	
	public int calculatePay() {
		return hour * uniPrice;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\n시급 : " + uniPrice + " 원" +
				"\n근무시간 : " + hour + " 시간" +
				"\n총 지불액 : " + calculatePay() + " 원";
	}
	

}
