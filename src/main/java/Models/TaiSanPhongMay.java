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
    private String iD, iDTaiSan, iDPhongMay;
    private int soLuong;

    public TaiSanPhongMay() {
    }

    public TaiSanPhongMay(String iD, String iDTaiSan, String iDPhongMay, int soLuong) {
        this.iD = iD;
        this.iDTaiSan = iDTaiSan;
        this.iDPhongMay = iDPhongMay;
        this.soLuong = soLuong;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getiDTaiSan() {
        return iDTaiSan;
    }

    public void setiDTaiSan(String iDTaiSan) {
        this.iDTaiSan = iDTaiSan;
    }

    public String getiDPhongMay() {
        return iDPhongMay;
    }

    public void setiDPhongMay(String iDPhongMay) {
        this.iDPhongMay = iDPhongMay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "TaiSanPhongMay{" + "iD=" + iD + ", iDTaiSan=" + iDTaiSan + ", iDPhongMay=" + iDPhongMay + ", soLuong=" + soLuong + '}';
    }
    
}
