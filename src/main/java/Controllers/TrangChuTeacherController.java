/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Interfaces.CheckRole;
import Models.NguoiDung;
import view.TrangChuTeacher;

/**
 *
 * @author thinh
 */
public class TrangChuTeacherController {
    private TrangChuTeacher trangChuTeacher;
    private NguoiDung nguoiDung;
    private CheckRole checkRole;
    
    public TrangChuTeacherController(TrangChuTeacher trangChuTeacher, NguoiDung nguoiDung, CheckRole checkRole) {
        this.trangChuTeacher = trangChuTeacher;
        this.nguoiDung = nguoiDung;
        this.checkRole = checkRole;
    }
    
    public void hienThiTrangChuTeacher() {
        trangChuTeacher.setVisible(true);
    }
    
    public void anTrangChuTeacher() {
        trangChuTeacher.setVisible(false);
    }
}
