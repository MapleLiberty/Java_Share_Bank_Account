
public class Transaction {

	public static void main(String[] args) {
		
		StrangeBank bank = new StrangeBank();
		
		Deposit deposit = new Deposit(bank);
		Withdraw withdraw = new Withdraw(bank);
		
		deposit.start();
		withdraw.start();
	}

}
