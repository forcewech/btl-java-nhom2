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
public class DanhGiaBaoTriDAO {
    Connection conn;
    PreparedStatement pttm = null;
    Statement sttm = null;
    
    public List<DanhGiaBaoTri> getAllDanhGiaBaoTrisByiDNhiemVuBaoTri(String iDNhiemVuBaoTri) throws SQLException {
        String query = "select * from DanhGiaBaoTri where iDNhiemVuBaoTri = " + "'" + iDNhiemVuBaoTri + "'";
        conn = database.DatabaseHelper.getDBConnection();
        sttm = conn.createStatement();
        ResultSet result = sttm.executeQuery(query);
    
        ArrayList<DanhGiaBaoTri> DanhGiaBaoTriList = new ArrayList<>();
        while(result.next()) {
            DanhGiaBaoTri dgbt = new DanhGiaBaoTri();
            dgbt.setiD(result.getString(1));
            dgbt.setTieuDe(result.getString(2));
            dgbt.setiDNhiemVuBaoTri(result.getString(3));
            dgbt.setDanhGia(result.getInt(4));
            dgbt.setGhiChu(result.getString(5));
            DanhGiaBaoTriList.add(dgbt);
        }
        return DanhGiaBaoTriList;
    }
    
    public List<DanhGiaBaoTri> getAllDanhGiaBaoTrisByiDTieuDe(String iDTieuDe) throws SQLException {
        String query = "select * from DanhGiaBaoTri where tieuDe = " + "'" + iDTieuDe + "'";
        conn = database.DatabaseHelper.getDBConnection();
        sttm = conn.createStatement();
        ResultSet result = sttm.executeQuery(query);
    
        ArrayList<DanhGiaBaoTri> DanhGiaBaoTriList = new ArrayList<>();
        while(result.next()) {
            DanhGiaBaoTri dgbt = new DanhGiaBaoTri();
            dgbt.setiD(result.getString(1));
            dgbt.setTieuDe(result.getString(2));
            dgbt.setiDNhiemVuBaoTri(result.getString(3));
            dgbt.setDanhGia(result.getInt(4));
            dgbt.setGhiChu(result.getString(5));
            DanhGiaBaoTriList.add(dgbt);
        }
        return DanhGiaBaoTriList;
    }
    
    public List<DanhGiaBaoTri> getAllDanhGiaBaoTrisByDanhGia(int DanhGia) throws SQLException {
        String query = "select * from DanhGiaBaoTri where tieuDe = " + DanhGia;
        conn = database.DatabaseHelper.getDBConnection();
        sttm = conn.createStatement();
        ResultSet result = sttm.executeQuery(query);
    
        ArrayList<DanhGiaBaoTri> DanhGiaBaoTriList = new ArrayList<>();
        while(result.next()) {
            DanhGiaBaoTri dgbt = new DanhGiaBaoTri();
            dgbt.setiD(result.getString(1));
            dgbt.setTieuDe(result.getString(2));
            dgbt.setiDNhiemVuBaoTri(result.getString(3));
            dgbt.setDanhGia(result.getInt(4));
            dgbt.setGhiChu(result.getString(5));
            DanhGiaBaoTriList.add(dgbt);
        }
        return DanhGiaBaoTriList;
    }
    
    public int addOneDanhGiaBaoTri(DanhGiaBaoTri dgbt) throws SQLException {
        String query = "insert into DanhGiaBaoTri(iD, tieuDe, iDNhiemVuBaoTri, danhGia, ghiChu) values (?, ?, ?, ?, ?)";
        conn = database.DatabaseHelper.getDBConnection();
        pttm = conn.prepareStatement(query);
        pttm.setString(1, dgbt.getiD());
        pttm.setString(2, dgbt.getTieuDe());
        pttm.setString(3, dgbt.getiDNhiemVuBaoTri());
        pttm.setInt(4, dgbt.getDanhGia());
        pttm.setString(5, dgbt.getGhiChu());
        
        if(pttm.executeUpdate() > 0) {
            System.out.println("Insert DanhGiaBaoTri thanh cong");
            return 1;
        }
        return -1;
    }
    
    public int addMoreDanhGiaBaoTri(List<DanhGiaBaoTri> dgbtList) throws SQLException {
        StringBuilder query = new StringBuilder("insert into DanhGiaBaoTri(iD, tieuDe, iDNhiemVuBaoTri, danhGia, ghiChu) values ");
        
        ArrayList<DanhGiaBaoTri> dgbtArrayListList = (ArrayList<DanhGiaBaoTri>)dgbtList;
        
        for(int i=0; i<dgbtArrayListList.size(); i++) {
            query.append("(?, ?, ?, ?, ?),");
        }
        
        query.deleteCharAt(query.length() - 1);
        
        conn = database.DatabaseHelper.getDBConnection();
        pttm = conn.prepareStatement(query.toString());
        int numColumnInOneTable = 5;
        for(int i=0; i<dgbtArrayListList.size(); i++) {
            pttm.setString(i*numColumnInOneTable + 1, dgbtArrayListList.get(i).getiD());
            pttm.setString(i*numColumnInOneTable + 2, dgbtArrayListList.get(i).getTieuDe());
            pttm.setString(i*numColumnInOneTable + 3, dgbtArrayListList.get(i).getiDNhiemVuBaoTri());
            pttm.setInt(i*numColumnInOneTable + 4, dgbtArrayListList.get(i).getDanhGia());
            pttm.setString(i*numColumnInOneTable + 5, dgbtArrayListList.get(i).getGhiChu());
        }
        
        if(pttm.executeUpdate()> 0) {
            System.out.println("Insert DanhGiaBaoTri thanh cong");
            return 1;
        }
        return -1;
    }
    
    public int updateDanhGiaBaoTriByiD(DanhGiaBaoTri dgbt) throws SQLException {
        String query = "update DanhGiaBaoTri set danhGia = ?, ghiChu = ? where iD = ?";
        conn = database.DatabaseHelper.getDBConnection();
        pttm = conn.prepareStatement(query);
        pttm.setInt(1, dgbt.getDanhGia());
        pttm.setString(2, dgbt.getGhiChu());
        pttm.setString(3, dgbt.getiD());
        
        if(pttm.executeUpdate() > 0) {
            System.out.println("Update DanhGiaBaoTri thanh cong");
            return 1;
        }
        return -1;
    }
    
    
    public int delTaiSanBaoTriByID(String iD) throws SQLException {
        conn = database.DatabaseHelper.getDBConnection();
        
        String query = "delete from DanhGiaBaoTri where DanhGiaBaoTri.iD = ?";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, iD);
        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete DanhGiaBaoTri thanh cong");
            return 1;
        } 
        return -1;
    }
    
    public int delMoreTaiSanBaoTriByID(List<String> listID) throws SQLException {
        conn = database.DatabaseHelper.getDBConnection();
        
        StringBuilder query = new StringBuilder("delete from DanhGiaBaoTri where ");
        
        ArrayList<String> listIDArrayList = (ArrayList<String>) listID;
        
        listIDArrayList.forEach(iD -> {
            query.append("DanhGiaBaoTri.iD = ? OR ");
        });
        
        String queryString = query.substring(0, query.length() - 4);
        
        pttm = conn.prepareStatement(queryString);
        for(int i=1; i<=listIDArrayList.size(); i++) {
            pttm.setString(i, listIDArrayList.get(i - 1));
        }
        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete DanhGiaBaoTri thanh cong");
            return 1;
        } 
        return -1;
    }
    
    public int delTaiSanBaoTriByiDNhiemVuBaoTri(String iDNhiemVuBaoTri) throws SQLException {
        conn = database.DatabaseHelper.getDBConnection();
        
        String query = "delete from DanhGiaBaoTri where DanhGiaBaoTri.iDNhiemVuBaoTri = ?";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, iDNhiemVuBaoTri);
        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete DanhGiaBaoTri thanh cong");
            return 1;
        } 
        return -1;
    }
    
}
