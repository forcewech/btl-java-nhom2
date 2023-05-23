/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

/**
 *
 * @author thinh
 */
import view.*;
import Models.*;

public class DangNhapController {
    private Login loginView;
    private DanhGiaBaoTri danhGiaBaoTri;

    public DangNhapController(Login loginView, DanhGiaBaoTri danhGiaBaoTri) {
        this.loginView = loginView;
        this.danhGiaBaoTri = danhGiaBaoTri;
    }
    
    public void hienThiDangNhapView() {
        loginView.setVisible(true);
    }
    
    
}
