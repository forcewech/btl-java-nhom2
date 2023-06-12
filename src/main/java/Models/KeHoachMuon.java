/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class KeHoachMuon {
    private String id, tenNguoiMuon, thoiGianSuDung, soPhong;
    private LocalDate thoiGianMuon;
    public KeHoachMuon() {
    }

    public KeHoachMuon(String id, String tenNguoiMuon, String thoiGianSuDung, String soPhong, LocalDate thoiGianMuon) {
        this.id = id;
        this.tenNguoiMuon = tenNguoiMuon;
        this.thoiGianSuDung = thoiGianSuDung;
        this.soPhong = soPhong;
        this.thoiGianMuon = thoiGianMuon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenNguoiMuon() {
        return tenNguoiMuon;
    }

    public void setTenNguoiMuon(String tenNguoiMuon) {
        this.tenNguoiMuon = tenNguoiMuon;
    }

    public String getThoiGianSuDung() {
        return thoiGianSuDung;
    }

    public void setThoiGianSuDung(String thoiGianSuDung) {
        this.thoiGianSuDung = thoiGianSuDung;
    }

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public LocalDate getThoiGianMuon() {
        return thoiGianMuon;
    }

    public void setThoiGianMuon(LocalDate thoiGianMuon) {
        this.thoiGianMuon = thoiGianMuon;
    }

    @Override
    public String toString() {
        return "KeHoachMuon{" + "id=" + id + ", tenNguoiMuon=" + tenNguoiMuon + ", thoiGianSuDung=" + thoiGianSuDung + ", soPhong=" + soPhong + ", thoiGianMuon=" + thoiGianMuon + '}';
    }
    
}
