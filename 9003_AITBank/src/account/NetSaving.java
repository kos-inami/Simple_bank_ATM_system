/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author kosuk
 */
public class NetSaving extends BankAccount {
    
    // Declaration for net account ----------
    private double netBalance;
    private double netTotalBalance;
    private double netInterestRate = 0.25;
    private double netInterest;
    private final double netWithdrawalLimit = 2000;

    /**
     * @return the netBalance
     */
    public double getNetBalance() {
        return netBalance;
    }

    /**
     * @param netBalance the netBalance to set
     */
    public void setNetBalance(double netBalance) {
        this.netBalance = netBalance;
    }

    /**
     * @return the netTotalBalance
     */
    public double getNetTotalBalance() {
        return netTotalBalance;
    }

    /**
     * @param netTotalBalance the netTotalBalance to set
     */
    public void setNetTotalBalance(double netTotalBalance) {
        this.netTotalBalance = netTotalBalance;
    }

    /**
     * @return the netInterestRate
     */
    public double getNetInterestRate() {
        return netInterestRate;
    }

    /**
     * @param netInterestRate the netInterestRate to set
     */
    public void setNetInterestRate(double netInterestRate) {
        this.netInterestRate = netInterestRate;
    }

    /**
     * @return the netIntrest
     */
    public double getNetInterest() {
        return netInterest;
    }

    /**
     * @param netInterest the netIntrest to set
     */
    public void setNetInterest(double netInterest) {
        this.netInterest = netInterest;
    }
    
    /**
     * @return the netWithdrawalLimit
     */
    public double getNetWithdrawalLimit() {
        return netWithdrawalLimit;
    }

    // Declaration: the commnet for a interest
    String interestComment;
    
    // =======================================
    // Calculation for mothly interest
    public void calculateInterestMonthly(int today){
        Calendar cal = Calendar.getInstance();          // create a calendar object
        int res = cal.getActualMaximum(Calendar.DATE);  // get the last day of the month.
        // System.out.println("Last Date of the current month = " + res);
        if (today == res) {
            netInterest = netBalance*(netInterestRate/100);
            netTotalBalance = netBalance + netInterest;
            interestComment = "$" + String.format("%,.2f", netInterest);
        }
        else {
            this.netTotalBalance = netBalance;
            interestComment = "Pleas wait until end of month.";
        }
    }
    
    // =======================================
    // Action calculation for withdraw 
    /**
     * @param netWithdrawAction the netWithdrawAction to set
     */
    public void setWithdrawAction(double netWithdrawAction) {
        if (netWithdrawAction < getNetWithdrawalLimit()) {
            if(netWithdrawAction < netTotalBalance) {
                double checkNote20 = netWithdrawAction % 20;
                double checkNote50 = netWithdrawAction % 50;
                if (checkNote20 == 0 && netWithdrawAction <= netTotalBalance && netWithdrawAction <= getNetWithdrawalLimit()) {
                    netTotalBalance = netTotalBalance - netWithdrawAction;
                    JOptionPane.showMessageDialog(null, "Thank you for withdrawing: " + String.format("%,.2f", netWithdrawAction));
                }
                else if(checkNote50 == 0 && netWithdrawAction <= netTotalBalance && netWithdrawAction <= getNetWithdrawalLimit()){
                    netTotalBalance = netTotalBalance - netWithdrawAction;
                    JOptionPane.showMessageDialog(null, "Thank you for withdrawing: " + String.format("%,.2f", netWithdrawAction));
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
    public void setDepositAction(double netDepositAction) {
        netTotalBalance = netTotalBalance + netDepositAction;
    }
    
    // =======================================
    // Action calculation for transfer 
    public void setTransferAddAction(double transferAddAction) {
        netTotalBalance = netTotalBalance + transferAddAction;
        JOptionPane.showMessageDialog(null, "Thank you for transfer: " + String.format("%,.2f", transferAddAction));
    }
    public void setTransferSubAction(double transferSubAction) {
        netTotalBalance = netTotalBalance - transferSubAction;
    }
            
    
}
