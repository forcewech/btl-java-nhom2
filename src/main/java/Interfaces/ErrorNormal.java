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
public class ErrorNormal implements Error{

    private String message;
    
    public ErrorNormal() {
        
    }
    
    public ErrorNormal(String message) {
       this.message = message;
    }
    
    @Override
    public void HienThiThongBaoLoi() {
        JOptionPane.showMessageDialog(null, message, "Lỗi dữ liệu", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void HienThiThongBaoLoi(String message) {
        JOptionPane.showMessageDialog(null, message, "Lỗi dữ liệu", JOptionPane.WARNING_MESSAGE);
    }
}
