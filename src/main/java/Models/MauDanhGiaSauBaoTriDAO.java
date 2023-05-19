/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thinh
 */
public class MauDanhGiaSauBaoTriDAO {
    Connection conn;
    PreparedStatement pttm = null;
    Statement sttm = null;
    
    public List<MauDanhGiaSauBaoTri> getAllMauDanhGiaSauBaoTris() throws SQLException {
        String query = "select * from MauDanhGiaSauBaoTri";
        conn = Database.DatabaseHelper.getDBConnection();
        sttm = conn.createStatement();
        ResultSet result = sttm.executeQuery(query);
    
        ArrayList<MauDanhGiaSauBaoTri> mauDanhGiaSauBaoTriList = new ArrayList<>();
        while(result.next()) {
            MauDanhGiaSauBaoTri mdgsbt = new MauDanhGiaSauBaoTri();
            mdgsbt.setiD(result.getString(1));
            mdgsbt.setTieuDe(result.getString(2));
            mauDanhGiaSauBaoTriList.add(mdgsbt);
        }
        return mauDanhGiaSauBaoTriList;
    }
    
    public int addOneMauDanhGiaSauBaoTri(MauDanhGiaSauBaoTri mdgsbt) throws SQLException {
        String query = "insert into MauDanhGiaSauBaoTri(iD, tieuDe) values (?, ?)";
        conn = Database.DatabaseHelper.getDBConnection();
        pttm = conn.prepareStatement(query);
        pttm.setString(1, mdgsbt.getiD());
        pttm.setString(2, mdgsbt.getTieuDe());
        
        if(pttm.executeUpdate() > 0) {
            System.out.println("Insert MauDanhGiaSauBaoTri thanh cong");
            return 1;
        }
        return -1;
    }
    
    public int addMoreMauDanhGiaSauBaoTri(List<MauDanhGiaSauBaoTri> mdgsbtList) throws SQLException {
        StringBuilder query = new StringBuilder("insert into MauDanhGiaSauBaoTri(iD, tieuDe) values ");
        
        ArrayList<MauDanhGiaSauBaoTri> mdgsbtArrayList = (ArrayList<MauDanhGiaSauBaoTri>)mdgsbtList;
        
        for(int i=0; i<mdgsbtArrayList.size(); i++) {
            query.append("(?, ?),");
        }
        
        query.deleteCharAt(query.length() - 1);
        
        conn = Database.DatabaseHelper.getDBConnection();
        pttm = conn.prepareStatement(query.toString());
        int numColumnInOneTable = 2;
        for(int i=0; i<mdgsbtArrayList.size(); i++) {
            pttm.setString(i*numColumnInOneTable + 1, mdgsbtArrayList.get(i).getiD());
            pttm.setString(i*numColumnInOneTable + 2, mdgsbtArrayList.get(i).getTieuDe());
        }
        
        if(pttm.executeUpdate()> 0) {
            System.out.println("Insert MauDanhGiaSauBaoTri thanh cong");
            return 1;
        }
        return -1;
    }
    
    public int updateMauDanhGiaSauBaoTri(MauDanhGiaSauBaoTri mdgsbt) throws SQLException {
        String query = "update MauDanhGiaSauBaoTri set tieuDe = ? where iD = ?";
        conn = Database.DatabaseHelper.getDBConnection();
        pttm = conn.prepareStatement(query);
        pttm.setString(1, mdgsbt.getTieuDe());
        pttm.setString(2, mdgsbt.getiD());
        
        if(pttm.executeUpdate() > 0) {
            System.out.println("Update MauDanhGiaSauBaoTri thanh cong");
            return 1;
        }
        return -1;
    }
    
    
    public int delMauDanhGiaSauBaoTribyID(String iD) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        
        String query = "delete from MauDanhGiaSauBaoTri where MauDanhGiaSauBaoTri.iD = ?";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, iD);
        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete MauDanhGiaSauBaoTri thanh cong");
            return 1;
        } 
        return -1;
    }
}
