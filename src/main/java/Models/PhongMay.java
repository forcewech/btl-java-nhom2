/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Administrator
 */
public class PhongMay {
    private String maPhong,tenPhong,trangThai;
    private boolean isBorrow;

    public PhongMay() {
    }

    public PhongMay(String maPhong) {
        this.maPhong = maPhong;
    }

    public PhongMay(String maPhong, String tenPhong, String trangThai, boolean isBorrow) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.trangThai = trangThai;
        this.isBorrow = isBorrow;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(boolean isBorrow) {
        this.isBorrow = isBorrow;
    }

    @Override
    public String toString() {
        return "PhongMay{" + "maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", trangThai=" + trangThai + ", isBorrow=" + isBorrow + '}';
    }
    
}
