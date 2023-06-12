/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Models.TaiSanPhongMay;

/**
 *
 * @author thinh
 */
public class NghiepVuBaoTriTaiSan {
    private HoanThanhBaoTri hoanThanhBaoTri;
    private KeHoachBaoTri keHoachBaoTri;
    private NhiemVuBaoTri nhiemVuBaoTri;
    private NhiemVuHoanThanh nhiemVuHoanThanh;
    private TaiSanBaoTri TaiSanBaoTri;
    private DanhGiaBaoTri danhGiaBaoTri;
    private MauDanhGiaSauBaoTri mauDanhGiaSauBaoTri;
    private TaiSanPhongMay taiSanPhongMay;
    private PhongMay phongMay;
    private TaiSan taiSan;

    public NghiepVuBaoTriTaiSan(HoanThanhBaoTri hoanThanhBaoTri, KeHoachBaoTri keHoachBaoTri, NhiemVuBaoTri nhiemVuBaoTri, NhiemVuHoanThanh nhiemVuHoanThanh, TaiSanBaoTri TaiSanBaoTri, DanhGiaBaoTri danhGiaBaoTri, MauDanhGiaSauBaoTri mauDanhGiaSauBaoTri, TaiSanPhongMay taiSanPhongMay, PhongMay phongMay, TaiSan taiSan) {
        this.hoanThanhBaoTri = hoanThanhBaoTri;
        this.keHoachBaoTri = keHoachBaoTri;
        this.nhiemVuBaoTri = nhiemVuBaoTri;
        this.nhiemVuHoanThanh = nhiemVuHoanThanh;
        this.TaiSanBaoTri = TaiSanBaoTri;
        this.danhGiaBaoTri = danhGiaBaoTri;
        this.mauDanhGiaSauBaoTri = mauDanhGiaSauBaoTri;
        this.taiSanPhongMay = taiSanPhongMay;
        this.phongMay = phongMay;
        this.taiSan = taiSan;
    }

    public NghiepVuBaoTriTaiSan() {
    }

    public HoanThanhBaoTri getHoanThanhBaoTri() {
        return hoanThanhBaoTri;
    }

    public KeHoachBaoTri getKeHoachBaoTri() {
        return keHoachBaoTri;
    }

    public NhiemVuBaoTri getNhiemVuBaoTri() {
        return nhiemVuBaoTri;
    }

    public NhiemVuHoanThanh getNhiemVuHoanThanh() {
        return nhiemVuHoanThanh;
    }

    public TaiSanBaoTri getTaiSanBaoTri() {
        return TaiSanBaoTri;
    }

    public DanhGiaBaoTri getDanhGiaBaoTri() {
        return danhGiaBaoTri;
    }

    public MauDanhGiaSauBaoTri getMauDanhGiaSauBaoTri() {
        return mauDanhGiaSauBaoTri;
    }

    public TaiSanPhongMay getTaiSanPhongMay() {
        return taiSanPhongMay;
    }

    public PhongMay getPhongMay() {
        return phongMay;
    }

    public TaiSan getTaiSan() {
        return taiSan;
    }

    public void setHoanThanhBaoTri(HoanThanhBaoTri hoanThanhBaoTri) {
        this.hoanThanhBaoTri = hoanThanhBaoTri;
    }

    public void setKeHoachBaoTri(KeHoachBaoTri keHoachBaoTri) {
        this.keHoachBaoTri = keHoachBaoTri;
    }

    public void setNhiemVuBaoTri(NhiemVuBaoTri nhiemVuBaoTri) {
        this.nhiemVuBaoTri = nhiemVuBaoTri;
    }

    public void setNhiemVuHoanThanh(NhiemVuHoanThanh nhiemVuHoanThanh) {
        this.nhiemVuHoanThanh = nhiemVuHoanThanh;
    }

    public void setTaiSanBaoTri(TaiSanBaoTri TaiSanBaoTri) {
        this.TaiSanBaoTri = TaiSanBaoTri;
    }

    public void setDanhGiaBaoTri(DanhGiaBaoTri danhGiaBaoTri) {
        this.danhGiaBaoTri = danhGiaBaoTri;
    }

    public void setMauDanhGiaSauBaoTri(MauDanhGiaSauBaoTri mauDanhGiaSauBaoTri) {
        this.mauDanhGiaSauBaoTri = mauDanhGiaSauBaoTri;
    }

    public void setTaiSanPhongMay(TaiSanPhongMay taiSanPhongMay) {
        this.taiSanPhongMay = taiSanPhongMay;
    }

    public void setPhongMay(PhongMay phongMay) {
        this.phongMay = phongMay;
    }

    public void setTaiSan(TaiSan taiSan) {
        this.taiSan = taiSan;
    }
}
