/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.nhom2;

import Models.KeHoachBaoTriDAO;
import Models.KeHoachBaoTri;
import Models.NhiemVuBaoTriDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import Models.*;

/**
 *
 * @author thinh
 */
public class TestModels {
    
    static void testNhiemVuBaoTri() throws SQLException {
        NhiemVuBaoTriDAO nvbtDAO = new NhiemVuBaoTriDAO();
        ArrayList<NhiemVuBaoTri> listNhiemVuBaoTri = new ArrayList<>();

        listNhiemVuBaoTri.add(new NhiemVuBaoTri("khbt01", "KH02", "khong biet", "okeeeee", "okeeeeeeee", 34000));

        listNhiemVuBaoTri.add(new NhiemVuBaoTri("khbt04", "KH02", "khong biet", "okeeeee", "okeeeeeeee", 34000));
        nvbtDAO.updateNhiemVuBaoTri(new NhiemVuBaoTri("khbt01", "KH02", "chiu", "okeeeee", "okeeeeeeee", 34000));
    }
    
    static void testTaiSanBaoTri() throws SQLException {
        ArrayList<TaiSanBaoTri> tsbt = new ArrayList<>();
        
//        tsbt.add(new TaiSanBaoTri("tsbt02", "khbt02", "m005", 54, "Kiểm tra mạng"));
//        tsbt.add(new TaiSanBaoTri("tsbt03", "khbt02", "m005", 54, "Kiểm tra mạng"));
//        
          TaiSanBaoTriDAO tsbtDAO = new TaiSanBaoTriDAO();
        
        tsbt = (ArrayList<TaiSanBaoTri>) tsbtDAO.getAllTaiSanBaoTrisByiDNhiemVuBaoTri("khbt02");
        tsbt.forEach(tsbtchild -> {
            System.out.println(tsbtchild.getSoLuong());
        });
    }
    
    static void testMauDanhGiaSauBaoTri() throws SQLException {
        ArrayList<MauDanhGiaSauBaoTri> mdgsbtArrayList = new ArrayList<>();
        
        mdgsbtArrayList.add(new MauDanhGiaSauBaoTri("mdg02", "oke"));
        mdgsbtArrayList.add(new MauDanhGiaSauBaoTri("mdg03", "oke"));
        
        MauDanhGiaSauBaoTriDAO mdgbtDAO = new MauDanhGiaSauBaoTriDAO();
        
        mdgbtDAO.addMoreMauDanhGiaSauBaoTri(mdgsbtArrayList);
        
    }
    
    static public void main(String[] args) {
        KeHoachBaoTri khbt = new KeHoachBaoTri("KH02", LocalDate.now(), LocalDate.now(), "update", false, "sources");
        
        KeHoachBaoTriDAO khbtdao = new KeHoachBaoTriDAO();
        
//        ArrayList<String> listIDArrayList = new ArrayList<>();
//        
//        listIDArrayList.add("khbt02");
//        listIDArrayList.add("khbt03");
        
//         try {
//             testMauDanhGiaSauBaoTri();
//         } catch(SQLException ex) {
//             System.out.println(ex.toString());
//         }
//        
    }
}
