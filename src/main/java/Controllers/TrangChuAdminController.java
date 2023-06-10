/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Interfaces.CheckRole;
import Models.NguoiDung;
import view.TrangChuAdmin;

/**
 *
 * @author thinh
 */
public class TrangChuAdminController {
    private TrangChuAdmin trangChuAdmin;
    private NguoiDung nguoiDung;
    
    public TrangChuAdminController(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
        initView(nguoiDung);
    }
    
    private void initView(NguoiDung nguoiDung) {
        trangChuAdmin = new TrangChuAdmin(this, nguoiDung);
    }
    
    public void hienThiTrangChuAdmin() {
        trangChuAdmin.setVisible(true);
    }
    
    public void anTrangChuAdmin() {
        trangChuAdmin.setVisible(false);
    }
    
    public void navigateToQuanLyBaoTriTaiSan() {
        QuanLyBaoTriController quanLyBaoTriController = new QuanLyBaoTriController(nguoiDung);
        quanLyBaoTriController.showQuanLyBaoTriView();
        trangChuAdmin.dispose();
    }
    
}
