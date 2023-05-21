package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author IT SUP
 */
public class TaiSanThayDoi {
    private String maTaiSan, iDTaiSanPhongMay, iDKeHoachThayDoiTaiSan;
    private int soLuong;
    private String trangThai;

    public TaiSanThayDoi() {
    }

    public TaiSanThayDoi(String maTaiSan) {
        this.maTaiSan = maTaiSan;
    }

    public TaiSanThayDoi(String maTaiSan, String iDTaiSanPhongMay, String iDKeHoachThayDoiTaiSan, int soLuong, String trangThai) {
        this.maTaiSan = maTaiSan;
        this.iDTaiSanPhongMay = iDTaiSanPhongMay;
        this.iDKeHoachThayDoiTaiSan = iDKeHoachThayDoiTaiSan;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public String getMaTaiSan() {
        return maTaiSan;
    }

    public void setMaTaiSan(String maTaiSan) {
        this.maTaiSan = maTaiSan;
    }

    public String getiDTaiSanPhongMay() {
        return iDTaiSanPhongMay;
    }

    public void setiDTaiSanPhongMay(String iDTaiSanPhongMay) {
        this.iDTaiSanPhongMay = iDTaiSanPhongMay;
    }

    public String getiDKeHoachThayDoiTaiSan() {
        return iDKeHoachThayDoiTaiSan;
    }

    public void setiDKeHoachThayDoiTaiSan(String iDKeHoachThayDoiTaiSan) {
        this.iDKeHoachThayDoiTaiSan = iDKeHoachThayDoiTaiSan;
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
        return "TaiSanThayDoi{" + "maTaiSan=" + maTaiSan + ", iDTaiSanPhongMay=" + iDTaiSanPhongMay + ", iDKeHoachThayDoiTaiSan=" + iDKeHoachThayDoiTaiSan + ", soLuong=" + soLuong + ", trangThai=" + trangThai + '}';
    }            
}
