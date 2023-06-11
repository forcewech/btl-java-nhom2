/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Database.DatabaseHelper;
import Models.KeHoachMuon;
import Models.KeHoachMuonDAO;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class KeHoachMuonView extends javax.swing.JFrame {

    /**
     * Creates new form KeHoachMuonView
     */
    String pattern = "yyyy-MM-dd";
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
    ArrayList<KeHoachMuon> dsKeHoachMuon = new ArrayList<>();
    int dongchon = -1;
    KeHoachMuon khmuon = new KeHoachMuon();
    public KeHoachMuonView() {
        initComponents();
        myInit();
        setSize(1100,600);
        setLocationRelativeTo(null);
        setTitle("Quản lý kế hoạch mượn phòng máy");
    }
    public void myInit(){
//        //Đọc dữ liệu từ file khi khởi động
        readData();
        LoadTableTS(dsKeHoachMuon);          
    }
    public void LoadTableTS(ArrayList<KeHoachMuon> ds){
        tableTS.setModel(new TableKeHoachMuon(ds));
    }
    public void readData(){
        try {
            Connection conn = DatabaseHelper.getDBConnection();
            KeHoachMuonDAO dao = new KeHoachMuonDAO();
            
            if(conn != null){
              for(KeHoachMuon khm : dao.getAll()){
                  dsKeHoachMuon.add(khm);
              }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc dữ liệu:\n" +ex,"Lỗi", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(JQLTaiSan.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labe2 = new javax.swing.JLabel();
        jTenTS = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDvTinh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTinhTrang = new javax.swing.JTextField();
        jButtonThem = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonHuy = new javax.swing.JButton();
        jButtonThoat1 = new javax.swing.JButton();
        jMaTS2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTS = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thực hiện"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Thời gian mượn");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        labe2.setText("Thời gian sử dụng");
        jPanel1.add(labe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jTenTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTenTSActionPerformed(evt);
            }
        });
        jPanel1.add(jTenTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 510, -1));

        jLabel2.setText("Số phòng");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jDvTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDvTinhActionPerformed(evt);
            }
        });
        jPanel1.add(jDvTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 510, -1));

        jLabel3.setText("Tên người mượn");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTinhTrangActionPerformed(evt);
            }
        });
        jPanel1.add(jTinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 510, -1));

        jButtonThem.setText("Thêm");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 70, -1));

        jButtonSua.setText("Sửa");
        jButtonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 70, -1));

        jButtonXoa.setText("Xóa");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 70, -1));

        jButtonHuy.setText("Hủy");
        jButtonHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHuyActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 70, -1));

        jButtonThoat1.setText("Thoát");
        jButtonThoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoat1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonThoat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 70, -1));

        jMaTS2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaTS2ActionPerformed(evt);
            }
        });
        jPanel1.add(jMaTS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 510, -1));

        tableTS.setModel(new javax.swing.table.DefaultTableModel(
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
        tableTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTS);

        jMenu1.setText("Đăng xuất");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Chức năng");

        jMenuItem2.setText("Quản lý tài sản");
        jMenuItem2.setToolTipText("");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem1.setText("Quản lý thay đổi tài sản");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setText("Quản lý kiểm kê tài sản");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Quản lý mượn phòng máy");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Quản lý thông tin người dùng");
        jMenuItem5.setToolTipText("");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Quản lý bảo trì");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Quản lý thông tin phòng máy");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTenTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTenTSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTenTSActionPerformed

    private void jDvTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDvTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDvTinhActionPerformed

    private void jTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTinhTrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTinhTrangActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        LocalDate date = LocalDate.parse(jMaTS2.getText().trim(), dateFormatter);
        double randomDouble = Math.random();
        randomDouble = randomDouble * 1000 + 1;
        int randomInt = (int) randomDouble;
        if(jMaTS2.getText().trim().length()==0)
        JOptionPane.showMessageDialog(null, "Không được để tài khoản trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        else if(jTenTS.getText().trim().length()==0)
        JOptionPane.showMessageDialog(null, "Không được để mật khẩu trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        else if(jDvTinh.getText().trim().length()==0)
        JOptionPane.showMessageDialog(null, "Không được để email trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        else if(jTinhTrang.getText().trim().length()==0)
        JOptionPane.showMessageDialog(null, "Không được để chức vụ trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        else {
            try{
                KeHoachMuonDAO dao = new KeHoachMuonDAO();
                KeHoachMuon khm1 = new KeHoachMuon("KHM"+randomInt,jTinhTrang.getText().trim(),jTenTS.getText().trim()+" phút",jDvTinh.getText().trim(),date);
                dao.add(khm1);
                JOptionPane.showMessageDialog(null, "Thêm người dùng thành công", "Thông báo", JOptionPane.WARNING_MESSAGE);
                dsKeHoachMuon.add(khm1);
                LoadTableTS(dsKeHoachMuon);
                resetTxt();
            }catch(Exception ex){
                System.out.println("Loi !!"+ex.toString());
            }
        }
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
        //Lấy vị trí của tài sản trong bảng trên giao diện
        LocalDate date = LocalDate.parse(jMaTS2.getText().trim(), dateFormatter);
        dongchon = tableTS.getSelectedRow();
        if(dongchon != -1){
            int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa không?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try{
                KeHoachMuonDAO dao = new KeHoachMuonDAO();
                if (response == JOptionPane.YES_OPTION){
                    //JOptionPane.showMessageDialog(null, "Trường mã sẽ không được cập nhật!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    //Lấy người dùng từ danh sách để sửa
                    khmuon = dsKeHoachMuon.get(dsKeHoachMuon.indexOf(khmuon));
                    //Thực hiện sửa dữ liệu từ các điều khiển bằng hàm setter
                    khmuon.setThoiGianMuon(date);
                    khmuon.setThoiGianSuDung(jTenTS.getText()+" phút");
                    khmuon.setSoPhong(jDvTinh.getText());
                    khmuon.setTenNguoiMuon(jTinhTrang.getText());
                    //Hiển thị lại bảng sau khi sửa
                    dao.update(khmuon);
                    LoadTableTS(dsKeHoachMuon);
                    //Đặt lại các điều khiển
                    resetTxt();
                }
                else
                JOptionPane.showMessageDialog(null, "Cần chọn một bản ghi để sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }catch(Exception ex){
                System.out.println("Loi trong khi sua!"+ex.toString());
            }
        }
    }//GEN-LAST:event_jButtonSuaActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        dongchon = tableTS.getSelectedRow();
        if (dongchon != -1){
            khmuon = dsKeHoachMuon.get(dsKeHoachMuon.indexOf(khmuon));
            int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá không?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION){
                try {
                    KeHoachMuonDAO dao = new KeHoachMuonDAO();
                    dao.delete(khmuon);
                    dsKeHoachMuon.remove(khmuon);
                    LoadTableTS(dsKeHoachMuon);
                    resetTxt();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex, "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else
        JOptionPane.showMessageDialog(null, "Cần chọn một bản ghi để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHuyActionPerformed
        // TODO add your handling code here:
        resetTxt();
    }//GEN-LAST:event_jButtonHuyActionPerformed

    private void jButtonThoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoat1ActionPerformed
        // TODO add your handling code here:
        TrangChuTeacher tct = new TrangChuTeacher();
        tct.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonThoat1ActionPerformed

    private void jMaTS2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaTS2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMaTS2ActionPerformed

    private void tableTSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTSMouseClicked
        // TODO add your handling code here:
        dongchon = tableTS.getSelectedRow();
        if(dongchon !=-1){
            khmuon = dsKeHoachMuon.get(dongchon);
            jMaTS2.setText(khmuon.getThoiGianMuon()+"");
            jTenTS.setText(khmuon.getThoiGianSuDung()+"");
            jDvTinh.setText(khmuon.getSoPhong()+"");
            jTinhTrang.setText(khmuon.getTenNguoiMuon()+"");
        }
    }//GEN-LAST:event_tableTSMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        Login dnForm = new Login();
        dnForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    public void resetTxt(){
        jMaTS2.setText("");
        jTenTS.setText("");
        jDvTinh.setText("");
        jTinhTrang.setText("");
        dongchon = -1;
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
            java.util.logging.Logger.getLogger(KeHoachMuonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KeHoachMuonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KeHoachMuonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeHoachMuonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeHoachMuonView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHuy;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonThoat1;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JTextField jDvTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jMaTS2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTenTS;
    private javax.swing.JTextField jTinhTrang;
    private javax.swing.JLabel labe2;
    private javax.swing.JTable tableTS;
    // End of variables declaration//GEN-END:variables
}