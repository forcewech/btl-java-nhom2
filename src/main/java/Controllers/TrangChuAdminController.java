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
    private CheckRole checkRole;
    
    public TrangChuAdminController(TrangChuAdmin trangChuAdmin, NguoiDung nguoiDung, CheckRole checkRole) {
        this.trangChuAdmin = trangChuAdmin;
        this.nguoiDung = nguoiDung;
        this.checkRole = checkRole;
    }
    
    public void hienThiTrangChuAdmin() {
        trangChuAdmin.setVisible(true);
    }
    
    public void anTrangChuAdmin() {
        trangChuAdmin.setVisible(false);
    }
    
}
