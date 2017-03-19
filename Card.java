package card;

public abstract class Card{
	
	private final Account account;
	private final String system;
	private final String number;
	private int pin;
	private final String owner;
	
	public double getBalance(){
		return account.getBalance();
	}
	
	public void setBalance(double balance){
		account,setBalance(balance); 
	}
	
	public String getSystem(){
		return system;
	}
	
	public String getNumber(){
		return number;
	}
	
	public int getPin(){
		return pin;
	}
	
	public String getOwner(){
		return owner;
	}

}