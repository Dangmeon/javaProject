package exam.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> wordList = new ArrayList<>();
		
		for(int i = 0; i < 4; i++) {
			System.out.print("단어를 입력하세요. >>" );
			String word = sc.next();
			wordList.add(word);
		}
		
		System.out.println("--------------------------------");
		
		for(int i = 0; i < wordList.size(); i++) {
			System.out.print(wordList.get(i) + " ");
		}
		System.out.println();
		
		String longWord = wordList.get(0);
		for(int i = 1; i < wordList.size(); i++) {
			if(wordList.get(i).length() > longWord.length()) {
				longWord = wordList.get(i);
			}
		}
		
		System.out.println("가장 긴 단어는 : " + longWord);
		System.out.println("가장 긴 단어의 길이는 : " + longWord.length());

		
		sc.close();

	}

}
