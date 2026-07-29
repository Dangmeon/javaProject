package exam.gmae_project.game;

import java.util.Random;
import java.util.Scanner;

public class GaBaBo {

	public void gababo() {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int userNum;
		
		System.out.print("***********************************\n");
		System.out.print("                      가위바위보 게임                       \n");
		System.out.print("가위 바위 보 게임 : 1. 가위, 2. 바위, 3. 보 \n");
		
		while(true) {
			System.out.print("================================\n");

			System.out.print("번호 입력 : ");
			userNum = sc.nextInt();
			
			if (userNum < 1 || userNum > 3) {
				System.out.println("1, 2, 3 중에서 다시 입력해 주세요.");
				continue;
			}
			
			int comNum = random.nextInt(3) + 1;
			String comChoice = (comNum == 1) ? "가위" : (comNum == 2) ? "바위" : "보";

			if (userNum == comNum) {
				System.out.println("비겼습니다!");
			} else if ((userNum == 1 && comNum == 3) || (userNum == 2 && comNum == 1) || (userNum == 3 && comNum == 2)) {
				System.out.println("당신이 이겼습니다^^");
			} else {
				System.out.println("당신이 졌습니다ㅠㅠ"); 
			}
			
			System.out.println("컴퓨터는 " + comChoice + "입니다.");
			
			System.out.print("계속하시겠습니까? (y) : ");
			String retry = sc.next();
			
			if(retry.equalsIgnoreCase("n")) {
				System.out.print("게임을 종료합니다.\n");
				break;
			}
			
			
		}


	}

}
