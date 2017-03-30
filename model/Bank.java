package model;

import java.util.*;

public class Bank{

	Set<Payer> clients ;
	List<Card> cards;

	HashMap<Payer, HashSet<Account>> accounts = new HashMap<Payer, HashSet<Account>>();


	public Bank(){
		clients = new HashSet<Payer>();
		cards = new ArrayList<Card>();
	}
	public void makeAccount(Payer client){
		if(!clients.contains(client)){
			clients.add(client);
			accounts.put(client, new HashSet<Account>());
		}
		Account account = new Account(client);

		accounts.get(client).add(account);
		
	}
		   
		   public Card issueCard(Account account){
		   Card card = new MasterCard(account);
		   cards.add(card);
		   return card;
		   }

		   public Card searchCard(String number) {
			   Card foundCard = null;
			   for (Card c : cards) {
				   if (number.equals(c.getNumber())) {
					   foundCard = c;
				   }

			   } return foundCard;
		   }

		   public Account searchAccount(Payer payer){
		   	Account foundAccount = null;
		   	HashSet<Account> payerAccounts = accounts.get(payer);
for(Account a : payerAccounts){
	if(a.getClient().equals(payer)){
		foundAccount = a;
	}
}
return foundAccount;
		   }
	
}


















