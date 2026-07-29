package interfaceex.extend1;

public interface ChildInterface3 extends ParentInterface{

	// ParentInterface에서 상속받은 default 메서드 재정의(추상 메소드 재선언)
	@Override
	public void method2(); // default 메소드를 추상 메소드로 재선언(구현 객체에서 필수 구현)
	
	
	public void method3(); // 추상 메소드
}
