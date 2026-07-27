package exam.constructor_ex1;

public class PartTime extends Worker{
	
	int hour;
	int unitPrice;
	
	public PartTime(String joominNo, String name, int hour, int unitPrice) {
		super(joominNo, name);
		this.hour = hour;
		this.unitPrice = unitPrice;
	}
	
	public int calculatePay() {
		return hour * unitPrice;
	}
	
	public String toString() {
		return super.toString() + 
	               "\n시급 : " + unitPrice + " 원" +
	               "\n근무시간 : " + hour + " 시간" +
	               "\n총지불액 : " + calculatePay() + " 원";
	}
}
