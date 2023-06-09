 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;

/**
 *
 * @author IT SUP
 */
public class BaoCao {
    private LocalDate ngayThucHien;
    private String phong, nguoiKiemKe, tenTaiSan; 
    private int soLuong;
    private String ghiChu;
    
    public BaoCao() {
    }

    public BaoCao(LocalDate ngayThucHien, String phong, String nguoiKiemKe, String tenTaiSan, int soLuong, String ghiChu) {
        this.ngayThucHien = ngayThucHien;
        this.phong = phong;
        this.nguoiKiemKe = nguoiKiemKe;
        this.tenTaiSan = tenTaiSan;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }    

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getNguoiKiemKe() {
        return nguoiKiemKe;
    }

    public void setNguoiKiemKe(String nguoiKiemKe) {
        this.nguoiKiemKe = nguoiKiemKe;
    }

    public String getTenTaiSan() {
        return tenTaiSan;
    }

    public void setTenTaiSan(String tenTaiSan) {
        this.tenTaiSan = tenTaiSan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public LocalDate getNgayThucHien() {
        return ngayThucHien;
    }

    public void setNgayThucHien(LocalDate ngayThucHien) {
        this.ngayThucHien = ngayThucHien;
    }  

    @Override
    public String toString() {
        return "BaoCao{" + "ngayThucHien=" + ngayThucHien + ", phong=" + phong + ", nguoiKiemKe=" + nguoiKiemKe + ", tenTaiSan=" + tenTaiSan + ", soLuong=" + soLuong + ", ghiChu=" + ghiChu + '}';
    }     
}
