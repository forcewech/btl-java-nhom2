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
public class PhongMayDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(PhongMay pm){
        try {
            String sSQL = "insert PhongMay(roomId,roomName,state,isBorrow) values(?,?,?,?)";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, pm.getMaPhong());
            sttm.setString(2, pm.getTenPhong());
            sttm.setString(3, pm.getTrangThai());
            sttm.setBoolean(4,pm.isIsBorrow());
            if(sttm.executeUpdate() < 0){
                System.out.println("Insert thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        return -1;
    }
    public int update(PhongMay pm){
        try {
            String sSQL = "update PhongMay set roomName=?, state=?, isBorrow=? where roomId = ?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);
          
            sttm.setString(1, pm.getTenPhong());
            sttm.setString(2, pm.getTrangThai());
            sttm.setBoolean(3,pm.isIsBorrow());
            sttm.setString(4, pm.getMaPhong());
            if(sttm.executeUpdate() < 0){
                System.out.println("Update thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        return -1;
    }
     public int delete(PhongMay pm){
        try {
            String sSQL = "delete PhongMay where roomId = ?";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, pm.getMaPhong());
            if(sttm.executeUpdate() < 0){
                System.out.println("Delete thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        return -1;
    }
     public List<PhongMay> getAll(){
         List<PhongMay> ls = new ArrayList<>();
         ResultSet rs = null;
         Statement sttm = null;
         try{
             String sSQL = "select * from PhongMay";
             conn = DatabaseHelper.getDBConnection();
             sttm = conn.createStatement();
             rs = sttm.executeQuery(sSQL);
             while(rs.next()){
                 PhongMay pm = new PhongMay();
                 pm.setMaPhong(rs.getString(1));
                 pm.setTenPhong(rs.getString(2));
                 pm.setTrangThai(rs.getString(3));
                 pm.setIsBorrow(rs.getBoolean(4));
                 ls.add(pm);
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
     public PhongMay findRoomByID(String maPhong){
         ResultSet rs = null;
         Statement sttm = null;
         try{
             String sSQL = "select * from PhongMay where roomId = '"+maPhong+"'";
             conn = DatabaseHelper.getDBConnection();
             sttm = conn.createStatement();
             rs = sttm.executeQuery(sSQL);
             while(rs.next()){
                 PhongMay pm = new PhongMay();
                 pm.setMaPhong(rs.getString(1));
                 pm.setTenPhong(rs.getString(2));
                 pm.setTrangThai(rs.getString(3));
                 pm.setIsBorrow(rs.getBoolean(4));
                 return pm;
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
