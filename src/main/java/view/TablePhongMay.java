/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Models.PhongMay;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class TablePhongMay extends AbstractTableModel {
    private String Name[] = {"Mã phòng","Tên phòng","Trạng thái","Đang cho mượn"};
    private Class classess[]  = {String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    ArrayList<PhongMay> dsPM = new ArrayList<>();
    public TablePhongMay(ArrayList<PhongMay> pm) {
        dsPM = pm;
    }
    @Override
    public int getRowCount() {
        return dsPM.size();
    }

    @Override
    public int getColumnCount() {
        return Name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsPM.get(rowIndex).getMaPhong();
            
            case 1: return dsPM.get(rowIndex).getTenPhong();
            
            case 2: return dsPM.get(rowIndex).getTrangThai();
             
            case 3: return dsPM.get(rowIndex).isIsBorrow();  
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
