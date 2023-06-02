/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author admin
 */
public class TaiSanPhongMay {
    private String maTaiSanPM, maTaiSan, maPhongMay;
    private double soLuong;

    public TaiSanPhongMay() {
    }

    public TaiSanPhongMay(String maTaiSanPM, String maTaiSan, String maPhongMay, double soLuong) {
        this.maTaiSanPM = maTaiSanPM;
        this.maTaiSan = maTaiSan;
        this.maPhongMay = maPhongMay;
        this.soLuong = soLuong;
    }

    public String getMaTaiSanPM() {
        return maTaiSanPM;
    }

    public void setMaTaiSanPM(String maTaiSanPM) {
        this.maTaiSanPM = maTaiSanPM;
    }

    public String getMaTaiSan() {
        return maTaiSan;
    }

    public void setMaTaiSan(String maTaiSan) {
        this.maTaiSan = maTaiSan;
    }

    public String getMaPhongMay() {
        return maPhongMay;
    }

    public void setMaPhongMay(String maPhongMay) {
        this.maPhongMay = maPhongMay;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "TaiSanPhongMay{" + "maTaiSanPM=" + maTaiSanPM + ", maTaiSan=" + maTaiSan + ", maPhongMay=" + maPhongMay + ", soLuong=" + soLuong + '}';
    }
    
}
