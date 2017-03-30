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
        iShop = new InternetShop();
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
    public String getPayerName() {
        return payer.getName();
    }

    public String getPayerPhone() {
        return payer.getPhone();
    }
    
    public String getAccountNumber(){
        String accNumber = currentBank.searchAccount(payer).getNumber();
        return accNumber;
     
    }
}
