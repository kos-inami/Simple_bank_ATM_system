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
public class Fixed extends BankAccount {

    // Declaration for fixed account ----------
    private double fixedBalance;
    private double fixedInterestRate = 1.25;
    private double fixedInterest;
    private double contractPeriodDate;

    /**
     * @return the fixedBalance
     */
    public double getFixedBalance() {
        return fixedBalance;
    }

    /**
     * @param fixedBalance the fixedBalance to set
     */
    public void setFixedBalance(double fixedBalance) {
        this.fixedBalance = fixedBalance;
    }

    /**
     * @return the fixedInterestRate
     */
    public double getFixedInterestRate() {
        return fixedInterestRate;
    }

    /**
     * @param fixedInterestRate the fixedInterestRate to set
     */
    public void setFixedInterestRate(double fixedInterestRate) {
        this.fixedInterestRate = fixedInterestRate;
    }

    /**
     * @return the fixedInterest
     */
    public double getFixedInterest() {
        return fixedInterest;
    }

    /**
     * @param fixedInterest the fixedInterest to set
     */
    public void setFixedInterest(double fixedInterest) {
        this.fixedInterest = fixedInterest;
    }

    /**
     * @return the contractPeriodDate
     */
    public double getContractPeriodDate() {
        return contractPeriodDate;
    }
   
    // Declaration
    double currentDate;
    boolean fcdate = false;
    
    /**
     * @param contractPeriodDate the contractPeriodDate to set
     */
    public void setContractPeriodDate(double contractPeriodDate) {
        this.contractPeriodDate = contractPeriodDate;
        currentDate = 20211020;                             // Current date
        if (currentDate <= contractPeriodDate)              // Check the date
            fcdate = true;
    }
    
 
    // =======================================
    // Action calculation for withdraw 
    /**
     * @param fixedWithdrawAction the fixedWithdrawAction to set
     */
    public void setWithdrawAction(double fixedWithdrawAction) { 
    
        if (fcdate == true) {
            fixedInterest = fixedBalance*(fixedInterestRate/100);
            fixedBalance = fixedBalance + fixedInterest;
            
            if(fixedWithdrawAction < fixedBalance) {
                double checkNote20 = fixedWithdrawAction % 20;
                double checkNote50 = fixedWithdrawAction % 50;
                if (checkNote20 == 0 && fixedWithdrawAction <= fixedBalance) {
                    fixedBalance = fixedBalance - fixedWithdrawAction;
                    JOptionPane.showMessageDialog(null, "Thank you for withdrawing: " + String.format("%,.2f", fixedWithdrawAction) + "\nThe interest is " + fixedInterest);
                }
                else if(checkNote50 == 0 && fixedWithdrawAction <= fixedBalance){
                    fixedBalance = fixedBalance - fixedWithdrawAction;
                    JOptionPane.showMessageDialog(null, "Thank you for withdrawing: " + String.format("%,.2f", fixedWithdrawAction) + "\nThe interest is " + fixedInterest);
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
            fixedBalance = fixedBalance - fixedWithdrawAction;
            JOptionPane.showMessageDialog(null, "You withdrawed earlier than contract date.\n" + "Thank you for withdrawing: " + String.format("%,.2f", fixedWithdrawAction));
        }
    }
    
    // =======================================
    // Action calculation for deposit 
    public void setDepositAction(double netDepositAction) {
        fixedBalance = fixedBalance + netDepositAction;
    }
    
    // =======================================
    // Action calculation for transfer 
    public void setTransferAddAction(double transferAddAction) {
        fixedBalance = fixedBalance + transferAddAction;
        JOptionPane.showMessageDialog(null, "Thank you for transfer: " + String.format("%,.2f", transferAddAction));
    }
    public void setTransferSubAction(double transferSubAction) {
        fixedBalance = fixedBalance - transferSubAction;
    }
    

}
