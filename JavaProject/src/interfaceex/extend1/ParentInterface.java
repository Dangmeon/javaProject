package interfaceex.extend1;

public interface ParentInterface {
	
	public void method1(); // 추상메서드
	public default void method2() {
		System.out.println("P-m2()"); 
	} // 디폴트 매소드 구현 부분 있어야함
	

}
