/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Models.KeHoachKiemKe;
import Models.KeHoachKiemKeDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IT SUP
 */
public class JFKeHoachKiemKe extends javax.swing.JFrame {

    /**
     * Creates new form JFKeHoachKiemKe
     */
    public JFKeHoachKiemKe() {
        initComponents();
        fillTable();
    }

    public void fillTable(){
        DefaultTableModel khkkModel = (DefaultTableModel) jTableKeHoachKiemKe.getModel();
        khkkModel.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for( KeHoachKiemKe khkk : khkkDAO.getAll()){
            Object dataRow[] = new Object[3];
            dataRow[0] = khkk.getMaKeHoach();
            dataRow[1] = khkk.getThoiGianBatDau().format(formatter);
            dataRow[2] = khkk.getThoiGianKetThuc().format(formatter);
            khkkModel.addRow(dataRow);
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

        jLabel2 = new javax.swing.JLabel();
        jTextFieldMaKeHoach = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKeHoachKiemKe = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldThoiGianKetThuc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldThoiGianBatDau = new javax.swing.JTextField();
        jButtonTim = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jButtonThem = new javax.swing.JButton();
        jButtonHuy = new javax.swing.JButton();
        jButtonLamMoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Mã kế hoạch");

        jTableKeHoachKiemKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã kế hoạch", "Thời gian bắt đầu", "Thời gian kết thúc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableKeHoachKiemKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKeHoachKiemKeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKeHoachKiemKe);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Thời gian kết thúc");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Thời gian bắt đầu");

        jButtonTim.setText("Tìm");
        jButtonTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimActionPerformed(evt);
            }
        });

        jButtonSua.setText("Sửa");
        jButtonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaActionPerformed(evt);
            }
        });

        jButtonThem.setText("Thêm");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });

        jButtonHuy.setText("Hủy");
        jButtonHuy.setToolTipText("");
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("KẾ HOẠCH KIỂM KÊ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldThoiGianKetThuc, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldThoiGianBatDau, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldMaKeHoach, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldMaKeHoach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldThoiGianBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldThoiGianKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonHuy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLamMoi)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLamMoiActionPerformed
        // TODO add your handling code here:
        resetForm();
        jTextFieldMaKeHoach.setEnabled(true);
    }//GEN-LAST:event_jButtonLamMoiActionPerformed

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
        KeHoachKiemKe khkk = getModel();
        jTextFieldMaKeHoach.setEnabled(false);
        if(khkkDAO.update(khkk) > 0){
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
            fillTable();
        }       
    }//GEN-LAST:event_jButtonSuaActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        jTextFieldMaKeHoach.setEnabled(false);
        KeHoachKiemKe khkk = getModel();
        if(khkkDAO.add(khkk) > 0)
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimActionPerformed
        // TODO add your handling code here:
        jTextFieldMaKeHoach.setEnabled(false);
        if(jTextFieldMaKeHoach.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ban chua nhap ma ke hoach");
        } else {
            KeHoachKiemKe khkk = khkkDAO.findKHKKByID(jTextFieldMaKeHoach.getText());
            if(khkk != null)
                setModel(khkk);
            else
                JOptionPane.showMessageDialog(this, "Không tìm thấy kế hoạch!");
        }
    }//GEN-LAST:event_jButtonTimActionPerformed

    private void jButtonHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHuyActionPerformed
        // TODO add your handling code here:
        if(jTextFieldMaKeHoach.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã kế hoach!");
        } else {
            KeHoachKiemKe khkk = khkkDAO.findKHKKByID(jTextFieldMaKeHoach.getText().trim());
            if (khkk != null) {
                int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn hủy kế hoạch?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);    
                if (result == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Hủy thành công!");          
                    int rowIndex = jTableKeHoachKiemKe.getSelectedRow();
                    if (rowIndex >= 0) {
                        jTableKeHoachKiemKe.setValueAt("<html><font color='red'>" + khkk.getMaKeHoach() + "</font></html>", rowIndex, 0);
                        jTableKeHoachKiemKe.setValueAt("<html><font color='red'>" + khkk.getThoiGianBatDau() + "</font></html>", rowIndex, 1);
                        jTableKeHoachKiemKe.setValueAt("<html><font color='red'>" + khkk.getThoiGianKetThuc() + "</font></html>", rowIndex, 2);
                    }   
                }                                                           
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy kế hoạch");
            }
        }
    }//GEN-LAST:event_jButtonHuyActionPerformed

    String maKeHoachClick = "-1";
    
    private void jTableKeHoachKiemKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKeHoachKiemKeMouseClicked
        // TODO add your handling code here:
        jTextFieldMaKeHoach.setEnabled(false);
        int position = jTableKeHoachKiemKe.rowAtPoint(evt.getPoint());
        maKeHoachClick = jTableKeHoachKiemKe.getValueAt(position, 0).toString();
        KeHoachKiemKe khkk = khkkDAO.findKHKKByID(maKeHoachClick);
        if(khkk != null)
            setModel(khkk);
    }//GEN-LAST:event_jTableKeHoachKiemKeMouseClicked

    public void resetForm(){
        jTextFieldMaKeHoach.setText("");
        jTextFieldThoiGianBatDau.setText(""); 
        jTextFieldThoiGianKetThuc.setText("");       
    }
    
    public KeHoachKiemKe getModel(){
        KeHoachKiemKe khkk = new KeHoachKiemKe();
        khkk.setMaKeHoach(jTextFieldMaKeHoach.getText().trim());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            
        String thoiGianBatDauString = jTextFieldThoiGianBatDau.getText().trim();
        LocalDate thoiGianBatDau = LocalDate.parse(thoiGianBatDauString, formatter);
        khkk.setThoiGianBatDau(thoiGianBatDau);
             
        String thoiGianKetThucString = jTextFieldThoiGianKetThuc.getText().trim();
        LocalDate thoiGianKetThuc = LocalDate.parse(thoiGianKetThucString, formatter);
        khkk.setThoiGianKetThuc(thoiGianKetThuc);
        
        return khkk;
    }
    
    KeHoachKiemKeDAO khkkDAO = new KeHoachKiemKeDAO();
    
    public void setModel(KeHoachKiemKe khkk){
        jTextFieldMaKeHoach.setText(khkk.getMaKeHoach());
        
        LocalDate thoiGianBatDau = khkk.getThoiGianBatDau();
        String thoiGianBatDauString = thoiGianBatDau.toString(); 
        jTextFieldThoiGianBatDau.setText(thoiGianBatDauString);
        
        LocalDate thoiGianKetThuc = khkk.getThoiGianKetThuc();
        String thoiGianKetThucString = thoiGianKetThuc.toString(); 
        jTextFieldThoiGianKetThuc.setText(thoiGianKetThucString);
    }
    
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
            java.util.logging.Logger.getLogger(JFKeHoachKiemKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFKeHoachKiemKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFKeHoachKiemKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFKeHoachKiemKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFKeHoachKiemKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHuy;
    private javax.swing.JButton jButtonLamMoi;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonTim;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableKeHoachKiemKe;
    private javax.swing.JTextField jTextFieldMaKeHoach;
    private javax.swing.JTextField jTextFieldThoiGianBatDau;
    private javax.swing.JTextField jTextFieldThoiGianKetThuc;
    // End of variables declaration//GEN-END:variables
}