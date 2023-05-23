/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class NguoiDungDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(NguoiDung nd){
        try {
            String sSQL = "insert ThongTinNguoiDung(userId,fullname,username,password,email,role) values(?,?,?,?,?,?)";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, nd.getMaNguoiDung());
            sttm.setString(2, nd.getHoTen());
            sttm.setString(3, nd.getTen());
            sttm.setString(4, nd.getMatKhau());
            sttm.setString(5, nd.getEmail());
            sttm.setString(6, nd.getRole());
            if(sttm.executeUpdate() < 0){
                System.out.println("Insert thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        return -1;
    }
    public int update(NguoiDung nd){
        try {
            String sSQL = "update ThongTinNguoiDung set fullname = ?, email=?, username=?, password=?, role=? where userId = ?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(6, nd.getMaNguoiDung());
            sttm.setString(1, nd.getHoTen());
            sttm.setString(3, nd.getTen());
            sttm.setString(4, nd.getMatKhau());
            sttm.setString(2, nd.getEmail());
            sttm.setString(5, nd.getRole());
            if(sttm.executeUpdate() < 0){
                System.out.println("Update thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        return -1;
    }
     public int delete(NguoiDung nd){
        try {
            String sSQL = "delete ThongTinNguoiDung where userId = ?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, nd.getMaNguoiDung());
            if(sttm.executeUpdate() < 0){
                System.out.println("Delete thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        return -1;
    }
     public List<NguoiDung> getAll(){
         List<NguoiDung> ls = new ArrayList<>();
         ResultSet rs = null;
         Statement sttm = null;
         try{
             String sSQL = "select * from ThongTinNguoiDung";
             conn = DatabaseHelper.getDBConnection();
             sttm = conn.createStatement();
             rs = sttm.executeQuery(sSQL);
             while(rs.next()){
                 NguoiDung nd = new NguoiDung();
                 nd.setMaNguoiDung(rs.getString(1));
                 nd.setHoTen(rs.getString(2));
                 nd.setTen(rs.getString(3));
                 nd.setEmail(rs.getString(4));
                 nd.setMatKhau(rs.getString(5));
                 nd.setRole(rs.getString(6));
                 ls.add(nd);
             }
         }catch(Exception e){
             System.out.println("Error: "+e.toString());
         }
         finally{
             try{
                 rs.close(); sttm.close();conn.close();
             }catch(Exception e){
                 System.out.println("Error: "+e.toString());
             }
         }
         return ls;
     }
     public NguoiDung findUserByID(String maNguoiDung){
         ResultSet rs = null;
         Statement sttm = null;
         try{
             String sSQL = "select * from ThongTinNguoiDung where userId = '"+maNguoiDung+"'";
             conn = DatabaseHelper.getDBConnection();
             sttm = conn.createStatement();
             rs = sttm.executeQuery(sSQL);
             while(rs.next()){
                 NguoiDung nd = new NguoiDung();
                 nd.setMaNguoiDung(rs.getString(1));
                 nd.setHoTen(rs.getString(2));
                 nd.setTen(rs.getString(3));
                 nd.setEmail(rs.getString(4));
                 nd.setMatKhau(rs.getString(5));
                 nd.setRole(rs.getString(6));
                 return nd;
             }
         }catch(Exception e){
             System.out.println("Error: "+e.toString());
         }
         finally{
             try{
                 rs.close(); sttm.close();conn.close();
             }catch(Exception e){
                 System.out.println("Error: "+e.toString());
             }
         }
         return null;
     }
}
