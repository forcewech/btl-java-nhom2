/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thinh
 */
public class NghiepVuBaoTriTaiSanDAO {
    Connection conn = null;
    PreparedStatement pttm = null;
    Statement sttm = null;
    
    // Lấy tài sản bảo trì theo nhiệm vụ bảo trì bao gồm thêm các thông tin của bảng tài sản phòng máy, phòng máy, tài sản
    public List<NghiepVuBaoTriTaiSan> getTSBT_TSPM_PM_TSbyiDNhiemVuBaoTri(String iDNhiemVuBaoTri) throws SQLException {
        List<NghiepVuBaoTriTaiSan> nghiepVuBaoTriTaiSansList = new ArrayList<>();
        
        String query = """
                       select TaiSanBaoTri.*, roomName, tenTaiSan
                       from TaiSanBaoTri join TaiSanPhongMay on TaiSanBaoTri.iDTaiSanPhongMay = TaiSanPhongMay.iD
                       join PhongMay on TaiSanPhongMay.iDPhongMay = PhongMay.roomId
                       join TaiSan on TaiSanPhongMay.iDTaiSan = TaiSan.maTaiSan
                       where iDNhiemVuBaoTri = '""" + iDNhiemVuBaoTri + "'";
        
        conn = Database.DatabaseHelper.getDBConnection();
        
        sttm = conn.createStatement();
        
        ResultSet result = sttm.executeQuery(query);
        
        while(result.next()) {
            NghiepVuBaoTriTaiSan nghiepVuBaoTriTaiSan = new NghiepVuBaoTriTaiSan();
            TaiSanBaoTri tsbt = new TaiSanBaoTri();
            tsbt.setiD(result.getString(1));
            tsbt.setiDNhiemVuBaoTri(result.getString(2));
            tsbt.setiDTaiSanPhongMay(result.getString(3));
            tsbt.setSoLuong(result.getInt(4));
            tsbt.setYeuCauBaoTri(result.getString(5));
            nghiepVuBaoTriTaiSan.setTaiSanBaoTri(tsbt);
            PhongMay phongMay = new PhongMay();
            phongMay.setTenPhong(result.getString(6));
            nghiepVuBaoTriTaiSan.setPhongMay(phongMay);
            TaiSan taiSan = new TaiSan();
            taiSan.setTenTaiSan(result.getString(7));
            nghiepVuBaoTriTaiSan.setTaiSan(taiSan);
            
            nghiepVuBaoTriTaiSansList.add(nghiepVuBaoTriTaiSan);
        }
        
        
        return nghiepVuBaoTriTaiSansList;
    }
    
    
}
