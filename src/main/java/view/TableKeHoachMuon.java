/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Models.KeHoachMuon;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class TableKeHoachMuon extends AbstractTableModel {
    //Thuộc tính mảng chuỗi Name để tạo tiêu đề
    private String Name[] = {"Mã kế hoạch","Thời gian mượn","Thời gian sử dụng","Số phòng","Tên người mượn"};
    //Thuộc tính mảng class để hiển thị thông tin lấy được từ đối tượng người dùng
    private Class classess[]  = {String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    //Thuộc tính dsND để lấy thông tin về các người dùng từ file dữ liệu
    ArrayList<KeHoachMuon> dsKHM = new ArrayList<>();
    public TableKeHoachMuon(ArrayList<KeHoachMuon> khm) {
        dsKHM = khm;
    }
    @Override
    public int getRowCount() {
        return dsKHM.size();
    }

    @Override
    public int getColumnCount() {
        return Name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsKHM.get(rowIndex).getId();
            
            case 1: return dsKHM.get(rowIndex).getThoiGianMuon();
            
            case 2: return dsKHM.get(rowIndex).getThoiGianSuDung();
             
            case 3: return dsKHM.get(rowIndex).getSoPhong();
            
            case 4: return dsKHM.get(rowIndex).getTenNguoiMuon();
            
            
            default : return null;
        }
    }
    
    @Override
    public Class getColumnClass(int columnIndex){
        return classess[columnIndex];
    }
    
    @Override
    public String getColumnName(int column){
        return Name[column];
    }
}
