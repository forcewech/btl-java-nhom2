/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author IT SUP
 */
public class CapNhatTienDoDAO {
    public int update(CapNhatTienDo cntd){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update CapNhatTienDo set soLuongHoanThanh=? where iDTaiSanThayDoi=? and iDNhiemVuThayDoiTaiSan=? and iD=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL); 
            sttm.setInt(1, cntd.getSoLuongHoanThanh());
            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
}
