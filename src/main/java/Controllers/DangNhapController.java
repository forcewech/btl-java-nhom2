/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

/**
 *
 * @author thinh
 */
import Interfaces.CheckManager;
import view.*;
import Models.*;
import javax.swing.JOptionPane;

public class DangNhapController {
    private Login loginView;
    private NguoiDungDAO nguoiDungDAO;
    private TrangChuAdmin trangChuAdmin;
    private TrangChuTeacher trangChuTeacher;
    
    
    public DangNhapController() {
        this.nguoiDungDAO = new NguoiDungDAO();
        this.loginView = new Login(this);
    }
    
    public void hienThiDangNhapView() {
        loginView.setVisible(true);
    }
    
    public void anDangNhapView() {
        loginView.setVisible(false);
    }
    
    public void removeDangNhapView(){
        loginView.dispose();
    }
    
    public void DangNhap(String Account, String Password) {
        NguoiDung nguoiDung = nguoiDungDAO.findUserByUsername_Password(Account, Password);
        if( nguoiDung != null) {
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            CheckManager checkManager = new CheckManager();
            TrangChuAdminController trangChuAdminController = new TrangChuAdminController(nguoiDung);
            trangChuAdminController.hienThiTrangChuAdmin();
            removeDangNhapView();
        } else {
            JOptionPane.showMessageDialog(null, "Đăng nhập thất bại", "Thất bại", JOptionPane.INFORMATION_MESSAGE);
            TrangChuTeacherController trangChuTeacherController = new TrangChuTeacherController(nguoiDung);
            trangChuTeacherController.hienThiTrangChuTeacher();
            removeDangNhapView();
        }
        
    }
    
    
}
