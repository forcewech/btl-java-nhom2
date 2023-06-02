/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author admin
 */
public class TaiSanPhongMayDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(TaiSanPhongMay tspm){
        try {
            String sSQL = "insert TaiSanPhongMay(iD,iDTaiSan,iDPhongMay,soLuong) values(?,?,?,?)";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, tspm.getMaTaiSanPM());
            sttm.setString(2, tspm.getMaTaiSan());
            sttm.setString(3, tspm.getMaPhongMay());
            sttm.setDouble(4, tspm.getSoLuong());
            if(sttm.executeUpdate() < 0){
                System.out.println("Insert thanh cong");
                return 1;
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        return -1;
    }
}
