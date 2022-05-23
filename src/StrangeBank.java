enum Currency {
		CLEAR,
		DOLLAR,
		EURO,
		POUND
	}

public class StrangeBank {
	private double money = 0;
	
	private Currency currency;
	
	public StrangeBank() {
		currency = Currency.CLEAR;
	}
	
	public synchronized void depositMoney(double money,Currency currency) {
		
		while(!(this.currency == Currency.CLEAR || this.currency == currency)) {
			try {
				System.out.println("Waiting to deposit " + money + " " + currency + "\n");
				wait();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.err.println(Thread.currentThread().getName() + " " + money + " " +  currency + "\n"); // Currency check
		
		setMoney(money);
		setCurrency(currency);
		
		notify();
	}
	
	public synchronized double withdrawMoney(Currency currency) {
		
		while(this.currency != currency) {
			try {
				System.out.println("Waiting to withdraw " + currency + "\n");
				wait();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.err.println(Thread.currentThread().getName() + " " + money + " " + currency + "\n"); // Currency check
		
		
		double depo = money;
		clearMoney();
		setCurrency(Currency.CLEAR);
		
		notify();
		
		return depo;
		
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public double getMoney() {
		return money;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void clearMoney() {
		money = 0;
	}
	
	
}
