/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author thinh
 */
public class MauDanhGiaSauBaoTri {
    private String iD;
    private String tieuDe;

    public String getiD() {
        return iD;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public MauDanhGiaSauBaoTri(String iD, String tieuDe) {
        this.iD = iD;
        this.tieuDe = tieuDe;
    }

    public MauDanhGiaSauBaoTri() {
    }
    
}
