/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Interfaces.ErrorDatabase;
import Models.KeHoachBaoTri;
import Models.KeHoachBaoTriDAO;
import Models.NghiepVuBaoTriTaiSan;
import Models.NghiepVuBaoTriTaiSanDAO;
import Models.NguoiDung;
import Models.NhiemVuBaoTri;
import Models.NhiemVuBaoTriDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import view.LichSuBaoTriView;
import view.QuanLyBaoTriTaiSanView;

/**
 *
 * @author thinh
 */
public class LichSuBaoTriController {
    private QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView;
    private NguoiDung nguoiDung;
    private LichSuBaoTriView lichSuBaoTriView;
    private KeHoachBaoTriDAO keHoachBaoTriDAO;
    private NghiepVuBaoTriTaiSanDAO nghiepVuBaoTriTaiSanDAO;
    private NhiemVuBaoTriDAO nhiemVuBaoTriDAO;
    
    public LichSuBaoTriController() {
        
    }

    public LichSuBaoTriController(QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView, NguoiDung nguoiDung) {
        this.quanLyBaoTriTaiSanView = quanLyBaoTriTaiSanView;
        this.nguoiDung = nguoiDung;
        initDAO();
    }
    
    private void initDAO() {
        keHoachBaoTriDAO = new KeHoachBaoTriDAO();
        nghiepVuBaoTriTaiSanDAO = new NghiepVuBaoTriTaiSanDAO();
        nhiemVuBaoTriDAO = new NhiemVuBaoTriDAO();
    }
    
    public List<KeHoachBaoTri> getKeHoachBaoTriDaHoanThanh() {
        List<KeHoachBaoTri> keHoachBaoTris = new ArrayList<>();
        try {
            keHoachBaoTris = keHoachBaoTriDAO.getAllKeHoachDaHoanThanh();
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
        return keHoachBaoTris;
    }
    
    public List<NghiepVuBaoTriTaiSan> getTSBT_TSPM_PM_TS_NVHTbyiDNhiemVuBaoTri(NhiemVuBaoTri nhiemVuBaoTri) {
        List<NghiepVuBaoTriTaiSan> nghiepVuBaoTriTaiSanList = new ArrayList<>();
        try {
            nghiepVuBaoTriTaiSanList = nghiepVuBaoTriTaiSanDAO.getTSBT_TSPM_PM_TS_NVHTbyiDNhiemVuBaoTri(nhiemVuBaoTri.getiD());
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
        return nghiepVuBaoTriTaiSanList;
    }
    
    public List<NhiemVuBaoTri> getNhiemVuBaoTriByiDKeHoachBaoTri(String iDKeHoachBaoTri) {
        List<NhiemVuBaoTri> nhiemVuBaoTrisList = new ArrayList<>();
        try {
            nhiemVuBaoTrisList = nhiemVuBaoTriDAO.getAllNhiemVuBaoTriByiDKeHoachBaoTri(iDKeHoachBaoTri);
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
        return nhiemVuBaoTrisList;
    }
    
    public void navigateQuanLyBaoTriViewAndUpdateLichSuBaoTriTable() {
        quanLyBaoTriTaiSanView.setVisible(true);
        quanLyBaoTriTaiSanView.showAllKeHoachDaHoanThanhbySQL();
    }

    public QuanLyBaoTriTaiSanView getQuanLyBaoTriTaiSanView() {
        return quanLyBaoTriTaiSanView;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public LichSuBaoTriView getLichSuBaoTriView() {
        return lichSuBaoTriView;
    }

    public void setQuanLyBaoTriTaiSanView(QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView) {
        this.quanLyBaoTriTaiSanView = quanLyBaoTriTaiSanView;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }
    
    public void setLichSuBaoTriView(LichSuBaoTriView lichSuBaoTriView) {
        this.lichSuBaoTriView = lichSuBaoTriView;
    }

}
