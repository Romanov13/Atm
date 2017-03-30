package view;

import com.sun.prism.paint.Color;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import oracle.jrockit.jfr.JFR;

import javax.swing.*;
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
    JLabel cardNumber1;
    JLabel cardNumber2;
    JLabel cardNumber3;
    JLabel cardNumber4;
    JLabel cvvL;
    JLabel holderNameL;
    JLabel dateL;
    
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
        
        accountMenu.add(newAccountItem);

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
        

        newAccountItem.addActionListener(new ActionPerformed(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(!(nameL.getText().equals(blank) && phoneL.getText().equals(blank))){
                cont.createAccount();
                accL.setText("The account No." + cont.getAccountNumber() + " for " + cont.getPayerName() + " has been opened.");
                } else {
                    accL.setText("The account for " + cont.getPayerName() + " cannot be created.");
                }
                
        });
            
        
        // Set up background
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(java.awt.Color.blue);
        // mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        // Profile panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(java.awt.Color.green);
        leftPanel.setPreferredSize(new Dimension(145, 750));
        //leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

        Box profileBox = Box.createVerticalBox();
        profileBox.setPreferredSize(new Dimension(140, 750));
                
        nameL.setText(cont.getPayerName());
        profileBox.add(new JLabel("Name:");
        profileBox.add(nameL);

        phoneL.setText(cont.getPayerPhone());
        profileBox.add(new JLabel("Phone:");
        profileBox.add(phoneL);
        profileBox.add("Account:");
        profileBox.add(accL);
        profileBox.add(Box.createVerticalGlue();
            
      

        leftPanel.add(profileBox);

        // Card panel
        
        JPanel cardPanel = new JPanel();
        cardPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        cardPanel.setPreferredSize(new Dimention(290, 350));
        bankCL = "Bank";
        cardPanel.add(bankCL);
                       
        JPanel cardNumber = new JPanel(new GridLayout(1, 4)); 
        cardNumber1 = "XXXX";
        cardNumber.add(cardNumber1); 
        cardNumber2 = "XXXX";
        cardNumber.add(cardNumber2);
        cardNumber3 = "XXXX";
        cardNumber.add(cardNumber3);
        cardNumber3 = "XXXX";
        cardNumber.add(cardNumber3);
        cardPanel.add(cardNumber);   
               
        dateL = "XX/XX";
        cardPanel.add(dateL);
                       
        cvvL = "XXX";
        cardPanel.add(cvvL); 
                       
        cardHolderName.setText(cont.getPayerName().toUpperCase());
        cardPanel.add(cardHolderName);
                       
                      
        
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(300, 750));
        centerPanel.add(cardPanel);

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(145, 750));
                       
        mainPanel.add(Box.createRigidArea(new Dimension(3, 0)));
        mainPanel.add(leftPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(rightPanel);

        setContentPane(mainPanel);


        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
