/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import account.CustomerAccount;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author kosuk
 */
public class UiChooseAccount extends BankUi {

    // Declarations ----------
    JFrame frame;   // a frame
    JTextArea infoPanel; // text area which display the calculation
    
    JPanel btnContainer, panel1, panel2, panel3, panel4, panel5;
    JPanel textArea, actionArea;

    JButton btnSaving, btnNetSaving, btnCheque, btnFixing, btnExit;
    
    private int accountChosen;
    private String info = "Choose the account.";
    
    /**
     * @return the accountChosen
     */
    public int getAccountChosen() {
        return accountChosen;
    }

    /**
     * @param accountChosen the accountChosen to set
     */
    public void setAccountChosen(int accountChosen) {
        this.accountChosen = accountChosen;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }
    
    // UI function for the display the frame design -----------
    public void setUiChooseAccount(){
        
        infoPanel = new JTextArea(getInfo());
        infoPanel.setEditable(false);   // user CANNOT input values
        textArea = new JPanel(new GridLayout(1,1));
        textArea.add(infoPanel);
        
        // set the button then display
        setUpButtons();    // get the setButtons function
        setUpPanel();      // get the setPanel function
        
        actionArea = new JPanel(new GridLayout(1,1));
        actionArea.add(btnContainer);

        setStyleDesign(infoPanel);  // set the style     
    }
    
    // setPanel function for placing each buttons ---------
    private void setUpPanel() {
        btnContainer = new JPanel(new GridLayout(5,1));
        panel1 = new JPanel(new GridLayout(1,1));  // Line 1 : 1 rows, 1 columns
        panel2 = new JPanel(new GridLayout(1,1));  // Line 2 : 1 rows, 1 columns
        panel3 = new JPanel(new GridLayout(1,1));  // Line 3 : 1 rows, 1 columns
        panel4 = new JPanel(new GridLayout(1,1));  // Line 4 : 1 rows, 1 columns
        panel5 = new JPanel(new GridLayout(1,1));  // Line 4 : 1 rows, 1 columns
        
        panel1.add(btnSaving);
        panel2.add(btnNetSaving);
        panel3.add(btnCheque);
        panel4.add(btnFixing);
        panel5.add(btnExit);
        
        btnContainer.add(panel1);
        btnContainer.add(panel2);
        btnContainer.add(panel3);
        btnContainer.add(panel4);
        btnContainer.add(panel5);
    }
    
    // setButtons function for set button methods ---------
    private void setUpButtons() {
        
        btnSaving = new JButton("Saving");
        btnNetSaving = new JButton("Net Saving");
        btnCheque = new JButton("Cheque");
        btnFixing = new JButton("Fixing");
        btnExit = new JButton("Exit");
        
        btnSaving.addActionListener(new ButtonActionListenerAccount(1, this));
        btnNetSaving.addActionListener(new ButtonActionListenerAccount(2, this));
        btnCheque.addActionListener(new ButtonActionListenerAccount(3, this));
        btnFixing.addActionListener(new ButtonActionListenerAccount(4, this));
        
        // Exit --------- 
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }

    CustomerAccount ca = new CustomerAccount();
    double ammoutSaving = ca.getSavingBalance();
    double ammoutNet = ca.getNetBalance();
    double ammoutCheque = ca.getChequeBalance();
    double ammoutFixed = ca.getFixedBalance();
   
        
    // Update GUI -----------
    public void updateGUI() {
        switch (accountChosen) {
            case 1:
                System.out.println("Saving Account");
                textArea.removeAll(); // remove the textArea (JPanel)
                actionArea.removeAll(); // remove the actionArea (JPanel)
                
                UiSaving us = new UiSaving();
                us.sb = ammoutSaving;
                us.nb = ammoutNet;
                us.cb = ammoutCheque;
                us.fb = ammoutFixed;
                us.setUiSaving();

                textArea.add(us.textArea);
                actionArea.add(us.actionArea);

                textArea.revalidate();
                actionArea.revalidate();
                // refresh the area
                textArea.repaint();
                actionArea.repaint();
                break;
            case 2:
                setInfo("NetSaving Account");
                textArea.removeAll(); // remove the textArea (JPanel)
                actionArea.removeAll(); // remove the actionArea (JPanel)

                UiNetSaving uns = new UiNetSaving();
                uns.sb = ammoutSaving;
                uns.nb = ammoutNet;
                uns.cb = ammoutCheque;
                uns.fb = ammoutFixed;
                uns.setUiSaving();
                
                textArea.add(uns.textArea);
                actionArea.add(uns.actionArea);

                textArea.revalidate();
                actionArea.revalidate();
                // refresh the area
                textArea.repaint();
                actionArea.repaint();   
                break;
            case 3:
                setInfo("Cheque Account");
                textArea.removeAll(); // remove the textArea (JPanel)
                actionArea.removeAll(); // remove the actionArea (JPanel)

                UiCheque uc = new UiCheque();
                uc.sb = ammoutSaving;
                uc.nb = ammoutNet;
                uc.cb = ammoutCheque;
                uc.fb = ammoutFixed;
                uc.setUiSaving();
                
                textArea.add(uc.textArea);
                actionArea.add(uc.actionArea);

                textArea.revalidate();
                actionArea.revalidate();
                // refresh the area
                textArea.repaint();
                actionArea.repaint();   
                break;
            case 4:
                setInfo("Fixed Account");
                textArea.removeAll(); // remove the textArea (JPanel)
                actionArea.removeAll(); // remove the actionArea (JPanel)

                UiFixed uf = new UiFixed();
                uf.sb = ammoutSaving;
                uf.nb = ammoutNet;
                uf.cb = ammoutCheque;
                uf.fb = ammoutFixed;
                uf.setUiSaving();
                
                textArea.add(uf.textArea);
                actionArea.add(uf.actionArea);

                textArea.revalidate();
                actionArea.revalidate();
                // refresh the area
                textArea.repaint();
                actionArea.repaint();  
                break;
            default:
                break;
        }
    }
    
}
