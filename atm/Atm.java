package atm;

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
	
	public double checkBalance(){
		
		return currentCard.getBalance();
	}
	
	public void deposit(double deposit){
		
		if(cardIn){
			
		double balance = currentCard.getBalance();
		
		balance += deposit;
		
		currentCard.setBalance(balance);
		} else {
			System.out.println("Please insert the card");
		}
	}
	
	public void withdraw(double amount){
		if(cardIn){
			
			double balance = currentCard.getBalance();
			
			if(balance >= amount){
				balance -= amount;
				currentCard.setBalance(balance);
			} else {
				System.out.println("Not enough money");
			}
		} else {
			System.out.println("Please insert the card");
		}
	}
}