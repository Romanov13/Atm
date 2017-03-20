package bank;

import java.math.BigDecimal;

public class Account{
	
	private Client client;

	private int number;
	private BigDecimal balance;

	public int getNumber() {
		return number;
	}



	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}



	public Account(Client client) {
		this.client = client;
		number = (int) (Math.random() * 9999);
		balance = 0.00;

	}

	public Client getClient() {
		return client;
	}
}
