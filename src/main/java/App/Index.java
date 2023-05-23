/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author thinh
 */
import Controllers.*;
import Models.DanhGiaBaoTri;
import view.Login;

public class Index {
    public static void main(String[] args) {
        
        DanhGiaBaoTri danhGiaBaoTri = new DanhGiaBaoTri();
        Login loginView = new Login();
        
        DangNhapController dangNhapController = new DangNhapController(loginView, danhGiaBaoTri);
        dangNhapController.hienThiDangNhapView();
    }
}
