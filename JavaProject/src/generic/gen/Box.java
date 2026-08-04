package generic.gen;

// generic 타입 클래스 구현 - T 는 아직 결졍되지 않은 타입 
public class Box<T> {
	
	private T product;
	
	public void set(T product) {
		this.product = product;
	}
	
	public T get() {
		return this.product;
	}
	
}
