package main;

import atm.*;
import bank.*;

import java.math.BigDecimal;

class Main{
	
	public static void main(String[] args){
		
		Atm atm = new Atm();
		Bank bank = new Bank();
		InternetShop iShop = new InternetShop("iShop", bank);
		Payer payer = new Payer("Sergey");
		bank.makeAccount(payer);
		payer.getACard(bank.issueCard(bank.searchAccount(payer)));
		payer.setPrimeCard(payer.cards.get(0));
		atm.insertCard(payer.getPrimeCard());
		System.out.println(atm.currentCard.geteDate());
		System.out.println(atm.currentCard.getCvv());
		atm.deposit(BigDecimal.valueOf(100));
		System.out.println(atm.checkBalance());
		atm.ejectCard();
		iShop.buyItem();
		atm.insertCard(payer.getPrimeCard());
		System.out.println(atm.checkBalance());




		
	}
}