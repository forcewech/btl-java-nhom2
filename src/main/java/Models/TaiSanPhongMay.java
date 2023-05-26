/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Administrator
 */
public class TaiSanPhongMay {
    private String tenTaiSan;
    private String maTaiSan;
    private double soLuong;

    public TaiSanPhongMay() {
    }

    public TaiSanPhongMay(String tenTaiSan, String maTaiSan, double soLuong) {
        this.tenTaiSan = tenTaiSan;
        this.maTaiSan = maTaiSan;
        this.soLuong = soLuong;
    }

    public String getTenTaiSan() {
        return tenTaiSan;
    }

    public void setTenTaiSan(String tenTaiSan) {
        this.tenTaiSan = tenTaiSan;
    }

    public String getMaTaiSan() {
        return maTaiSan;
    }

    public void setMaTaiSan(String maTaiSan) {
        this.maTaiSan = maTaiSan;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "TaiSanPhongMay{" + "tenTaiSan=" + tenTaiSan + ", maTaiSan=" + maTaiSan + ", soLuong=" + soLuong + '}';
    }
    
    
}
