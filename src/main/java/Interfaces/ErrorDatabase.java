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
public class ErrorDatabase implements Error {
    @Override
    public void HienThiThongBaoLoi() {
        JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu", "Đang có vấn đề nào đó cần sửa chữa...! Bạn hãy reset lại phần mềm", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void HienThiThongBaoLoi(String Message) {
        JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu", Message, JOptionPane.ERROR_MESSAGE);
    }
      
}
