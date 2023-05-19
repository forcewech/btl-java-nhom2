/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author thinh
 */
public class TaiSanBaoTri {
    private String iD;
    private String iDNhiemVuBaoTri;
    private String iDTaiSanPhongMay;
    private int soLuong;
    private String yeuCauBaoTri;

    public String getiD() {
        return iD;
    }

    public String getiDNhiemVuBaoTri() {
        return iDNhiemVuBaoTri;
    }

    public String getiDTaiSanPhongMay() {
        return iDTaiSanPhongMay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getYeuCauBaoTri() {
        return yeuCauBaoTri;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setiDNhiemVuBaoTri(String iDNhiemVuBaoTri) {
        this.iDNhiemVuBaoTri = iDNhiemVuBaoTri;
    }

    public void setiDTaiSanPhongMay(String iDTaiSanPhongMay) {
        this.iDTaiSanPhongMay = iDTaiSanPhongMay;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setYeuCauBaoTri(String yeuCauBaoTri) {
        this.yeuCauBaoTri = yeuCauBaoTri;
    }

    public TaiSanBaoTri(String iD, String iDNhiemVuBaoTri, String iDTaiSanPhongMay, int soLuong, String yeuCauBaoTri) {
        this.iD = iD;
        this.iDNhiemVuBaoTri = iDNhiemVuBaoTri;
        this.iDTaiSanPhongMay = iDTaiSanPhongMay;
        this.soLuong = soLuong;
        this.yeuCauBaoTri = yeuCauBaoTri;
    }

    public TaiSanBaoTri() {
        
    }
    
}
