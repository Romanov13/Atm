package model;

import java.math.BigDecimal;

public abstract class Card{
	
	protected Account account;
	protected String system;
	protected String number;
	protected String pin;
	protected Payer owner;
	protected String eDate;
	protected String cvv;


	
	public BigDecimal getBalance() {
		return account.getBalance();
	}
	
	public void setBalance(BigDecimal balance) throws OverdraftException {
		account.setBalance(balance);
	}
	
	public String getSystem(){
		return system;
	}
	
	public String getNumber(){
		return number;
	}
	
	public String getPin(){
		return pin;
	}
	
	public Payer getOwner(){
		return owner;
	}

	public String getDate() {
		return eDate;
	}

	public String getCvv(){
		return cvv;
	}



}
