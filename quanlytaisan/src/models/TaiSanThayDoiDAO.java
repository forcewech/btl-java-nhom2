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
public class TaiSanThayDoiDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(TaiSanThayDoi tstd){
        try {
            String sSQL = """
                          insert TaiSanThayDoi(maTaiSan, iDTaiSanPhongMay, iDKeHoachThayDoiTaiSan, soLuong, trangThai)
                          values(?,?,?,?,?)""";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, tstd.getMaTaiSan());
            sttm.setString(2, tstd.getiDTaiSanPhongMay());
            sttm.setString(3, tstd.getiDKeHoachThayDoiTaiSan());
            sttm.setInt(3, tstd.getSoLuong());
            sttm.setString(4, tstd.getTrangThai());
            if(sttm.executeUpdate()>0){
                System.out.println("insert thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(TaiSanThayDoi tstd){
        try {
            String sSQL = "update TaiSanThayDoi set iDTaiSanPhongMay=?, iDKeHoachThayDoiTaiSan=?, soLuong=?, trangThai=? where maTaiSan=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, tstd.getiDTaiSanPhongMay());
            sttm.setString(2, tstd.getiDKeHoachThayDoiTaiSan());
            sttm.setInt(3, tstd.getSoLuong());
            sttm.setString(4, tstd.getTrangThai());
            sttm.setString(5, tstd.getMaTaiSan());
            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int delete(TaiSanThayDoi tstd){
        try {
            String sSQL = "delete TaiSanThayDoi where maTaiSan=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);   
            sttm.setString(1, tstd.getMaTaiSan());
            if(sttm.executeUpdate()>0){
                System.out.println("delete thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<TaiSanThayDoi> getAll(){
        List<TaiSanThayDoi> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from TaiSanThayDoi";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                TaiSanThayDoi tstd = new TaiSanThayDoi();
                tstd.setMaTaiSan(rs.getString(1));
                tstd.setiDTaiSanPhongMay(rs.getString(2));
                tstd.setiDKeHoachThayDoiTaiSan(rs.getString(3));
                tstd.setSoLuong(rs.getInt(4));
                tstd.setTrangThai(rs.getString(5));
                ls.add(tstd);
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
