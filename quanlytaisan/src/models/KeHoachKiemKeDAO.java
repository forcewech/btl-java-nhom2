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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IT SUP
 */
public class KeHoachKiemKeDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(KeHoachKiemKe khkk){
        try {
            String sSQL = """
                          insert KeHoachKiemKe(maTaiSan, thoiGianBatDau, thoiGianKetThuc)
                          values(?,?,?)""";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, khkk.getMaKeHoach());
            sttm.setString(2, khkk.getThoiGianBatDau());           
            sttm.setString(3, khkk.getThoiGianKetThuc());  
            if(sttm.executeUpdate()>0){
                System.out.println("insert thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(KeHoachKiemKe khkk){
        try {
            String sSQL = "update KeHoachKiemKe set thoiGianBatDau=?, thoiGianKetThuc=? where maKeHoach=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, khkk.getMaKeHoach());
            sttm.setString(2, khkk.getThoiGianBatDau());
            sttm.setString(3, khkk.getThoiGianKetThuc());
            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<KeHoachKiemKe> getAll(){
        List<KeHoachKiemKe> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from KeHoachKiemKe";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                KeHoachKiemKe khkk = new KeHoachKiemKe();
                khkk.setMaKeHoach(rs.getString(1));
                khkk.setThoiGianBatDau(rs.getString(2));
                khkk.setThoiGianKetThuc(rs.getString(3));
                ls.add(khkk);
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
    
    public KeHoachKiemKe findTSByID(String maKeHoach){        
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from KeHoachKiemKe where maKeHoach='" + maKeHoach + "'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                KeHoachKiemKe khkk = new KeHoachKiemKe();
                khkk.setMaKeHoach(rs.getString(1));
                khkk.setThoiGianBatDau(rs.getString(2));
                khkk.setThoiGianKetThuc(rs.getString(3));             
                return khkk;
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
