package controller;

import view.*;
import model.*;

import javax.swing.*;
import java.io.*;
import java.math.BigDecimal;

public class Controller {

    Payer payer;

    public  void setProfile() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(new File("resources\\PayerList.txt")));
            String name = bf.readLine();
            String[] payerName = name.split("/");
            payer = new Payer(payerName[0], payerName[1]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPayerName() {
        return payer.getName();
    }

    public String getPayerPhone() {
        return payer.getPhone();
    }
}
