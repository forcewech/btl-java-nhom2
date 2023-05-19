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
public class NhiemVuBaoTriDAO {
    PreparedStatement pttm = null;
    Statement sttm = null;
    Connection conn;
    
    public List<NhiemVuBaoTri> getAllNhiemVuBaoTriByiDKeHoachBaoTri(String iDKeHoachBaoTri) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        
        String query = "select * from NhiemVubaoTri join KeHoachBaoTri on NhiemVubaoTri.iD = KeHoachBaoTri.iD where KeHoachBaoTri.iD = " + "'" + iDKeHoachBaoTri + "'";
        
        sttm = conn.createStatement();
        ResultSet result = sttm.executeQuery(query);
        
        List<NhiemVuBaoTri> listNV = new ArrayList<>();
        
        while(result.next()) {
            NhiemVuBaoTri nvbt = new NhiemVuBaoTri();
            
            nvbt.setiD(result.getString(1));
            nvbt.setiDKeHoachBaoTri(result.getString(2));
            nvbt.setTenNhiemVu(result.getString(3));
            nvbt.setChiTietNhiemVu(result.getString(4));
            nvbt.setDanhGia(result.getString(5));
            nvbt.setChiPhi(result.getInt(6));
        }
        
        return listNV;
    }
    
    public int addOneNhiemVuBaoTri(NhiemVuBaoTri nhiemVuBaoTri) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        String query = "insert into NhiemVubaoTri(iD, iDKeHoachBaoTri, tenNhiemVu, chiTietNhiemVu, danhGia, chiPhi) values(?, ?, ?, ?, ?, ?)";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, nhiemVuBaoTri.getiD());
        pttm.setString(2, nhiemVuBaoTri.getiDKeHoachBaoTri());
        pttm.setString(3, nhiemVuBaoTri.getTenNhiemVu());
        pttm.setString(4, nhiemVuBaoTri.getChiTietNhiemVu());
        pttm.setString(5, nhiemVuBaoTri.getDanhGia());
        pttm.setInt(6, nhiemVuBaoTri.getChiPhi());
        if(pttm.executeUpdate() > 0) {
            System.out.println("Insert thanh cong");
            return 1;
        }
        return -1;
    }
    
    public int addMoreNhiemVuBaoTri(List<NhiemVuBaoTri> nhiemVuBaoTris) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        
        StringBuilder query = new StringBuilder("insert into NhiemVubaoTri(iD, iDKeHoachBaoTri, tenNhiemVu, chiTietNhiemVu, danhGia, chiPhi) values ");
        ArrayList<NhiemVuBaoTri> khbts = (ArrayList<NhiemVuBaoTri>) nhiemVuBaoTris;
        khbts.forEach(nhiemVuBaoTri -> {
            query.append("(?, ?, ?, ?, ?, ?),");
        });
        query.deleteCharAt(query.length() - 1);
        
        pttm = conn.prepareStatement(query.toString());
        
        // Khoảng cách các dấu hỏi
        int distance = 6;
        
        // Thêm các giá trị cho dãy truy vẫn
        for(int i=0; i<khbts.size(); i++) {
            NhiemVuBaoTri nhiemVuBaoTriChild = khbts.get(i);
            pttm.setString((i * distance) + 1, nhiemVuBaoTriChild.getiD());
            pttm.setString((i * distance) + 2, nhiemVuBaoTriChild.getiDKeHoachBaoTri());
            pttm.setString((i * distance) + 3, nhiemVuBaoTriChild.getTenNhiemVu());
            pttm.setString((i * distance) + 4, nhiemVuBaoTriChild.getChiTietNhiemVu());
            pttm.setString((i * distance) + 5, nhiemVuBaoTriChild.getDanhGia());
            pttm.setInt((i * distance) + 6, nhiemVuBaoTriChild.getChiPhi());
        }
        
        if(pttm.executeUpdate() > 0) {
            System.out.println("Insert thanh cong");
            return 1;
        }
        return -1;
    }
    
    public int updateNhiemVuBaoTri(NhiemVuBaoTri nhiemVuBaoTri) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        
        String query = "update NhiemVubaoTri set tenNhiemVu = ?, chiTietNhiemVu = ?, danhGia = ?, chiPhi = ? where iD = ?";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, nhiemVuBaoTri.getTenNhiemVu());
        pttm.setString(2, nhiemVuBaoTri.getChiTietNhiemVu());
        pttm.setString(3, nhiemVuBaoTri.getDanhGia());
        pttm.setInt(4, nhiemVuBaoTri.getChiPhi());
        pttm.setString(5, nhiemVuBaoTri.getiD());
        
        if(pttm.executeUpdate() > 0) {
            System.out.println("Update NhiemVuBaoTri thanh cong");
            return 1;
        }
        return -1;
    }
    
    public int delNhiemVuBaoTriByID(String iD) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        
        String query = "delete from NhiemVubaoTri where NhiemVubaoTri.iD = ?";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, iD);
        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete NhiemVuBaoTri thanh cong");
            return 1;
        } 
        return -1;
    }
    
    public int delMoreNhiemVuBaoTriByID(List<String> listID) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        
        StringBuilder query = new StringBuilder("delete from NhiemVubaoTri where ");
        
        ArrayList<String> listIDArrayList = (ArrayList<String>) listID;
        
        listIDArrayList.forEach(iD -> {
            query.append("NhiemVubaoTri.iD = ? OR ");
        });
        
        
        String queryString = query.substring(0, query.length() - 4);
        
        pttm = conn.prepareStatement(queryString);
        for(int i=1; i<=listIDArrayList.size(); i++) {
            pttm.setString(i, listIDArrayList.get(i - 1));
        }
        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete NhiemVuBaoTri thanh cong");
            return 1;
        } 
        return -1;
    }
    
    public int delNhiemVuBaoTriByiDKeHoachBaoTri(String iDKeHoachBaoTri) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        
        String query = "delete from NhiemVubaoTri where NhiemVubaoTri.iDKeHoachBaoTri = ?";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, iDKeHoachBaoTri);
        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete NhiemVuBaoTri thanh cong");
            return 1;
        } 
        return -1;
    }
    
}
