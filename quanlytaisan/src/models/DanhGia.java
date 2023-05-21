package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author IT SUP
 */
public class DanhGia {
    private String maPhieu, danhGia;

    public DanhGia() {
    }

    public DanhGia(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public DanhGia(String maPhieu, String danhGia) {
        this.maPhieu = maPhieu;
        this.danhGia = danhGia;
    }
       
    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    @Override
    public String toString() {
        return "DanhGia{" + "maPhieu=" + maPhieu + ", danhGia=" + danhGia + '}';
    }
    
    
}
