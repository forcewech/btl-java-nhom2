/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


/**
 *
 * @author admin
 */
public class NguoiDung {
    private String maNguoiDung, hoTen, ten, matKhau, email, role;

    public NguoiDung() {
    }

    public NguoiDung(String maNguoiDung, String hoTen, String ten, String matKhau, String email, String role) {
        this.maNguoiDung = maNguoiDung;
        this.hoTen = hoTen;
        this.ten = ten;
        this.matKhau = matKhau;
        this.email = email;
        this.role = role;
    }

    public NguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }
    
    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "NguoiDung{" + "maNguoiDung=" + maNguoiDung + ", hoTen=" + hoTen + ", ten=" + ten + ", matKhau=" + matKhau + ", email=" + email + ", role=" + role + '}';
    }

}
