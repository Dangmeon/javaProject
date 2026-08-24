package exam.algo.parking;

import java.util.Scanner;

import datastructure.linkedlist.LinkedList;
import datastructure.linkedlist.ListNode;

public class LinkedListEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList linkedList = new LinkedList();

		System.out.println("주차장을 구성합니다.");
		System.out.print("주차면을 입력하세요 : ");
		int maxCapacity = sc.nextInt();
		System.out.println(maxCapacity + "대를 주차할 수 있는 주차장이 구성되었습니다.");
		
		char nextCarName = 'A';

		while (true) {
			System.out.println();
			System.out.print("0. 주차여부 확인 | 1. 주차장 주차 | 2. 자동차 출차 | 3. 만차여부 | 4. 종료 >> ");
			int menu = sc.nextInt();
			sc.nextLine();

			if (menu == 4) {
				System.out.println("종료합니다.");
				break;
			}

			switch (menu) {
			case 0:
				System.out.println("주차된 차량의 고유값을 입력하세요. : ");
				char carChar = sc.nextLine().charAt(0);
				int num = linkedList.contains(carChar);
				
				if(num < 0) {
					System.out.println("입력하신 차량 정보는 주차 목록에 없습니다.");
				}else {
					System.out.println("입력하신 차량은 " + (num + 1) + "번째 출차 가능합니다.");
				}
				if(linkedList.getSize() == 0) {
					System.out.println("현재 주차장이 비어있습니다.");
					break;
				}
				System.out.print("현재 주차된 차량 : ");
				linkedList.printList();
				break;
			case 1:
				if(linkedList.getSize() > maxCapacity - 1) {
					System.out.println("주차장이 가득 찼습니다.");
				}else {
					String carName = String.valueOf(nextCarName);
					
					System.out.print("주차 위치를 선택하세요. (1. 중간 2. 맨 앞  3. 마지막) >> ");
					int position = sc.nextInt();
					
					if(position == 1 && linkedList.getSize() > 0) {
						System.out.print("현재 주차된 차량: ");
						linkedList.printList();
						System.out.print("어떤 차량 뒤에 주차하시겠습니까? (차량 문자 입력) : ");
						String targetCar = sc.next();
						ListNode targetNode = linkedList.searchNode(targetCar);
						
						if(targetNode != null) {
							linkedList.insertNode(targetNode, carName);
							System.out.println(carName + " 자동차가 " + targetCar + " 뒤에 주차 완료되었습니다.");
							nextCarName++;
						}else {
							System.out.println("해당 차량이 존재하지 않아 마지막에 주차합니다.");
							linkedList.insertNode(targetCar);
							System.out.println(carName + " 주차 완료되었습니다.");
							nextCarName++;
						}
					}else if(position == 2) {
						linkedList.insertNodeFirst(carName);
						System.out.println(carName + " 를 맨 앞에 주차 완료되었습니다.");
						nextCarName++;
					}
					else {
						linkedList.insertNode(carName);
						System.out.println(carName + " 주차 완료되었습니다.");
						nextCarName++;
					}
				}
				break;
			case 2:
				if(linkedList.getSize() == 0) {
					System.out.println("주차장이 비어있어 출차할 차량이 없습니다.");
				}else {
					System.out.print("현재 주차된 차량: ");
					linkedList.printList();
					System.out.print("출차할 차량을 입력하세요 (차량 문자 입력) : ");
					String targetCar = sc.next();
					
					if(linkedList.searchNode(targetCar) != null) {
						linkedList.deleteNode(targetCar);
						System.out.println(targetCar + " 자동차 출차 완료");
					}else {
						System.out.println(targetCar + " 차량이 주차장에 존재하지 않습니다.");
					}
				}
				break;
			case 3:
				int currentCar = linkedList.getSize();
				System.out.print("현재 주차장에 자동차 " + currentCar + "대가 주차되어있습니다. ");

				if (currentCar >= maxCapacity -1) {
					System.out.println("현재 주차장이 만차입니다. ");
				} else {
					System.out.println("여유공간이 " + (maxCapacity - currentCar) + "대 존재합니다.");
				}
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 재실행해주세요");
			}
		}

	}

}
