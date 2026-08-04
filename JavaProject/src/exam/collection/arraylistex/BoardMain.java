package exam.collection.arraylistex;

import java.util.ArrayList;

public class BoardMain {

	public static void main(String[] args) {
		
		ArrayList<Board> boardList = new ArrayList<>();
		
		boardList.add(new Board("감자 종류" , "감자의 종류는 몇 가지일까요?" , "김감자"));
		boardList.add(new Board("감자 요리" , "감자 요리가 가장 쉬웠어요." , "솊감자"));
		boardList.add(new Board("감자 살림" , "감자는 어디서나 잘 자랍니다." , "땅감자"));

		System.out.println("=== 게시글 목록 ===");
		for(int i = 0; i< boardList.size(); i++) {
			Board board = boardList.get(i);
			System.out.println("제목 : " + board.getSubject());
			System.out.println("내용 : " + board.getContent());
			System.out.println("작성자 : " + board.getWirter());
			System.out.println("---------------------------------");

		}
	}

}
