package atm;

import bank.Card;

import java.math.BigDecimal;
import java.util.Scanner;

public class Atm{
	
	public Card currentCard;
	boolean cardIn;
	
	public Atm(){
		
		currentCard = null;
		cardIn = false;
	}
	
	public void insertCard(Card card){
		if(!cardIn){
			if(checkPin(card)){
		currentCard = card;
		cardIn = true;
		System.out.println("Card " + card.getNumber() + " of " + card.getOwner() + " is inserted.");
			} else {System.out.println("Sorry, the PIN is incorrect");}
		} else {
			System.out.println("Please eject the current card");
		}
	}
	
	public boolean checkPin(Card card){
		
		System.out.println("Enter the PIN");
		Scanner sc = new Scanner(System.in);
		String pinInput = sc.nextLine();
		
		if((card.getPin()).equals(pinInput))
		{return true;} else {return false;}
	}
	
	public void ejectCard(){
		
		currentCard = null;
		cardIn = false;
		
		System.out.println("Card in Ejected");
	}
	
	public BigDecimal checkBalance(){
		try{
		return currentCard.getBalance();
		} catch (OverdraftException oe){
		System.out.println("Sorry, the card is suspended");
			oe.printStackTrace();
		}
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
