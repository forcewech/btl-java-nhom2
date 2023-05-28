/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author thinh
 */
public class TaiSanPhongMay {
    private String iD;
    private String iDTaiSan;
    private String iDPhongMay;
    private int soLuong;

    public String getiD() {
        return iD;
    }

    public String getiDTaiSan() {
        return iDTaiSan;
    }

    public String getiDPhongMay() {
        return iDPhongMay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setiDTaiSan(String iDTaiSan) {
        this.iDTaiSan = iDTaiSan;
    }

    public void setiDPhongMay(String iDPhongMay) {
        this.iDPhongMay = iDPhongMay;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public TaiSanPhongMay(String iD, String iDTaiSan, String iDPhongMay, int soLuong) {
        this.iD = iD;
        this.iDTaiSan = iDTaiSan;
        this.iDPhongMay = iDPhongMay;
        this.soLuong = soLuong;
    }

    public TaiSanPhongMay() {
    }
    
}
