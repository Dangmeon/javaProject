package exam;

import java.util.Scanner;

import datastructure.stack.Stack;

public class StackEx2 {

	public static void main(String[] args) {
		// stack 사용자 인터페이스(메뉴)
		Scanner stdIn = new Scanner(System.in);
		Stack s;

		// 스택 구성을 위한 용량 입력
		System.out.println("주차장을 구성합니다.");
		System.out.print("주차면을 입력하세요 : ");
		int stackSize = stdIn.nextInt();
		System.out.println(stackSize + "대를 주차할 수 있는 주차장이 구성되었습니다.");
		s = new Stack(stackSize);

		char carName = 'A';
		
		while (true) {
			System.out.println();
			System.out.print("0. 주차현황 | 1. 주차장 주차 | 2. 자동차 출차 | 3. 만차여부 | 4. 종료 ");
			int menu = stdIn.nextInt();

			if (menu == 4) {
				System.out.println("종료합니다.");
				break;
			}


			switch (menu) {
			case 0:
				s.showParkingStack();
				break;
			case 1:
				if(s.isFull()) {
					System.out.println("주차장이 가득찼습니다.");
				}else {
					s.push(carName);
					System.out.println(carName + " 자동차 주차 완료");
					carName++;
				}
				break;
			case 2:
				if(s.isEmpty()) {
					System.out.println("주차장이 비었습니다.");
				}else {
					char exitedCar = s.pop();
					System.out.println(exitedCar + " 자동차 출차");
				}
				break;
			case 3:
				int currentCar = s.size();
				System.out.print("현재 주차장에 자동차 " + currentCar + "대가 주차되어있습니다.");
				
				if(s.isFull()) {
					System.out.println("현재 주차장이 만차입니다.");
				}else {
					System.out.println("여유공간이 존재합니다.");
				}
				break;
			default : 
					System.out.println("잘못 입력하셨습니다. 다시 재실행해주세요");
			}
		}

	}

}
