
package Session;

import Database.DatabaseHelper;
import Models.NguoiDung;
import Models.NguoiDungDAO;
import Models.PhongMay;
import Models.PhongMayDAO;
import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn = DatabaseHelper.getDBConnection();
//        NguoiDungDAO dao = new NguoiDungDAO();
        PhongMayDAO dao = new PhongMayDAO();
        if(conn != null){
            System.out.println("connect thanh cong");
//            PhongMay pm1 = new PhongMay("PM003","Phong May 03","Chua su dung",false);
//            dao.add(pm1);
//            dao.update(pm1);
//            PhongMay pm1 = new PhongMay("PM003");
//            dao.delete(pm1);
//                for(PhongMay pm: dao.getAll()){
//                    System.out.println(pm.toString());
//                }
                PhongMay find = dao.findRoomByID("PM001");
                if(find != null){
                    System.out.println("Tim thay");
                    System.out.println(find.toString());
                }
        }
        else{
            System.out.println("connect that bai");
        }
    }
}
