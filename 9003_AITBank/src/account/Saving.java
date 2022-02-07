/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import gui.*;

import javax.swing.JOptionPane;

/**
 *
 * @author kosuk
 */
public class Saving extends BankAccount {

    // Declaration for saving account ----------
    private double savingBalance;
    private double savingTotalBalance;
    private double savingInterestRate = 0.005;
    private double savingInterest;
    private double savingWithdrawalLimit = 500;
    private double savingCountDailyWithdraw;

    /**
     * @return the savingBalance
     */
    public double getSavingBalance() {
        return savingBalance;
    }

    /**
     * @param savingBalance the savingBalance to set
     */
    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
        savingInterest = savingBalance*(savingInterestRate/100);
        savingTotalBalance = savingBalance + savingInterest;
    }
    
    /**
     * @return the savingTotalBalance
     */
    public double getSavingTotalBalance() {
        return savingTotalBalance;
    }

    /**
     * @param savingTotalBalance the savingTotalBalance to set
     */
    public void setSavingTotalBalance(double savingTotalBalance) {
        this.savingTotalBalance = savingTotalBalance;
    }
    
    /**
     * @return the savingIntrest
     */
    public double getSavingInterest() {
        return savingInterest;
    }

    /**
     * @param savingInterest the savingInterest to set 
     */
    public void setSavingIntrest(double savingInterest) {
        this.savingInterest = savingInterest;
    }
    
    /**
     * @return the savingInterestRate
     */
    public double getSavingInterestRate() {
        return savingInterestRate;
    }
    
    /**
     * @param savingInterestRate the savingInterestRate to set
     */
    public void setSavingInterestRate(double savingInterestRate) {
        this.savingInterestRate = savingInterestRate;
    }

    /**
     * @return the savingWithdrawalLimit
     */
    public double getSavingWithdrawalLimit() {
        return savingWithdrawalLimit;
    }

    /**
     * @param savingWithdrawalLimit the savingWithdrawalLimit to set
     */
    public void setSavingWithdrawalLimit(double savingWithdrawalLimit) {
        this.savingWithdrawalLimit = savingWithdrawalLimit;
    }
    
    /**
     * @return the savingCountDailyWithdraw
     */
    public double getSavingCountDailyWithdraw() {
        return savingCountDailyWithdraw;
    }

    /**
     * @param savingCountDailyWithdraw the savingCountDailyWithdraw to set
     */
    public void setSavingCountDailyWithdraw(double savingCountDailyWithdraw) {
        this.savingCountDailyWithdraw = savingCountDailyWithdraw;
    }
    

    // =======================================
    // Action calculation for withdraw 
    /**
     * @param savingWithdrawAction the savingWithdrawAction to set
     */

    public void setWithdrawAction(double savingWithdrawAction) {
        
        boolean checkLimit = false;
        if (savingCountDailyWithdraw + savingWithdrawAction < savingWithdrawalLimit){
            checkLimit = true;
        }
        if (checkLimit == true && savingWithdrawAction < savingWithdrawalLimit) {
            if(savingWithdrawAction < savingTotalBalance) {
                double checkNote20 = savingWithdrawAction % 20;
                double checkNote50 = savingWithdrawAction % 50;
                if (checkNote20 == 0 && savingWithdrawAction <= savingTotalBalance && savingWithdrawAction <= savingWithdrawalLimit) {
                    savingTotalBalance = savingTotalBalance - savingWithdrawAction;
                    JOptionPane.showMessageDialog(null, "Thank you for withdrawing: " + String.format("%,.2f", savingWithdrawAction));
                    setSavingCountDailyWithdraw(savingCountDailyWithdraw + savingWithdrawAction);
                }
                else if(checkNote50 == 0 && savingWithdrawAction <= savingTotalBalance && savingWithdrawAction <= savingWithdrawalLimit){
                    savingTotalBalance = savingTotalBalance - savingWithdrawAction;
                    JOptionPane.showMessageDialog(null, "Thank you for withdrawing: " + String.format("%,.2f", savingWithdrawAction));
                    setSavingCountDailyWithdraw(savingCountDailyWithdraw + savingWithdrawAction);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter the correct value. (You can withdraw notes: 20 / 50 / 100)");
                 }  
            }
            else {
               JOptionPane.showMessageDialog(null, "You have not enough moeny to withdraw.");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Limit the daily withdraw.");
        }
    }
    
    // =======================================
    // Action calculation for deposit 
    public void setDepositAction(double savingDepositAction) {
        savingTotalBalance = savingTotalBalance + savingDepositAction;
    }
    
    // =======================================
    // Action calculation for transfer 
    public void setTransferAddAction(double transferAddAction) {
        savingTotalBalance = savingTotalBalance + transferAddAction;
        JOptionPane.showMessageDialog(null, "Thank you for transfer: " + String.format("%,.2f", transferAddAction));
    }
    public void setTransferSubAction(double transferSubAction) {
        savingTotalBalance = savingTotalBalance - transferSubAction;
    }
    
    
}
