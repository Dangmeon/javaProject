package exam.constructor_ex;

public class CarAutomobile {

	public static void main(String[] args) {
		
		Automobile myAuto = new Automobile("01가 1234", "아반떼", "현대", 2022, "자동");
		
		System.out.println("차량 번호 : " + myAuto.carNo);
		System.out.println("차종 : " + myAuto.carName);
		System.out.println("제조사 : " + myAuto.carMaker);
		System.out.println("연식 : " + myAuto.carYear);
		System.out.println("기어 변속 : " + myAuto.autoManual);


	}

}
