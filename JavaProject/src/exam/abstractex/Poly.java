package exam.abstractex;

public class Poly extends DrawingObject{

	public Poly(String color) {
		super(color);
	}
	
	@Override
	public void draw() {
		System.out.println(color + "색상으로 다각형 그리기");
	}

	
}
