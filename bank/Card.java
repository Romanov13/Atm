package bank;

import java.math.BigDecimal;

public abstract class Card{
	
	protected Account account;
	protected String system;
	protected String number;
	protected String pin;
	protected Payer owner;
	protected String eDate;
	protected String cvv;


	
	public BigDecimal getBalance(){
		return account.getBalance();
	}
	
	public void setBalance(BigDecimal balance){
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

	public String geteDate() {
		return eDate;
	}

	public String getCvv(){
		return cvv;
	}



}
