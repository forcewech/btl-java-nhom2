/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author thinh
 */
public class DanhGiaBaoTri {
    private String iD;
    private String tieuDe;
    private String iDNhiemVuBaoTri;
    private int danhGia;
    private String ghiChu;

    public String getiD() {
        return iD;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public int getDanhGia() {
        return danhGia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getiDNhiemVuBaoTri() {
        return iDNhiemVuBaoTri;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setDanhGia(int danhGia) {
        this.danhGia = danhGia;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setiDNhiemVuBaoTri(String iDNhiemVuBaoTri) {
        this.iDNhiemVuBaoTri = iDNhiemVuBaoTri;
    }

    public DanhGiaBaoTri(String iD, String tieuDe, String iDNhiemVuBaoTri, int danhGia, String ghiChu) {
        this.iD = iD;
        this.tieuDe = tieuDe;
        this.danhGia = danhGia;
        this.ghiChu = ghiChu;
        this.iDNhiemVuBaoTri = iDNhiemVuBaoTri;
    }

    public DanhGiaBaoTri() {
    }
}
