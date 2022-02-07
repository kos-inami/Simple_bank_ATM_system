/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import account.CustomerAccount;
import java.awt.BorderLayout;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author kosuk
 */
public class UiLogin extends JFrame {
    
    JTextArea infoPanel;
    
    JPanel namePw;
    JPanel jpLogin;
    JPanel login;
    JPanel actionArea;
    JPanel textArea;
    
    JLabel nameLabel;
    JTextField name;
    JLabel pwLabel;
    JPasswordField pw;
    
    JButton btnLogin;
    JButton btnExit;
    
    private String info = "Welcome to AIT BANK\nLog in";
    private int btnChosen;
    
    String userName;
    String userPw;
    
    
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
    
    /**
     * @return the accountChosen
     */
    public int getBtnChosen() {
        return btnChosen;
    }

    /**
     * @param btnChosen the btnChosen to set
     */
    public void setBtnChosen(int btnChosen) {
        this.btnChosen = btnChosen;
        
        userName = name.getText();
        userPw = pw.getText();
        
        switch (btnChosen) {
            case 1:
                checkIdentify();
                System.out.println("Login");
                break;
            case 2:
//                infoPanel.setText("Thank you for using us.");
                System.out.println("Exit");
                System.exit(0);
                break;
            default:
                System.out.println("default");
                break;
        }
    }
    
    BankUi bu = new BankUi();
    
    public void setUiLogin(){
        
        info = getInfo();
        
        infoPanel = new JTextArea(info);
        infoPanel.setEditable(false);   // user CANNOT input values
        
        setUpBtns();
        setUpBtnsPanel();
        
        textArea = new JPanel(new GridLayout(1,1));
        textArea.add(infoPanel);
        
        actionArea = new JPanel(new GridLayout(1,1));
        actionArea.add(login);
        
    }
    
    private void setUpBtnsPanel() {
        
        nameLabel = new JLabel("Account Name");
        name = new JTextField();
        pwLabel = new JLabel("Password");
        pw = new JPasswordField();
        namePw = new JPanel(new GridLayout(4,1));
        namePw.add(nameLabel);
        namePw.add(name);
        namePw.add(pwLabel);
        namePw.add(pw);
        
        setBtnChosen(btnChosen);
        
        login = new JPanel(new GridLayout(2,1));
        login.add(namePw);
        login.add(jpLogin);
    }
    
    private void setUpBtns() {
        
        jpLogin = new JPanel(new GridLayout(2,1));
        btnLogin = new JButton("Login");
        btnExit = new JButton("Exit");
        jpLogin.add(btnLogin);
        jpLogin.add(btnExit);
        
        btnLogin.addActionListener(new ButtonActionListenerLogin(1, this));
        btnExit.addActionListener(new ButtonActionListenerLogin(2, this));
        
    }
    
    public void checkIdentify() {  
        CustomerAccount ca = new CustomerAccount();
        if (userName == null ? ca.getName() == null : userName.equals(ca.getName()) && userPw == null ? ca.getPw() == null : userPw.equals(ca.getPw())) {
            
            textArea.removeAll(); // remove the actionArea (JPanel)
            actionArea.removeAll(); // remove the actionArea (JPanel)
            
            System.out.println("success!");
            UiChooseAccount uca = new UiChooseAccount();
            uca.setUiChooseAccount();
            
            textArea.add(uca.textArea);
            actionArea.add(uca.actionArea);
            
            textArea.revalidate();
            actionArea.revalidate();
            // refresh the area
            textArea.repaint();
            actionArea.repaint();   
            
            
            infoPanel.setText(uca.getInfo());
        }
        else {
            infoPanel.setText("Name or Password is wrong.\nPlease try again.");
            System.out.println("worng!");
        }
    }
    
}
