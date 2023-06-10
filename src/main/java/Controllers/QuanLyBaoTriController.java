/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.NguoiDung;
import view.QuanLyBaoTriTaiSanView;

/**
 *
 * @author thinh
 */
public class QuanLyBaoTriController {
    private NguoiDung nguoiDung;
    private KeHoachBaoTriController keHoachBaoTriController;
    private ThucThiBaoTriController thucThiBaoTriController;
    private LichSuBaoTriController lichSuBaoTriController;
    private QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView;
    
    public QuanLyBaoTriController(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
        initController(nguoiDung);
        initView();
        initControllerFromView();
    }
    
    private void initView() {
        this.quanLyBaoTriTaiSanView = new QuanLyBaoTriTaiSanView(this);
    }
    
    private void initController(NguoiDung nguoiDung) {
        this.keHoachBaoTriController = new KeHoachBaoTriController(quanLyBaoTriTaiSanView, nguoiDung);
        this.thucThiBaoTriController = new ThucThiBaoTriController(quanLyBaoTriTaiSanView, nguoiDung);
        this.lichSuBaoTriController = new LichSuBaoTriController(quanLyBaoTriTaiSanView, nguoiDung);
    }
    
    private void initControllerFromView() {
        keHoachBaoTriController.setQuanLyBaoTriTaiSanView(quanLyBaoTriTaiSanView);
        thucThiBaoTriController.setQuanLyBaoTriTaiSanView(quanLyBaoTriTaiSanView);
        lichSuBaoTriController.setQuanLyBaoTriTaiSanView(quanLyBaoTriTaiSanView);
    }
    
    public void showQuanLyBaoTriView() {
        quanLyBaoTriTaiSanView.setVisible(true);
    }
    
    public void hiddenQuanLyBaoTriView() {
        quanLyBaoTriTaiSanView.setVisible(false);
    }
    
    public void removeQuanLyBaoTriView() {
        quanLyBaoTriTaiSanView.dispose();
    }
    
    public void navigateToTrangChuAdminView() {
        TrangChuAdminController trangChuAdminController = new TrangChuAdminController(nguoiDung);
        trangChuAdminController.hienThiTrangChuAdmin();
        removeQuanLyBaoTriView();
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public QuanLyBaoTriTaiSanView getQuanLyBaoTriTaiSanView() {
        return quanLyBaoTriTaiSanView;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public void setQuanLyBaoTriTaiSanView(QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView) {
        this.quanLyBaoTriTaiSanView = quanLyBaoTriTaiSanView;
    }
    
    public KeHoachBaoTriController getKeHoachBaoTriController() {
        return keHoachBaoTriController;
    }

    public ThucThiBaoTriController getThucThiBaoTriController() {
        return thucThiBaoTriController;
    }

    public LichSuBaoTriController getLichSuBaoTriController() {
        return lichSuBaoTriController;
    }

    public void setKeHoachBaoTriController(KeHoachBaoTriController keHoachBaoTriController) {
        this.keHoachBaoTriController = keHoachBaoTriController;
    }

    public void setThucThiBaoTriController(ThucThiBaoTriController thucThiBaoTriController) {
        this.thucThiBaoTriController = thucThiBaoTriController;
    }

    public void setLichSuBaoTriController(LichSuBaoTriController lichSuBaoTriController) {
        this.lichSuBaoTriController = lichSuBaoTriController;
    }
    
}
