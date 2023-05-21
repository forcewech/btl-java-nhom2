/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author IT SUP
 */
public class CapNhatTienDo {
    private String iD, iDTaiSanThayDoi, iDNhiemVuThayDoiTaiSan;
    private int soLuongHoanThanh;

    public CapNhatTienDo() {
    }

    public CapNhatTienDo(String iD) {
        this.iD = iD;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getiDTaiSanThayDoi() {
        return iDTaiSanThayDoi;
    }

    public void setiDTaiSanThayDoi(String iDTaiSanThayDoi) {
        this.iDTaiSanThayDoi = iDTaiSanThayDoi;
    }

    public String getiDNhiemVuThayDoiTaiSan() {
        return iDNhiemVuThayDoiTaiSan;
    }

    public void setiDNhiemVuThayDoiTaiSan(String iDNhiemVuThayDoiTaiSan) {
        this.iDNhiemVuThayDoiTaiSan = iDNhiemVuThayDoiTaiSan;
    }

    public int getSoLuongHoanThanh() {
        return soLuongHoanThanh;
    }

    public void setSoLuongHoanThanh(int soLuongHoanThanh) {
        this.soLuongHoanThanh = soLuongHoanThanh;
    }

    public CapNhatTienDo(String iD, String iDTaiSanThayDoi, String iDNhiemVuThayDoiTaiSan, int soLuongHoanThanh) {
        this.iD = iD;
        this.iDTaiSanThayDoi = iDTaiSanThayDoi;
        this.iDNhiemVuThayDoiTaiSan = iDNhiemVuThayDoiTaiSan;
        this.soLuongHoanThanh = soLuongHoanThanh;
    }

    @Override
    public String toString() {
        return "CapNhatTienDo{" + "iD=" + iD + ", iDTaiSanThayDoi=" + iDTaiSanThayDoi + ", iDNhiemVuThayDoiTaiSan=" + iDNhiemVuThayDoiTaiSan + ", soLuongHoanThanh=" + soLuongHoanThanh + '}';
    }
    
    
}
