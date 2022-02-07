/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kosuk
 */
public class ButtonActionListenerNumber implements ActionListener {
    
    public int number;  //the number on the button
    public UiSaving uiS;
    public UiNetSaving uiN;
    public UiCheque uiQ;
    public UiFixed uiF;
    
    public int checkAccout;

    // For UiSaving Class ---------
    public ButtonActionListenerNumber(int number, UiSaving uiS) {
        this.number = number;
        this.uiS = uiS;
        checkAccout = 1;
    }
    // For UiNetSaving Class ---------
    public ButtonActionListenerNumber(int number, UiNetSaving uiN) {
        this.number = number;
        this.uiN = uiN;
        checkAccout = 2;
    }
    // For UiCheque Class ---------
    public ButtonActionListenerNumber(int number, UiCheque uiQ) {
        this.number = number;
        this.uiQ = uiQ;
        checkAccout = 3;
    }
    // For UiFixed Class ---------
    public ButtonActionListenerNumber(int number, UiFixed uiF) {
        this.number = number;
        this.uiF = uiF;
        checkAccout = 4;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (checkAccout == 1){
            uiS.num += number;
            uiS.updateNumberGUI();
        }
        else if (checkAccout == 2){
            uiN.num += number;
            uiN.updateNumberGUI();
        }
        else if (checkAccout == 3){
            uiQ.num += number;
            uiQ.updateNumberGUI();
        }
        else if (checkAccout == 4){
            uiF.num += number;
            uiF.updateNumberGUI();
        }
       
    }
}
