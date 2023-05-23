 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author IT SUP
 */
public class BaoCao {
    private String maBaoCao, nguoiKiemKe, ngayThucHien, loaiKiemKe;

    public BaoCao() {
    }

    public BaoCao(String maBaoCao) {
        this.maBaoCao = maBaoCao;
    }

    public BaoCao(String maBaoCao, String nguoiKiemKe, String ngayThucHien, String loaiKiemKe) {
        this.maBaoCao = maBaoCao;
        this.nguoiKiemKe = nguoiKiemKe;
        this.ngayThucHien = ngayThucHien;
        this.loaiKiemKe = loaiKiemKe;
    }   

    public String getMaBaoCao() {
        return maBaoCao;
    }

    public void setMaBaoCao(String maBaoCao) {
        this.maBaoCao = maBaoCao;
    }

    public String getNguoiKiemKe() {
        return nguoiKiemKe;
    }

    public void setNguoiKiemKe(String nguoiKiemKe) {
        this.nguoiKiemKe = nguoiKiemKe;
    }   
    
    public String getNgayThucHien() {
        return ngayThucHien;
    }

    public void setNgayThucHien(String ngayThucHien) {
        this.ngayThucHien = ngayThucHien;
    }

    public String getLoaiKiemKe() {
        return loaiKiemKe;
    }

    public void setLoaiKiemKe(String loaiKiemKe) {
        this.loaiKiemKe = loaiKiemKe;
    }

    @Override
    public String toString() {
        return "BaoCao{" + "maBaoCao=" + maBaoCao + ", nguoiKiemKe=" + nguoiKiemKe + ", ngayThucHien=" + ngayThucHien + ", loaiKiemKe=" + loaiKiemKe + '}';
    }
        
}
