/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author thinh
 */
public class NhiemVuBaoTri {
    private String iD;
    private String iDKeHoachBaoTri;
    private String tenNhiemVu;
    private String chiTietNhiemVu;
    private String danhGia;
    private int chiPhi;
    
    public String getiD() {
        return iD;
    }

    public String getiDKeHoachBaoTri() {
        return iDKeHoachBaoTri;
    }


    public String getTenNhiemVu() {
        return tenNhiemVu;
    }

    public String getChiTietNhiemVu() {
        return chiTietNhiemVu;
    }

    public int getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(int chiPhi) {
        this.chiPhi = chiPhi;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setiDKeHoachBaoTri(String iDKeHoachBaoTri) {
        this.iDKeHoachBaoTri = iDKeHoachBaoTri;
    }

    public void setTenNhiemVu(String tenNhiemVu) {
        this.tenNhiemVu = tenNhiemVu;
    }

    public void setChiTietNhiemVu(String chiTietNhiemVu) {
        this.chiTietNhiemVu = chiTietNhiemVu;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public NhiemVuBaoTri(String iD, String iDKeHoachBaoTri, String tenNhiemVu, String chiTietNhiemVu, String danhGia, int chiPhi) {
        this.iD = iD;
        this.iDKeHoachBaoTri = iDKeHoachBaoTri;
        this.tenNhiemVu = tenNhiemVu;
        this.chiTietNhiemVu = chiTietNhiemVu;
        this.chiPhi = chiPhi;
        this.danhGia = danhGia;
    }

    public NhiemVuBaoTri() {
    }
    
    
}
