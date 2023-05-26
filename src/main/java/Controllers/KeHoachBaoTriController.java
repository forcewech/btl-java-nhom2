/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Interfaces.CheckRole;
import Interfaces.ErrorAuthen;
import Interfaces.ErrorDatabase;
import Models.KeHoachBaoTri;
import Models.KeHoachBaoTriDAO;
import Models.NghiepVuBaoTriTaiSan;
import Models.NghiepVuBaoTriTaiSanDAO;
import Models.NguoiDung;
import Models.NhiemVuBaoTri;
import Models.NhiemVuBaoTriDAO;
import Models.TaiSanBaoTri;
import Models.TaiSanBaoTriDAO;
import java.sql.SQLException;
import java.util.List;
import view.ChiTietKeHoachBaoTriView;
import view.QuanLyBaoTriTaiSanView;

/**
 *
 * @author thinh
 */
public class KeHoachBaoTriController {
    private QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView;
    private NguoiDung nguoiDung;
    private CheckRole checkRole;
    private KeHoachBaoTriDAO keHoachBaoTriDAO;
    private NhiemVuBaoTriDAO nhiemVuBaoTriDAO;
    private TaiSanBaoTriDAO taiSanBaoTriDAO;
    private ChiTietKeHoachBaoTriView chiTietKeHoachBaoTriView;
    private NghiepVuBaoTriTaiSanDAO nghiepVuBaoTriTaiSanDAO;

    public QuanLyBaoTriTaiSanView getQuanLyBaoTriTaiSanView() {
        return quanLyBaoTriTaiSanView;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public CheckRole getCheckRole() {
        return checkRole;
    }

    public KeHoachBaoTriDAO getKeHoachBaoTriDAO() {
        return keHoachBaoTriDAO;
    }

    public NhiemVuBaoTriDAO getNhiemVuBaoTriDAO() {
        return nhiemVuBaoTriDAO;
    }

    public TaiSanBaoTriDAO getTaiSanBaoTriDAO() {
        return taiSanBaoTriDAO;
    }

    public ChiTietKeHoachBaoTriView getChiTietKeHoachBaoTriView() {
        return chiTietKeHoachBaoTriView;
    }

    public void setQuanLyBaoTriTaiSanView(QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView) {
        this.quanLyBaoTriTaiSanView = quanLyBaoTriTaiSanView;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public void setCheckRole(CheckRole checkRole) {
        this.checkRole = checkRole;
    }

    public void setKeHoachBaoTriDAO(KeHoachBaoTriDAO keHoachBaoTriDAO) {
        this.keHoachBaoTriDAO = keHoachBaoTriDAO;
    }

    public void setNhiemVuBaoTriDAO(NhiemVuBaoTriDAO nhiemVuBaoTriDAO) {
        this.nhiemVuBaoTriDAO = nhiemVuBaoTriDAO;
    }

    public void setTaiSanBaoTriDAO(TaiSanBaoTriDAO taiSanBaoTriDAO) {
        this.taiSanBaoTriDAO = taiSanBaoTriDAO;
    }

    public void setChiTietKeHoachBaoTriView(ChiTietKeHoachBaoTriView chiTietKeHoachBaoTriView) {
        this.chiTietKeHoachBaoTriView = chiTietKeHoachBaoTriView;
    }
    
    public KeHoachBaoTriController(QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView, NguoiDung nguoiDung, CheckRole checkManager) {
        this.quanLyBaoTriTaiSanView = quanLyBaoTriTaiSanView;
        this.nguoiDung = nguoiDung;
        this.checkRole = checkManager;
        keHoachBaoTriDAO = new KeHoachBaoTriDAO();
        nhiemVuBaoTriDAO = new NhiemVuBaoTriDAO();
        taiSanBaoTriDAO = new TaiSanBaoTriDAO();
        nghiepVuBaoTriTaiSanDAO = new NghiepVuBaoTriTaiSanDAO();
    }
    
    public void hienThiKeHoachBaoTriView() {
        if(checkRole.checkRole(nguoiDung.getTen(), nguoiDung.getMatKhau()) != null) {
            quanLyBaoTriTaiSanView.setVisible(true);
        } else {
            ErrorAuthen error = new ErrorAuthen();
            error.HienThiThongBaoLoi("Bạn không được phép truy cập vào chức năng này");
        }
    }
    
    public void anKeHoachBaoTriView() {
        quanLyBaoTriTaiSanView.setVisible(false);
    }
    
    public List<KeHoachBaoTri> hienThiTatCaKeHoachBaoTri() {
        try {
            return keHoachBaoTriDAO.getAllKeHoachBaoTriChuaThucThi();
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
            return null;
        }
    }
    
    public List<NhiemVuBaoTri> hienThiNhiemVuBaoTri(String iDKeHoachBaoTri) {
        try {
            return nhiemVuBaoTriDAO.getAllNhiemVuBaoTriByiDKeHoachBaoTri(iDKeHoachBaoTri);
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
            return null;
        }
    }
    
    public List<NghiepVuBaoTriTaiSan> hienThiTaiSanBaoTris(String iDNhiemVuBaoTri) {
        try {
            return nghiepVuBaoTriTaiSanDAO.getTSBT_TSPM_PM_TSbyiDNhiemVuBaoTri(iDNhiemVuBaoTri);
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
            return null;
        }
    }
    
    public void addKeHoachBaoTri(KeHoachBaoTri keHoachBaoTri) {
        try {
            keHoachBaoTriDAO.addKeHoachBaoTri(keHoachBaoTri);
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public void updateKeHoachBaoTri(KeHoachBaoTri keHoachBaoTri) {
        try {
            keHoachBaoTriDAO.updateKeHoachBaoTri(keHoachBaoTri);
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
}
