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
public class ErrorAuthen implements Error{

    @Override
    public void HienThiThongBaoLoi() {
        JOptionPane.showMessageDialog(null, "Người dùng không hợp lệ", "Bạn không có quyền hạn truy cập", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void HienThiThongBaoLoi(String Message) {
        JOptionPane.showMessageDialog(null, "Người dùng không hợp lệ", Message, JOptionPane.ERROR_MESSAGE);
    }
    
}
