/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
                          insert BaoCao(ngayThucHien, phong, nguoiKiemKe, tenTaiSan, soLuong, ghiChu)
                          values(?,?,?,?,?,?)""";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setDate(1, Date.valueOf(bc.getNgayThucHien()));
            sttm.setString(2, bc.getPhong());
            sttm.setString(3, bc.getNguoiKiemKe());
            sttm.setString(4, bc.getTenTaiSan()); 
            sttm.setInt(5, bc.getSoLuong()); 
            sttm.setString(6, bc.getGhiChu());
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
            String sSQL = "update BaoCao set tenTaiSan=?, soLuong=?, ghiChu=? where ngayThucHien=? and phong=? and nguoiKiemKe=?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);            
            sttm.setString(1, bc.getTenTaiSan()); 
            sttm.setInt(2,  bc.getSoLuong()); 
            sttm.setString(3, bc.getGhiChu()); 
            sttm.setDate(4, Date.valueOf(bc.getNgayThucHien()));
            sttm.setString(5, bc.getPhong());
            sttm.setString(6, bc.getNguoiKiemKe());
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
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                BaoCao bc = new BaoCao();
                bc.setNgayThucHien(rs.getDate(1).toLocalDate());
                bc.setPhong(rs.getString(2));
                bc.setNguoiKiemKe(rs.getString(3));               
                bc.setTenTaiSan(rs.getString(4));
                bc.setSoLuong(rs.getInt(5));
                bc.setGhiChu(rs.getString(6));
                ls.add(bc);
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
    
    public List<BaoCao> findBCByNTH(LocalDate ngayThucHien){
        List<BaoCao> lbc = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from BaoCao where ngayThucHien =" + "'" + ngayThucHien + "'";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                BaoCao bc = new BaoCao();
                bc.setNgayThucHien(rs.getDate(1).toLocalDate());
                bc.setPhong(rs.getString(2));
                bc.setNguoiKiemKe(rs.getString(3));               
                bc.setTenTaiSan(rs.getString(4));
                bc.setSoLuong(rs.getInt(5));
                bc.setGhiChu(rs.getString(6));
                lbc.add(bc);
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
        return lbc;
    }
    
    public List<BaoCao> findBCByP(String phong){
        List<BaoCao> lbc = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from BaoCao where phong =" + "'" + phong + "'";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                BaoCao bc = new BaoCao();
                bc.setNgayThucHien(rs.getDate(1).toLocalDate());
                bc.setPhong(rs.getString(2));
                bc.setNguoiKiemKe(rs.getString(3));               
                bc.setTenTaiSan(rs.getString(4));
                bc.setSoLuong(rs.getInt(5));
                bc.setGhiChu(rs.getString(6));
                lbc.add(bc);
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
        return lbc;
    }
    
    public List<BaoCao> findBCByTTS(String tenTaiSan){
        List<BaoCao> lbc = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from BaoCao where tenTaiSan =" + "'" + tenTaiSan + "'";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                BaoCao bc = new BaoCao();
                bc.setNgayThucHien(rs.getDate(1).toLocalDate());
                bc.setPhong(rs.getString(2));
                bc.setNguoiKiemKe(rs.getString(3));               
                bc.setTenTaiSan(rs.getString(4));
                bc.setSoLuong(rs.getInt(5));
                bc.setGhiChu(rs.getString(6));
                lbc.add(bc);
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
        return lbc;
    }
    
    public BaoCao findBCByNgayPhongNguoi(LocalDate ngayThucHien, String phong, String nguoiKiemKe){        
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from BaoCao where ngayThucHien='" + ngayThucHien + "'" + "AND phong ='" + phong + "'" + "AND nguoiKiemKe ='" + nguoiKiemKe + "'";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                BaoCao bc = new BaoCao();
                bc.setNgayThucHien(rs.getDate(1).toLocalDate());
                bc.setPhong(rs.getString(2));
                bc.setNguoiKiemKe(rs.getString(3));
                bc.setTenTaiSan(rs.getString(4));
                bc.setSoLuong(rs.getInt(5));
                bc.setGhiChu(rs.getString(6));                  
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
