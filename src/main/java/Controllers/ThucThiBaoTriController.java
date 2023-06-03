/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Interfaces.ErrorDatabase;
import Models.HoanThanhBaoTri;
import Models.HoanThanhBaoTriDAO;
import Models.KeHoachBaoTri;
import Models.KeHoachBaoTriDAO;
import Models.NghiepVuBaoTriTaiSan;
import Models.NghiepVuBaoTriTaiSanDAO;
import Models.NguoiDung;
import Models.NhiemVuBaoTri;
import Models.NhiemVuBaoTriDAO;
import Models.NhiemVuHoanThanh;
import Models.NhiemVuHoanThanhDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import view.QuanLyBaoTriTaiSanView;

/**
 *
 * @author thinh
 */
public class ThucThiBaoTriController {
    private QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView;
    private NguoiDung nguoiDung;
    private KeHoachBaoTriDAO keHoachBaoTriDAO;
    private NghiepVuBaoTriTaiSanDAO nghiepVuBaoTriTaiSanDAO = new NghiepVuBaoTriTaiSanDAO();
    private NhiemVuBaoTriDAO nhiemVuBaoTriDAO;
    private NhiemVuHoanThanhDAO nhiemVuHoanThanhDAO;
    private HoanThanhBaoTriDAO hoanThanhBaoTriDAO;

    public QuanLyBaoTriTaiSanView getQuanLyBaoTriTaiSanView() {
        return quanLyBaoTriTaiSanView;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setQuanLyBaoTriTaiSanView(QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView) {
        this.quanLyBaoTriTaiSanView = quanLyBaoTriTaiSanView;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }
    
    
    
    public ThucThiBaoTriController(QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView, NguoiDung nguoiDung) {
        this.quanLyBaoTriTaiSanView = quanLyBaoTriTaiSanView;
        this.nguoiDung = nguoiDung;
        InitDAO();
    }
    
    private void InitDAO() {
        keHoachBaoTriDAO = new KeHoachBaoTriDAO();
        nghiepVuBaoTriTaiSanDAO = new NghiepVuBaoTriTaiSanDAO();
        nhiemVuBaoTriDAO = new NhiemVuBaoTriDAO();
        nhiemVuHoanThanhDAO = new NhiemVuHoanThanhDAO();
        hoanThanhBaoTriDAO = new HoanThanhBaoTriDAO();
    }
    
    public void navigateQuanLyBaoTriViewAndUpdateThucThiBaoTriTable() {
        quanLyBaoTriTaiSanView.setVisible(true);
        quanLyBaoTriTaiSanView.showTatCaKeHoachDangThucThibySQL();
    }
    
    public void navigateQuanLyBaoTriViewAndUpdateLichSuBaoTriTable() {
        quanLyBaoTriTaiSanView.setVisible(true);
        quanLyBaoTriTaiSanView.showAllKeHoachDaHoanThanhbySQL();
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
    
    public List<KeHoachBaoTri> getKeHoachDangThucThi() {
        List<KeHoachBaoTri> keHoachBaoTrisList = new ArrayList<>();
        try {
            keHoachBaoTrisList = keHoachBaoTriDAO.getAllKeHoachDangThucThi();
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
        return keHoachBaoTrisList;
    }
    
    public void updateSoLuongHoanThanh(NhiemVuHoanThanh nhiemVuHoanThanh) {
        try {
            nhiemVuHoanThanhDAO.updateNhiemVuHoanThanh(nhiemVuHoanThanh);
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public void updateDanhGiaNhiemVuBaoTri(NhiemVuBaoTri nhiemVuBaoTri) {
        try {
            nhiemVuBaoTriDAO.updateDanhGiaNhiemVuBaoTri(nhiemVuBaoTri);
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public boolean checkKeHoachBaoTriThucThiDayDu(KeHoachBaoTri keHoachBaoTri) {
        try {
            if(keHoachBaoTriDAO.checkKeHoachBaoTriThucThiDayDu(keHoachBaoTri)) { 
                return true;
            }
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
        return false;
    }
    
    public void hoanThanhBaoTri(HoanThanhBaoTri hoanThanhBaoTri) {
        try {
            hoanThanhBaoTriDAO.updateHoanThanhBaoTri(hoanThanhBaoTri);
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
}
