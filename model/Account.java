package model;

import java.math.BigDecimal;

public class Account{
	
	private Payer client;

	private int number;
	private BigDecimal balance;

	public Account(Payer client) {
		this.client = client;
		balance = BigDecimal.valueOf(0);
	}

	public int getNumber() {
		return number;
	}



	public BigDecimal getBalance(){

		return balance;

	}

	public void setBalance(BigDecimal balance) throws OverdraftException {

		if ((this.balance.compareTo(balance)) >= 0) {
			this.balance = balance;
		} else {
			throw new OverdraftException("Overdraft");
		}
	}


	public Payer getClient() {
		return client;
	}
}
