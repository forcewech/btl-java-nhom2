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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class KeHoachMuonDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(KeHoachMuon khm){
        try {
            String sSQL = """
                          insert KeHoachMuon(id, thoiGianMuon, thoiGianSuDung, soPhong, tenNguoiMuon)
                          values(?,?,?,?,?)""";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, khm.getId());
            sttm.setDate(2, Date.valueOf(khm.getThoiGianMuon()));           
            sttm.setString(3, khm.getThoiGianSuDung()); 
            sttm.setString(4, khm.getSoPhong());
            sttm.setString(5, khm.getTenNguoiMuon());
            if(sttm.executeUpdate()>0){
                System.out.println("insert thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    public int delete(KeHoachMuon khm){
        try {
            String sSQL = "delete KeHoachMuon where iD = ?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, khm.getId());
            if(sttm.executeUpdate() < 0){
                System.out.println("Delete thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        return -1;
    }
    public int update(KeHoachMuon khm){
        try {
            String sSQL = "update KeHoachMuon set thoiGianMuon=?, thoiGianSuDung=?, soPhong=?, tenNguoiMuon=? where id=?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);            
            sttm.setDate(1, Date.valueOf(khm.getThoiGianMuon()));           
            sttm.setString(2, khm.getThoiGianSuDung()); 
            sttm.setString(3, khm.getSoPhong());
            sttm.setString(4, khm.getTenNguoiMuon());
            sttm.setString(5, khm.getId());
            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<KeHoachMuon> getAll(){
        List<KeHoachMuon> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from KeHoachMuon";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                KeHoachMuon khm = new KeHoachMuon();
                khm.setId(rs.getString(1));
                khm.setThoiGianMuon(rs.getDate(2).toLocalDate());
                khm.setThoiGianSuDung(rs.getString(3));
                khm.setSoPhong(rs.getString(4));
                khm.setTenNguoiMuon(rs.getString(5));
                ls.add(khm);
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
