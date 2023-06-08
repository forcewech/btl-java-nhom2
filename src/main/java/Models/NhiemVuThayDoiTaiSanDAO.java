/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Models.TaiSan;
import Models.TaiSanDAO;
import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author IT SUP
 */
public class NhiemVuThayDoiTaiSanDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(NhiemVuThayDoiTaiSan nvtdts){
        try {
            String sSQL = """
                          insert NhiemVuThayDoiTaiSan(iD, iDKeHoachThayDoiTaiSan,tenNhiemVu, chiTietNhiemVu, tienDo)
                          values(?,?,?,?,?)""";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, nvtdts.getiD());
            sttm.setString(2, nvtdts.getiDKeHoachThayDoiTaiSan());
            sttm.setString(3, nvtdts.getTenNhiemVu());            
            sttm.setString(4, nvtdts.getChiTietNhiemVu());    
            sttm.setString(5, nvtdts.getTienDo());
            if(sttm.executeUpdate()>0){
                System.out.println("insert thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(NhiemVuThayDoiTaiSan nvtdts){
        try {
            String sSQL = "update NhiemVuThayDoiTaiSan set iDKeHoachThayDoiTaiSan=?, tenNhiemVu=?, chiTietNhiemVu=?, tienDo=? where iD=?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, nvtdts.getiDKeHoachThayDoiTaiSan());
            sttm.setString(2, nvtdts.getTenNhiemVu());
            sttm.setString(3, nvtdts.getChiTietNhiemVu());
            sttm.setString(4, nvtdts.getTienDo());
            sttm.setString(5, nvtdts.getiD());
            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int delete(String iD){
        try {
            String sSQL = "delete NhiemVuThayDoiTaiSan where iD=?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);   
            sttm.setString(1, iD);
            if(sttm.executeUpdate()>0){
                System.out.println("delete thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<NhiemVuThayDoiTaiSan> getAll(){
        List<NhiemVuThayDoiTaiSan> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from NhiemVuThayDoiTaiSan";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                NhiemVuThayDoiTaiSan nvtdts = new NhiemVuThayDoiTaiSan();
                nvtdts.setiD(rs.getString(1));
                nvtdts.setiDKeHoachThayDoiTaiSan(rs.getString(2));
                nvtdts.setTenNhiemVu(rs.getString(3));
                nvtdts.setChiTietNhiemVu(rs.getString(4));
                nvtdts.setTienDo(rs.getString(5));
                ls.add(nvtdts);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } 
        finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e){
                
            }
        }
        return ls;
    } 
    
    public NhiemVuThayDoiTaiSan findNVTDTSByID(String iD){        
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from NhiemVuThayDoiTaiSan where iD='" + iD + "'";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                NhiemVuThayDoiTaiSan nvtdts = new NhiemVuThayDoiTaiSan();
                nvtdts.setiD(rs.getString(1));
                nvtdts.setiDKeHoachThayDoiTaiSan(rs.getString(2));
                nvtdts.setTenNhiemVu(rs.getString(3));
                nvtdts.setChiTietNhiemVu(rs.getString(4));
                nvtdts.setTienDo(rs.getString(5));
                return nvtdts;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } 
        finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e){
                
            }
        }
        return null;
    } 
    
    public List<NhiemVuThayDoiTaiSan> getNhiemVuThayDoiTaiSanByiDKeHoachThayDoiTaiSan(String iDKeHoachThayDoiTaiSan){
        List<NhiemVuThayDoiTaiSan> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        NhiemVuThayDoiTaiSanDAO nvtdtsDAO = new NhiemVuThayDoiTaiSanDAO();
        try {
            String sSQL = "select * from NhiemVuThayDoiTaiSan where iDKeHoachThayDoiTaiSan =" + "'" + iDKeHoachThayDoiTaiSan + "'";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                NhiemVuThayDoiTaiSan nvtdts = new NhiemVuThayDoiTaiSan();               
                nvtdts.setiD(rs.getString(1));
                nvtdts.setTenNhiemVu(rs.getString(3));
                nvtdts.setChiTietNhiemVu(rs.getString(4)); 
                nvtdts.setTienDo(rs.getString(5));
                ls.add(nvtdts);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } 
        finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e){
                
            }
        }
        return ls;
    }
    
}
