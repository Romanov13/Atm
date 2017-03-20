package atm;

public class MasterCard extends Card{

public MasterCard(Account account){

this.account = account;
this.system = "MasterCard";
this.setBalance(account.getBalance);
this.number = account.getNumber + (int) (Math.random() * 9999);
this.pin = 1111;
this.owner = account.getClient().getName();
}
}
