package bank;

import java.math.BigDecimal;

public class Account{
	
	private Payer client;

	private int number;
	private BigDecimal balance;

	public int getNumber() {
		return number;
	}



	public BigDecimal getBalance() throws OverdraftException{
		if(balance >= 0){
		return balance;
		} else {
			throw new OverdraftException("Overdraft") extends Exception{
				
			};
		}
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}



	public Account(Payer client) {
		this.client = client;
		number = (int) (Math.random() * 9999);
		balance = BigDecimal.valueOf(0.00);

	}

	public Payer getClient() {
		return client;
	}
}
