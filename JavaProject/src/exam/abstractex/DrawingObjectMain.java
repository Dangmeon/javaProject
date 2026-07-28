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
