package exam;

import java.util.Scanner;

import datastructure.stack.Stack;

public class StackEx1 {
	
	public static boolean checkStack(String stackSize) {
		Stack stack = new Stack(stackSize.length());
		
		for(int i = 0; i < stackSize.length(); i++) {
			char ch = stackSize.charAt(i);
			
			// 앞 괄호 확인 후  push
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
            } 
			// 뒷 괄호 확인
			else if (ch == ')' || ch == '}' || ch == ']') {
				// 비었는지 확인
				if(stack.isEmpty()) {
					return false;
				}
				// 저장된 데이터 중 가장 최근에 저장된 데이터를 반환 -> 앞 괄호 가져오기
				char open = stack.peek();
				
				// 앞 괄호 가져온거랑 뒷괄호가 알맞게 앞 뒤 다 닫혀있는지 확인 후 pop
				if (
					(ch == ')' && open == '(') ||
	                (ch == '}' && open == '{') ||
	                (ch == ']' && open == '[')) {
	                    stack.pop();
	            } else {
	                return false;
	            }
			}
		}
		// true 반환
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        
        System.out.print("수식을 입력하세요 : ");
        String input = sc.nextLine(); 
        
        System.out.println();
        
        if (checkStack(input)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        
        sc.close();
	}

}
