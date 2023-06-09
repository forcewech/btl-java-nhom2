package Models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author IT SUP
 */
public class NhiemVuThayDoiTaiSan {
    private String iD, iDKeHoachThayDoiTaiSan,tenNhiemVu, chiTietNhiemVu, tienDo;

    public NhiemVuThayDoiTaiSan() {
    }

    public NhiemVuThayDoiTaiSan(String iD) {
        this.iD = iD;
    }

    public NhiemVuThayDoiTaiSan(String iD, String iDKeHoachThayDoiTaiSan, String tenNhiemVu, String chiTietNhiemVu, String tienDo) {
        this.iD = iD;
        this.iDKeHoachThayDoiTaiSan = iDKeHoachThayDoiTaiSan;
        this.tenNhiemVu = tenNhiemVu;
        this.chiTietNhiemVu = chiTietNhiemVu;
        this.tienDo = tienDo;
    } 

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getiDKeHoachThayDoiTaiSan() {
        return iDKeHoachThayDoiTaiSan;
    }

    public void setiDKeHoachThayDoiTaiSan(String iDKeHoachThayDoiTaiSan) {
        this.iDKeHoachThayDoiTaiSan = iDKeHoachThayDoiTaiSan;
    }

    public String getTenNhiemVu() {
        return tenNhiemVu;
    }

    public void setTenNhiemVu(String tenNhiemVu) {
        this.tenNhiemVu = tenNhiemVu;
    }

    public String getChiTietNhiemVu() {
        return chiTietNhiemVu;
    }

    public void setChiTietNhiemVu(String chiTietNhiemVu) {
        this.chiTietNhiemVu = chiTietNhiemVu;
    }

    public String getTienDo() {
        return tienDo;
    }

    public void setTienDo(String tienDo) {
        this.tienDo = tienDo;
    }

    @Override
    public String toString() {
        return "NhiemVuThayDoiTaiSan{" + "iD=" + iD + ", iDKeHoachThayDoiTaiSan=" + iDKeHoachThayDoiTaiSan + ", tenNhiemVu=" + tenNhiemVu + ", chiTietNhiemVu=" + chiTietNhiemVu + ", tienDo=" + tienDo + '}';
    }

}
