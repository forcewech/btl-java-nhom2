/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thinh
 */
public class HoanThanhBaoTriDAO {
    Connection conn = null;
    PreparedStatement pttm = null;
    Statement sttm = null;
    
    public int addHoanThanhBaoTri(HoanThanhBaoTri hoanThanhBaoTri) throws SQLException {
        
        conn = DatabaseHelper.getDBConnection();
        
        
        String query = "insert into HoanThanhBaoTri(iD, daHoanThanh, lyDoKetThuc) values (?, ?, ?)";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, hoanThanhBaoTri.getiD());
        pttm.setBoolean(2, hoanThanhBaoTri.isDaHoanThanh());
        pttm.setString(3, hoanThanhBaoTri.getLyDoKeThucSom());
        
        if(pttm.executeUpdate()> 0) {
            System.out.println("Insert thanh cong vao bang HoanThanhBaoTri");
            return 1;
        }
        return -1;
    }
    
    public int updateHoanThanhBaoTri(HoanThanhBaoTri hoanThanhBaoTri) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        String query = "update HoanThanhBaoTri set daHoanThanh = ?, lyDoKetThuc = ? where HoanThanhBaoTri.iD = ?";
        
        pttm = conn.prepareStatement(query);
        pttm.setBoolean(1, hoanThanhBaoTri.isDaHoanThanh());
        pttm.setString(2, hoanThanhBaoTri.getLyDoKeThucSom());
        pttm.setString(3, hoanThanhBaoTri.getiD());
        
        if(pttm.executeUpdate()> 0) {
            System.out.println("Update thanh cong vao bang HoanThanhBaoTri");
            return 1;
        }
        return -1;
    }
    
    public HoanThanhBaoTri getHoanThanhBaoTriByKeHoachBaoTri(KeHoachBaoTri khbt) throws SQLException {
        conn = DatabaseHelper.getDBConnection();
        String query = "select * from KeHoachbaoTri join HoanThanhBaoTri on KeHoachBaoTri.iD = HoanThanhBaoTri.iD where KeHoachBaoTri.iD = " + "'" + khbt.getiD() + "'";
        
        sttm = conn.createStatement();
        ResultSet result = sttm.executeQuery(query);
        result.next();
        
        HoanThanhBaoTri htbt = new HoanThanhBaoTri();
        
        htbt.setiD(result.getString(1));
        htbt.setDaHoanThanh(result.getBoolean(2));
        htbt.setLyDoKeThucSom(result.getString(3));
        
        return htbt;
    }
    
    public int deleteHoanThanhBaoTriByIDKeHoachBaoTri(KeHoachBaoTri khbt) throws SQLException {
        conn = Database.DatabaseHelper.getDBConnection();
        String query = "Delete HoanThanhBaoTri where HoanThanhBaoTri.iD = ?";
        
        pttm = conn.prepareStatement(query);
        pttm.setString(1, khbt.getiD());
        
        if(pttm.executeUpdate()> 0) {
            System.out.println("Da xoa 1 dòng bang HoanThanhBaoTri");
            return 1;
        }
        return -1;
    }
    
}
