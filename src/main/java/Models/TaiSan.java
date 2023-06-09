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
public class TaiSan {
    private String maTaiSan, tenTaiSan, trangThai, hangSanXuat; 
    private LocalDate ngayTrangBi;
    private double gia;
    private int soLuong;

    public TaiSan() {
    }

    public TaiSan(String maTaiSan) {
        this.maTaiSan = maTaiSan;
    }
    
    public TaiSan(String maTaiSan, String tenTaiSan, int soLuong, String trangThai, String hangSanXuat, LocalDate ngayTrangBi, double gia) {
        this.maTaiSan = maTaiSan;
        this.tenTaiSan = tenTaiSan;
        this.trangThai = trangThai;
        this.hangSanXuat = hangSanXuat;
        this.ngayTrangBi = ngayTrangBi;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public String getMaTaiSan() {
        return maTaiSan;
    }

    public void setMaTaiSan(String maTaiSan) {
        this.maTaiSan = maTaiSan;
    }

    public String getTenTaiSan() {
        return tenTaiSan;
    }

    public void setTenTaiSan(String tenTaiSan) {
        this.tenTaiSan = tenTaiSan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public LocalDate getNgayTrangBi() {
        return ngayTrangBi;
    }

    public void setNgayTrangBi(LocalDate ngayTrangBi) {
        this.ngayTrangBi = ngayTrangBi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "TaiSan{" + "maTaiSan=" + maTaiSan + ", tenTaiSan=" + tenTaiSan + ", trangThai=" + trangThai + ", hangSanXuat=" + hangSanXuat + ", ngayTrangBi=" + ngayTrangBi + ", soLuong=" + soLuong + ", gia=" + gia + '}';
    }
    
    
}
