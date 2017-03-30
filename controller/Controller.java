package controller;

import view.*;
import model.*;

import javax.swing.*;
import java.io.*;
import java.math.BigDecimal;

public class Controller {
    // MVC eleemnts
    Payer currentPayer;
    Bank currentBank;
    InternetShop iShop;
    Atm activeAtm;
    
    public Controller(){
       currentBank = new Bank();
        iShop = new InternetShop("iShop", currentBank);
        activeAtm= new Atm();
 
    }
    
    public  void setProfile(String name, String phone) {
     currentPayer = new Payer(name, phone);   
    }

    public  void setProfile() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(new File("resources\\PayerList.txt")));
            String name = bf.readLine();
            String[] payerName = name.split("/");
            currentPayer = new Payer(payerName[0], payerName[1]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createAccount(){
        currentBank.makeAccount(currentPayer);
        
    }
    
    public void issueCard(){
    Card c = currentBank.issueCard(currentBank.searchAccount(currentPayer));
        currentPayer.addCard(c);
        currentPayer.setPrimeCard(c);
        
    }
    
    
    public String getPayerName() {
        return currentPayer.getName();
    }

    public String getPayerPhone() {
        return currentPayer.getPhone();
    }
    
    public String getAccountNumber(){
        String accNumber = String.valueOf(currentBank.searchAccount(currentPayer).getNumber());
        return accNumber;
     
    }
    
    public String getCardNumber(){
     return currentPayer.getPrimeCard().getNumber();   
    }
    
    public String getCardCvv(){
     return currentPayer.getPrimeCard().getCvv();   
    }
    
    public String getCardDate(){
     return currentPayer.getPrimeCard().getDate();   
    }
    
    public String getHolderName(){
     return currentPayer.getName();   
    }
    
    public String getCardSystem(){
     return currentPayer.getPrimeCard().getSystem();   
    }
}
