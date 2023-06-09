/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

/**
 *
 * @author IT SUP
 */
public class TaiSanDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(TaiSan ts){
        try {
            String sSQL = """
                          insert TaiSan(maTaiSan, tenTaiSan, soLuong, trangThai, hangSanXuat, ngayTrangBi, gia)
                          values(?,?,?,?,?,?,?)""";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, ts.getMaTaiSan());
            sttm.setString(2, ts.getTenTaiSan());
            sttm.setInt(3, ts.getSoLuong());
            sttm.setString(4, ts.getTrangThai());
            sttm.setString(5, ts.getHangSanXuat());
            sttm.setDate(6, Date.valueOf(ts.getNgayTrangBi()));
            sttm.setDouble(7, ts.getGia());  
            if(sttm.executeUpdate()>0){
                System.out.println("insert thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(TaiSan ts){
        try {
            String sSQL = "update TaiSan set tenTaiSan=?, soLuong=?, trangThai=?, hangSanXuat=?, ngayTrangBi=?, gia=? where maTaiSan=?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, ts.getTenTaiSan());
            sttm.setInt(2, ts.getSoLuong());
            sttm.setString(3, ts.getTrangThai());
            sttm.setString(4, ts.getHangSanXuat());           
            sttm.setDate(5, Date.valueOf(ts.getNgayTrangBi()));
            sttm.setDouble(6, ts.getGia());  
            sttm.setString(7, ts.getMaTaiSan());
            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int delete(String maTaiSan){
        try {
            String sSQL = "delete TaiSan where maTaiSan=?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);   
            sttm.setString(1, maTaiSan);
            if(sttm.executeUpdate()>0){
                System.out.println("delete thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<TaiSan> getAll(){
        List<TaiSan> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from TaiSan";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                TaiSan ts = new TaiSan();
                ts.setMaTaiSan(rs.getString(1));
                ts.setTenTaiSan(rs.getString(2));
                ts.setSoLuong(rs.getInt(3));
                ts.setTrangThai(rs.getString(4));
                ts.setHangSanXuat(rs.getString(5));
                ts.setNgayTrangBi(rs.getDate(6).toLocalDate());
                ts.setGia(rs.getDouble(7));
                ls.add(ts);
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
    
    public TaiSan findTSByID(String maTaiSan){        
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from TaiSan where maTaiSan='" + maTaiSan + "'";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                TaiSan ts = new TaiSan();
                ts.setMaTaiSan(rs.getString(1));
                ts.setTenTaiSan(rs.getString(2));
                ts.setSoLuong(rs.getInt(3));
                ts.setTrangThai(rs.getString(4));
                ts.setHangSanXuat(rs.getString(5));
                ts.setNgayTrangBi(rs.getDate(6).toLocalDate());
                ts.setGia(rs.getDouble(7));
                return ts;
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
