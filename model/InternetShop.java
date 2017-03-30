package model;

import model.*;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class InternetShop{

String name;
Bank bank;

public InternetShop(String name, Bank bank){
this.name = name;
this.bank = bank;
}

public void buyItem(){
BigDecimal price = BigDecimal.valueOf(150);
System.out.println("To buy an item for $150, please enter the card number, the date of expiery and CVV.");
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
            BigDecimal balance = null;

                balance = cardToWithdraw.getBalance();

            balance = balance.subtract(price);
            try {
                cardToWithdraw.setBalance(balance);
            } catch (OverdraftException e) {
                e.printStackTrace();
            }
        } else { System.out.println("Sorry, the code is incrrect");}

} else {System.out.println("Invalid card");}
}



    public boolean verify(String numberInput, String dateInput, String cvvInput){

    Card cardToCheck = bank.searchCard(numberInput);
    if(!(cardToCheck ==null)) {
        if (cardToCheck.getDate().equals(dateInput) && cardToCheck.getCvv().equals(cvvInput)) {
            return true;
        } else {
            return false;
        }
    } else {return false;}

}

public boolean smsSecure(Card card){
        System.out.println("SMS have been sent to your number " + card.getOwner().getPhone() + ". Please enter the code.");
        Random r = new Random();
        StringBuilder code = new StringBuilder(4);
        for(int i = 0; i < code.capacity(); i++){
            int c = r.nextInt(10);
            code.append(c);
        }
        System.out.println("The code for your transaction is " + code + ". Do not tell it to anyone.");
        Scanner scn = new Scanner(System.in);
        String codeInput = scn.nextLine();
        if(codeInput.equals(code.toString())){System.out.println("The code is correct");return true;} else {return false;}
}
}




















