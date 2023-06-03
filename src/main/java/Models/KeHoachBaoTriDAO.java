/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thinh
 */
public class KeHoachBaoTriDAO {
    Connection conn = null;
    PreparedStatement pttm = null;
    
    // Chỉ lấy những kế hoạch chưa được xác nhận bảo trì
    public List<KeHoachBaoTri> getAllKeHoachBaoTriChuaThucThi() throws SQLException{
        List<KeHoachBaoTri> listKHBT = new ArrayList<>();
        
        conn = DatabaseHelper.getDBConnection();
        
        String query = "select * from KeHoachBaoTri where trangThai = 0";
        
        Statement sttm = null;
        
        sttm = conn.createStatement();
        
        ResultSet result = sttm.executeQuery(query);
        
        while(result.next()) {
            KeHoachBaoTri khbt = new KeHoachBaoTri();
            khbt.setiD(result.getString(1));
            khbt.setThoiGianBatDau(result.getDate(2).toLocalDate());
            khbt.setThoiGianKetThuc(result.getDate(3).toLocalDate());
            khbt.setGhiChu(result.getString(4));
            khbt.setTrangThai(result.getBoolean(5));
            khbt.setAnhXacNhan(result.getString(6));
            
            listKHBT.add(khbt);
        }
        return listKHBT;
    }
    
    public List<KeHoachBaoTri> getAllKeHoachDangThucThi() throws SQLException{
        List<KeHoachBaoTri> listKHBT = new ArrayList<>();
        
        conn = DatabaseHelper.getDBConnection();
        
        String query = """
                       select KeHoachBaoTri.* from KeHoachBaoTri 
                       join HoanThanhBaoTri on KeHoachBaoTri.iD = HoanThanhBaoTri.iD
                       where trangThai = 1 and daHoanThanh = 0""";
        
        Statement sttm = null;
        
        sttm = conn.createStatement();
        
        ResultSet result = sttm.executeQuery(query);
        
        while(result.next()) {
            KeHoachBaoTri khbt = new KeHoachBaoTri();
            khbt.setiD(result.getString(1));
            khbt.setThoiGianBatDau(result.getDate(2).toLocalDate());
            khbt.setThoiGianKetThuc(result.getDate(3).toLocalDate());
            khbt.setGhiChu(result.getString(4));
            khbt.setTrangThai(result.getBoolean(5));
            khbt.setAnhXacNhan(result.getString(6));
            
            listKHBT.add(khbt);
        }
        return listKHBT;
    }
    
    public List<KeHoachBaoTri> getAllKeHoachDaHoanThanh() throws SQLException{
        List<KeHoachBaoTri> listKHBT = new ArrayList<>();
        
        conn = DatabaseHelper.getDBConnection();
        
        String query = """
                       select KeHoachBaoTri.* from KeHoachBaoTri 
                       join HoanThanhBaoTri on KeHoachBaoTri.iD = HoanThanhBaoTri.iD
                       where daHoanThanh = 1""";
        
        Statement sttm = null;
        
        sttm = conn.createStatement();
        
        ResultSet result = sttm.executeQuery(query);
        
        while(result.next()) {
            KeHoachBaoTri khbt = new KeHoachBaoTri();
            khbt.setiD(result.getString(1));
            khbt.setThoiGianBatDau(result.getDate(2).toLocalDate());
            khbt.setThoiGianKetThuc(result.getDate(3).toLocalDate());
            khbt.setGhiChu(result.getString(4));
            khbt.setTrangThai(result.getBoolean(5));
            khbt.setAnhXacNhan(result.getString(6));
            
            listKHBT.add(khbt);
        }
        return listKHBT;
    }
    
    public List<KeHoachBaoTri> getAllKeHoachBaoTri() throws SQLException{
        List<KeHoachBaoTri> listKHBT = new ArrayList<>();
        
        conn = DatabaseHelper.getDBConnection();
        
        String query = "select * from KeHoachBaoTri";
        
        Statement sttm = null;
        
        sttm = conn.createStatement();
        
        ResultSet result = sttm.executeQuery(query);
        
        while(result.next()) {
            KeHoachBaoTri khbt = new KeHoachBaoTri();
            khbt.setiD(result.getString(1));
            khbt.setThoiGianBatDau(result.getDate(2).toLocalDate());
            khbt.setThoiGianKetThuc(result.getDate(3).toLocalDate());
            khbt.setGhiChu(result.getString(4));
            khbt.setTrangThai(result.getBoolean(5));
            khbt.setAnhXacNhan(result.getString(6));
            
            listKHBT.add(khbt);
        }
        return listKHBT;
    }
    
    public int addKeHoachBaoTri(KeHoachBaoTri kehoach) throws SQLException{
        String addQuery = "insert into KeHoachBaoTri(iD, thoiGianBatDau, thoiGianKetThuc, ghiChu, trangThai, anhXacNhan) "
                + "values (?, ?, ?, ?, 0, ?)";

        conn = DatabaseHelper.getDBConnection();

        pttm = conn.prepareStatement(addQuery);

        pttm.setString(1, kehoach.getiD());
        pttm.setDate(2, Date.valueOf(kehoach.getThoiGianBatDau()));
        pttm.setDate(3, Date.valueOf(kehoach.getThoiGianKetThuc()));
        pttm.setString(4, kehoach.getGhiChu());
        pttm.setString(5, kehoach.getAnhXacNhan());
        if(pttm.executeUpdate() > 0) {
            System.out.println("Insert thành công");
            return 1;
        }
        return -1;
    }
    
    // Chỉ update những kế hoạch khi chưa update
    public int updateKeHoachBaoTri(KeHoachBaoTri kehoach) throws SQLException{
        
        if(checkTrangThai(kehoach.getiD())) {
            System.out.println("Ke hoach dang duoc thuc thi hoac da ket thuc");
            return -1;
        }
        
        String addQuery = "update KeHoachBaoTri set "
                + "thoiGianBatDau = ?, thoiGianKetThuc = ?, ghiChu = ?, anhXacNhan = ? where iD = ?";

        conn = DatabaseHelper.getDBConnection();

        pttm = conn.prepareStatement(addQuery);

        pttm.setString(5, kehoach.getiD());
        pttm.setDate(1, Date.valueOf(kehoach.getThoiGianBatDau()));
        pttm.setDate(2, Date.valueOf(kehoach.getThoiGianKetThuc()));
        pttm.setString(3, kehoach.getGhiChu());
        pttm.setString(4, kehoach.getAnhXacNhan());

        if(pttm.executeUpdate() > 0) {
            System.out.println("Update thành công");
            return 1;
        }
        return -1;
    }
    
    // Chỉ cho phép delete khi trạng thái là chưa thực ti 
    public int deleteKeHoachBaoTri(String iD) throws SQLException{
        
        if(checkTrangThai(iD)) {
            System.out.println("Ke hoach dang duoc thuc thi hoac da ket thuc");
            return -1;
        }
        
        String addQuery = "delete from KeHoachBaoTri where iD = ?";

        conn = DatabaseHelper.getDBConnection();

        pttm = conn.prepareStatement(addQuery);
        
        pttm.setString(1, iD);

        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete thành công");
            return 1;
        }
        
        return -1;
    }
    
    public int xacNhanThucThi(KeHoachBaoTri keHoachBaoTri) throws SQLException {
        String addQuery = "update KeHoachBaoTri set "
                + "trangThai = ?, anhXacNhan = ? where iD = ?";

        conn = DatabaseHelper.getDBConnection();

        pttm = conn.prepareStatement(addQuery);

        pttm.setBoolean(1, true);
        pttm.setString(2, keHoachBaoTri.getAnhXacNhan());
        pttm.setString(3, keHoachBaoTri.getiD());

        if(pttm.executeUpdate() > 0) {
            System.out.println("Update thành công");
            return 1;
        }
        return -1;
    }
    
    public boolean checkTrangThai(String iD) throws SQLException {
        
        conn = DatabaseHelper.getDBConnection();
        
        String query = "Select trangThai from KeHoachBaoTri where iD = " + "'" + iD + "'";
        
        Statement sttm = conn.createStatement();
        
        ResultSet result = sttm.executeQuery(query);

        result.next();
        return result.getBoolean(1);
    }
    
    public List<NhiemVuBaoTri> getListNhiemVuBaoTri(String iD) throws SQLException {
        List<NhiemVuBaoTri> listNV = new ArrayList<>();
        
        String query = "select * from KeHoachBaoTri join NhiemVuBaoTri on KeHoachBaoTri.iD = NhiemVubaoTri.iDKeHoachBaoTri where KeHoachBaoTri.iD = " + "'" + iD + "'";
        
        conn = DatabaseHelper.getDBConnection();
        Statement sttm = conn.createStatement();
        ResultSet result = sttm.executeQuery(query);
        
        while(result.next()) {
            NhiemVuBaoTri nvbt = new NhiemVuBaoTri();
            
            nvbt.setiD(result.getString(1));
            nvbt.setiDKeHoachBaoTri(result.getString(2));
            nvbt.setTenNhiemVu(result.getString(3));
            nvbt.setChiTietNhiemVu(result.getString(4));
            nvbt.setDanhGia(result.getString(5));
            
            listNV.add(nvbt);
        }
        result.close();
        return listNV;
    }
    
    public boolean checkKeHoachBaoTriThucThiDayDu(KeHoachBaoTri keHoachBaoTri) throws SQLException {
        conn = DatabaseHelper.getDBConnection();
        Statement sttm = conn.createStatement();
        
        String query = "select NhiemVubaoTri.iDKeHoachBaoTri from NhiemVubaoTri\n" +
            "where NhiemVubaoTri.iDKeHoachBaoTri = '" + keHoachBaoTri.getiD() + "'" + "\n" +
            "group by NhiemVubaoTri.iDKeHoachBaoTri\n" +
            "having COUNT(NhiemVuBaoTri.iDKeHoachBaoTri) = (select COUNT(NhiemVubaoTri.iDKeHoachBaoTri) as tong from NhiemVubaoTri\n" +
            "left join TaiSanBaoTri on TaiSanBaoTri.iDNhiemVuBaoTri = NhiemVubaoTri.iD\n" +
            "left join NhiemVuHoanThanh on TaiSanBaoTri.iD = NhiemVuHoanThanh.iD\n" +
            "where NhiemVubaoTri.iDKeHoachBaoTri = '" + keHoachBaoTri.getiD() + "'" + " and (TaiSanBaoTri.soLuong = NhiemVuHoanThanh.soLuongDaHoanThanh or TaiSanBaoTri.iD is null)\n" +
            "group by NhiemVubaoTri.iDKeHoachBaoTri)";
        
        ResultSet result = sttm.executeQuery(query);
        
        if(result.next()) {
            return true;
        }
        return false;
    }
}
