/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Models.TaiSan;
import Models.TaiSanDAO;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IT SUP
 */
public class JFTaiSan extends javax.swing.JFrame {

    /**
     * Creates new form TaiSan
     */
    public JFTaiSan() {
        initComponents();
        fillTable();
    }

    public void updateTable() {
        DefaultTableModel tSModel = (DefaultTableModel) jTableTaiSan.getModel();
        tSModel.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (TaiSan ts : tSDAO.getAll()) {
            Object dataRow[] = new Object[7];
            dataRow[0] = ts.getMaTaiSan();
            dataRow[1] = ts.getTenTaiSan();
            dataRow[2] = ts.getSoLuong();
            dataRow[3] = ts.getTrangThai();
            dataRow[4] = ts.getHangSanXuat();
            dataRow[5] = ts.getNgayTrangBi().format(formatter);
            dataRow[6] = ts.getGia();
            tSModel.addRow(dataRow);
        }
    }
    
    public void fillTable(){
        updateTable();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QUANLYTAISAN = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMaTaiSan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNgayTrangBi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldHangSanXuat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTrangThai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldTenTaiSan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldSoLuong = new javax.swing.JTextField();
        jButtonTim = new javax.swing.JButton();
        jButtonThem = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTaiSan = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        QUANLYTAISAN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        QUANLYTAISAN.setText("QUẢN LÝ TÀI SẢN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Mã tài sản");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Giá");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Ngày trang bị");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Hãng sản xuất");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Trạng thái");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Tên tài sản");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Số lượng");

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

        jButtonXoa.setText("Xóa");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        jTableTaiSan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tài sản", "Tên tài sản", "Số lượng", "Trạng thái", "Hãng sản xuất", "Ngày trang bị", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableTaiSan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTaiSanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTaiSan);
        if (jTableTaiSan.getColumnModel().getColumnCount() > 0) {
            jTableTaiSan.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableTaiSan.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTableTaiSan.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        jButton1.setText("Làm mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                        .addComponent(QUANLYTAISAN)
                        .addContainerGap(327, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jTextFieldMaTaiSan))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSoLuong)
                                    .addComponent(jTextFieldTenTaiSan)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldHangSanXuat)
                                    .addComponent(jTextFieldNgayTrangBi)
                                    .addComponent(jTextFieldGia)
                                    .addComponent(jTextFieldTrangThai))))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(QUANLYTAISAN)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonTim)
                    .addComponent(jTextFieldMaTaiSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldTenTaiSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldHangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNgayTrangBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
        TaiSan ts = getModel();
        jTextFieldMaTaiSan.setEnabled(false);
        if(tSDAO.update(ts) > 0)
        {
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
            updateTable();
        }       
    }//GEN-LAST:event_jButtonSuaActionPerformed
    
    public void resetForm(){
        jTextFieldMaTaiSan.setText("");
        jTextFieldTenTaiSan.setText("");
        jTextFieldSoLuong.setText("");
        jTextFieldTrangThai.setText("");
        jTextFieldHangSanXuat.setText("");
        jTextFieldNgayTrangBi.setText("");
        jTextFieldGia.setText("");
    }
    
    public TaiSan getModel(){
        TaiSan ts = new TaiSan();
        ts.setMaTaiSan(jTextFieldMaTaiSan.getText().trim());
        ts.setTenTaiSan(jTextFieldTenTaiSan.getText().trim());
        ts.setSoLuong(parseInt(jTextFieldSoLuong.getText().trim()));
        ts.setTrangThai(jTextFieldTrangThai.getText().trim());
        ts.setHangSanXuat(jTextFieldHangSanXuat.getText().trim());
        String ngayTrangBiString = jTextFieldNgayTrangBi.getText().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ngayTrangBi = LocalDate.parse(ngayTrangBiString, formatter);
        ts.setNgayTrangBi(ngayTrangBi);
        ts.setGia(parseDouble(jTextFieldGia.getText().trim()));
        return ts;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        resetForm();
        jTextFieldMaTaiSan.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    TaiSanDAO tSDAO = new TaiSanDAO();
    
    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        TaiSan ts = getModel();
        if(tSDAO.add(ts) > 0){
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            updateTable();
        }           
    }//GEN-LAST:event_jButtonThemActionPerformed

    public void setModel(TaiSan ts){     
        jTextFieldMaTaiSan.setText(ts.getMaTaiSan());
        jTextFieldTenTaiSan.setText(ts.getTenTaiSan());
        jTextFieldSoLuong.setText(Integer.toString(ts.getSoLuong()));
        jTextFieldTrangThai.setText(ts.getTrangThai());
        jTextFieldHangSanXuat.setText(ts.getHangSanXuat());
        
        LocalDate ngayTrangBi = ts.getNgayTrangBi();
        String ngayTrangBiString = ngayTrangBi.toString(); 
        jTextFieldNgayTrangBi.setText(ngayTrangBiString);
        
        jTextFieldGia.setText(Double.toString(ts.getGia()));
    }
    
    private void jButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimActionPerformed
        // TODO add your handling code here:
        jTextFieldMaTaiSan.setEnabled(false);
        if(jTextFieldMaTaiSan.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã tài sản");
        } else {
            TaiSan ts = tSDAO.findTSByID(jTextFieldMaTaiSan.getText());
            if(ts != null)
                setModel(ts);
            else
                JOptionPane.showMessageDialog(this, "Không tìm thấy tài sản");
        }
    }//GEN-LAST:event_jButtonTimActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        if(jTextFieldMaTaiSan.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã tài sản");
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);    
            if (result == JOptionPane.YES_OPTION) {
                if(tSDAO.delete(jTextFieldMaTaiSan.getText()) > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                    updateTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy tài sản!");
                }
            }
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    String maTaiSanClick = "-1";
    
    private void jTableTaiSanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTaiSanMouseClicked
        // TODO add your handling code here:
        jTextFieldMaTaiSan.setEnabled(false);
        int position = jTableTaiSan.rowAtPoint(evt.getPoint());
        maTaiSanClick = jTableTaiSan.getValueAt(position, 0).toString();
        TaiSan ts = tSDAO.findTSByID(maTaiSanClick);
        if(ts != null)
            setModel(ts);
    }//GEN-LAST:event_jTableTaiSanMouseClicked

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
            java.util.logging.Logger.getLogger(JFTaiSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFTaiSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFTaiSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFTaiSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFTaiSan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel QUANLYTAISAN;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonTim;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTaiSan;
    private javax.swing.JTextField jTextFieldGia;
    private javax.swing.JTextField jTextFieldHangSanXuat;
    private javax.swing.JTextField jTextFieldMaTaiSan;
    private javax.swing.JTextField jTextFieldNgayTrangBi;
    private javax.swing.JTextField jTextFieldSoLuong;
    private javax.swing.JTextField jTextFieldTenTaiSan;
    private javax.swing.JTextField jTextFieldTrangThai;
    // End of variables declaration//GEN-END:variables
}
