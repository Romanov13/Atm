package bank;

import bank.Card;

public class MasterCard extends Card {

public MasterCard(Account account){

this.account = account;
this.system = "MasterCard";
this.setBalance(account.getBalance());
this.number = String.valueOf(account.getNumber() + " " + (int) (Math.random() * 9999));
this.pin = "1111";
this.owner = account.getClient();
this.cvv = "999";
this.eDate = "03/20";
}
}
