/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author thinh
 */
public class NhiemVuHoanThanh {
    private String iD;
    private int soLuongDaHoanThanh;
    private String danhGiaNhiemVu;

    public String getiD() {
        return iD;
    }

    public int getSoLuongDaHoanThanh() {
        return soLuongDaHoanThanh;
    }

    public String getDanhGiaNhiemVu() {
        return danhGiaNhiemVu;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setSoLuongDaHoanThanh(int soLuongDaHoanThanh) {
        this.soLuongDaHoanThanh = soLuongDaHoanThanh;
    }

    public void setDanhGiaNhiemVu(String danhGiaNhiemVu) {
        this.danhGiaNhiemVu = danhGiaNhiemVu;
    }

    public NhiemVuHoanThanh(String iD, int soLuongDaHoanThanh, String danhGiaNhiemVu) {
        this.iD = iD;
        this.soLuongDaHoanThanh = soLuongDaHoanThanh;
        this.danhGiaNhiemVu = danhGiaNhiemVu;
    }

    public NhiemVuHoanThanh() {
    }
    
    
}
