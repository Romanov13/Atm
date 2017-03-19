package bank;

import sun.swing.CachedPainter;

public class Account{
	
	private Client client;

	private int number;
	private double balance;

	public int getNumber() {
		return number;
	}



	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
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