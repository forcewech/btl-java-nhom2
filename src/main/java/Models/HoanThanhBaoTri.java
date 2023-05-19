/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author thinh
 */
public class HoanThanhBaoTri {
    private String iD;
    private boolean daHoanThanh;
    private String lyDoKeThucSom; 

    public String getiD() {
        return iD;
    }

    public boolean isDaHoanThanh() {
        return daHoanThanh;
    }

    public String getLyDoKeThucSom() {
        return lyDoKeThucSom;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setDaHoanThanh(boolean daHoanThanh) {
        this.daHoanThanh = daHoanThanh;
    }

    public void setLyDoKeThucSom(String lyDoKeThucSom) {
        this.lyDoKeThucSom = lyDoKeThucSom;
    }

    public HoanThanhBaoTri(String iD, boolean daHoanThanh, String lyDoKeThucSom, KeHoachBaoTri keHoachBaoTri) {
        this.iD = iD;
        this.daHoanThanh = daHoanThanh;
        this.lyDoKeThucSom = lyDoKeThucSom;
    }

    public HoanThanhBaoTri() {
    }
}
