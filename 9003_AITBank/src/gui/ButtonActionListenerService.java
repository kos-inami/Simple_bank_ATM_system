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
public class ButtonActionListenerService implements ActionListener {
    
    public int number;  //the number on the button
    public UiSaving uiS;
    public UiNetSaving uiN;
    public UiCheque uiQ;
    public UiFixed uiF;
    
    public int checkAccout;

    // For UiSaving Class ---------
    public ButtonActionListenerService(int number, UiSaving uiS) {
        this.number = number;
        this.uiS = uiS;
        checkAccout = 1;
    }
    // For UiNetSaving Class ---------
    public ButtonActionListenerService(int number, UiNetSaving uiN) {
        this.number = number;
        this.uiN = uiN;
        checkAccout = 2;
    }
    // For UiCheque Class ---------
    public ButtonActionListenerService(int number, UiCheque uiQ) {
        this.number = number;
        this.uiQ = uiQ;
        checkAccout = 3;
    }
    // For UiFixed Class ---------
    public ButtonActionListenerService(int number, UiFixed uiF) {
        this.number = number;
        this.uiF = uiF;
        checkAccout = 4;
    }

    
    public void actionPerformed(ActionEvent e) {
        if (checkAccout == 1){
            int serviceChosen = number;
            uiS.setServiceChosen(serviceChosen);
            uiS.updateGUI();
        }
        else if (checkAccout == 2){
            int serviceChosen = number;
            uiN.setServiceChosen(serviceChosen);
            uiN.updateGUI();
        }
        else if (checkAccout == 3){
            int serviceChosen = number;
            uiQ.setServiceChosen(serviceChosen);
            uiQ.updateGUI();
        }
        else if (checkAccout == 4){
            int serviceChosen = number;
            uiF.setServiceChosen(serviceChosen);
            uiF.updateGUI();
        }
    }
}
