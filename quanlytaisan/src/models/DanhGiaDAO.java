/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author IT SUP
 */
public class DanhGiaDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(DanhGia dg){
        try {
            String sSQL = """
                          insert DanhGia(maPhieu, danhGia)
                          values(?,?)""";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, dg.getMaPhieu());
            sttm.setString(2, dg.getDanhGia());             
            if(sttm.executeUpdate()>0){
                System.out.println("insert thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(DanhGia dg){
        try {
            String sSQL = "update DanhGia set danhGia=?, where maPhieu=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, dg.getDanhGia());
            sttm.setString(2, dg.getMaPhieu());           
            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public DanhGia findTSByID(String maPhieu){        
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from DanhGia where maPhieu='" + maPhieu + "'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                DanhGia dg = new DanhGia();
                dg.setMaPhieu(rs.getString(1));
                dg.setDanhGia(rs.getString(2));              
                return dg;
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
