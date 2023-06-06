/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Models.TaiSan;
import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TaiSanPhongMayDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(TaiSan ts){
        try {
            String sSQL = "insert TaiSan(maTaiSan, tenTaiSan, soLuong) values(?,?,?)";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, ts.getMaTaiSan());
            sttm.setString(2, ts.getTenTaiSan());
            sttm.setDouble(3, ts.getSoLuong()); 
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
            String sSQL = "update TaiSan set tenTaiSan=?, soLuong=? where maTaiSan=?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, ts.getTenTaiSan());
            sttm.setDouble(2, ts.getSoLuong());
            sttm.setString(3, ts.getMaTaiSan());
            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int delete(TaiSan ts){
        try {
            String sSQL = "delete TaiSan where maTaiSan=?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);   
            sttm.setString(1, ts.getMaTaiSan());
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
                ts.setSoLuong((int) rs.getDouble(3));
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
    public List<TaiSanPhongMay> getTaiSanPhongMayByiDPhongMay(String iDPhongMay){
        List<TaiSanPhongMay> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from TaiSanPhongMay where iDPhongMay =" + "'" + iDPhongMay + "'";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                TaiSanPhongMay tspm = new TaiSanPhongMay();
                tspm.setiDTaiSan(rs.getString(2));
                tspm.setSoLuong(rs.getInt(4));
                ls.add(tspm);
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
                ts.setSoLuong((int) rs.getDouble(3));
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