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
public class NhiemVuHoanThanhDAO {
    Connection conn;
    PreparedStatement pttm = null;
    Statement sttm = null;
    
    public NhiemVuHoanThanh getNhiemVuHoanThanhsByiD(String iD) throws SQLException {
        String query = "select * from NhiemVuHoanThanh where iD = " + "'" + iD + "'";
        conn = Database.DatabaseHelper.getDBConnection();
        sttm = conn.createStatement();
        ResultSet result = sttm.executeQuery(query);
        result.next();
        NhiemVuHoanThanh nvht = new NhiemVuHoanThanh();
        nvht.setiD(result.getString(1));
        nvht.setSoLuongDaHoanThanh(result.getInt(2));
        nvht.setDanhGiaNhiemVu(result.getString(3));
        return nvht;
    }
    
    public int addNhiemVuHoanThanh(NhiemVuHoanThanh nvht) throws SQLException {
        String query = "insert into NhiemVuHoanThanh(iD, soLuongDaHoanThanh, danhGiaNhiemVu) values (?, ?, ?)";
        conn = Database.DatabaseHelper.getDBConnection();
        pttm = conn.prepareStatement(query);
        pttm.setString(1, nvht.getiD());
        pttm.setInt(2, nvht.getSoLuongDaHoanThanh());
        pttm.setString(3, nvht.getDanhGiaNhiemVu());
        
        if(pttm.executeUpdate() > 0) {
            System.out.println("Insert NhiemVuHoanThanh thanh cong");
            return 1;
        }
        return -1;
    }
    
     public int addMoreNhiemVuHoanThanh(List<NhiemVuHoanThanh> nvht) throws SQLException {
        StringBuilder query = new StringBuilder("insert into NhiemVuHoanThanh(iD, soLuongDaHoanThanh, danhGiaNhiemVu) values ");
        
        ArrayList<NhiemVuHoanThanh> nvhtList = (ArrayList<NhiemVuHoanThanh>)nvht;
        
        if(!nvht.isEmpty()) {
            for (NhiemVuHoanThanh nvhtChild : nvhtList) {
                query.append("(?, ?, ?),");
            }

            query.deleteCharAt(query.length() - 1);

            conn = Database.DatabaseHelper.getDBConnection();
            pttm = conn.prepareStatement(query.toString());
            int numColumnInOneTable = 3;
            for(int i=0; i<nvhtList.size(); i++) {
                pttm.setString(i*numColumnInOneTable + 1, nvhtList.get(i).getiD());
                pttm.setInt(i*numColumnInOneTable + 2, nvhtList.get(i).getSoLuongDaHoanThanh());
                pttm.setString(i*numColumnInOneTable + 3, nvhtList.get(i).getDanhGiaNhiemVu());
            }

            if(pttm.executeUpdate()> 0) {
                System.out.println("Insert thanh cong");
                return 1;
            }
        }
        return -1;
    }
    
    public int updateNhiemVuHoanThanh(NhiemVuHoanThanh nvht) throws SQLException {
        String query = "update NhiemVuHoanThanh set soLuongDaHoanThanh = ?, danhGiaNhiemVu = ? where iD = ?";
        conn = Database.DatabaseHelper.getDBConnection();
        pttm = conn.prepareStatement(query);
        pttm.setInt(1, nvht.getSoLuongDaHoanThanh());
        pttm.setString(2, nvht.getDanhGiaNhiemVu());
        pttm.setString(3, nvht.getiD());
        
        if(pttm.executeUpdate() > 0) {
            System.out.println("Update NhiemVuHoanThanh thanh cong");
            return 1;
        }
        return -1;
    }
    
    
    public int delNhiemVuHoanThanhByID(String iD) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        
        String query = "delete from NhiemVuHoanThanh where NhiemVuHoanThanh.iD = ?";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, iD);
        if(pttm.executeUpdate() > 0) {
            System.out.println("Delete NhiemVuHoanThanh thanh cong");
            return 1;
        } 
        return -1;
    }
}
