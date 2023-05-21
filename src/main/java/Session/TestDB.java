
package Session;

import Database.DatabaseHelper;
import Models.NguoiDung;
import Models.NguoiDungDAO;
import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn = DatabaseHelper.getDBConnection();
        NguoiDungDAO dao = new NguoiDungDAO();
        if(conn != null){
            System.out.println("connect thanh cong");
//            NguoiDung nd1 = new NguoiDung("ND003","Nguyen Xuan Thang","truong","123456","truong@gmail.com","Teacher");
//            dao.add(nd1);
//            dao.update(nd1);
//            NguoiDung nd1 = new NguoiDung("ND003");
//            dao.delete(nd1);
//                for(NguoiDung nd: dao.getAll()){
//                    System.out.println(nd.toString());
//                }
                NguoiDung find = dao.findUserByID("ND001");
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
