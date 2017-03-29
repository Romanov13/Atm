package view;

import com.sun.prism.paint.Color;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;

/**
 * Created by samsung on 29.03.2017.
 */
public class MainWindow extends JFrame {

    public MainWindow(){
        super("ATM Simulation");

        JMenuBar menuBar = new JMenuBar();

        JMenu profileMenu = new JMenu("Profile");
        JMenuItem newProfileItem = new JMenuItem("Set Profile");
        profileMenu.add(newProfileItem);

        JMenu accountMenu = new JMenu("Account");
        JMenuItem newAccountItem = new JMenuItem("Create Account");
        accountMenu.add(newAccountItem);

        menuBar.add(profileMenu);
        menuBar.add(accountMenu);

        setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(java.awt.Color.blue);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(java.awt.Color.green);
        leftPanel.setPreferredSize(new Dimension(300, 800));

        Box profileBox = Box.createVerticalBox();

        JButton addButton = new JButton("Add");

        profileBox.add(addButton);


        Box secondBox = Box.createVerticalBox();

        profileBox.add(new JButton("Add2"));

        leftPanel.add(profileBox);

        mainPanel.add(leftPanel, BorderLayout.WEST);

        setContentPane(mainPanel);


        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
