package atm;

import bank.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class InternetShop{

String name;
Bank bank;

public InternetShop(String name, Bank bank){
this.name = name;
this.bank = bank;
}

public void buyItem(){

System.out.println("To buy an item for $50, please enter the card number, the date of expiery and CVV.");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number");
    String numberInput = sc.nextLine();
    System.out.println("Enter the expiry date");
    String dateInput = sc.nextLine();
    System.out.println("Enter the CVV");
    String cvvInput = sc.nextLine();
    if(verify(numberInput, dateInput, cvvInput)){
    System.out.println("Veryfied");

        Card cardToWithdraw = bank.searchCard(numberInput);
        if(smsSecure(cardToWithdraw)) {
        BigDecimal balance = cardToWithdraw.getBalance();
        balance = balance.subtract(BigDecimal.valueOf(50));
        cardToWithdraw.setBalance(balance);
    } else { System.out.println("Sorry, the code is incrrect");}

} else {System.out.println("Invalid card");}
}



    public boolean verify(String numberInput, String dateInput, String cvvInput){

    Card cardToCheck = bank.searchCard(numberInput);
    if(!(cardToCheck ==null)) {
        if (cardToCheck.geteDate().equals(dateInput) && cardToCheck.getCvv().equals(cvvInput)) {
            return true;
        } else {
            return false;
        }
    } else {return false;}

}

public boolean smsSecure(Card card){
        System.out.println("SMS have been sent to your number " + card.getOwner().getPhone() + ". Please enter the code.");
        int c = (int) Math.random() * 9999;
        String code = String.valueOf(c);
        System.out.println("The code for your transaction is " + code + ". Do not tell it to anyone.");
        Scanner scn = new Scanner(System.in);
        String codeInput = scn.nextLine();
        if(scn.equals(code)){System.out.println("The code is correct");return true;} else {return false;}
}
}
