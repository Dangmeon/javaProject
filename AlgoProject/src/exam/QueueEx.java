package exam;



import java.util.Scanner;

import datastructure.queue.MyQueueMove;

public class QueueEx {

	public static void main(String[] args) {
		// stack 사용자 인터페이스(메뉴)
		Scanner stdIn = new Scanner(System.in);
		MyQueueMove q;

		// 스택 구성을 위한 용량 입력
		System.out.println("주차장을 구성합니다.");
		System.out.print("주차면을 입력하세요 : ");
		int queueSize = stdIn.nextInt();
		System.out.println(queueSize + "대를 주차할 수 있는 주차장이 구성되었습니다.");
		q = new MyQueueMove(queueSize);

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
				q.showParkingQueue();
				break;
			case 1:
				if (q.isFull()) {
					System.out.println("주차장이 가득찼습니다.");
				} else {
					q.enqueue(carName);
					System.out.println(carName + " 자동차 주차 완료");
					carName++;
				}
				break;
			case 2:
				if (q.isEmpty()) {
					System.out.println("주차장이 비었습니다.");
				} else {
					System.out.print("주차 시간이 1시간 경과했습니까? (1: 예 / 0: 아니오): ");
					int timeCheck = stdIn.nextInt();
					
					if(timeCheck == 0) {
						char exitedCar = q.dequeue();
						System.out.println(exitedCar + " 자동차 출차");
					}else if(timeCheck ==1) {
						System.out.print("출차할 차량 고유 문자를 입력하세요: ");
						char targetCar = stdIn.next().charAt(0);
						
						int targetIndex = q.contains(targetCar);
						if(targetIndex == -1) {
							System.out.print(targetCar + "차량이 주차장에 없습니다.");
						}else {
							
							if(targetCar == q.peek()) {
								char exitedCar = q.dequeue();
								System.out.println(exitedCar + " 자동차 출차");
							}else {
								int currentSize = q.size();
								char[] tempArray = new char[currentSize];
								
								for(int i = 0; i < currentSize; i++) {
									tempArray[i] = q.dequeue();
								}
								
								for(int i = 0; i < currentSize; i++) {
									if(tempArray[i] != targetCar) {
										q.enqueue(tempArray[i]);
									}
								}
								
								q.enqueue(targetCar);
								System.out.println("패널티가 적용되어 " + targetCar + " 차량은 출차 순서가 뒤로 밀립니다.");
							}
						}
					}
					
				}
				break;
			case 3:
				int currentCar = q.size();
				System.out.print("현재 주차장에 자동차 " + currentCar + "대가 주차되어있습니다.");

				if (q.isFull()) {
					System.out.println("현재 주차장이 만차입니다.");
				} else {
					System.out.println("여유공간이 존재합니다.");
				}
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 재실행해주세요");
			}
		}

	}

}
