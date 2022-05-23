
public class Deposit extends Thread{
	private StrangeBank bank;
	
	private double dollar;
	private double euro;
	private double pound;
	
	public Deposit(StrangeBank bank) {
		super("Deposit");
		this.bank = bank;
		dollar = 1;
		euro = 2;
		pound = 3;
	}
	
	public void run() {
		bank.depositMoney(dollar, Currency.DOLLAR);
		clearDollar();
		bank.depositMoney(euro, Currency.EURO);
		clearEuro();
		bank.depositMoney(pound, Currency.POUND);
		clearPound();
	}
	
	public void clearDollar() {
		dollar = 0;
	}
	
	public void clearEuro() {
		euro = 0;
	}
	
	public void clearPound() {
		pound = 0;
	}
}
