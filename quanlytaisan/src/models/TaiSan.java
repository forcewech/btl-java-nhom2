/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author IT SUP
 */
public class TaiSan {
    private String maTaiSan, tenTaiSan, trangThai, hangSanXuat, ngayTrangBi;
    private double soLuong, gia;

    public TaiSan() {
    }

    public TaiSan(String maTaiSan) {
        this.maTaiSan = maTaiSan;
    }
    
    public TaiSan(String maTaiSan, String tenTaiSan, double soLuong, String trangThai, String hangSanXuat, String ngayTrangBi, double gia) {
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

    public String getNgayTrangBi() {
        return ngayTrangBi;
    }

    public void setNgayTrangBi(String ngayTrangBi) {
        this.ngayTrangBi = ngayTrangBi;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
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
