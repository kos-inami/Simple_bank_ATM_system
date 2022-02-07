/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

/**
 *
 * @author kosuk
 */
public class CustomerAccount {
    
    private String name = "kosuke";
    private String pw = "173";
    private double savingBalance = 1000.00, netBalance = 2000.00, chequeBalance = 3000.00, fixedBalance = 4000.00;
    private String regSaving = "2021-01-01", regNet = "2021-02-02", regCheque = "2021-03-03", regFixed = "2021-04-04";
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pw
     */
    public String getPw() {
        return pw;
    }

    /**
     * @param pw the pw to set
     */
    public void setPw(String pw) {
        this.pw = pw;
    }
    
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
    }

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
     * @return the regSaving
     */
    public String getRegSaving() {
        return regSaving;
    }

    /**
     * @param regSaving the regSaving to set
     */
    public void setRegSaving(String regSaving) {
        this.regSaving = regSaving;
    }

    /**
     * @return the regNet
     */
    public String getRegNet() {
        return regNet;
    }

    /**
     * @param regNet the regNet to set
     */
    public void setRegNet(String regNet) {
        this.regNet = regNet;
    }

    /**
     * @return the regCheque
     */
    public String getRegCheque() {
        return regCheque;
    }

    /**
     * @param regCheque the regCheque to set
     */
    public void setRegCheque(String regCheque) {
        this.regCheque = regCheque;
    }

    /**
     * @return the regFixed
     */
    public String getRegFixed() {
        return regFixed;
    }

    /**
     * @param regFixed the regFixed to set
     */
    public void setRegFixed(String regFixed) {
        this.regFixed = regFixed;
    }
    
}
