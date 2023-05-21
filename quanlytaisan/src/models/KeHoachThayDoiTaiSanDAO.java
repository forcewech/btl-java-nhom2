/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.DatabaseHelper;
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
public class KeHoachThayDoiTaiSanDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(KeHoachThayDoiTaiSan khtdts){
        try {
            String sSQL = """
                          insert KeHoachThayDoiTaiSan(maKeHoach, thoiGianBatDau, thoiGianKetThuc)
                          values(?,?,?,?,?)""";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, khtdts.getMaKeHoach());
            sttm.setString(2, khtdts.getThoiGianBatDau());
            sttm.setString(3, khtdts.getThoiGianKetThuc()); 
            if(sttm.executeUpdate()>0){
                System.out.println("insert thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(KeHoachThayDoiTaiSan khtdts){
        try {
            String sSQL = "update KeHoachThayDoiTaiSan set thoiGianBatDau=?, thoiGianKetThuc=? where maKeHoach=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, khtdts.getThoiGianBatDau());
            sttm.setString(2, khtdts.getThoiGianKetThuc());
            sttm.setString(3, khtdts.getMaKeHoach());
            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int delete(KeHoachThayDoiTaiSan khtdts){
        try {
            String sSQL = "delete KeHoachThayDoiTaiSan where maKeHoach=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);   
            sttm.setString(1, khtdts.getMaKeHoach());
            if(sttm.executeUpdate()>0){
                System.out.println("delete thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<KeHoachThayDoiTaiSan> getAll(){
        List<KeHoachThayDoiTaiSan> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from KeHoachThayDoiTaiSan";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                KeHoachThayDoiTaiSan khtdts = new KeHoachThayDoiTaiSan();
                khtdts.setMaKeHoach(rs.getString(1));
                khtdts.setThoiGianBatDau(rs.getString(2));
                khtdts.setThoiGianKetThuc(rs.getString(3));
                ls.add(khtdts);
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
    
    public KeHoachThayDoiTaiSan findTSByID(String maKeHoach){        
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from KeHoachThayDoiTaiSan where maKeHoach='" + maKeHoach + "'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                KeHoachThayDoiTaiSan khtdts = new KeHoachThayDoiTaiSan();
                khtdts.setMaKeHoach(rs.getString(1));
                khtdts.setThoiGianBatDau(rs.getString(2));
                khtdts.setThoiGianKetThuc(rs.getString(3));
                return khtdts;
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
}
