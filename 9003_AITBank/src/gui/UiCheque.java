/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import account.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author kosuk
 */
public class UiCheque extends BankUi {
    
    // Declarations ----------
    JFrame frame;   // a frame
    JTextArea infoPanel; // text area which display the calculation
    
    JPanel btnContainer, panel1, panel2, panel3, panel4, panel5;
    JPanel textArea, actionArea;

    JButton btnWithdraw, btnDeposite, btnTransfer, btnBalance, btnCancel;
    
    private String info = "What would like to do?";
    private int serviceChosen;
    
    /** ===================
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
    
    /** ===================
     * @return the accountChosen
     */
    public int getServiceChosen() {
        return serviceChosen;
    }

    /**
     * @param serviceChosen the serviceChosen to set
     */
    public void setServiceChosen(int serviceChosen) {
        this.serviceChosen = serviceChosen;
    }   

    // Declare the value for the set the ammount of each account balance
    double sb, nb, cb, fb;
    
    // display the panels ----------
    public void setUiSaving() {
        
        // Set the saving total balance
        s.setSavingBalance(sb);
        n.setNetBalance(nb);
        c.setChequeBalance(cb);
        f.setFixedBalance(fb);
        
        // Set a date
        n.calculateInterestMonthly(date);

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
        panel5 = new JPanel(new GridLayout(1,1));  // Line 5 : 1 rows, 1 columns
        
        panel1.add(btnWithdraw);
        panel2.add(btnDeposite);
        panel3.add(btnTransfer);
        panel4.add(btnBalance);
        panel5.add(btnCancel);
        
        btnContainer.add(panel1);
        btnContainer.add(panel2);
        btnContainer.add(panel3);
        btnContainer.add(panel4);
        btnContainer.add(panel5);
    }
    
    // setButtons function for set button methods ---------
    private void setUpButtons() {
        
        btnWithdraw = new JButton("Withdraw");
        btnDeposite = new JButton("Deposite");
        btnTransfer = new JButton("Transfer");
        btnBalance = new JButton("Balance Details");
        btnCancel = new JButton("Cancel");
        
        btnWithdraw.addActionListener(new ButtonActionListenerService(1, this));
        btnDeposite.addActionListener(new ButtonActionListenerService(2, this));
        btnTransfer.addActionListener(new ButtonActionListenerService(3, this));
        btnBalance.addActionListener(new ButtonActionListenerService(4, this));
        btnCancel.addActionListener(new ButtonActionListenerService(5, this));
        
    }
    
    // Update GUI -----------
    public void updateGUI() {
        switch (serviceChosen) {
            case 1:
                num = "";
                System.out.println("gui - withdraw");
                infoPanel.setText("How much do you want to withdraw?");
                actionArea.removeAll(); // remove the actionArea (JPanel)
                setNumberButtons();
                setNumberPanel();
                actionArea.add(btnNumContainer);               
                System.out.println("success!");
                actionArea.revalidate();
                actionArea.repaint();   
                
                break;
            case 2:
                System.out.println("gui - deposite");
                num = "";
                infoPanel.setText("How much do you want to deposit?");
                actionArea.removeAll(); // remove the actionArea (JPanel)
                setNumberButtons(); // get button number and action
                setNumberPanel();   // get button panel
                actionArea.add(btnNumContainer);    // button into the actionArea panel
                actionArea.revalidate();
                actionArea.repaint();   // reflesh the panel
                break;
            case 3:
                System.out.println("gui - transfer");
                infoPanel.setText("How much do you want to transfer?");
                actionArea.removeAll(); // remove the actionArea (JPanel)
                setNumberButtons(); // get button number and action
                setNumberPanel();   // get button panel
                actionArea.add(btnNumContainer);    // button into the actionArea panel
                actionArea.revalidate();
                actionArea.repaint();   // reflesh the panel
                break;
            case 4:
                System.out.println("gui - Balance Details");
                showDetails();
                break;
            case 5:
                System.out.println("gui - Cancel");
                textArea.removeAll(); // remove the actionArea (JPanel)
                actionArea.removeAll(); // remove the actionArea (JPanel)

                UiChooseAccount uca = new UiChooseAccount();
                uca.ammoutSaving = s.getSavingTotalBalance() - s.getSavingInterest();   // get a Saving current balance and interest to set the balance
                uca.ammoutNet = n.getNetTotalBalance() - n.getNetInterest();             // get a Net current balance and interest to set the balance
                uca.ammoutCheque = c.getChequeBalance();                                // get a Cheque current balance
                uca.ammoutFixed =f.getFixedBalance()- f.getFixedInterest();             // get a Fixed current balance and interest to set the balance
                uca.setUiChooseAccount();

                textArea.add(uca.textArea);
                actionArea.add(uca.actionArea);

                textArea.revalidate();
                actionArea.revalidate();
                // refresh the area
                textArea.repaint();
                actionArea.repaint();
                break;
            default:
                System.out.println("default");
                break;
        }
    }
    
    public void showDetails() {
        String acFName = c.getFirstName();  //  get user first name
        String acLName = c.getLastName();   //  get user last name
        String acNum = Integer.toString(c.getAccountNumber());  // get an account number

        // set saving balance and get total balance
        Double balTotal = c.getChequeBalance();
        String sBalTotal = String.format("%.2f", balTotal);

        String regDate = ca.getRegCheque();   // get a registration date

        infoPanel.setText(
            "Account Name: " + acFName + " " + acLName + "\n" +
            "Account Number: " + acNum + "\n" +
            "Total Balance: " + sBalTotal + "\n" +
            "Registration Date: " + regDate
        );
    }
    
    // Declarations for number buttons ---------- 
    JPanel btnNumContainer;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDec, btnClr, btnEtr, btnCan;
    String num = "";
    double dAmountNum;
    
    // setPanel function for placing each buttons ---------
    private void setNumberPanel() {
        btnNumContainer = new JPanel(new GridLayout(5,3));
        
        panel1 = new JPanel(new GridLayout(1,3));  // Line 1 : 1 rows, 3 columns
        panel2 = new JPanel(new GridLayout(1,3));  // Line 2 : 1 rows, 3 columns
        panel3 = new JPanel(new GridLayout(1,3));  // Line 3 : 1 rows, 3 columns
        panel4 = new JPanel(new GridLayout(1,3));  // Line 4 : 1 rows, 3 columns
        panel5 = new JPanel(new GridLayout(1,2));  // Line 5 : 1 rows, 2 columns
        
        panel1.add(btn1);
        panel1.add(btn2);
        panel1.add(btn3);
        
        panel2.add(btn4);
        panel2.add(btn5);
        panel2.add(btn6);
        
        panel3.add(btn7);
        panel3.add(btn8);
        panel3.add(btn9);
        
        panel4.add(btn0);
        panel4.add(btnDec);
        panel4.add(btnClr);
        
        panel5.add(btnCan);
        panel5.add(btnEtr);
        
        btnNumContainer.add(panel1);
        btnNumContainer.add(panel2);
        btnNumContainer.add(panel3);
        btnNumContainer.add(panel4);
        btnNumContainer.add(panel5);
        
    }
    
    // setButtons function for set button methods ---------
    private void setNumberButtons() {
        
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btn0 = new JButton("0");
        btnDec = new JButton(".");
        btnClr = new JButton("Clear");
        btnCan = new JButton("Cancel");
        btnEtr = new JButton("Enter");
        
        btn1.addActionListener(new ButtonActionListenerNumber(1, this));
        btn2.addActionListener(new ButtonActionListenerNumber(2, this));
        btn3.addActionListener(new ButtonActionListenerNumber(3, this));
        btn4.addActionListener(new ButtonActionListenerNumber(4, this));
        btn5.addActionListener(new ButtonActionListenerNumber(5, this));
        btn6.addActionListener(new ButtonActionListenerNumber(6, this));
        btn7.addActionListener(new ButtonActionListenerNumber(7, this));
        btn8.addActionListener(new ButtonActionListenerNumber(8, this));
        btn9.addActionListener(new ButtonActionListenerNumber(9, this));
        btn0.addActionListener(new ButtonActionListenerNumber(0, this));
        

        // Decimal --------- 
        btnDec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num += ".";
                updateNumberGUI();
            }
        });
        
        // Clear all --------- 
        btnClr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = "";
                updateNumberGUI();
            }
        });
        
        // Enter --------- 
        btnEtr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dAmountNum = Double.parseDouble(num);
                
                switch (serviceChosen) {
                    case 1:
                        c.setWithdrawAction(dAmountNum);
                        System.out.println("withdraw action!");
                        continueAction();
                        break;
                    case 2:
                        c.setDepositAction(dAmountNum);
                        System.out.println("deposit action!");
                        continueAction();
                        break;
                    case 3:
                        actionArea.removeAll(); // remove the actionArea (JPanel)
                        setTransferButtons();    // get the setButtons function
                        setTransferPanel();      // get the setPanel function
                        actionArea.add(btnTransferContainer);
                        actionArea.revalidate();
                        actionArea.repaint();
                        System.out.println("transfer action!");
                        break;
                    default:
                        break;
                }
            }
        });
        
        // Cancel ----------
        btnCan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                continueAction();                
                System.out.println("Cancel - success!");

            }
        });
        
    }
    
    public void continueAction(){
        infoPanel.setText("What do you want to do?");

        actionArea.removeAll(); // remove the actionArea (JPanel)

        setUpButtons();    // get the setButtons function
        setUpPanel();      // get the setPanel function

        actionArea.add(btnContainer);

        actionArea.revalidate();
        actionArea.repaint();   

        System.out.println("continue - success!");
    }
    
    // Declarations for buttons of transfer selection ---------- 
    JPanel btnTransferContainer;
    JButton btnT1, btnT2, btnT3;
    
    // setPanel function for placing each buttons ---------
    private void setTransferPanel() {
        btnTransferContainer = new JPanel(new GridLayout(3,1));
        
        panel1 = new JPanel(new GridLayout(1,1));  // Line 1 : 1 rows, 1 columns
        panel2 = new JPanel(new GridLayout(1,1));  // Line 2 : 1 rows, 1 columns
        panel3 = new JPanel(new GridLayout(1,1));  // Line 3 : 1 rows, 1 columns
        
        panel1.add(btnT1);
        panel2.add(btnT2);
        panel3.add(btnT3);
        
        btnTransferContainer.add(panel1);
        btnTransferContainer.add(panel2);
        btnTransferContainer.add(panel3);
        
    }
    
    // setButtons function for set button methods ---------
    private void setTransferButtons() {
        btnT1 = new JButton("Saving");
        btnT2 = new JButton("Net Saving");
        btnT3 = new JButton("Fixed");
        
        // Transfer to saveing --------- 
        btnT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.setTransferAddAction(dAmountNum);
                c.setTransferSubAction(dAmountNum);
                continueAction();
            }
        });
        
        // Transfer to net saving --------- 
        btnT2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n.setTransferAddAction(dAmountNum);
                c.setTransferSubAction(dAmountNum);
                continueAction();
            }
        });
                
        // Transfer to fixed --------- 
        btnT3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setTransferAddAction(dAmountNum);
                c.setTransferSubAction(dAmountNum);
                continueAction();
            }
        });
        
    }

    
    // Update Infopanel with number -----------
    public void updateNumberGUI() {
        String output = num;
        //if statement gone, deleted
        infoPanel.setText(output);
    }

}
