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
    JLabel nameL;
    JLabel phoneL;
    JLabel accL = new JLabel("");
    
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
        
        resetProfileItem
        
        

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
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));


        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(java.awt.Color.green);
        leftPanel.setPreferredSize(new Dimension(250, 750));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

        Box profileBox = Box.createVerticalBox();
        profileBox.setPreferredSize(new Dimension(250, 750));

        JButton addButton = new JButton("Add");
                
        nameL.setText(cont.getPayerName());
        profileBox.add(nameL);


        Box secondBox = Box.createVerticalBox();

        phoneL.setText(cont.getPayerPhone());
        profileBox.add(phoneL);

        leftPanel.add(profileBox);

        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(250, 750));

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(250, 750));
        mainPanel.add(Box.createRigidArea(new Dimension(3, 0)));
        mainPanel.add(leftPanel);
//        mainPanel.add(centerPanel);
//        mainPanel.add(rightPanel);

        setContentPane(mainPanel);


        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
