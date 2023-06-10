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
import javax.swing.JOptionPane;

public class DangNhapController {
    private Login loginView;
    private NguoiDungDAO nguoiDungDAO;
    private TrangChuAdminController trangChuAdminController;
    private TrangChuTeacherController trangChuTeacherController;
    
    public DangNhapController() {
        initDAO();
        initView();
    }
    
    private void initView() {
        this.loginView = new Login(this);
    }
    
    private void initDAO() {
        this.nguoiDungDAO = new NguoiDungDAO();
    }
    
    public void hienThiDangNhapView() {
        loginView.setVisible(true);
    }
    
    public void anDangNhapView() {
        loginView.setVisible(false);
    }
    
    public void DangNhap(String Account, String Password) {
        NguoiDung nguoiDung = nguoiDungDAO.findUserByUsername_Password(Account, Password);
        if(nguoiDung == null) {
            JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không chính xác", "Thất bại", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        if(nguoiDung.getRole().equals("Manager")) {
            trangChuAdminController = new TrangChuAdminController(nguoiDung);
            trangChuAdminController.hienThiTrangChuAdmin();
        } else {
            trangChuTeacherController = new TrangChuTeacherController(nguoiDung);
            trangChuTeacherController.hienThiTrangChuTeacher();
        }
        this.loginView.dispose();
    }
}
