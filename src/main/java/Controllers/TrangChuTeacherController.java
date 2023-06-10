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
    
    public TrangChuTeacherController(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
        initView(nguoiDung);
    }
    
    private void initView(NguoiDung nguoiDung) {
        trangChuTeacher = new TrangChuTeacher(this, nguoiDung);
    }
    
    public void hienThiTrangChuTeacher() {
        trangChuTeacher.setVisible(true);
    }
    
    public void anTrangChuTeacher() {
        trangChuTeacher.setVisible(false);
    }
}
