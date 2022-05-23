
public class Withdraw extends Thread {
	private StrangeBank bank;
	private double dollar;
	private double euro;
	private double pound;
	
	public Withdraw(StrangeBank bank) {
		super("Withdraw");
		this.bank = bank;
		dollar = 0;
		euro = 0;
		pound = 0;
	}
	
	public void run() {
		dollar = bank.withdrawMoney(Currency.DOLLAR);
		euro = bank.withdrawMoney(Currency.EURO);
		pound = bank.withdrawMoney(Currency.POUND);
		System.out.println("Withdrawal    Dollar: " + dollar + " Euro: " + euro + " Pound: " + pound);
	}
}
