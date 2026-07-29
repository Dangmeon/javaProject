package exam.gmae_project.game;

import java.util.Random;
import java.util.Scanner;

public class Guess {
	
	public void guess() {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("                    숫자 알아맞히기 게임                       ");
		System.out.println("----------------------------------------------------------");
		System.out.println("어떤 숫자일까요? 알아 맞혀보세요^^ (1 ~ 10)");
		System.out.println("----------------------------------------------------------");

		int comNum = random.nextInt(10) + 1;
		
		System.out.print("숫자 입력 : ");
		int userNum = sc.nextInt();
		
		while (userNum != comNum) {
			System.out.println("----------------------------------------------------------");
			System.out.print("아닙니다. 다시 맞혀보세요^^ 다시 입력 : ");
			userNum = sc.nextInt();
		}
		
		System.out.println("----------------------------------------------------------");
		System.out.println("드디어 맞혔습니다~ 나의 숫자는 " + comNum + "입니다");
	}

}
