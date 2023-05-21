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
public class PhongKiemKeDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(PhongKiemKe pkk){
        try {
            String sSQL = """
                          insert PhongKiemKe(iD, iDKeHoachKiemKe, iDPhongMay)
                          values(?,?,?)""";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, pkk.getiD());
            sttm.setString(2, pkk.getiDKeHoachKiemKe());
            sttm.setString(3, pkk.getiDPhongMay());
            if(sttm.executeUpdate()>0){
                System.out.println("insert thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int update(PhongKiemKe pkk){
        try {
            String sSQL = "update PhongKiemKe set iDKeHoachKiemKe=?, iDPhongMay=? where iD=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setString(1, pkk.getiDKeHoachKiemKe());
            sttm.setString(2, pkk.getiDPhongMay());
            sttm.setString(3, pkk.getiD());
            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public int delete(PhongKiemKe pkk){
        try {
            String sSQL = "delete PhongKiemKe where iD=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);   
            sttm.setString(1, pkk.getiD());
            if(sttm.executeUpdate()>0){
                System.out.println("delete thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
    
    public List<PhongKiemKe> getAll(){
        List<PhongKiemKe> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from PhongKiemKe";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()){
                PhongKiemKe pkk = new PhongKiemKe();
                pkk.setiD(rs.getString(1));
                pkk.setiDKeHoachKiemKe(rs.getString(2));
                pkk.setiDPhongMay(rs.getString(3));
                ls.add(pkk);
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
