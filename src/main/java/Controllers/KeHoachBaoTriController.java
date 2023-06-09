/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Interfaces.CheckRole;
import Interfaces.ErrorAuthen;
import Interfaces.ErrorDatabase;
import Interfaces.NotifyNormal;
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
import Models.TaiSanBaoTri;
import Models.TaiSanBaoTriDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ChiTietKeHoachBaoTriView;
import view.QuanLyBaoTriTaiSanView;
import view.TrangChuAdmin;

/**
 *
 * @author thinh
 */
public class KeHoachBaoTriController {
    private QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView;
    private TrangChuAdmin trangChuAdminView;
    private NguoiDung nguoiDung;
    private CheckRole checkRole;
    private KeHoachBaoTriDAO keHoachBaoTriDAO;
    private NhiemVuBaoTriDAO nhiemVuBaoTriDAO;
    private TaiSanBaoTriDAO taiSanBaoTriDAO;
    private NhiemVuHoanThanhDAO nhiemVuHoanThanhDAO;
    private ChiTietKeHoachBaoTriView chiTietKeHoachBaoTriView;
    private NghiepVuBaoTriTaiSanDAO nghiepVuBaoTriTaiSanDAO;
    private HoanThanhBaoTriDAO hoanThanhBaoTriDAO;

    public KeHoachBaoTriController(QuanLyBaoTriTaiSanView quanLyBaoTriTaiSanView, NguoiDung nguoiDung) {
        this.quanLyBaoTriTaiSanView = quanLyBaoTriTaiSanView;
        this.nguoiDung = nguoiDung;
        initDAO();
    }
    
    private void initDAO() {
        keHoachBaoTriDAO = new KeHoachBaoTriDAO();
        nhiemVuBaoTriDAO = new NhiemVuBaoTriDAO();
        taiSanBaoTriDAO = new TaiSanBaoTriDAO();
        nghiepVuBaoTriTaiSanDAO = new NghiepVuBaoTriTaiSanDAO();
        nhiemVuHoanThanhDAO = new NhiemVuHoanThanhDAO();
        hoanThanhBaoTriDAO = new HoanThanhBaoTriDAO();
    }
    
    // navigate đến các view
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
    
    public void navigateQuanLyBaoTriViewAndUpdateKeHoachBaotriTable() {
        quanLyBaoTriTaiSanView.setVisible(true);
        quanLyBaoTriTaiSanView.showTatCaKeHoachByDataSQL();
    }
    
    public void navigateQuanLyBaoTriViewAndUpdateKeHoachBaotriTable_ThucThiBaoTriTable() {
        quanLyBaoTriTaiSanView.setVisible(true);
        quanLyBaoTriTaiSanView.showTatCaKeHoachByDataSQL();
        quanLyBaoTriTaiSanView.showTatCaKeHoachDangThucThibySQL();
    }
    
    public void navigateChiTietKeHoachBaoTriViewAndUpdateThongTinChung() {
        chiTietKeHoachBaoTriView.setVisible(true);
        chiTietKeHoachBaoTriView.hienThiThongTinChung();
    }
    
    
    
    public String randomIDWith6Char() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
    
    
    
    
    // api thao tác dữ liệu
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
    
    public void deleteKeHoachBaoTri(KeHoachBaoTri keHoachBaoTri) {
        try {
            ArrayList<NhiemVuBaoTri> nhiemVuBaoTriList = (ArrayList<NhiemVuBaoTri>)nhiemVuBaoTriDAO.getAllNhiemVuBaoTriByiDKeHoachBaoTri(keHoachBaoTri.getiD());
            nhiemVuBaoTriList.forEach(nhiemVuBaoTri -> {
                try {
                    taiSanBaoTriDAO.delTaiSanBaoTriByiDNhiemVuBaoTri(nhiemVuBaoTri.getiD());
                } catch (SQLException ex) {
                    ErrorDatabase errorDatabase = new ErrorDatabase();
                    errorDatabase.HienThiThongBaoLoi(ex.getMessage());
                }
            });
            nhiemVuBaoTriDAO.delNhiemVuBaoTriByiDKeHoachBaoTri(keHoachBaoTri.getiD());
            hoanThanhBaoTriDAO.deleteHoanThanhBaoTriByIDKeHoachBaoTri(keHoachBaoTri);
            keHoachBaoTriDAO.deleteKeHoachBaoTri(keHoachBaoTri.getiD());
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public void addNhiemVuBaoTri(NhiemVuBaoTri nhiemVuBaoTri) {
        try {
            nhiemVuBaoTriDAO.addOneNhiemVuBaoTri(nhiemVuBaoTri);
            NotifyNormal notifyNormal = new NotifyNormal("Thêm nhiệm vụ bảo trì thành công");
            notifyNormal.showNotify();
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public void updateNhiemVuBaoTri(NhiemVuBaoTri nhiemVuBaoTri) {
        try {
            nhiemVuBaoTriDAO.updateNhiemVuBaoTri(nhiemVuBaoTri);
            NotifyNormal notifyNormal = new NotifyNormal("Update nhiệm vụ bảo trì thành công");
            notifyNormal.showNotify();
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public void deleteNhiemVuBaoTri(NhiemVuBaoTri nhiemVuBaoTri) {
        try {
            taiSanBaoTriDAO.delTaiSanBaoTriByiDNhiemVuBaoTri(nhiemVuBaoTri.getiD());
            nhiemVuBaoTriDAO.delNhiemVuBaoTriByID(nhiemVuBaoTri.getiD());
            NotifyNormal notifyNormal = new NotifyNormal("Delete nhiệm vụ bảo trì thành công");
            notifyNormal.showNotify();
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public void addTaiSanBaoTri(TaiSanBaoTri taiSanBaoTri) {
        try {
            taiSanBaoTriDAO.addOneTaiSanBaoTri(taiSanBaoTri);
            NotifyNormal notifyNormal = new NotifyNormal("Thêm tài sản bảo trì thành công");
            notifyNormal.showNotify();
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public void updateTaiSanBaotri(TaiSanBaoTri taiSanBaoTri) {
        try {
            taiSanBaoTriDAO.updateTaiSanBaoTri(taiSanBaoTri);
            NotifyNormal notifyNormal = new NotifyNormal("update tài sản bảo trì thành công");
            notifyNormal.showNotify();
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public void deleteTaiSanBaoTri(TaiSanBaoTri taiSanBaoTri) {
        try {
            taiSanBaoTriDAO.delTaiSanBaoTriByID(taiSanBaoTri.getiD());
            NotifyNormal notifyNormal = new NotifyNormal("Delete tài sản bảo trì thành công");
            notifyNormal.showNotify();
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public void addCompletedKeHoachBaoTri(KeHoachBaoTri keHoachBaoTri, List<NhiemVuBaoTri> nhiemVuBaoTrisList, List<TaiSanBaoTri> taiSanBaoTrisList) {
        try {
            HoanThanhBaoTri hoanThanhBaoTri = new HoanThanhBaoTri(keHoachBaoTri.getiD(), false, "");
            keHoachBaoTriDAO.addKeHoachBaoTri(keHoachBaoTri);
            hoanThanhBaoTriDAO.addHoanThanhBaoTri(hoanThanhBaoTri);
            nhiemVuBaoTriDAO.addMoreNhiemVuBaoTri(nhiemVuBaoTrisList);
            taiSanBaoTriDAO.addMoreTaiSanBaoTri(taiSanBaoTrisList);
            ArrayList<NhiemVuHoanThanh> nhiemVuHoanThanhsList = new ArrayList<>();
            taiSanBaoTrisList.forEach(taiSanBaoTri -> {
                nhiemVuHoanThanhsList.add(new NhiemVuHoanThanh(taiSanBaoTri.getiD(), 0, ""));
            });
            nhiemVuHoanThanhDAO.addMoreNhiemVuHoanThanh(nhiemVuHoanThanhsList);
            NotifyNormal notifyNormal = new NotifyNormal("Đã thêm kế hoạch bảo trì mới");
            notifyNormal.showNotify();
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public int xacNhanThucThiKeHoach(KeHoachBaoTri keHoachBaoTri) {
        try {
            keHoachBaoTriDAO.xacNhanThucThi(keHoachBaoTri);
            NotifyNormal notifyNormal = new NotifyNormal("Đã thêm kế hoạch vào quá trình thực thi");
            notifyNormal.showNotify();
            return 1;
        } catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
            return -1;
        }
    }
    
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

    public TrangChuAdmin getTrangChuAdminView() {
        return trangChuAdminView;
    }

    public void setTrangChuAdminView(TrangChuAdmin trangChuAdminView) {
        this.trangChuAdminView = trangChuAdminView;
    }
}
