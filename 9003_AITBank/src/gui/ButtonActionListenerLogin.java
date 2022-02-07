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
public class ButtonActionListenerLogin implements ActionListener {

    public int number;  //the number on the button
    public UiLogin ui;

    public ButtonActionListenerLogin(int number, UiLogin ui) {
        this.number = number;
        this.ui = ui;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       int btnChosen = number;
       ui.setBtnChosen(btnChosen);
    }
    
}
