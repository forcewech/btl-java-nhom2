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
public class TaiSanPhongMayDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    
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

}

