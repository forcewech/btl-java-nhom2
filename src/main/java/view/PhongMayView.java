/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import database.DatabaseHelper;
import Models.PhongMayDAO;
import Models.PhongMay;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class PhongMayView extends javax.swing.JFrame {

    /**
     * Creates new form PhongMayView
     */
    ArrayList<PhongMay> dsPhongMay = new ArrayList<>();
    int dongchon = -1;
    PhongMay pmay = new PhongMay();
    public PhongMayView() {
        initComponents();
        myInit();
        setSize(1100,600);
        setLocationRelativeTo(null);
        setTitle("Quản lý thông tin phòng máy");
    }
    public void myInit(){
//        //Đọc dữ liệu từ file khi khởi động
        readData();
        LoadTableTS(dsPhongMay);
        //Tạo combo danh mục để lọc   
        String dm[]={"true","false"};
        jComboDMLoc1.setModel(new javax.swing.DefaultComboBoxModel(dm));
        jComboDMLoc1.setSelectedItem("true"); 
        String am[]={"Dang su dung","Chua su dung","Dang bao tri"};
        jComboDMLoc2.setModel(new javax.swing.DefaultComboBoxModel(am));
        jComboDMLoc2.setSelectedItem("Dang su dung");  
    }
    public void LoadTableTS(ArrayList<PhongMay> ds){
        tableTS.setModel(new TablePhongMay(ds));
    }
    public void readData(){
        try {
            Connection conn = DatabaseHelper.getDBConnection();
            PhongMayDAO dao = new PhongMayDAO();
            
            if(conn != null){
              for(PhongMay pm : dao.getAll()){
                  dsPhongMay.add(pm);
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
        jMaTS = new javax.swing.JTextField();
        jButtonThem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButtonSua = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonHuy = new javax.swing.JButton();
        jButtonThoat1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboDMLoc = new javax.swing.JComboBox<>();
        jTextTim = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButtonLoc = new javax.swing.JButton();
        jButtonReLoc = new javax.swing.JButton();
        jComboDMLoc1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboDMLoc2 = new javax.swing.JComboBox<>();
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

        jLabel1.setText("Đang cho mượn");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jMaTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaTSActionPerformed(evt);
            }
        });
        jPanel1.add(jMaTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 510, -1));

        jButtonThem.setText("Thêm");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 70, -1));

        jLabel8.setText("Tên Phòng");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lọc"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("Chức vụ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jComboDMLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item1", "item2" }));
        jComboDMLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboDMLocActionPerformed(evt);
            }
        });
        jPanel2.add(jComboDMLoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, -1));
        jPanel2.add(jTextTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 190, -1));

        jLabel11.setText("Từ khóa tìm kiếm");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jButtonLoc.setText("Tìm");
        jButtonLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLocActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonLoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 70, -1));

        jButtonReLoc.setText("Reset");
        jButtonReLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReLocActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonReLoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 70, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 220, 202));

        jComboDMLoc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item1", "item2" }));
        jComboDMLoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboDMLoc1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboDMLoc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 190, -1));

        jLabel2.setText("Trạng thái");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jComboDMLoc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item1", "item2" }));
        jComboDMLoc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboDMLoc2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboDMLoc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 190, -1));

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMaTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaTSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMaTSActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        double randomDouble = Math.random();
        randomDouble = randomDouble * 1000 + 1;
        int randomInt = (int) randomDouble;
        if(jMaTS.getText().trim().length()==0)
                JOptionPane.showMessageDialog(null, "Không được để tên trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        else {
            try{
//                Connection conn = DatabaseHelper.getDBConnection();
                PhongMayDAO dao = new PhongMayDAO();
                PhongMay pm1 = new PhongMay("PM"+randomInt,jMaTS.getText().trim(),jComboDMLoc2.getSelectedItem().toString(), Boolean.parseBoolean(jComboDMLoc1.getSelectedItem().toString()));
                dao.add(pm1);
                JOptionPane.showMessageDialog(null, "Thêm phòng máy thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                dsPhongMay.add(pm1);
                LoadTableTS(dsPhongMay);
                resetTxt();                
            }catch(Exception ex){
                System.out.println("Loi !!"+ex.toString());
            }
        }
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
        dongchon = tableTS.getSelectedRow();
        if(dongchon != -1){                        
            int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa không?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try{
                PhongMayDAO dao = new PhongMayDAO();
                if (response == JOptionPane.YES_OPTION){
                //JOptionPane.showMessageDialog(null, "Trường mã sẽ không được cập nhật!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                //Lấy người dùng từ danh sách để sửa
                pmay = dsPhongMay.get(dsPhongMay.indexOf(pmay));
                //Thực hiện sửa dữ liệu từ các điều khiển bằng hàm setter
                pmay.setTenPhong(jMaTS.getText());
                pmay.setTrangThai(jComboDMLoc2.getSelectedItem().toString());
                pmay.setIsBorrow(Boolean.parseBoolean(jComboDMLoc1.getSelectedItem().toString()));
                //Hiển thị lại bảng sau khi sửa
                dao.update(pmay);
                LoadTableTS(dsPhongMay);
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
            pmay = dsPhongMay.get(dsPhongMay.indexOf(pmay));
            int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá không?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION){
                try {
                    PhongMayDAO dao = new PhongMayDAO();
                    dao.delete(pmay);
                    dsPhongMay.remove(pmay);
                    LoadTableTS(dsPhongMay);
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
        this.dispose();
    }//GEN-LAST:event_jButtonThoat1ActionPerformed

    private void jComboDMLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboDMLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboDMLocActionPerformed

    private void jButtonLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLocActionPerformed

    private void jButtonReLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReLocActionPerformed

    private void tableTSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTSMouseClicked
        // TODO add your handling code here:
        dongchon = tableTS.getSelectedRow();
        if(dongchon !=-1){
            pmay = dsPhongMay.get(dongchon);
            jMaTS.setText(pmay.getTenPhong()+"");
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

    private void jComboDMLoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboDMLoc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboDMLoc1ActionPerformed

    private void jComboDMLoc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboDMLoc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboDMLoc2ActionPerformed
    public void resetTxt(){
        jMaTS.setText("");
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
            java.util.logging.Logger.getLogger(PhongMayView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhongMayView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhongMayView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhongMayView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhongMayView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHuy;
    private javax.swing.JButton jButtonLoc;
    private javax.swing.JButton jButtonReLoc;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonThoat1;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JComboBox<String> jComboDMLoc;
    private javax.swing.JComboBox<String> jComboDMLoc1;
    private javax.swing.JComboBox<String> jComboDMLoc2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jMaTS;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextTim;
    private javax.swing.JTable tableTS;
    // End of variables declaration//GEN-END:variables
}
