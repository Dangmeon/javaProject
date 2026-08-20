package exam.finalalgo;

import java.util.Scanner;

public class StorageMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTreeStorage<Product> storage = new BinarySearchTreeStorage<Product>();
		storage.add(new Product("melon", 5));
		storage.add(new Product("apple", 5));
		storage.add(new Product("banana", 5));
		storage.add(new Product("orange", 5));
		storage.add(new Product("kiwi", 5));
		storage.add(new Product("mango", 5));
		storage.add(new Product("tomato", 5));
		
		while(true) {
			System.out.println();
			System.out.print("-------------------재고 관리 프로그램 ------------------\n");
			System.out.print("1. 재고 확인 | 2. 재고 등록 | 3. 재고 반출 | 4. 종료 \n");
			System.out.print("------------------------------------------------------------\n");
			System.out.print("번호를 선택하세요 : ");
			int menuNum = sc.nextInt();
			
			if(menuNum == 4) {
				break;
			}
			
			switch(menuNum) {
			case 1:
				System.out.print("재고 확인 : ");
				storage.preorder();
				System.out.println();
				break;
			case 2:
				System.out.print("재고 등록 (품목) : ");
				String newPrd = sc.next();
				System.out.print("재고 등록 (수량) : ");
				int newPrdAmount = sc.nextInt();
				
				Product searchPrd = new Product(newPrd);
				
				if(storage.contains(searchPrd)) {
					System.out.println("이미 " + newPrd + "는 등록된 품목입니다.");
				}else {
					storage.add(new Product(newPrd, newPrdAmount));
					System.out.println(newPrd + "가 등록되었습니다.");
				}
				
				System.out.print("재고 확인 : ");
				storage.preorder();
				System.out.println();
				
				break;
			case 3:
				System.out.print("재고 반출 (품목): ");
				String prd = sc.next();
				System.out.print("재고 반출 (수량): ");
				int prdAmount = sc.nextInt();
				
				int resTemp = storage.updateStock(new Product(prd), prdAmount);
				
				System.out.print("재고 확인 : ");
				storage.preorder();
				System.out.println();
				
				if(resTemp == 0) {
					System.out.println(prd + "는 재고가 0이된 품목이므로 재고 품목에서 삭제합니다.");
					storage.remove(new Product(prd));
				}else if(resTemp == -1) {
					System.out.println("반품 수량만큼 재고가 없습니다.");
					storage.preorder();
				}else if(resTemp > 0) {
					System.out.println("재고 반출 완료");
					storage.preorder();
				}else {
					System.out.println("반출하려는 품목이 창고에 없습니다.");
					storage.preorder();
				}
				
				System.out.print("\n현재 재고 확인 : ");
				storage.preorder();
				System.out.println();
				break;
			default :
				System.out.println("잘못된 번호입니다.");
			}
			
		}
		
		
		
		
//		storage.updateStock(new Product(prd), prdAmount);
//		System.out.print("재고 확인 : ");
//		storage.preorder();
//		System.out.println("재고 반출 : banana 3");
//		System.out.println("재고 반출 결과 : " + storage.updateStock(new Product(prd), prdAmount));
//		System.out.print("재고 확인 : ");
//		storage.preorder();
//		System.out.println();
//		

	}

}
