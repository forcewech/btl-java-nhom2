/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author IT SUP
 */
public class KeHoachThayDoiTaiSan {
    private String maKeHoach, thoiGianBatDau, thoiGianKetThuc;

    public KeHoachThayDoiTaiSan() {
    }

    public KeHoachThayDoiTaiSan(String maKeHoach) {
        this.maKeHoach = maKeHoach;
    }

    public KeHoachThayDoiTaiSan(String maKeHoach, String thoiGianBatDau, String thoiGianKetThuc) {
        this.maKeHoach = maKeHoach;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMaKeHoach() {
        return maKeHoach;
    }

    public void setMaKeHoach(String maKeHoach) {
        this.maKeHoach = maKeHoach;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    @Override
    public String toString() {
        return "KeHoachThayDoiTaiSan{" + "maKeHoach=" + maKeHoach + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc=" + thoiGianKetThuc + '}';
    }
      
}
