/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import Models.NguoiDung;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Administrator
 */
public class TableNguoiDung extends AbstractTableModel {
    //Thuộc tính mảng chuỗi Name để tạo tiêu đề
    private String Name[] = {"Mã người dùng","Họ tên","Tên người dùng","Mật khẩu","Email","Chức vụ"};
    //Thuộc tính mảng class để hiển thị thông tin lấy được từ đối tượng người dùng
    private Class classess[]  = {String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    //Thuộc tính dsND để lấy thông tin về các người dùng từ file dữ liệu
    ArrayList<NguoiDung> dsND = new ArrayList<>();
    public TableNguoiDung(ArrayList<NguoiDung> nd) {
        dsND = nd;
    }
    @Override
    public int getRowCount() {
        return dsND.size();
    }

    @Override
    public int getColumnCount() {
        return Name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsND.get(rowIndex).getMaNguoiDung();
            
            case 1: return dsND.get(rowIndex).getHoTen();
            
            case 2: return dsND.get(rowIndex).getTen();
             
            case 3: return dsND.get(rowIndex).getMatKhau();
            
            case 4: return dsND.get(rowIndex).getEmail();
            
            case 5: return dsND.get(rowIndex).getRole();
            
            default : return null;
        }
    }
    
    public Class getColumnClass(int columnIndex){
        return classess[columnIndex];
    }
    
    public String getColumnName(int column){
        return Name[column];
    }
}
