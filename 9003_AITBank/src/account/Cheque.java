/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import javax.swing.JOptionPane;

/**
 *
 * @author kosuk
 */
public class Cheque extends BankAccount {
    
    // Declaration for cheque account ----------
    private double chequeBalance;

    /**
     * @return the chequeBalance
     */
    public double getChequeBalance() {
        return chequeBalance;
    }

    /**
     * @param chequeBalance the chequeBalance to set
     */
    public void setChequeBalance(double chequeBalance) {
        this.chequeBalance = chequeBalance;
    }
 
    // =======================================
    // Action calculation for withdraw 
    /**
     * @param chequeWithdrawAction the chequeWithdrawAction to set
     */
    public void setWithdrawAction(double chequeWithdrawAction) {
        if(chequeWithdrawAction < chequeBalance) {
            double checkNote20 = chequeWithdrawAction % 20;
            double checkNote50 = chequeWithdrawAction % 50;
            if (checkNote20 == 0 && chequeWithdrawAction <= chequeBalance) {
                chequeBalance = chequeBalance - chequeWithdrawAction;
                JOptionPane.showMessageDialog(null, "Thank you for withdrawing: " + String.format("%,.2f", chequeWithdrawAction));
            }
            else if(checkNote50 == 0 && chequeWithdrawAction <= chequeBalance){
                chequeBalance = chequeBalance - chequeWithdrawAction;
                JOptionPane.showMessageDialog(null, "Thank you for withdrawing: " + String.format("%,.2f", chequeWithdrawAction));
            }
            else {
                JOptionPane.showMessageDialog(null, "Please enter the correct value. (You can withdraw notes: 20 / 50 / 100)");
             }  
        }
        else {
           JOptionPane.showMessageDialog(null, "You have not enough moeny to withdraw.");
        } 
    }
    
    // =======================================
    // Action calculation for deposit 
    public void setDepositAction(double netDepositAction) {
        chequeBalance = chequeBalance + netDepositAction;
    }
    
    // =======================================
    // Action calculation for transfer 
    public void setTransferAddAction(double transferAddAction) {
        chequeBalance = chequeBalance + transferAddAction;
        JOptionPane.showMessageDialog(null, "Thank you for transfer: " + String.format("%,.2f", transferAddAction));
    }
    public void setTransferSubAction(double transferSubAction) {
        chequeBalance = chequeBalance - transferSubAction;
    }
    
    
    
}
