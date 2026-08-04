package threads.sync;

public class Calculator2 {

	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	// 이 객체가 공용 객체로 사용이 될 때 스레드 사용 시작 후 점유해서 사용 가능하도록 동기화
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e){
			
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);

	}
}
