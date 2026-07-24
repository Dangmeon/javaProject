package exam;

public class SavingsMain {

	public static void main(String[] args) {
		
        Savings saving = new Savings();

        saving.setName();
        saving.setBalance();

        System.out.println("예금주 : " + saving.getName());
        System.out.println("입금전 잔액 : " + saving.getBalance());
        
        saving.inputDeposit(); 
        
        System.out.println("이자 : " + (int)saving.getInterest());
        System.out.println("최종 잔액 : " + saving.getBalance());

	}

}
