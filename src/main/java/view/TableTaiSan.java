/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Models.TaiSan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class TableTaiSan extends AbstractTableModel {
    private String Name[] = {"Mã tài sản","Tên tài sản","Số lượng","Trạng Thái","Hãng sản xuất","Ngày trang bị","Giá"};
    //Thuộc tính mảng class để hiển thị thông tin lấy được từ đối tượng người dùng
    private Class classess[]  = {String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    //Thuộc tính dsND để lấy thông tin về các người dùng từ file dữ liệu
    ArrayList<TaiSan> dsTS = new ArrayList<>();
    public TableTaiSan(ArrayList<TaiSan> ts) {
        dsTS = ts;
    }
    @Override
    public int getRowCount() {
        return dsTS.size();
    }

    @Override
    public int getColumnCount() {
        return Name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsTS.get(rowIndex).getMaTaiSan();
            
            case 1: return dsTS.get(rowIndex).getTenTaiSan();
            
            case 2: return dsTS.get(rowIndex).getSoLuong();
             
            case 3: return dsTS.get(rowIndex).getTrangThai();
            
            case 4: return dsTS.get(rowIndex).getHangSanXuat();
            
            case 5: return dsTS.get(rowIndex).getNgayTrangBi();
            
            case 6: return dsTS.get(rowIndex).getGia();
            
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
