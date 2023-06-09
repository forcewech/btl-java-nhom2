/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Models.KeHoachThayDoiTaiSan;
import Models.KeHoachThayDoiTaiSanDAO;
import Models.NhiemVuThayDoiTaiSan;
import Models.NhiemVuThayDoiTaiSanDAO;
import Models.TaiSanThayDoi;
import Models.TaiSanThayDoiDAO;

/**
 *
 * @author IT SUP
 */
public class JFKeHoachThayDoiTaiSan extends javax.swing.JFrame {

    /**
     * Creates new form KeHoachThayDoiTaiSan
     */
    public JFKeHoachThayDoiTaiSan() {
        initComponents();
        fillTable();
    }

    public void fillTable(){
        DefaultTableModel khtdtsModel = (DefaultTableModel) jTableKeHoachThayDoiTaiSan.getModel();
        khtdtsModel.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for( KeHoachThayDoiTaiSan khtdts : khtdtsDAO.getAll()){
            Object dataRow[] = new Object[3];
            dataRow[0] = khtdts.getMaKeHoach();
            dataRow[1] = khtdts.getThoiGianBatDau().format(formatter);
            dataRow[2] = khtdts.getThoiGianKetThuc().format(formatter);
            khtdtsModel.addRow(dataRow);
        }
    }
    
    public KeHoachThayDoiTaiSan getModel(){
        KeHoachThayDoiTaiSan khtdts = new KeHoachThayDoiTaiSan();
        khtdts.setMaKeHoach(jTextFieldMaKeHoach.getText().trim());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            
        String thoiGianBatDauString = jTextFieldThoiGianBatDau.getText().trim();
        LocalDate thoiGianBatDau = LocalDate.parse(thoiGianBatDauString, formatter);
        khtdts.setThoiGianBatDau(thoiGianBatDau);
             
        String thoiGianKetThucString = jTextFieldThoiGianKetThuc.getText().trim();
        LocalDate thoiGianKetThuc = LocalDate.parse(thoiGianKetThucString, formatter);
        khtdts.setThoiGianKetThuc(thoiGianKetThuc);
        
        return khtdts;
    }
    
    KeHoachThayDoiTaiSanDAO khtdtsDAO = new KeHoachThayDoiTaiSanDAO();
    
    public void setModel(KeHoachThayDoiTaiSan khtdts){
        jTextFieldMaKeHoach.setText(khtdts.getMaKeHoach());
        
        LocalDate thoiGianBatDau = khtdts.getThoiGianBatDau();
        String thoiGianBatDauString = thoiGianBatDau.toString(); 
        jTextFieldThoiGianBatDau.setText(thoiGianBatDauString);
        
        LocalDate thoiGianKetThuc = khtdts.getThoiGianKetThuc();
        String thoiGianKetThucString = thoiGianKetThuc.toString(); 
        jTextFieldThoiGianKetThuc.setText(thoiGianKetThucString);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldMaKeHoach = new javax.swing.JTextField();
        jTextFieldThoiGianBatDau = new javax.swing.JTextField();
        jTextFieldThoiGianKetThuc = new javax.swing.JTextField();
        jButtonTim = new javax.swing.JButton();
        jButtonThem = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jButtonHuy = new javax.swing.JButton();
        jButtonLamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKeHoachThayDoiTaiSan = new javax.swing.JTable();
        jButtonChiTiet = new javax.swing.JButton();
        jButtonThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("KẾ HOẠCH THAY ĐỔI TÀI SẢN");

        jLabel2.setText("Mã kế hoạch");

        jLabel3.setText("Thời gian bắt đầu");

        jLabel4.setText("Thời gian kết thúc");

        jButtonTim.setText("Tìm");
        jButtonTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimActionPerformed(evt);
            }
        });

        jButtonThem.setText("Thêm");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });

        jButtonSua.setText("Sửa");
        jButtonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaActionPerformed(evt);
            }
        });

        jButtonHuy.setText("Hủy");
        jButtonHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHuyActionPerformed(evt);
            }
        });

        jButtonLamMoi.setText("Làm mới");
        jButtonLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLamMoiActionPerformed(evt);
            }
        });

        jTableKeHoachThayDoiTaiSan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã kế hoạch", "Thời gian bắt đầu", "Thời gian kết thúc"
            }
        ));
        jTableKeHoachThayDoiTaiSan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKeHoachThayDoiTaiSanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKeHoachThayDoiTaiSan);

        jButtonChiTiet.setText("Thực thi");
        jButtonChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChiTietActionPerformed(evt);
            }
        });

        jButtonThoat.setText("Thoát");
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMaKeHoach)
                            .addComponent(jTextFieldThoiGianBatDau)
                            .addComponent(jTextFieldThoiGianKetThuc))
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(472, Short.MAX_VALUE)
                        .addComponent(jButtonChiTiet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonThoat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldMaKeHoach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldThoiGianBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldThoiGianKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonHuy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLamMoi)
                    .addComponent(jButtonChiTiet))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonThoat)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimActionPerformed
        // TODO add your handling code here:
        jTextFieldMaKeHoach.setEnabled(false);
        if(jTextFieldMaKeHoach.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ban chua nhap ma ke hoach");
        } else {
            KeHoachThayDoiTaiSan khtdts = khtdtsDAO.findKHTDTSByID(jTextFieldMaKeHoach.getText());
            if(khtdts != null)
                setModel(khtdts);
            else
                JOptionPane.showMessageDialog(this, "Không tìm thấy kế hoạch!");
        }
    }//GEN-LAST:event_jButtonTimActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        jTextFieldMaKeHoach.setEnabled(false);
        KeHoachThayDoiTaiSan khtdts = getModel();
        if(khtdtsDAO.add(khtdts) > 0){
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            fillTable();
        }         
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
        KeHoachThayDoiTaiSan khtdts = getModel();
        jTextFieldMaKeHoach.setEnabled(false);
        if(khtdtsDAO.update(khtdts) > 0){
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
            fillTable();
        }          
    }//GEN-LAST:event_jButtonSuaActionPerformed

    private void jButtonHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHuyActionPerformed
        // TODO add your handling code here:
        if(jTextFieldMaKeHoach.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã kế hoach!");
        } else {
            KeHoachThayDoiTaiSan khtdts = khtdtsDAO.findKHTDTSByID(jTextFieldMaKeHoach.getText().trim());
            if (khtdts != null) {
                int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn hủy kế hoạch?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);    
                if (result == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Hủy thành công!");          
                    int rowIndex = jTableKeHoachThayDoiTaiSan.getSelectedRow();
                    if (rowIndex >= 0) {
                        jTableKeHoachThayDoiTaiSan.setValueAt("<html><font color='red'>" + khtdts.getMaKeHoach() + "</font></html>", rowIndex, 0);
                        jTableKeHoachThayDoiTaiSan.setValueAt("<html><font color='red'>" + khtdts.getThoiGianBatDau() + "</font></html>", rowIndex, 1);
                        jTableKeHoachThayDoiTaiSan.setValueAt("<html><font color='red'>" + khtdts.getThoiGianKetThuc() + "</font></html>", rowIndex, 2);
                    }   
                }                                                           
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy kế hoạch");
            }
        }
    }//GEN-LAST:event_jButtonHuyActionPerformed

    private void jButtonLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLamMoiActionPerformed
        // TODO add your handling code here:
        resetForm();
        jTextFieldMaKeHoach.setEnabled(true);
    }//GEN-LAST:event_jButtonLamMoiActionPerformed

    String maKeHoachClick="-1";
    private void jTableKeHoachThayDoiTaiSanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKeHoachThayDoiTaiSanMouseClicked
        // TODO add your handling code here:
        jTextFieldMaKeHoach.setEnabled(false);
        int position = jTableKeHoachThayDoiTaiSan.rowAtPoint(evt.getPoint());
        maKeHoachClick = jTableKeHoachThayDoiTaiSan.getValueAt(position, 0).toString();
        KeHoachThayDoiTaiSan khtdts = khtdtsDAO.findKHTDTSByID(maKeHoachClick);
        if(khtdts != null)
            setModel(khtdts);
    }//GEN-LAST:event_jTableKeHoachThayDoiTaiSanMouseClicked

    TaiSanThayDoiDAO tstdDAO = new TaiSanThayDoiDAO();
    JFChiTietKeHoach ctkh = new JFChiTietKeHoach(); 
    NhiemVuThayDoiTaiSanDAO nvtdtsDAO = new NhiemVuThayDoiTaiSanDAO();
    private void jButtonChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChiTietActionPerformed
        // TODO add your handling code here:      
        if(jTextFieldMaKeHoach.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn kế hoạch!");
        } else {
            ctkh.setVisible(true);
            KeHoachThayDoiTaiSan khtdts = khtdtsDAO.findKHTDTSByID(jTextFieldMaKeHoach.getText());          
            ctkh.setModel2(khtdts);
            List<TaiSanThayDoi> ls = new ArrayList<>();
            ls = tstdDAO.getTaiSanThayDoiByiDKeHoachThayDoiTaiSan(jTextFieldMaKeHoach.getText());
            ctkh.fillTableTaiSanThayDoi(ls);
            List<NhiemVuThayDoiTaiSan> nv = new ArrayList<>();
            nv = nvtdtsDAO.getNhiemVuThayDoiTaiSanByiDKeHoachThayDoiTaiSan(jTextFieldMaKeHoach.getText());
            ctkh.fillTableNhiemVu(nv);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButtonChiTietActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        // TODO add your handling code here:
        SubMenuQuanLyThayDoiTaiSan smqltdts = new SubMenuQuanLyThayDoiTaiSan();
        smqltdts.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonThoatActionPerformed
   
    
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
            java.util.logging.Logger.getLogger(JFKeHoachThayDoiTaiSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFKeHoachThayDoiTaiSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFKeHoachThayDoiTaiSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFKeHoachThayDoiTaiSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFKeHoachThayDoiTaiSan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChiTiet;
    private javax.swing.JButton jButtonHuy;
    private javax.swing.JButton jButtonLamMoi;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JButton jButtonTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableKeHoachThayDoiTaiSan;
    private javax.swing.JTextField jTextFieldMaKeHoach;
    private javax.swing.JTextField jTextFieldThoiGianBatDau;
    private javax.swing.JTextField jTextFieldThoiGianKetThuc;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {       
        jTextFieldMaKeHoach.setText("");
        jTextFieldThoiGianBatDau.setText("");
        jTextFieldThoiGianKetThuc.setText("");        
    }
}
