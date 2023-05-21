/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlytaisan;

import database.DatabaseHelper;
import java.sql.Connection;
import models.TaiSan;
import models.TaiSanDAO;

/**
 *
 * @author IT SUP
 */
public class testcn {
    public static void main(String[] args){
        Connection conn = DatabaseHelper.getDBConnect();
        TaiSanDAO dao = new TaiSanDAO();
        if (conn != null){
            System.out.println("connect thanh cong");
            TaiSan ts1 = new TaiSan("TS012", "Fan", 300, "Hoat dong", "CFan", "2010-05-19", 50000);
            dao.add(ts1);
//            dao.update(ts1);
//            TaiSan ts2 = new TaiSan("TS001");
//            dao.delete(ts2);
//            for (TaiSan ts : dao.getAll()){
//                System.out.println(ts.toString());
//            }
//              TaiSan find = dao.findTSByID("TS001");
//              if(find != null){
//                System.out.println(find.toString());
//              }
        }else{
            System.out.println("connect that bai");
        }
    }
}
