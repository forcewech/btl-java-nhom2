/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import javax.swing.JOptionPane;

/**
 *
 * @author thinh
 */
public class NotifyNormal implements Notify{
    private String message;

    public NotifyNormal() {
    }
    
    public NotifyNormal(String message) {
        this.message = message;
    }
    
    @Override
    public void showNotify() {
        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showNotify(String message) {
        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
