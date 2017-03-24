package main;

import atm.*;
import bank.*;

import java.math.BigDecimal;

class Main{
	
	public static void main(String[] args){
		
		Atm atm = new Atm();
		Bank bank = new Bank();
		InternetShop iShop = new InternetShop("iShop", bank);
		try{
		File payerList = new File("resources/PayerList.txt");
		BufferedReader br = new BufferedReader(new FileReader(payerList));
			String line = "";
			line = br.readLine();
			String[] payer = line.split("/");
		Payer payer = new Payer(payer[0], payer[1]);
			br.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		bank.makeAccount(payer);
		payer.getACard(bank.issueCard(bank.searchAccount(payer)));
		payer.setPrimeCard(payer.cards.get(0));
		try{
			FileWriter writer = new FileWriter("resources/PayerList.txt");
			writer.write(payer.getName() + "/" + payer.getPhone());
			writer.close();
		} catch (IOException e){
			e.printStackTrace();
		}
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
