package exam.abstractex;

public class DrawingObjectMain {

	public static void main(String[] args) {
		
		DrawingObject circle = new Circle("blue");
		DrawingObject rect = new Rect("green");
		DrawingObject poly = new Poly("red");
		
		poly.draw();
		circle.draw();
		rect.draw();

	}
}


// 추상클래스 : 생성자 필요, 독립적인 객체 인스턴스 생성 불가능(new 생성자() : 안됨)
// : 상속받은 자식 클래스에서 반드시 추상 메서드 구현
// : 자식 클래스 객체 인스턴스를 생성하면 자동으로 상속받은 추상 클래스 객체 인스턴스가 생성됨