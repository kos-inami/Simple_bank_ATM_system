/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import account.*;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author kosuk
 */
public class BankUi extends JFrame {
    
    JFrame uiFrame;
    
    JTextArea infoPanel;
    private String title = "AIT BANK";
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    // Set the account classes
    Saving s = new Saving();
    NetSaving n = new NetSaving();
    Cheque c = new Cheque();
    Fixed f = new Fixed();
    CustomerAccount ca = new CustomerAccount();
    
    // Set the date
    int date = 31;
        
    public void setBankUi(){
        
        uiFrame = new JFrame(title);
        uiFrame.setSize(800, 600);
            
        // Login ---------
        UiLogin ul = new UiLogin();
        ul.setUiLogin();
        infoPanel = ul.infoPanel;
        setStyleDesign(infoPanel);
        
        // set the textArea and actionArea panels into the JFrame ---------
        uiFrame.add(ul.textArea, BorderLayout.NORTH);
        uiFrame.add(ul.actionArea, BorderLayout.CENTER);
     
            
        // Set Frame attributes ----------
        uiFrame.setLayout(new GridLayout(2,1));
        uiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // when closing window program is also end it
        uiFrame.setVisible(true); // show the Frame
    }
    
    // Set JTextArea font and color. ----------
    public void setStyleDesign(JTextArea infoPanel) {
        Font font = new Font("Arai", Font.BOLD, 18);
        infoPanel.setFont(font);
        infoPanel.setBackground(Color.BLACK);
        infoPanel.setForeground(Color.WHITE);
    }
    
    
}
