/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Controllers.KeHoachBaoTriController;
import Models.NghiepVuBaoTriTaiSan;
import Models.NhiemVuBaoTri;
import Models.NhiemVuHoanThanh;
import Models.TaiSanBaoTri;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thinh
 */
public class test2 extends javax.swing.JFrame {

    /**
     * Creates new form test2
     */
    public test2() {
        this.setSize(1300, 700);
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
        
        PanelForNhiemVuBaoTri panelForNhiemVuBaoTri = new PanelForNhiemVuBaoTri();
        
        PanelForNhiemVuBaoTri panelForNhiemVuBaoTri1 = new PanelForNhiemVuBaoTri();
        
        JCheckBox jCheckBox = new JCheckBox();
        jpanel.add(jCheckBox);
        jpanel.add(panelForNhiemVuBaoTri);
        jpanel.add(panelForNhiemVuBaoTri1);
        
        add(jpanel);
        setVisible(true);
    }

    private class PanelForNhiemVuBaoTri extends JPanel{
        private NhiemVuBaoTri nhiemVuBaoTri;
        private List<TaiSanBaoTri> taiSanBaoTriList;
        private List<NhiemVuHoanThanh> nhiemVuHoanThanhsList;
        private List<NghiepVuBaoTriTaiSan> nghiepVuBaoTriTaiSanList;
        private KeHoachBaoTriController keHoachBaoTriController;
        
        JLabel jLabel3 = new javax.swing.JLabel();
        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JTextArea jTextArea1 = new javax.swing.JTextArea();
        JLabel Label_danhGia = new javax.swing.JLabel();
        JCheckBox checkBox_hoanThanh = new javax.swing.JCheckBox();
        JLabel label_tenNhiemVu = new javax.swing.JLabel();
        JLabel jLabel7 = new javax.swing.JLabel();
        JLabel label_ChiTietNhiemVu = new javax.swing.JLabel();
        JLabel jLabel9 = new javax.swing.JLabel();
        JLabel Label_chiPhi = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        DefaultTableModel modelTable;
        
        
        public PanelForNhiemVuBaoTri() {
            setUI();
        }
        
        public PanelForNhiemVuBaoTri(NhiemVuBaoTri nhiemVuBaoTri, List<TaiSanBaoTri> taiSanBaoTris, List<NhiemVuHoanThanh> nhiemVuHoanThanhs) {
            setUI();
            setDataForNhiemVuBaoTri();
            setDataForTable();
        }
        
        private void setDataForTable() {
            String[] columnsName = {"iD", "Tên phòng", "Tên tài sản", "Số lượng", "Yêu cầu", "Số lượng đã hoàn thành", ""};
            
            int row = taiSanBaoTriList.size();
            int column = columnsName.length;
            Object[][] rowCount = new Object[row][column];
            
            for(int i=0; i<row; i++) {
                nghiepVuBaoTriTaiSanList = (ArrayList<NghiepVuBaoTriTaiSan>)keHoachBaoTriController.hienThiTaiSanBaoTris(nhiemVuBaoTri.getiD());
                
                String tenTaiSan = nghiepVuBaoTriTaiSanList.get(i).getTaiSan().getTenTaiSan();
                String tenPhongMay = nghiepVuBaoTriTaiSanList.get(i).getPhongMay().getTenPhong();
                int soLuong = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getSoLuong();
                String yeuCauBaoTri = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getYeuCauBaoTri();
                String iDTaiSanBaoTri = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getiD();
                String iDTaiSanPhongMay = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getiDTaiSanPhongMay();

                int soLuongDaHoanThanh = 0;
                for(int k=0; k<nhiemVuHoanThanhsList.size(); i++) {
                    if(nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getiD().equals(nhiemVuHoanThanhsList.get(k).getiD())) {
                       soLuongDaHoanThanh = nhiemVuHoanThanhsList.get(k).getSoLuongDaHoanThanh();
                    }
                }
                
                rowCount[i][0] = iDTaiSanBaoTri;
                rowCount[i][1] = tenPhongMay;
                rowCount[i][2] = tenTaiSan;
                rowCount[i][3] = soLuong;
                rowCount[i][4] = yeuCauBaoTri;
                rowCount[i][5] = jTextFieldForSoLuongHoanThanh(soLuongDaHoanThanh);
                rowCount[i][6] = jProgressBarForSoLuongHoanThanh(soLuong, soLuongDaHoanThanh);
            }
            
            modelTable = new DefaultTableModel(rowCount, columnsName) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if(columnIndex == 5) {
                        return JTextField.class;
                    }
                    if (columnIndex == 6) {
                        return JProgressBar.class;
                    }
                    return Object.class;
                }
            };
            
            jTable1.setModel(modelTable);
        }
        
        private JTextField jTextFieldForSoLuongHoanThanh(int soLuongDaHoanThanh) {
            JTextField jTextField = new JTextField();
            jTextField.setText(soLuongDaHoanThanh + "");
            return jTextField;
        }
        
        private JProgressBar jProgressBarForSoLuongHoanThanh(int soLuong, int soLuongDaHoanThanh) {
            JProgressBar jProgressBar = new JProgressBar(0, soLuong);
            jProgressBar.setValue(soLuongDaHoanThanh);
            jProgressBar.setSize(50, 10);
            return jProgressBar;
        }
        
        
        private void setDataForNhiemVuBaoTri() {
            label_tenNhiemVu.setText(nhiemVuBaoTri.getTenNhiemVu());
            label_ChiTietNhiemVu.setText(nhiemVuBaoTri.getTenNhiemVu());
            Label_danhGia.setText(nhiemVuBaoTri.getDanhGia());
            Label_chiPhi.setText(nhiemVuBaoTri.getChiPhi() + "");
        }
        
        private void setUI() {
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Label_danhGia = new javax.swing.JLabel();
        checkBox_hoanThanh = new javax.swing.JCheckBox();
        label_tenNhiemVu = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_ChiTietNhiemVu = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Label_chiPhi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel3.setText("Tên nhiệm vụ:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        Label_danhGia.setText("Đánh giá:");

        jLabel7.setText("Chi tiết nhiệm vụ");

        jLabel9.setText("Chi phí:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout NhiemVuBaoTriContainerLayout = new javax.swing.GroupLayout(this);
        setLayout(NhiemVuBaoTriContainerLayout);
        NhiemVuBaoTriContainerLayout.setHorizontalGroup(
            NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NhiemVuBaoTriContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBox_hoanThanh)
                .addGap(28, 28, 28)
                .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(NhiemVuBaoTriContainerLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_tenNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_ChiTietNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_chiPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_danhGia, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        NhiemVuBaoTriContainerLayout.setVerticalGroup(
            NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhiemVuBaoTriContainerLayout.createSequentialGroup()
                .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(NhiemVuBaoTriContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_tenNhiemVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(label_ChiTietNhiemVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_chiPhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_danhGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NhiemVuBaoTriContainerLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(checkBox_hoanThanh))
                    .addGroup(NhiemVuBaoTriContainerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(this, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(this, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 423, Short.MAX_VALUE))
        );
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 686));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
