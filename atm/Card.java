package atm;

import bank.Account;

public abstract class Card{
	
	private Account account;
	private  String system;
	private  int number;
	private int pin;
	private  String owner;
	
	public double getBalance(){
		return account.getBalance();
	}
	
	public void setBalance(double balance){
		account.setBalance(balance);
	}
	
	public String getSystem(){
		return system;
	}
	
	public int getNumber(){
		return number;
	}
	
	public int getPin(){
		return pin;
	}
	
	public String getOwner(){
		return owner;
	}

}
