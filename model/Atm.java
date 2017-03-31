package model;

import model.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Atm{
	
	public Card currentCard;
	boolean cardIn;
	boolean pinCorrect;
	
	public Atm(){
		
		currentCard = null;
		cardIn = false;
	}
	
	public void insertCard(Card card){
		if(!cardIn){
			
		currentCard = card;
		cardIn = true;
		System.out.println("Card " + currentCard.getNumber() + " of " + currentCard.getOwner() + " is inserted.");
			
		} else {
			System.out.println("Please eject the current card");
		}
	}
	
	public boolean checkPin(String pin){
		
		if((currentCard.getPin()).equals(pin))
		{return true;} else {return false;}
	}
	
	public void ejectCard(){
		
		currentCard = null;
		cardIn = false;
		
		System.out.println("Card is Ejected");
	}
	
	public BigDecimal checkBalance(){
			return currentCard.getBalance();
	}
	
	public void deposit(BigDecimal deposit){
		
		if(cardIn){

			BigDecimal balance = null;
				balance = currentCard.getBalance();
			balance = balance.add(deposit);

			try {
				currentCard.setBalance(balance);
			} catch (OverdraftException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Please insert the card");
		}
	}
	
	public void withdraw(BigDecimal amount){
		if(cardIn){

			BigDecimal balance = null;

				balance = currentCard.getBalance();


			try {
				currentCard.setBalance(balance);
			} catch (OverdraftException e) {
				e.printStackTrace();
				System.out.println("Not enough money");
			}
		} else {
			System.out.println("Please insert the card");
		}
	}
	
	public boolean isCardIn(){
		return cardIn;
	}
}
