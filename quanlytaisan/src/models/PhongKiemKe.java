/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author IT SUP
 */
public class PhongKiemKe {
    private String iD, iDKeHoachKiemKe, iDPhongMay;

    public PhongKiemKe() {
    }

    public PhongKiemKe(String iD) {
        this.iD = iD;
    }

    public PhongKiemKe(String iD, String iDKeHoachKiemKe, String iDPhongMay) {
        this.iD = iD;
        this.iDKeHoachKiemKe = iDKeHoachKiemKe;
        this.iDPhongMay = iDPhongMay;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getiDKeHoachKiemKe() {
        return iDKeHoachKiemKe;
    }

    public void setiDKeHoachKiemKe(String iDKeHoachKiemKe) {
        this.iDKeHoachKiemKe = iDKeHoachKiemKe;
    }

    public String getiDPhongMay() {
        return iDPhongMay;
    }

    public void setiDPhongMay(String iDPhongMay) {
        this.iDPhongMay = iDPhongMay;
    }

    @Override
    public String toString() {
        return "PhongKiemKe{" + "iD=" + iD + ", iDKeHoachKiemKe=" + iDKeHoachKiemKe + ", iDPhongMay=" + iDPhongMay + '}';
    }
    
    
}
