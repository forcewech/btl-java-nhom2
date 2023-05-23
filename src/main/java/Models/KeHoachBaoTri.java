/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author thinh
 */
public class KeHoachBaoTri {
    private String iD;
    private LocalDate thoiGianBatDau;
    private LocalDate thoiGianKetThuc;
    private String ghiChu;
    private boolean trangThai;
    private String anhXacNhan;
    
    
    public String getiD() {
        return iD;
    }

    public LocalDate getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public LocalDate getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public String getAnhXacNhan() {
        return anhXacNhan;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setThoiGianBatDau(LocalDate thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public void setThoiGianKetThuc(LocalDate thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void setAnhXacNhan(String anhXacNhan) {
        this.anhXacNhan = anhXacNhan;
    }
    
    public KeHoachBaoTri(String iD, LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc, String ghiChu, boolean trangThai, String anhXacNhan) {
        this.iD = iD;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.anhXacNhan = anhXacNhan;
    }

    public KeHoachBaoTri() {
    }
    
}
