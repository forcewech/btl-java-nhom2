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
public class KeHoachKiemKe {
    private String maKeHoach;
    private LocalDate thoiGianBatDau, thoiGianKetThuc;

    public KeHoachKiemKe() {
    }

    public KeHoachKiemKe(String maKeHoach) {
        this.maKeHoach = maKeHoach;
    }

    public KeHoachKiemKe(String maKeHoach, LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc) {
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

    public LocalDate getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDate thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalDate getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalDate thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    @Override
    public String toString() {
        return "KeHoachKiemKe{" + "maKeHoach=" + maKeHoach + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc=" + thoiGianKetThuc + '}';
    }
      
}
