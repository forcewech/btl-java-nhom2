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
public class TaiSanBaoTriDAO {
    Connection conn;
    PreparedStatement pttm = null;
    Statement sttm = null;
    
    public List<TaiSanBaoTri> getAllTaiSanBaoTrisByiDNhiemVuBaoTri(String iDNhiemVuBaoTri) throws SQLException {
        String query = "select * from TaiSanBaoTri where iDNhiemVuBaoTri = " + "'" + iDNhiemVuBaoTri + "'";
        conn = Database.DatabaseHelper.getDBConnection();
        sttm = conn.createStatement();
        ResultSet result = sttm.executeQuery(query);
    
        ArrayList<TaiSanBaoTri> taiSanBaoTriList = new ArrayList<>();
        while(result.next()) {
            TaiSanBaoTri tsbt = new TaiSanBaoTri();
            tsbt.setiD(result.getString(1));
            tsbt.setiDNhiemVuBaoTri(result.getString(2));
            tsbt.setiDTaiSanPhongMay(result.getString(3));
            tsbt.setSoLuong(result.getInt(4));
            tsbt.setYeuCauBaoTri(result.getString(5));
            taiSanBaoTriList.add(tsbt);
        }
        return taiSanBaoTriList;
    }
    
    public List<TaiSanBaoTri> getAllTaiSanBaoTrisByiDTaiSanPhongMay(String iDTaiSanPhongMay) throws SQLException {
        String query = "select * from TaiSanBaoTri where iDTaiSanPhongMay = " + "'" + iDTaiSanPhongMay + "'";
        conn = Database.DatabaseHelper.getDBConnection();
        sttm = conn.createStatement();
        ResultSet result = sttm.executeQuery(query);
    
        ArrayList<TaiSanBaoTri> taiSanBaoTriList = new ArrayList<>();
        while(result.next()) {
            TaiSanBaoTri tsbt = new TaiSanBaoTri();
            tsbt.setiD(result.getString(1));
            tsbt.setiDNhiemVuBaoTri(result.getString(2));
            tsbt.setiDTaiSanPhongMay(result.getString(3));
            tsbt.setSoLuong(result.getInt(4));
            tsbt.setYeuCauBaoTri(result.getString(5));
            taiSanBaoTriList.add(tsbt);
        }
        return taiSanBaoTriList;
    }
    
    public int addOneTaiSanBaoTri(TaiSanBaoTri tsbt) throws SQLException {
        String query = "insert into TaiSanBaoTri(iD, iDNhiemVuBaoTri, iDTaiSanPhongMay, soLuong, yeuCauBaoTri) values (?, ?, ?, ?, ?)";
        conn = Database.DatabaseHelper.getDBConnection();
        pttm = conn.prepareStatement(query);
        pttm.setString(1, tsbt.getiD());
        pttm.setString(2, tsbt.getiDNhiemVuBaoTri());
        pttm.setString(3, tsbt.getiDTaiSanPhongMay());
        pttm.setInt(4, tsbt.getSoLuong());
        pttm.setString(5, tsbt.getYeuCauBaoTri());
        
        if(pttm.executeUpdate() > 0) {
            System.out.println("Insert thanh cong");
            return 1;
        }
        return -1;
    }
    
    public int addMoreTaiSanBaoTri(List<TaiSanBaoTri> tsbt) throws SQLException {
        StringBuilder query = new StringBuilder("insert into TaiSanBaoTri(iD, iDNhiemVuBaoTri, iDTaiSanPhongMay, soLuong, yeuCauBaoTri) values ");
        
        ArrayList<TaiSanBaoTri> tsbtList = (ArrayList<TaiSanBaoTri>)tsbt;
        
        for(int i=0; i<tsbtList.size(); i++) {
            query.append("(?, ?, ?, ?, ?),");
        }
        
        query.deleteCharAt(query.length() - 1);
        
        conn = Database.DatabaseHelper.getDBConnection();
        pttm = conn.prepareStatement(query.toString());
        int numColumnInOneTable = 5;
        for(int i=0; i<tsbtList.size(); i++) {
            pttm.setString(i*numColumnInOneTable + 1, tsbt.get(i).getiD());
            pttm.setString(i*numColumnInOneTable + 2, tsbt.get(i).getiDNhiemVuBaoTri());
            pttm.setString(i*numColumnInOneTable + 3, tsbt.get(i).getiDTaiSanPhongMay());
            pttm.setInt(i*numColumnInOneTable + 4, tsbt.get(i).getSoLuong());
            pttm.setString(i*numColumnInOneTable + 5, tsbt.get(i).getYeuCauBaoTri());
        }
        
        if(pttm.executeUpdate()> 0) {
            System.out.println("Insert thanh cong");
            return 1;
        }
        return -1;
    }
    
    public int updateTaiSanBaoTri(TaiSanBaoTri tsbt) throws SQLException {
        String query = "update TaiSanBaoTri set soLuong = ?, yeuCauBaoTri = ? where iD = ?";
        conn = Database.DatabaseHelper.getDBConnection();
        pttm = conn.prepareStatement(query);
        pttm.setInt(1, tsbt.getSoLuong());
        pttm.setString(2, tsbt.getYeuCauBaoTri());
        pttm.setString(3, tsbt.getiD());
        
        if(pttm.executeUpdate() > 0) {
            System.out.println("Update TaiSanBaoTri thanh cong");
            return 1;
        }
        return -1;
    }
    
    
    public int delTaiSanBaoTriByID(String iD) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        
        String query = "delete from TaiSanBaoTri where TaiSanBaoTri.iD = ?";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, iD);
        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete TaiSanBaoTri thanh cong");
            return 1;
        } 
        return -1;
    }
    
    public int delMoreTaiSanBaoTriByID(List<String> listID) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        
        StringBuilder query = new StringBuilder("delete from TaiSanBaoTri where ");
        
        ArrayList<String> listIDArrayList = (ArrayList<String>) listID;
        
        listIDArrayList.forEach(iD -> {
            query.append("TaiSanBaoTri.iD = ? OR ");
        });
        
        
        String queryString = query.substring(0, query.length() - 4);
        
        pttm = conn.prepareStatement(queryString);
        for(int i=1; i<=listIDArrayList.size(); i++) {
            pttm.setString(i, listIDArrayList.get(i - 1));
        }
        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete TaiSanBaoTri thanh cong");
            return 1;
        } 
        return -1;
    }
    
    public int delTaiSanBaoTriByiDNhiemVuBaoTri(String iDNhiemVuBaoTri) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        
        String query = "delete from TaiSanBaoTri where TaiSanBaoTri.iDNhiemVuBaoTri = ?";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, iDNhiemVuBaoTri);
        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete TaiSanBaoTri thanh cong");
            return 1;
        } 
        return -1;
    }
    
}
