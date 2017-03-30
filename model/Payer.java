package model;

import java.util.ArrayList;
import java.util.List;

public class Payer{
    String name;
    String phone;
    public List<Card> cards;
    Card primeCard;

    public String getName() {
        return name;

    }

    public String getPhone(){
        return phone;
    }

    public void addCard(Card card){
cards.add(card);
    }


	
	public Payer(String name, String phone){
		this.name = name;
		cards = new ArrayList<Card>();
		this.phone = phone;
	}

	public void setPrimeCard(Card card){
	    primeCard = card;
    }

    public Card getPrimeCard(){
	    return primeCard;
    }

    public String toString(){
        return name;
    }
}
