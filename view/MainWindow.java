package view;

import com.sun.prism.paint.Color;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;

/**
 * Created by samsung on 29.03.2017.
 */
public class MainWindow extends JFrame {

    
    //MVC elements
    Controller cont;
    
    //Labels
    
    // Profile labels
    JLabel nameL;
    JLabel phoneL;
    JLabel accL = new JLabel("");
    
    // Card labels
    JLabel bankCL;
    JLabel cardSystemL;
    JLabel cardNumber1;
    JLabel cardNumber2;
    JLabel cardNumber3;
    JLabel cardNumber4;
    JLabel cvvL;
    JLabel holderNameL;
    JLabel dateL;
    
    // ATM fields
    JButton insertEjectBtn;
    JButton depositBtn;
    JButton withdrawBtn;
    JButton okBtn;
    JLabel atmL;
    JTextField displayFld;
    JTextField atmInputFld;
    
    
    String blank = "Blank";



    
       
   
    public MainWindow(Controller cont){
        super("ATM Simulation");
         this.cont = cont;
        cont.setProfile(blank, blank);
        
        // Setup menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu profileMenu = new JMenu("Profile");
        JMenuItem newProfileItem = new JMenuItem("Set Profile");
        JMenuItem resetProfileItem = new JMenuItem("Reset Profile");
        profileMenu.add(newProfileItem);
        profileMenu.add(resetProfileItem);
        
        
        JMenu accountMenu = new JMenu("Account");
        JMenuItem newAccountItem = new JMenuItem("Create Account");
        JMenuItem issueCardItem = new JMenuItem("Issue a Card");
        accountMenu.add(newAccountItem);
        accountMenu.add(issueCardItem);
        
     

        menuBar.add(profileMenu);
        menuBar.add(accountMenu);

        setJMenuBar(menuBar);
        
        // Set up action listeners for menu
        newProfileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont.setProfile();
                nameL.setText(cont.getPayerName());
                phoneL.setText(cont.getPayerPhone());
            }
        });
        
        resetProfileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 cont.setProfile(blank, blank);
                nameL.setText(cont.getPayerName());
                phoneL.setText(cont.getPayerPhone());
         }
        });
        

        newAccountItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(nameL.getText().equals(blank) && phoneL.getText().equals(blank))) {
                    cont.createAccount();
                    accL.setText("The account No." + cont.getAccountNumber() + " for " + cont.getPayerName() + " has been opened.");
                } else {
                    accL.setText("The account for " + cont.getPayerName() + " cannot be created.");
                }

            }
        });
            
            issueCardItem.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    cont.issueCard();
                                                    setCardNumber(cont.getCardNumber());
                                                    cardSystemL.setText(cont.getCardSystem());
                                                    holderNameL.setText(cont.getPayerName().toUpperCase());
                                                    cvvL.setText(cont.getCardCvv());
                                                    dateL.setText(cont.getCardDate());
                                                }
                                            });
                
            
        
        // Set up background
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(java.awt.Color.blue);
        // mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        // Profile panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(java.awt.Color.green);
        leftPanel.setPreferredSize(new Dimension(245, 750));
        //leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

        Box profileBox = Box.createVerticalBox();
        //profileBox.setPreferredSize(new Dimension(140, 750));
                
        nameL = new JLabel(cont.getPayerName());
        profileBox.add(new JLabel("Name:"));
        profileBox.add(nameL);

        phoneL = new JLabel(cont.getPayerPhone());
        profileBox.add(new JLabel("Phone:"));
        profileBox.add(phoneL);
        profileBox.add(new JLabel("Account:"));
        profileBox.add(accL);
        profileBox.add(Box.createVerticalGlue());
            
      

        leftPanel.add(profileBox);

        // Card panel
        
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        cardPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        cardPanel.setPreferredSize(new Dimension(390, 300));
        bankCL = new JLabel("Bank");
        cardPanel.add(bankCL);
        cardSystemL = new JLabel("");
                       
        JPanel cardNumber = new JPanel(new GridLayout(1, 4)); 
        cardNumber1 = new JLabel("XXXX");
        cardNumber.add(cardNumber1); 
        cardNumber2 = new JLabel("XXXX");
        cardNumber.add(cardNumber2);
        cardNumber3 = new JLabel("XXXX");
        cardNumber.add(cardNumber3);
        cardNumber4 = new JLabel("XXXX");
        cardNumber.add(cardNumber4);
        cardPanel.add(cardNumber);   
               
        dateL = new JLabel("XX/XX");
        cardPanel.add(dateL);
                       
        cvvL = new JLabel("XXX");
        cardPanel.add(cvvL); 
                       
        holderNameL = new JLabel(cont.getPayerName().toUpperCase());
        cardPanel.add(holderNameL);
                       
                       // ATM Panel
                     JPanel atmPanel = new JPanel();
                       atmPanel.setLayout(new BoxLayout(atmPanel, BoxLayout.X_AXIS));
                       atmPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "ATM"));
                       atmPanel.setPreferredSize(new Dimension(390, 350));
                       
                       Box leftAtmPanel = Box.createVerticalBox();
                       insertEjectBtn = new JButton("Insert");
                       depositBtn = new JButton("Deposit");
                       depositBtn.setEnabled(false);
                       
                       leftAtmPanel.add(Box.createRigidArea(new Dimension(0, 3)));
                       leftAtmPanel.add(insertEjectBtn);
                       leftAtmPanel.add(Box.createVerticalGlue());
                       leftAtmPanel.add(depositBtn);
                        leftAtmPanel.add(Box.createRigidArea(new Dimension(0, 3)));
                       
                       JPanel centralAtmPanel = new JPanel(new GridLayout(0, 1));
                       atmL = new JLabel("Insert a card");
                       
                       displayFld = new JTextField(10);
                      displayFld.setEditable(false);
                       
                       atmInputFld = new JTextField(10);
                       
                       
                       centralAtmPanel.add(atmL);
                       centralAtmPanel.add(displayFld);
                       centralAtmPanel.add(atmInputFld);
                     
                       Box rightAtmPanel = Box.createVerticalBox();
                       okBtn = new JButton("OK");
                       withdrawBtn = new JButton("Withdraw");
                        withdrawBtn.setEditable(false);
                       
                       rightAtmPanel.add(Box.createRigidArea(new Dimension(0, 3)));
                       rightAtmPanel.add(okBtn);
                       rightAtmPanel.add(Box.createVerticalGlue());
                       rightAtmPanel.add(withdrawBtn);
                        rightAtmPanel.add(Box.createRigidArea(new Dimension(0, 3)));
                       
                       
                                                   
                       
                       
                       atmPanel.add(leftAtmPanel);
                       atmPanel.add(centralAtmPanel);
                       atmPanel.add(rightAtmPanel);
        
        // Action Listeners for ATM buttons
                       insertEjectBtn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    if(!cont.isCardInserted()){
                                                    insertEjectBtn.setText("Eject");
                                                        cont.insertCard();
                                                        atmL.setText("Enter PIN:");
                                                      
                                                      
                                                    } else {
                                                        insertEjectBtn.setText("Insert");
                                                        cont.ejectCard();
                                                        depositBtn.setEnabled(false);
                                                        withdrawBtn.setEditable(false);
                                                    }
                                                }
                           
                           okBtn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                      String pin = atmInputFld.getText();
                                                        while(!cont.checkPin(pin)){
                                                            atmL.setText("Sorry, the PIN is incorrect.");}
                                                        displayFld.setText(cont.getAtmBalance());
                                                         depositBtn.setEnabled(true);
                                                        withdrawBtn.setEditable(true);
                                                }
                           }
                                                   JFrame thisFrame = this;
                                                   depositBtn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                   try{ cont.withdraw(atmInputFld.getText());
                                                       displayFld.setText(cont.getAtmBalance());
                                                      }
                                                    catch (OverdraftException o){
                                                       JOptionPane.showMessageDialog(thisFrame, "Not enough money");
                                                    }
                                                    
                                                    depositBtn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    cont.deposit(atmInputFld.getText());
                                                    displayFld.setText(cont.getAtmBalance());
                                                }
                                                    
                     
                       
                      
        
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(395, 750));
        centerPanel.add(cardPanel);
                       centerPanel.add(atmPanel);
                                                        
                                                        // Internet Shop panel
                                                        
                                                        JPanel firstItem = new JPanel();
                                                        firstItem.setBorder(BorderFactory.createLineBorder(Color.black));
                                                        JPanel firstItemCost = new JPanel(new GridLayout(1, 2));
                                                        int fic = 100;
                                                        firstItemCost.add(new JLabel("Price: "));
                                                        JButton ficBtn = new JButton ("$" + String.ValueOf(fic);
                                                                 ficBtnaddActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    
                                                    
                                                }
                                                        firstItemCost.add(ficBtn);
                                                        firstItem.add(new JLabel("Random Quartz Military Men Watch"));
                                                        ImageIcon image = new ImageIcon("watch.jpg");
                                                        firstItem.add(new JLabel("", image, JLabel.CENTER));
                                                         firstItem.add(firstItemCost);
                                                                          
                                                                          
                                                         
                                                        

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(245, 750));
        rightPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "iShop"));
            rightPanel.add(firstItem);                                            
                       
        mainPanel.add(Box.createRigidArea(new Dimension(3, 0)));
        mainPanel.add(leftPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(rightPanel);




        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPanel);
        setVisible(true);
    }
                       
                       public void setCardNumber(String cardNumber){
                       String[] fullNumber = cardNumber.split(" ");
                           cardNumber3.setText(fullNumber[0]);
                                               cardNumber4.setText(fullNumber[1]);
                       }
}
