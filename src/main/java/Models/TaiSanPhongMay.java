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
    private String trangThai;

    public TaiSanPhongMay() {
    }

    public TaiSanPhongMay(String iD) {
        this.iD = iD;
    }

    public TaiSanPhongMay(String iD, String iDTaiSan, String iDPhongMay, int soLuong, String trangThai) {
        this.iD = iD;
        this.iDTaiSan = iDTaiSan;
        this.iDPhongMay = iDPhongMay;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "TaiSanPhongMay{" + "iD=" + iD + ", iDTaiSan=" + iDTaiSan + ", iDPhongMay=" + iDPhongMay + ", soLuong=" + soLuong + ", ghiChu=" + trangThai + '}';
    }  
    
}
