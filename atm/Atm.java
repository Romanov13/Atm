package atm;

import java.math.BigDecimal;

public class Atm{
	
	Card currentCard;
	boolean cardIn;
	
	public Atm(){
		
		currentCard = null;
		cardIn = false;
	}
	
	public void insertCard(Card card){
		if(!cardIn){
		currentCard = card;
		cardIn = true;
		} else {
			System.out.println("Please eject the current card");
		}
	}
	
	public void ejectCard(){
		
		currentCard = null;
		cardIn = false;
		
		System.out.println("Card in Ejected");
	}
	
	public BigDecimal checkBalance(){
		
		return currentCard.getBalance();
	}
	
	public void deposit(BigDecimal deposit){
		
		if(cardIn){
			
		BigDecimal balance = currentCard.getBalance();
		
		balance = balance.add(deposit);
		
		currentCard.setBalance(balance);
		} else {
			System.out.println("Please insert the card");
		}
	}
	
	public void withdraw(BigDecimal amount){
		if(cardIn){
			
			BigDecimal balance = currentCard.getBalance();
			
			if(balance.compareTo(amount) >= 0){
				balance = balance.subtract(amount);
				currentCard.setBalance(balance);
			} else {
				System.out.println("Not enough money");
			}
		} else {
			System.out.println("Please insert the card");
		}
	}
}
