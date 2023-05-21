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
public class BaoCaoDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(BaoCao bc){
        try {
            String sSQL = """
                          insert BaoCao(maBaoCao, nguoiKiemKe, ngayThucHien, loaiKiemKe)
                          values(?,?,?,?)""";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, bc.getMaBaoCao());
            sttm.setString(2, bc.getNguoiKiemKe());
            sttm.setString(3, bc.getNgayThucHien());
            sttm.setString(4, bc.getLoaiKiemKe()); 
            if(sttm.executeUpdate()>0){
                System.out.println("insert thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(BaoCao bc){
        try {
            String sSQL = "update BaoCao set nguoiKiemKe=?, ngayThucHien=?, loaiKiemKe where maBaoCao=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, bc.getNguoiKiemKe());
            sttm.setString(2, bc.getNgayThucHien());
            sttm.setString(3, bc.getLoaiKiemKe());
            sttm.setString(4, bc.getMaBaoCao());           
            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }      
    
    public List<BaoCao> getAll(){
        List<BaoCao> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from BaoCao";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                BaoCao bc = new BaoCao();
                bc.setMaBaoCao(rs.getString(1));
                bc.setNguoiKiemKe(rs.getString(2));
                bc.setNgayThucHien(rs.getString(3));
                bc.setLoaiKiemKe(rs.getString(4));               
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
    
    public BaoCao findTSByID(String maBaoCao){        
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from BaoCao where maBaoCao='" + maBaoCao + "'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                BaoCao bc = new BaoCao();
                bc.setMaBaoCao(rs.getString(1));
                bc.setNguoiKiemKe(rs.getString(2));
                bc.setNgayThucHien(rs.getString(3));
                bc.setLoaiKiemKe(rs.getString(4));           
                return bc;
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
